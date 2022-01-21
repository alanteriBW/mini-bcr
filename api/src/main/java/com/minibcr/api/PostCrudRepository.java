package com.minibcr.api;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.minibcr.commons.Post;

@Repository
public interface PostCrudRepository extends CrudRepository<Post, Long> {
}
