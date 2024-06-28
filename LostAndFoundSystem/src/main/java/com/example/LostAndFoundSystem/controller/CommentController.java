package com.example.LostAndFoundSystem.controller;

import com.example.LostAndFoundSystem.entity.Comment;
import com.example.LostAndFoundSystem.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// REST controller for managing comments
@RestController
@RequestMapping("/api/comments")
@CrossOrigin(origins = "http://localhost:5173")
public class CommentController {

    @Autowired
    private CommentService commentService;

    // Create or update a comment
    @PostMapping("/")
    public ResponseEntity<Comment> saveComment(@RequestBody Comment comment) {
        commentService.saveComment(comment);
        return ResponseEntity.ok(comment);
    }

    // Delete a comment
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Integer id) {
        commentService.deleteComment(id);
        return ResponseEntity.ok().build();
    }

    // Get a comment by ID
    @GetMapping("/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Integer id) {
        Comment comment = commentService.getCommentById(id);
        return ResponseEntity.ok(comment);
    }

    // Get all comments
    @GetMapping("/")
    public ResponseEntity<List<Comment>> getAllComments() {
        List<Comment> comments = commentService.getAllComments();
        return ResponseEntity.ok(comments);
    }
}
