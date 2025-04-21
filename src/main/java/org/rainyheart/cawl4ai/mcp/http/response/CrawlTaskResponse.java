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
package org.rainyheart.cawl4ai.mcp.http.response;

public class CrawlTaskResponse {
    private String status;
    private String created_at;
    private Result[] results;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public Result[] getResults() {
        return results;
    }

    public void setResults(Result[] results) {
        this.results = results;
    }

    public class Result {

        private String url;
        private String html;
        private Boolean success;
        private String cleaned_html;
        private String[] media;
        private String[] links;
        private String downloaded_files;
        private String screenshot;
        private String markdown;
        private String markdown_v2;
        private String fit_markdown;
        private String fit_html;
        private String extracted_content;
        private String[] metadata;
        private String error_message;
        private String session_id;
        private String[] response_headers;
        private String status_code;

        public Result() {
            super();
        }
        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getHtml() {
            return html;
        }

        public void setHtml(String html) {
            this.html = html;
        }

        public Boolean getSuccess() {
            return success;
        }

        public void setSuccess(Boolean success) {
            this.success = success;
        }

        public String getCleaned_html() {
            return cleaned_html;
        }

        public void setCleaned_html(String cleaned_html) {
            this.cleaned_html = cleaned_html;
        }

        public String[] getMedia() {
            return media;
        }

        public void setMedia(String[] media) {
            this.media = media;
        }

        public String[] getLinks() {
            return links;
        }

        public void setLinks(String[] links) {
            this.links = links;
        }

        public String getDownloaded_files() {
            return downloaded_files;
        }

        public void setDownloaded_files(String downloaded_files) {
            this.downloaded_files = downloaded_files;
        }

        public String getScreenshot() {
            return screenshot;
        }

        public void setScreenshot(String screenshot) {
            this.screenshot = screenshot;
        }

        public String getMarkdown() {
            return markdown;
        }

        public void setMarkdown(String markdown) {
            this.markdown = markdown;
        }

        public String getMarkdown_v2() {
            return markdown_v2;
        }

        public void setMarkdown_v2(String markdown_v2) {
            this.markdown_v2 = markdown_v2;
        }

        public String getFit_markdown() {
            return fit_markdown;
        }

        public void setFit_markdown(String fit_markdown) {
            this.fit_markdown = fit_markdown;
        }

        public String getFit_html() {
            return fit_html;
        }

        public void setFit_html(String fit_html) {
            this.fit_html = fit_html;
        }

        public String getExtracted_content() {
            return extracted_content;
        }

        public void setExtracted_content(String extracted_content) {
            this.extracted_content = extracted_content;
        }

        public String[] getMetadata() {
            return metadata;
        }

        public void setMetadata(String[] metadata) {
            this.metadata = metadata;
        }

        public String getError_message() {
            return error_message;
        }

        public void setError_message(String error_message) {
            this.error_message = error_message;
        }

        public String getSession_id() {
            return session_id;
        }

        public void setSession_id(String session_id) {
            this.session_id = session_id;
        }

        public String[] getResponse_headers() {
            return response_headers;
        }

        public void setResponse_headers(String[] response_headers) {
            this.response_headers = response_headers;
        }

        public String getStatus_code() {
            return status_code;
        }

        public void setStatus_code(String status_code) {
            this.status_code = status_code;
        }
    }
}
