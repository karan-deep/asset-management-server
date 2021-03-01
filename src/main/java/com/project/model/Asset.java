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
    //defining id as column name and primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    //defining name as column name
    @Column(name = "ASSETTYPEID")
    private int assetTypeId;

    //defining name as column name
    @Column(name = "NAME")
    private String name;

    //defining description as column name
    @Column(name = "DESCRIPTION")
    private String description;

    //defining price as column name
    @Column(name = "PRICE")
    private double price;

    //defining price as column name
    @Column(name = "PURCHASEDATE")
    @Temporal(TemporalType.DATE)
    private Calendar purchaseDate;

    public Asset(int assetTypeId, String name, String description, double price, Calendar purchaseDate) {
        this.assetTypeId = assetTypeId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.purchaseDate = purchaseDate;
    }
}
