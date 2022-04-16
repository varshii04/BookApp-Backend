package com.bookapp.design.controller;

import com.bookapp.design.model.User;
import com.bookapp.design.services.RegService;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping("/")


public class AppController {

    @Autowired
    private RegService service;

    @PostMapping("/registeruser")
    public User registerUser(@RequestBody User user) throws Exception{
        String tempEmailId = user.getEmail();
        if(tempEmailId != null && !"".equals(tempEmailId)) {
            User userobj = service.fetchUserByEmail(tempEmailId);
            if(userobj != null) {
                throw new Exception("user with "+tempEmailId+"already exists");
            }
        }
        User userObj = null;
        userObj = service.saveUser(user);
        return userObj;
    }

    @PostMapping("/login")
    public User loginUser(@RequestBody User user) throws Exception {
        String tempEmailId = user.getEmail();
        String tempPass = user.getPassword();
        User userobj = null;
        if(tempEmailId != null && tempPass != null) {
            userobj = service.fetchUserByEmailAndPassword(tempEmailId,tempPass);
        }
        if(userobj == null)
        {
            throw new Exception("Bad Credentials");
        }
        return userobj;
    }



















//   private static final Logger LOGGER = LoggerFactory.getLogger(AppController.class);
//    @GetMapping("/register")
//    public ResponseEntity<String> register()
//    {
//        try {
//            LOGGER.info("you have successfully registered");
//            return new ResponseEntity("success", HttpStatus.OK);
//        }
//        catch(Exception e) {
//            LOGGER.error("Not registered",e);
//            return new ResponseEntity("error",HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//    }

//    public String viewHomePage() {
//        return "index";

}
