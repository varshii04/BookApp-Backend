package com.bookapp.design.services;

import com.bookapp.design.model.BookList;
import com.bookapp.design.model.Fav;
import com.bookapp.design.model.User;
import com.bookapp.design.repository.FavRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class FavService {
    @Autowired

    private FavRepo favRepo;
    BookList book;
    Fav fav = new Fav();

    public void saveFav(BookList book, String emailId) {
        if(favRepo.findByEmail(emailId)==null){
            List<BookList> list = new ArrayList<BookList>();
            list.add(book);
            System.out.println(list);
            fav.setEmail(emailId);
            fav.setFavs(list);
            System.out.println(fav);
            favRepo.save(fav);
        }
        else
        {
            fav = favRepo.findByEmail(emailId);
            favRepo.deleteByEmail(emailId);
            fav.getFavs().add(book);
            fav.setEmail(emailId);
            favRepo.save(fav);
            System.out.println(fav);
        }

    }

    public List<BookList> findFav(String emailId) {
        if(favRepo.findByEmail(emailId)==null){
            return null;
        }
        else {
            fav = favRepo.findByEmail(emailId);
            return fav.getFavs();
        }
    }
}

