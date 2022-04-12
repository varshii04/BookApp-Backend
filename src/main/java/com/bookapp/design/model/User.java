package com.bookapp.design.model;

import javax.persistence.*;

@Entity
@Table(name="UserInfo")
public class User {



    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    //@SequenceGenerator(name = )
//    @Column(name = "id")
    private long id;
    @Column(name = "Name", nullable = false, length = 50)
    private String name;
    @Column(name = "Phone_no", nullable = false, length = 15)
    private String phone;
    @Column(name = "Email", nullable = false, unique = true, length = 255)
    private String email;
    @Column(name = "Password", nullable = false, length = 64)
    private String password;

//constructors using fields

    public User(long id, String name, String phone, String email, String password) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    public User() {

    }


//Getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
