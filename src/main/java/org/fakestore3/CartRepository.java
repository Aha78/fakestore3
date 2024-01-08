package org.fakestore3;

import org.springframework.data.jpa.repository.JpaRepository;

public  interface CartRepository extends JpaRepository<Basket, Long> {

    Basket findById(long id);
}