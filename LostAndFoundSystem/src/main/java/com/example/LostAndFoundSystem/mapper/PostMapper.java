package com.example.LostAndFoundSystem.mapper;

import com.example.LostAndFoundSystem.entity.Post;
import org.apache.ibatis.annotations.*;

import java.util.List;

// Mapper interface for Post entity
@Mapper
public interface PostMapper {

    // Insert a new post
    @Insert("INSERT INTO Post(post_id, user_id, type_id, title, description, location, img_url, post_type, status) VALUES(#{post_id}, #{user_id}, #{type_id}, #{title}, #{description}, #{location}, #{img_url}, #{post_type}, #{status})")
    void insertPost(Post post);

    // Update an existing post
    @Update("UPDATE Post SET title=#{title}, description=#{description}, location=#{location}, img_url=#{img_url}, post_type=#{post_type}, status=#{status} WHERE post_id=#{post_id}")
    void updatePost(Post post);

    // Delete a post by ID
    @Delete("DELETE FROM Post WHERE post_id=#{post_id}")
    void deletePost(int post_id);

    // Select a post by ID
    @Select("SELECT * FROM Post WHERE post_id=#{post_id}")
    Post selectPostById(int post_id);

    // Select all posts
    @Select("SELECT * FROM Post")
    List<Post> selectAllPosts();
}
