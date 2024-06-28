package com.example.LostAndFoundSystem.service;

import com.example.LostAndFoundSystem.entity.Post;
import com.example.LostAndFoundSystem.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Service class for Post-related operations
@Service
public class PostService {

    @Autowired
    private PostMapper postMapper;

    // Create or update a post
    public void savePost(Post post) {
        if (post.getPost_id() != null && postMapper.selectPostById(post.getPost_id()) != null) {
            postMapper.updatePost(post);
        } else {
            postMapper.insertPost(post);
        }
    }

    // Delete a post by ID
    public void deletePost(Integer postId) {
        postMapper.deletePost(postId);
    }

    // Get a post by ID
    public Post getPostById(Integer postId) {
        return postMapper.selectPostById(postId);
    }

    // Get all posts
    public List<Post> getAllPosts() {
        return postMapper.selectAllPosts();
    }
}
