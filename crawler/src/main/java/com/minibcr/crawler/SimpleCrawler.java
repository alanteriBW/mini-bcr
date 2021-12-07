package com.minibcr.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashSet;

import static java.lang.Thread.sleep;

@Component
@PropertySource("classpath:crawler.properties")
public class SimpleCrawler {

    private static String URL;
    private static int MAX_DEPTH;
    private static int SLEEP_TIME;
    private static String[] DISALLOWED;

    @Value("${ycombinator.url}")
    public void setUrl(String value) {
        this.URL = value;
    }
    @Value("${ycombinator.depth}")
    public void setMaxDepth(String value) {
        this.MAX_DEPTH = Integer.parseInt(value);
    }
    @Value("${ycombinator.delay}")
    public void setSleepTime(String value) {
        this.SLEEP_TIME = Integer.parseInt(value);
    }

    @Value("${ycombinator.disallowed}")
    public void setDisallowed(String[] value) {
        this.DISALLOWED = value;
    }

    private HashSet<String> links;

    public SimpleCrawler() {
        links = new HashSet<String>();
    }

    public void getLinks(int depth){
        getPageLinks(URL, depth);
    }

    public void getArticles() throws IOException {
        Document document = Jsoup.connect(URL).get();
        Elements entries = document.select("tr.athing");
        for(Element entry : entries){
            System.out.println(entry);
        }

    }

    public void getPageLinks(String url, int depth) {
       if (!links.contains(url) && depth < MAX_DEPTH && !disallowed(url) ) {
            try {
                if (links.add(url)) {
                    System.out.println(">> Depth: " + depth + " [" + url + "]");
                    sleep(SLEEP_TIME);

                }

                Document document = Jsoup.connect(url).get();
                Elements linksOnPage = document.select("a[href]");

                for (Element page : linksOnPage) {
                    getPageLinks(page.attr("abs:href"), depth);
                }
            } catch (IOException | InterruptedException e) {
                System.err.println("For '" + url + "': " + e.getMessage());
            }
        }
    }

    private boolean disallowed(String url) {

        for(String disallowedUrl : DISALLOWED)
            if(url.contains(disallowedUrl)){
                return true;
            }

        return false;
    }

}
