package com.minibcr.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostServiceImpl postService;

    @GetMapping("")
    public List<Post> getAllPeople() {
        return postService.findAllPeople();
    }

    @GetMapping("{id}")
    public Post getPost(@PathVariable long id) {
        return postService.findById(id);
    }

    @PostMapping("")
    public String addPost(@RequestBody Post post) {

        if (post != null) {
            postService.insert(post);
            return "Added a post";
        } else {
            return "Request does not contain a body";
        }
    }

    @DeleteMapping("{id}")
    public String deletePost(@PathVariable("id") long id) {

        if (id > 0) {
            if (postService.delete(id)) {
                return "Deleted the post.";
            } else {
                return "Cannot delete the post.";
            }
        }
        return "The id is invalid for the post.";
    }

    @PutMapping("")
    public String updatePost(@RequestBody Post post) {
        if (post != null) {
            postService.update(post);
            return "Updated post.";
        } else {
            return "Request does not contain a body";
        }
    }

}
