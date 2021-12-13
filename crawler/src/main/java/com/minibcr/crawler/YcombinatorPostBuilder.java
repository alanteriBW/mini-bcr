package com.minibcr.crawler;

import org.jsoup.nodes.Element;

public class YcombinatorPostBuilder {


    public YcombinatorPost build(Element element) {
        YcombinatorPost post = new YcombinatorPost();

        post.setId(element.attr("id"));
        post.setLink(element.childNode(4).childNode(0).attr("href"));
        post.setRank(Integer.parseInt(element.childNode(1).childNode(0).childNode(0).toString().replaceAll(".$","")));
        post.setTitle(element.childNode(4).childNode(0).childNode(0).toString());

        return post;
    }

}

