package com.silva.liveclass.service;

import com.silva.liveclass.domain.User;
import com.silva.liveclass.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User createUser(User user){

        return repository.save(user);
    }

    public List<User>getAll(){
        return (List<User>) repository.findAll();
    }
}
