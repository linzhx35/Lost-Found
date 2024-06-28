package com.example.LostAndFoundSystem.controller;

import com.example.LostAndFoundSystem.entity.Post;
import com.example.LostAndFoundSystem.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// REST controller for managing posts
@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = "http://localhost:5173")
public class PostController {

    @Autowired
    private PostService postService;

    // Create or update a post
    @PostMapping("/")
    public ResponseEntity<Post> savePost(@RequestBody Post post) {
        postService.savePost(post);
        return ResponseEntity.ok(post);
    }

    // Delete a post
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Integer id) {
        postService.deletePost(id);
        return ResponseEntity.ok().build();
    }

    // Get a post by ID
    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Integer id) {
        Post post = postService.getPostById(id);
        return ResponseEntity.ok(post);
    }

    // Get all posts
    @GetMapping("/")
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        return ResponseEntity.ok(posts);
    }
}
