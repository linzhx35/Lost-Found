package com.example.LostAndFoundSystem.mapper;

import com.example.LostAndFoundSystem.entity.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

// Mapper interface for Comment entity
@Mapper
public interface CommentMapper {

    // Insert a new comment
    @Insert("INSERT INTO Comment(comment_id, post_id, user_id, content, time, parent_id) VALUES(#{comment_id}, #{post_id}, #{user_id}, #{content}, #{time}, #{parent_id})")
    void insertComment(Comment comment);

    // Update an existing comment
    @Update("UPDATE Comment SET content=#{content}, time=#{time} WHERE comment_id=#{comment_id}")
    void updateComment(Comment comment);

    // Delete a comment by ID
    @Delete("DELETE FROM Comment WHERE comment_id=#{comment_id}")
    void deleteComment(int comment_id);

    // Select a comment by ID
    @Select("SELECT * FROM Comment WHERE comment_id=#{comment_id}")
    Comment selectCommentById(int comment_id);

    // Select all comments
    @Select("SELECT * FROM Comment")
    List<Comment> selectAllComments();
}
