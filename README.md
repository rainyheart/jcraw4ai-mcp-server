# jcrawl4ai-mcp-server

Java implementation of MCP Server for interacting with Crawl4ai API.

## Project Overview

jcrawl4ai-mcp-server is a Spring Boot-based MCP server that interacts with the Crawl4ai API to perform web crawling. The main functionalities include:

- Crawling specified URLs using a given strategy, maximum depth, and output format.
- Getting the crawl result by a given task ID.

## Configuration

### application.properties

Configure the following properties in the `src/main/resources/application.properties` file:

- `cawl4ai.base-url`: Base URL of the Crawl4ai server.
- `cawl4ai.api-token`: API token for the Crawl4ai server.

Example configuration:
```properties
cawl4ai.base-url=http://your-cral4ai-server-url:11235
cawl4ai.api-token=your-api-token
```

## Dependencies

The project depends on the following libraries:

- Spring AI MCP Server
- Spring Boot
- Hutool

## Running the Project

Build and run the project using Maven:

```sh
mvn clean install
java -jar target/jcawl4ai-mcp-server-1.0.0.jar
```

## APIs

### Crawl4aiApi

#### `crawl` Method

- **Description**: Call the Crawl4ai API to crawl the specified URLs.
- **Parameters**:
  - `urls`: Array of target website URLs.
  - `strategy`: Crawl strategy.
  - `max_depth`: Maximum depth.
  - `output_format`: Output format.
- **Return Value**: JSON string of the crawl result.

#### `task` Method

- **Description**: Get the crawl result by a given task ID.
- **Parameters**:
  - `taskId`: Task ID.
- **Return Value**: JSON string of the crawl result.

## Logging

Log file path: `./target/mcp-stdio-server.log`.

## MCP Server Configuration

``` Json
{
  "mcpServers": {
    "jcawl4ai-mcp-server": {
      "autoApprove": [
        "crawl",
        "task"
      ],
      "disabled": false,
      "timeout": 60,
      "command": "java",
      "args": [
        "-jar",
        "/path/to/your/jar/file/jcawl4ai-mcp-server-1.0.0.jar"
      ],
      "transportType": "stdio"
    }
  }
}
```

## Contact

If you have any questions or suggestions, please contact [Ken Ye](mailto:yjz_work@126.com).

---

# jcrawl4ai-mcp-server

Java 实现的 MCP 服务器，用于与 Crawl4ai API 进行交互。

## 项目概述

jcrawl4ai-mcp-server 是一个基于 Spring Boot 的 MCP 服务器，用于调用 Crawl4ai API 进行网页爬取。该项目的主要功能包括：

- 使用指定的策略、最大深度和输出格式对给定的 URL 进行爬取。
- 根据给定的任务 ID 获取爬取结果。

## 配置

### application.properties

在 `src/main/resources/application.properties` 文件中配置以下属性：

- `cawl4ai.base-url`：Crawl4ai 服务器的基础 URL。
- `cawl4ai.api-token`：Crawl4ai 服务器的 API 令牌。

示例配置：
```properties
cawl4ai.base-url=http://your-cral4ai-server-url:11235
cawl4ai.api-token=your-api-token
```

## 依赖

项目依赖于以下库：

- Spring AI MCP Server
- Spring Boot
- Hutool

## 启动

使用 Maven 构建并运行项目：

```sh
mvn clean install
java -jar target/jcawl4ai-mcp-server-1.0.0.jar
```

## 接口

### Crawl4aiApi

#### `crawl` 方法

- **描述**：调用 Crawl4ai API 爬取指定的 URL。
- **参数**：
  - `urls`：目标网站的 URL 数组。
  - `strategy`：爬取策略。
  - `max_depth`：最大深度。
  - `output_format`：输出格式。
- **返回值**：爬取结果的 JSON 字符串。

#### `task` 方法

- **描述**：根据给定的任务 ID 获取爬取结果。
- **参数**：
  - `taskId`：任务 ID。
- **返回值**：爬取结果的 JSON 字符串。

## 日志

日志文件路径为 `./target/mcp-stdio-server.log`。


## MCP Server 配置

``` Json
{
  "mcpServers": {
    "jcawl4ai-mcp-server": {
      "autoApprove": [
        "crawl",
        "task"
      ],
      "disabled": false,
      "timeout": 60,
      "command": "java",
      "args": [
        "-jar",
        "/path/to/your/jar/file/jcawl4ai-mcp-server-1.0.0.jar"
      ],
      "transportType": "stdio"
    }
  }
}
```

## 联系

如果您有任何问题或建议，请联系 [Ken Ye](mailto:yjz_work@126.com)。