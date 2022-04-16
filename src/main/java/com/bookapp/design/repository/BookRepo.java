package com.bookapp.design.repository;

import com.bookapp.design.model.BookList;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepo extends MongoRepository<BookList, Integer> {
    List<BookList> findByTitleContaining(String title);
    List<BookList> findByAuthorContaining(String author);
}