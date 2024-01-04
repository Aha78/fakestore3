package org.fakestore3;

import org.springframework.data.jpa.repository.JpaRepository;

public  interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByUsername(String username);
    Customer findById(long id);
}