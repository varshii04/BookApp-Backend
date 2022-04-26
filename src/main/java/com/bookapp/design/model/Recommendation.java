package com.bookapp.design.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@ToString
@Document(collection = "RecommendationList")
public class Recommendation {
    private String email;
    private List<BookList> recommendation;

    public Recommendation() {

    }

    public Recommendation(String email, List<BookList> favs) {
        this.email = email;
        this.recommendation = recommendation;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<BookList> getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(List<BookList> recommendation) {
        this.recommendation = recommendation;
    }
}

