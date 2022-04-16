package com.bookapp.design.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection = "favlist")
public class BookList {
    private String id;
    private String title;
    private String text;
//    private String description;
//    private String image;
//    private String lang;
//    private String date;

    public BookList() {
    }

    public BookList( String id, String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
//        this.description = description;
//        this.image = image;
//        this.lang = lang;
//        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setAuthor(String text) {
        this.text = text;
    }

//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getImage() {
//        return image;
//    }
//
//    public void setImage(String image) {
//        this.image = image;
//    }
//
//    public String getLang() {
//        return lang;
//    }
//
//    public void setLang(String lang) {
//        this.lang = lang;
//    }
//
//    public String getDate() {
//        return date;
//    }
//
//    public void setDate(String date) {
//        this.date = date;
//    }

    @Override
    public String toString() {
        return "BookList{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + text + '\'' +

                '}';
    }
}
