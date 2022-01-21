package com.minibcr.crawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;

import com.minibcr.commons.Post;

public class YcombinatorService {
    public YcombinatorService() {
    }

    private static YcombinatorPostBuilder ycombinatorPostBuilder = new YcombinatorPostBuilder();
    private static YcombinatorClient ycombinatorClient = new YcombinatorClient();

    public List<Post> getArticles(String url, String[] disallowed) throws IOException {
        List<Post> ycombinatorPosts = new ArrayList<>();

        if (disallowed(url, disallowed)) {
            System.out.println("This url is disallowed: " + url);
        }

        for (Element element : ycombinatorClient.getElements(url)) {
            ycombinatorPosts.add(ycombinatorPostBuilder.build(element));
        }

        return ycombinatorPosts;
    }

    boolean disallowed(String url, String[] disallowed) {
        for (String disallowedUrl : disallowed) {
            if (url.contains(disallowedUrl)) {
                return true;
            }
        }

        return false;
    }
}
