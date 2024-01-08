package org.fakestore3;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
class Product {

    @Id
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "price")
    private Double price;
    @Column(name = "description")
    private String description;
    @Column(name = "category")
    private String category;

    @Column(name = "image")
    private String image;



    protected Product() {}
}







