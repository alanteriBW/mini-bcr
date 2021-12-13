package com.minibcr.crawler;

import java.util.Objects;

public class YcombinatorPost {

    public String id;
    public String title;
    public int rank;
    public String link;

    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof YcombinatorPost)) {
            return false;
        }
        YcombinatorPost entry = (YcombinatorPost) o;
        return getRank() == entry.getRank() && Objects.equals(getId(), entry.getId())
                && Objects.equals(getTitle(), entry.getTitle()) && Objects.equals(getLink(),
                entry.getLink());
    }

    @Override public int hashCode() {
        return Objects.hash(getId(), getTitle(), getRank(), getLink());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }


}
