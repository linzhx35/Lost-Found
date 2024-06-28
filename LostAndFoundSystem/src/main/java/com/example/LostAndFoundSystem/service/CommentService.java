package com.example.LostAndFoundSystem.service;

import com.example.LostAndFoundSystem.entity.Comment;
import com.example.LostAndFoundSystem.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Service class for Comment-related operations
@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;

    // Create or update a comment
    public void saveComment(Comment comment) {
        if (comment.getComment_id() != null && commentMapper.selectCommentById(comment.getComment_id()) != null) {
            commentMapper.updateComment(comment);
        } else {
            commentMapper.insertComment(comment);
        }
    }

    // Delete a comment by ID
    public void deleteComment(Integer commentId) {
        commentMapper.deleteComment(commentId);
    }

    // Get a comment by ID
    public Comment getCommentById(Integer commentId) {
        return commentMapper.selectCommentById(commentId);
    }

    // Get all comments
    public List<Comment> getAllComments() {
        return commentMapper.selectAllComments();
    }
}
