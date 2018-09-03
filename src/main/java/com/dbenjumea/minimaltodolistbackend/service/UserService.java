package com.dbenjumea.minimaltodolistbackend.service;

import com.dbenjumea.minimaltodolistbackend.entity.User;
import com.dbenjumea.minimaltodolistbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements GenericService <User> {
    @Autowired
    UserRepository userRepository;

    @Override
    public Optional<User> findById(long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User save(User obj) {
        User userSaved = userRepository.save(obj);
        return userSaved;
    }

    public Optional<User> findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
}
