package com.minibcr.api;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostCrudRepository extends CrudRepository<Post, Long> {
}
