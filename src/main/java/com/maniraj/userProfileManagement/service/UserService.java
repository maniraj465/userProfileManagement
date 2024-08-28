package com.maniraj.userProfileManagement.service;

import com.maniraj.userProfileManagement.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface UserService {

    void addUser(User user, MultipartFile image) throws IOException;

    User updateUser(User user, MultipartFile image) throws IOException;

    List<User> getAllUsers();

    Optional<User> getUser(Long id);

    void deleteUser(User user);
}
