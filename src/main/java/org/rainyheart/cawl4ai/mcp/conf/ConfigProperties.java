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
package org.rainyheart.cawl4ai.mcp.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "crawl4ai")
public class ConfigProperties {
    private String baseUrl;
    private String apiToken;
    public String getBaseUrl() {
        return baseUrl;
    }
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
    public String getApiToken() {
        return apiToken;
    }
    public void setApiToken(String apiToken) {
        this.apiToken = apiToken;
    }

}
