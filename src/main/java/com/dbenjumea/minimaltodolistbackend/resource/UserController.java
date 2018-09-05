package com.dbenjumea.minimaltodolistbackend.resource;

import com.dbenjumea.minimaltodolistbackend.entity.User;
import com.dbenjumea.minimaltodolistbackend.repository.UserRepository;
import com.dbenjumea.minimaltodolistbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin
public class UserController {

    @Autowired
    UserRepository repository;

    @Autowired
    UserService service;

    @GetMapping
    public String getHelloWorld() {
        return "Hello World";
    }

    @GetMapping(value = "/user/all")
    public List<User> retrieveAllUsers() {
        List<User> list = repository.findAll();
        return list;
    }

    @GetMapping("/user/{username}/{password}")
    public User retrieveUser(@PathVariable String username, @PathVariable String password) {
        User user = service.findByUsernameAndPassword(username, password);

        return user;
    }
}
