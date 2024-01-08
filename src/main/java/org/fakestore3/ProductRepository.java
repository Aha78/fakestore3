package org.fakestore3;

import org.springframework.data.jpa.repository.JpaRepository;

public  interface ProductRepository extends JpaRepository<Product, Long> {


    Product findById(long id);
}