package com.minibcr.crawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
@PropertySource("classpath:crawler.properties")
public class Crawler {

    private static String URL;
    private static String[] DISALLOWED;

    private static YcombinatorPostBuilder ycombinatorPostBuilder = new YcombinatorPostBuilder();

    @Scheduled(fixedRate = 30000)
    public void run() {
        Crawler crawler = new Crawler();

        try {
            for (YcombinatorPost post : crawler.getArticles()) {
                System.out.println("-----------");
                System.out.println("Title: " + post.getTitle());
                System.out.println("Link: " + post.getLink());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<YcombinatorPost> getArticles() throws IOException {
        List<YcombinatorPost> ycombinatorPosts = new ArrayList<>();

        if (disallowed(URL)) {
            System.out.println("This url is disallowed: " + URL);
        }

        Document document = Jsoup.connect(URL).get();
        Elements elements = document.select("tr.athing");
        for (Element element : elements) {
            ycombinatorPosts.add(ycombinatorPostBuilder.build(element));
        }

        return ycombinatorPosts;
    }

    private boolean disallowed(String url) {
        for (String disallowedUrl : DISALLOWED) {
            if (url.contains(disallowedUrl)) {
                return true;
            }
        }

        return false;
    }

    @Value("${ycombinator.url}")
    public void setUrl(String value) {
        this.URL = value;
    }

    @Value("${ycombinator.disallowed}")
    public void setDisallowed(String[] value) {
        this.DISALLOWED = value;
    }

}
