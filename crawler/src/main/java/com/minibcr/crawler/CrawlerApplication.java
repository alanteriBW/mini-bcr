package com.minibcr.crawler;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = {"com.minibcr.commons"})
@EntityScan(basePackages = "com.minibcr.commons")
public class CrawlerApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(CrawlerApplication.class, args);
    }
}
