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
package org.rainyheart.cawl4ai.mcp.controller;

public interface Crawl4aiApi {

    public String task(String taskId);

    public String crawl(String[] urls, String strategy, Integer max_depth, String output_format);
}
