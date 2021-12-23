package com.minibcr.crawler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:crawler.properties")
public class YcombinatorConfig {


    private static String URL;
    private static String[] DISALLOWED;

    @Value("${ycombinator.url}")
    public void setUrl(String value) {
        this.URL = value;
    }

    public String getUrl() {
        return this.URL;
    }

    @Value("${ycombinator.disallowed}")
    public void setDisallowed(String[] value) {
        this.DISALLOWED = value;
    }

    public String[] getDisallowed() {
        return this.DISALLOWED;
    }
}
