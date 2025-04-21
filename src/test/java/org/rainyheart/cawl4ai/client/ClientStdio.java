/*
* Copyright 2024 - 2024 the original author or authors.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* https://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package org.rainyheart.cawl4ai.client;

import org.rainyheart.cawl4ai.mcp.http.request.CrawlRequest;
import org.rainyheart.cawl4ai.mcp.http.response.CrawlResponse;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import io.modelcontextprotocol.client.McpClient;
import io.modelcontextprotocol.client.transport.ServerParameters;
import io.modelcontextprotocol.client.transport.StdioClientTransport;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpSchema.CallToolRequest;
import io.modelcontextprotocol.spec.McpSchema.CallToolResult;
import io.modelcontextprotocol.spec.McpSchema.ListToolsResult;
import io.modelcontextprotocol.spec.McpSchema.TextContent;

/**
 * With stdio transport, the MCP server is automatically started by the client. But you
 * have to build the server jar first:
 *
 * <pre>
 * ./mvnw clean install
 * </pre>
 */
public class ClientStdio {

	public static void main(String[] args) throws InterruptedException {

		var stdioParams = ServerParameters.builder("java")
			.args("-jar",
					"./target/jcawl4ai-mcp-server-1.0.0.jar")
			.build();

		var transport = new StdioClientTransport(stdioParams);
		var client = McpClient.sync(transport).build();

		client.initialize();

		// List and demonstrate tools
		ListToolsResult toolsList = client.listTools();
		System.out.println("Available Tools = " + toolsList);
		CrawlRequest request = new CrawlRequest();
		request.setMax_depth(10);
		request.setStrategy("best_first");
		request.setOutput_format("markdown");
		request.setUrls(new String[] { "https://www.weather.gov" });
		
		CallToolResult crawlResult = client.callTool(new CallToolRequest("crawl",
		        request.toMap()));
		System.out.println("Crawl response: " + crawlResult);		
		String taskId = null;
		for(McpSchema.Content content : crawlResult.content()) {
		    if(content instanceof TextContent) {
		        taskId = ((TextContent)content).text();
		    }
		}
		JSONObject json = JSONUtil.parseObj(JSONUtil.toJsonPrettyStr(taskId.replace("\\", "").replace("\"", "")));
		taskId = (String) json.get("taskId");
		CrawlResponse response = new CrawlResponse();
		response.setTaskId(taskId);

		CallToolResult finalResult = client.callTool(new CallToolRequest("task", response.toMap()));
        
        String status = finalResult.content().get(0).toString();
        while (status.indexOf("completed") < 0) {
            finalResult = client.callTool(new CallToolRequest("task", response.toMap()));
            status = finalResult.content().get(0).toString();
        }
        
		System.out.println("Task Response = " + finalResult);

		client.closeGracefully();
	}

}
