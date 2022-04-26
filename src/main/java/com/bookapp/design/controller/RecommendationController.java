package com.bookapp.design.controller;

import com.bookapp.design.model.BookList;
import com.bookapp.design.model.Fav;
import com.bookapp.design.model.Recommendation;
import com.bookapp.design.services.FavService;
import com.bookapp.design.services.RecommendationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController


public class RecommendationController {

    @Autowired
    RecommendationService recommendationService;

    private static final Logger LOGGER = LoggerFactory.getLogger(AppController.class);


    @PostMapping("/postrec")
    public ResponseEntity<Recommendation> createRecommendationList(@RequestBody BookList book, @RequestParam String emailId) {
        try {
            recommendationService.saveRecommendation(book, emailId);
            LOGGER.info("you have successfully created a new list");
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            LOGGER.error("Not Created",e);
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getrec")
    public ResponseEntity<List<BookList>> getRecommendationList(@RequestParam String emailId) {
        try {
            return new ResponseEntity(recommendationService.findRecommendation(emailId), HttpStatus.OK);
        }
        catch (Exception e) {
            LOGGER.error("Not fetched",e);
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
