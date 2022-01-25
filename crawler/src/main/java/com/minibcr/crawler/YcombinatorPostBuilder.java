package com.minibcr.crawler;

import org.jsoup.nodes.Element;

import com.minibcr.commons.Post;

public class YcombinatorPostBuilder {

    public Post build(Element element) {
        Post post = new Post();

        post.setId(Long.decode(element.attr("id")));
        post.setLink(element.childNode(4).childNode(0).attr("href"));
        post.setTitle(element.childNode(4).childNode(0).childNode(0).toString());

        return post;
    }

}

