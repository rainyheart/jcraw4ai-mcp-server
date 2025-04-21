/**
 * Create on Apr 21, 2025
 * 
 * Copyright (c) 2025 by Ken Ye.
 *
 * All Rights Reserved, Designed By Ken Ye
 *
 * Copyright:  Copyright(C) 2025-2035
 *
 * Company:    Ken Ye
 */
package org.rainyheart.cawl4ai.mcp.controller.impl;

import org.rainyheart.cawl4ai.mcp.conf.ConfigProperties;
import org.rainyheart.cawl4ai.mcp.controller.Crawl4aiApi;
import org.rainyheart.cawl4ai.mcp.http.request.CrawlRequest;
import org.rainyheart.cawl4ai.mcp.http.response.CrawlResponse;
import org.rainyheart.cawl4ai.mcp.http.response.CrawlTaskResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;

@Service
public class Crawl4aiApiImpl implements Crawl4aiApi {

    @Autowired
    private ConfigProperties configProperties;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    @Tool(description = "Call crawl4ai API to crawl a URL")
    public String crawl(@ToolParam(description = "the target websites urls") String[] urls,
            @ToolParam(description = "cawl strategy") String strategy,
            @ToolParam(description = "max_depth for cawl") Integer max_depth,
            @ToolParam(description = "response output format for cawl") String output_format) {
        logger.debug("Crawl4aiApiImpl.crawl() urls: {}, strategy: {}, max_depth: {}, output_format: {}", urls, strategy,
                max_depth, output_format);
        CrawlRequest request = new CrawlRequest();
        request.setUrls(urls);
        request.setStrategy(strategy);
        request.setMax_depth(max_depth);
        request.setOutput_format(output_format);
        HttpRequest httpRequest = HttpRequest.post(configProperties.getBaseUrl() + "/crawl")
                .bearerAuth(configProperties.getApiToken()).body(request.toJson());
        HttpResponse response = httpRequest.execute();
        logger.debug(response.body());
        CrawlResponse rsp = JSONUtil.toBean(response.body(), CrawlResponse.class);
        return JSONUtil.toJsonStr(rsp);
    }

    @Override
    @Tool(description = "Get the crawl result by the given taskId")
    public String task(String taskId) {
        logger.debug("taskId: {}", taskId);
        HttpRequest httpRequest = HttpRequest.get(configProperties.getBaseUrl() + "/task/" + taskId)
                .bearerAuth(configProperties.getApiToken());
        HttpResponse response = httpRequest.execute();
        logger.debug(response.body());
        CrawlTaskResponse rsp = JSONUtil.toBean(response.body(), CrawlTaskResponse.class);
        return JSONUtil.toJsonStr(rsp);
    }
}
