package com.minibcr.api;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Posts")
public class Post {

    @Id
    @Column(name = "id")
    public Long id;
    @Column(name = "title")
    public String title;
    @Column(name = "link")
    public String link;

    public Post(Long id, String title, String link) {
        this.id = id;
        this.title = title;
        this.link = link;
    }

    public Post() {

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Post)) {
            return false;
        }
        Post post = (Post) o;
        return getId().equals(post.getId()) && Objects.equals(getTitle(), post.getTitle()) && Objects.equals(getLink(), post.getLink());
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        builder.append(id.toString());
        builder.append(", ");
        builder.append(title);
        builder.append(", ");
        builder.append(link);

        return builder.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getLink());
    }

    public String getId() {
        return id.toString();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
