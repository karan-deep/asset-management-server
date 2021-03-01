package com.project.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;

//Generating non-parameterized, getter and setter using lombok
@Getter
@Setter
@NoArgsConstructor
//marking class as an Entity
@Entity
//defining table name as Assets
@Table(name = "ASSETS")
public class Asset {
    private int id;
    private int assetTypeId;
    private String name;
    private String description;
    private double price;
    private Calendar purchaseDate;

    public Asset(int assetTypeId, String name, String description, double price, Calendar purchaseDate) {
        this.assetTypeId = assetTypeId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.purchaseDate = purchaseDate;
    }
}
