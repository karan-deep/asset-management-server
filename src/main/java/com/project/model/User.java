package com.project.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

//Generating non-parameterized constructor, getter and setter using lombok
@Getter
@Setter
@NoArgsConstructor
//marking class as an Entity
@Entity
//defining table name as Users
@Table(name = "USERS")
public class User {
    @Column(name = "ID")
    private int id;

    //defining username as column name
    @Column(name = "USERNAME",unique = true,nullable = false)
    private String username;

    //defining age as column name
    @Column(name = "PASSWORD")
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
