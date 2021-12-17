package com.minibcr.crawler;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class YcombinatorClient {

    public Elements getElements(String url) throws IOException {
        Document document = Jsoup.connect(url).get();
        return document.select("tr.athing");
    }
}
