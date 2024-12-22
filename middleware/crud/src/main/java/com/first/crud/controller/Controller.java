package com.first.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.first.crud.DTO.SaveDTO;
import com.first.crud.repo.Repo;
import com.first.crud.service.Service; 
import com.first.crud.entity.User;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/crud")
public class Controller {

    @Autowired
    private Service service;

    @Autowired
    private Repo repo; 

    @PostMapping("/save")
    public ResponseEntity<String> addData(@RequestBody SaveDTO saveDTO) {
        try {
            String userId = service.addUser(saveDTO);
            return ResponseEntity.ok("User added with ID: " + userId);
        } catch (Exception e) {
            // Log the error
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding user: " + e.getMessage());
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        Optional<User> user = repo.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUser(@PathVariable int id, @RequestBody SaveDTO updatedUser) {
        Optional<User> userOpt = repo.findById(id);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            user.setName(updatedUser.getName());
            user.setMobile(updatedUser.getMobile());
            user.setEmail(updatedUser.getEmail());
            repo.save(user);
            return ResponseEntity.ok("User updated successfully.");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return ResponseEntity.ok("User deleted successfully.");
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = repo.findAll();
        return ResponseEntity.ok(users);
    }

}
