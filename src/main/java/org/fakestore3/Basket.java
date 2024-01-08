package org.fakestore3;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "cart")
@Getter
@Setter
public class Basket {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String user;
    private String title;
    private double price;
    private int amount;
    private String url;
    protected Basket() {}

}




