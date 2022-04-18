package com.bookapp.design.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@ToString
@Document(collection = "FavouriteList")
public class Fav {
    private String email;
    private List<BookList> favs;

    public Fav() {

    }

    public Fav(String email, List<BookList> favs) {
        this.email = email;
        this.favs = favs;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<BookList> getFavs() {
        return favs;
    }

    public void setFavs(List<BookList> favs) {
        this.favs = favs;
    }
}


