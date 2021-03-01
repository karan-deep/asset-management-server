package com.project.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Generating non-parameterized constructor, getter and setter using lombok
@Getter
@Setter
@NoArgsConstructor
public class User {
    private int id;
    private String username;
    private String password;

}

}
