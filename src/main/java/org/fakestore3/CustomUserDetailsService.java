package org.fakestore3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;


public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private CustomerRepository userRepo;

    @Autowired
    private DataSource dataSource;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        Customer customer=new Customer();
        customer.setUsername("user");
        customer.setPassword("password");



        return   new CustomUserDetails(customer);

    }
}