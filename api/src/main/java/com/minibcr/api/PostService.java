package com.minibcr.api;

import java.util.List;

import com.minibcr.commons.Post;

public interface PostService {

    List<Post> findAllPeople();

    Post findById(Long id);

    Post insert(Post p);

    boolean delete(Long id);

    boolean update(Post p);
}
