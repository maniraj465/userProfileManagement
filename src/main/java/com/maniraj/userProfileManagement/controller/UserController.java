package com.maniraj.userProfileManagement.controller;

import com.maniraj.userProfileManagement.entity.User;
import com.maniraj.userProfileManagement.exception.UserNotFoundException;
import com.maniraj.userProfileManagement.service.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    UserServiceImpl service;

    public UserController(UserServiceImpl service) {
        this.service = service;
    }

    @PostMapping(consumes = { "multipart/form-data" })
    public ResponseEntity<?> createUser(@RequestPart("user") User user, @RequestPart("profile_picture") MultipartFile image) throws IOException {
        service.addUser(user, image);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PutMapping(path = "{id}", consumes = { "multipart/form-data" })
    public ResponseEntity<?> updateUser(@RequestPart("user") User user, @RequestPart("profile_picture") MultipartFile image) throws IOException {
        service.updateUser(user, image);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        List<User> users = service.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {
        Optional<User> user = service.getUser(id);
        if (user.isPresent()) {
            return ResponseEntity.of(user);
        }
        else {
            throw new UserNotFoundException(id);
        }
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        return service.getUser(id)
                .map(user -> {
                    service.deleteUser(user);
                    return ResponseEntity.noContent().build();
                }).orElseThrow(() -> new UserNotFoundException(id));
    }
}