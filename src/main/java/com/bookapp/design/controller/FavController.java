package com.bookapp.design.controller;


import com.bookapp.design.model.BookList;
import com.bookapp.design.model.Fav;
import com.bookapp.design.services.FavService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController


public class FavController {

    @Autowired
    FavService favService;

    private static final Logger LOGGER = LoggerFactory.getLogger(AppController.class);


    @PostMapping("/postfav")
    public ResponseEntity<Fav> createFavList(@RequestBody BookList book, @RequestParam String emailId) {
        try {
            favService.saveFav(book, emailId);
            LOGGER.info("you have successfully created a new list");
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            LOGGER.error("Not Created",e);
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getfav")
    public ResponseEntity<List<BookList>> getFavList(@RequestParam String emailId) {
        try {
            return new ResponseEntity(favService.findFav(emailId), HttpStatus.OK);
        }
        catch (Exception e) {
            LOGGER.error("Not fetched",e);
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
