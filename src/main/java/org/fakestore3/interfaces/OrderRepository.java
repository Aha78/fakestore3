package org.fakestore3.interfaces;

import org.fakestore3.entitys.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface OrderRepository extends JpaRepository<Orders, Long> {
    Orders findById(long id);
}