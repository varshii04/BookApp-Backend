package com.bookapp.design.services;

import com.bookapp.design.model.User;
import com.bookapp.design.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegService {

    @Autowired
    private UserRepo repo;

    public User saveUser(User user) {
        return repo.save(user);
    }

    public User fetchUserByEmail(String email) {
        return repo.findByEmail(email);
    }

    public User fetchUserByEmailAndPassword(String email, String password) {
        return repo.findByEmailAndPassword(email, password);
    }
}
