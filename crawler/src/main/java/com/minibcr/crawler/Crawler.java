package com.minibcr.crawler;

import java.io.IOException;

import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.minibcr.commons.Post;

@Component
@EnableScheduling
@PropertySource("classpath:crawler.properties")
public class Crawler {

    private final YcombinatorService ycombinatorService = new YcombinatorService();
    private final YcombinatorConfig ycombinatorConfig = new YcombinatorConfig();
    
    @Scheduled(fixedRate = 30000)
    public void run() {

        String url = ycombinatorConfig.getUrl();
        String[] disallowed = ycombinatorConfig.getDisallowed();


        try {
            for (Post post : ycombinatorService.getArticles(url, disallowed)) {
                System.out.println("-----------");
                System.out.println("Title: " + post.getTitle());
                System.out.println("Link: " + post.getLink());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
