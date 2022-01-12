package com.minibcr.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostCrudRepository repository;

    @Override
    public List<Post> findAllPeople() {
        return (List<Post>) repository.findAll();
    }

    @Override
    public Post findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Post insert(Post post) {
        return repository.save(post);
    }

    @Override
    public boolean delete(Long id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Post post) {
        try {
            repository.save(post);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
