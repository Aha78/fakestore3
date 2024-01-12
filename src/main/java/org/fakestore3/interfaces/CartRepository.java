package org.fakestore3.interfaces;

import org.fakestore3.entitys.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface CartRepository extends JpaRepository<Basket, Long> {
    Basket findById(long id);
}