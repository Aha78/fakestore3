package org.fakestore3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;
import java.util.List;

@Controller
class GreetingController {

    @Autowired
    CustomerRepository repo;
    @PostMapping("/antto")
    ResponseEntity<String> hello() {
        System.err.println("leinoja");
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);

    }

    @GetMapping("/greeting")
    public ResponseEntity<List>  greeting() throws SQLException {
        CustomerRepository repository;
        Customer customer=new Customer();
        customer.setPassword("{noop}123456");
        customer.setUsername("user");
        repo.save(customer);
        return new ResponseEntity<List>((List<Customer>) repo.findAll(), HttpStatus.OK);
    }

}