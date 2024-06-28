package com.example.LostAndFoundSystem.mapper;

import com.example.LostAndFoundSystem.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

// Mapper interface for User entity
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE username = #{username}")
    User findByUsername(String username);

    @Insert("INSERT INTO user(username, password, email, role) VALUES(#{username}, #{password}, #{email}, #{role})")
    @Options(useGeneratedKeys = true, keyProperty = "user_id")
    void insertUser(User user);

    // Update an existing user
    @Update("UPDATE User SET username=#{username}, password=#{password}, email=#{email}, role=#{role} WHERE user_id=#{user_id}")
    void updateUser(User user);

    // Delete a user by ID
    @Delete("DELETE FROM User WHERE user_id=#{user_id}")
    void deleteUser(int user_id);

    // Select a user by ID
    @Select("SELECT * FROM User WHERE user_id=#{user_id}")
    User selectUserById(int user_id);

    // Select all users
    @Select("SELECT * FROM User")
    List<User> selectAllUsers();
}
