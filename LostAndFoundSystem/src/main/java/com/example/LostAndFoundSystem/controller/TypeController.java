package com.example.LostAndFoundSystem.controller;

import com.example.LostAndFoundSystem.entity.Type;
import com.example.LostAndFoundSystem.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// REST controller for managing types
@RestController
@RequestMapping("/api/types")
@CrossOrigin(origins = "http://localhost:5173")
public class TypeController {

    @Autowired
    private TypeService typeService;

    // Create or update a type
    @PostMapping("/")
    public ResponseEntity<Type> saveType(@RequestBody Type type) {
        typeService.saveType(type);
        return ResponseEntity.ok(type);
    }

    // Delete a type
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteType(@PathVariable Integer id) {
        typeService.deleteType(id);
        return ResponseEntity.ok().build();
    }

    // Get a type by ID
    @GetMapping("/{id}")
    public ResponseEntity<Type> getTypeById(@PathVariable Integer id) {
        Type type = typeService.getTypeById(id);
        return ResponseEntity.ok(type);
    }

    // Get all types
    @GetMapping("/")
    public ResponseEntity<List<Type>> getAllTypes() {
        List<Type> types = typeService.getAllTypes();
        return ResponseEntity.ok(types);
    }
}
