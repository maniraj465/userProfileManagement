package com.maniraj.userProfileManagement.service;

import com.maniraj.userProfileManagement.entity.User;
import com.maniraj.userProfileManagement.exception.UserNotFoundException;
import com.maniraj.userProfileManagement.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    UserRepository repository;

    UserServiceImpl (UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addUser(User user, MultipartFile image) throws IOException {
        user.setProfilePicture(image.getBytes());
        repository.save(user);
    }

    @Override
    public User updateUser(User user, MultipartFile image) throws IOException {
        Long id = user.getUserId();
        Optional<User> existingUser = repository.findById(id);
        if (existingUser.isPresent()) {
            user.setProfilePicture(image.getBytes());
            return repository.save(user);
        }
        else {
            throw new UserNotFoundException(id);
        }
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public Optional<User> getUser(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteUser(User user) {
        repository.delete(user);
    }


}
