package org.fakestore3.interfaces;

import org.fakestore3.entitys.Product;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ProductRepository extends JpaRepository<Product, Long> {

}