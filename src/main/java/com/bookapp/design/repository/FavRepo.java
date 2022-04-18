package com.bookapp.design.repository;

import com.bookapp.design.model.BookList;
import com.bookapp.design.model.Fav;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavRepo extends MongoRepository<Fav, Integer> {

    Fav findByEmail(String emailId);

    void deleteByEmail(String emailId);

    List<Fav> findAllByEmail(String emailId);
}
