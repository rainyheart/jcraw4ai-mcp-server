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
package org.rainyheart.cawl4ai.mcp.http.request;

import java.util.HashMap;
import java.util.Map;

import cn.hutool.json.JSONUtil;

public class CrawlRequest {

    private String[] urls;

    private String strategy;

    private Integer max_depth;

    private String output_format;

    public String[] getUrls() {
        return urls;
    }

    public void setUrls(String[] urls) {
        this.urls = urls;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    public Integer getMax_depth() {
        return max_depth;
    }

    public void setMax_depth(Integer max_depth) {
        this.max_depth = max_depth;
    }

    public String getOutput_format() {
        return output_format;
    }

    public void setOutput_format(String output_format) {
        this.output_format = output_format;
    }

    public String toJson() {
        return JSONUtil.toJsonStr(this);
    }
    
    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("urls", urls);
        map.put("urstrategyls", strategy);
        map.put("max_depth", max_depth);
        map.put("output_format", output_format);
        return map;
    }

}
