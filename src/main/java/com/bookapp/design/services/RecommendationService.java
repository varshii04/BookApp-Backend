package com.bookapp.design.services;

import com.bookapp.design.model.BookList;

import com.bookapp.design.model.Recommendation;
import com.bookapp.design.repository.RecommendationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecommendationService {
    @Autowired

    private RecommendationRepo recommendationRepo;
    BookList book;
    Recommendation rec = new Recommendation();

    public void saveRecommendation(BookList book, String emailId) {
        if(recommendationRepo.findByEmail(emailId)==null){
            List<BookList> list = new ArrayList<BookList>();
            list.add(book);
            System.out.println(list);
            rec.setEmail(emailId);
            rec.setRecommendation(list);
            System.out.println(rec);
            recommendationRepo.save(rec);
        }
        else
        {
            rec = recommendationRepo.findByEmail(emailId);
            recommendationRepo.deleteByEmail(emailId);
            rec.getRecommendation().add(book);
            rec.setEmail(emailId);
            recommendationRepo.save(rec);
            System.out.println(rec);
        }

    }

    public List<BookList> findRecommendation(String emailId) {
        if(recommendationRepo.findByEmail(emailId)==null){
            return null;
        }
        else {
            rec = recommendationRepo.findByEmail(emailId);
            return rec.getRecommendation();
        }
    }
}