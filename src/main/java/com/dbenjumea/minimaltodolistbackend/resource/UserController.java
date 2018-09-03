package com.dbenjumea.minimaltodolistbackend.resource;

import com.dbenjumea.minimaltodolistbackend.entity.User;
import com.dbenjumea.minimaltodolistbackend.repository.UserRepository;
import com.dbenjumea.minimaltodolistbackend.service.UserService;
import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository repository;

    @Autowired
    UserService service;

    @GetMapping
    public String getHelloWorld() {
        return "Hello World";
    }

    @GetMapping(value = "/users")
    public List<User> retrieveAllUsers() {
        List<User> list = repository.findAll();
        return list;
    }

    @GetMapping("/user/{username}/{password}")
    public User retrieveUser(@PathVariable String username, @PathVariable String password) throws UserException {
        Optional<User> user = service.findByUsernameAndPassword(username, password);
        return user.get();
    }
}
