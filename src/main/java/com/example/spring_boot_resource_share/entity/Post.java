package com.example.spring_boot_resource_share.entity;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Table(name = "post")
@Data 
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "user")
    private String user;

    @Column(name = "category")
    private String category;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "listing_price")
    private float listingPrice;

    @Column(name = "img")
    private String img;

    @Column(name = "date")
    private String date;
}
