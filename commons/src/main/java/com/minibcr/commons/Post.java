package com.minibcr.commons;

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

    public Post() {

    }

    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Post)) {
            return false;
        }
        Post entry = (Post) o;
        return  Objects.equals(getId(), entry.getId())
                && Objects.equals(getTitle(), entry.getTitle()) && Objects.equals(getLink(),
                entry.getLink());
    }

    @Override public int hashCode() {
        return Objects.hash(getId(), getTitle(), getLink());
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

    public Long getId() {
        return id;
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
