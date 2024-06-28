package com.example.LostAndFoundSystem.service;

import com.example.LostAndFoundSystem.entity.Type;
import com.example.LostAndFoundSystem.mapper.TypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Service class for Type-related operations
@Service
public class TypeService {

    @Autowired
    private TypeMapper typeMapper;

    // Create or update a type
    public void saveType(Type type) {
        if (type.getType_id() != null && typeMapper.selectTypeById(type.getType_id()) != null) {
            typeMapper.updateType(type);
        } else {
            typeMapper.insertType(type);
        }
    }

    // Delete a type by ID
    public void deleteType(Integer typeId) {
        typeMapper.deleteType(typeId);
    }

    // Get a type by ID
    public Type getTypeById(Integer typeId) {
        return typeMapper.selectTypeById(typeId);
    }

    // Get all types
    public List<Type> getAllTypes() {
        return typeMapper.selectAllTypes();
    }
}
