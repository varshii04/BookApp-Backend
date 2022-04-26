package com.bookapp.design.repository;


import com.bookapp.design.model.Fav;
import com.bookapp.design.model.Recommendation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommendationRepo extends MongoRepository<Recommendation, Integer> {

    Recommendation findByEmail(String emailId);

    void deleteByEmail(String emailId);

    List<Fav> findAllByEmail(String emailId);
}
