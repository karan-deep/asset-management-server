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
public class User {
    private int id;
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
