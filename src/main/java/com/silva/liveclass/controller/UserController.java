package com.silva.liveclass.controller;

import com.silva.liveclass.domain.User;
import com.silva.liveclass.service.EncryptionDemo;
import com.silva.liveclass.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.IntStream;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public User create(@RequestBody User user){
        return service.createUser(user);
    }

    @GetMapping
    public List<User> getAll(){
        return service.getAll();
    }

    @GetMapping("/cpu/{times}")
    public ResponseEntity<Void> cpu(@PathVariable Integer times){
        IntStream.range(1, times).forEach(item -> {
            new EncryptionDemo().execute();
            System.out.println("UserController.getAll");
        });
        return ResponseEntity.ok().build();
    }

    @GetMapping("/hello/{name}")
    public ResponseEntity<String> sayHello(@PathVariable String name){
        return ResponseEntity.ok("Hello: " + name);
    }

}
