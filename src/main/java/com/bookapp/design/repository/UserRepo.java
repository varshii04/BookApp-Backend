package com.bookapp.design.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bookapp.design.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    public User findByEmail(String emailId);
    public User findByEmailAndPassword(String emailId, String password);
}
