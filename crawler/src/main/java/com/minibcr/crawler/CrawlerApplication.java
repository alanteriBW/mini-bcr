package com.minibcr.crawler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

@SpringBootApplication public class CrawlerApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(CrawlerApplication.class, args);
        SimpleCrawler crawler = new SimpleCrawler();

        crawler.getArticles();
    }

}
