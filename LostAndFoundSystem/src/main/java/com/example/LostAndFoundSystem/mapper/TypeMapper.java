package com.example.LostAndFoundSystem.mapper;

import com.example.LostAndFoundSystem.entity.Type;
import org.apache.ibatis.annotations.*;

import java.util.List;

// Mapper interface for Type entity
@Mapper
public interface TypeMapper {

    // Insert a new type
    @Insert("INSERT INTO Type(type_id, typename) VALUES(#{type_id}, #{typename})")
    void insertType(Type type);

    // Update an existing type
    @Update("UPDATE Type SET typename=#{typename} WHERE type_id=#{type_id}")
    void updateType(Type type);

    // Delete a type by ID
    @Delete("DELETE FROM Type WHERE type_id=#{type_id}")
    void deleteType(int type_id);

    // Select a type by ID
    @Select("SELECT * FROM Type WHERE type_id=#{type_id}")
    Type selectTypeById(int type_id);

    // Select all types
    @Select("SELECT * FROM Type")
    List<Type> selectAllTypes();
}
