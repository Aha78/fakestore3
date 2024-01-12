package org.fakestore3.interfaces;

import org.fakestore3.entitys.Users;
import org.springframework.data.jpa.repository.JpaRepository;


public  interface UserRepository extends JpaRepository<Users, Long> {


}
