package com.bookapp.design.model;

import javax.persistence.*;

@Entity
@Table(name="UserInfo")
public class User {

    @Id
    //@GeneratedValue(Strategy = GenerationType.IDENTITY)

    @Column(name = "Name")
    private String name;
    @Column(name = "Phone_no")
    private long ph_num;
    @Column(name = "Email")
    private String mail_id;
    @Column(name = "Password")
    private String password;
}
