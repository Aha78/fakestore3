package org.fakestore3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin("*")
@Controller
public class GreetingController {


    @Autowired
    CustomerRepository repo;
    @Autowired
    ProductRepository productrepo;
    @Autowired
    CartRepository cartRepo;
    @PostMapping("/antto")
    ResponseEntity<String> hello() {

        return new ResponseEntity<>("Hello World!", HttpStatus.OK);

    }

    @GetMapping("/greeting")
    public String  greeting() throws SQLException {
        DAOexample a=new DAOexample();

        a.setProductrepo(productrepo);
        a.pagination(0,3);
        return "home";
    }

    @GetMapping(value = "/barangs")
    public ResponseEntity get(@RequestParam(name = "page") int page,@RequestParam(name = "size") int size) {
        DAOexample a=new DAOexample();
        a.setProductrepo(productrepo);
        return ResponseEntity.ok().body( a.pagination(page,size));

    }


    @CrossOrigin("*")
    @PostMapping(value = "/cart")
    @ResponseBody
    public ResponseEntity deleteFromCart(@RequestBody Deleteproduct a) {
        Basket carts=cartRepo.findById(a.getId());

        if(carts!=null) {
            cartRepo.delete(cartRepo.findById(a.getId()));
        }
        return ResponseEntity.ok().body( "ok");

    }

    @CrossOrigin("*")
    @PutMapping(value = "/cart")
    @ResponseBody
    public ResponseEntity PutCart(@RequestBody Basket basket) {
        cartRepo.save(basket);
        return ResponseEntity.ok().body( "ok");

    }



    @GetMapping(value = "/cart")
    public ResponseEntity getCart() {
        return ResponseEntity.ok().body(   cartRepo.findAll());

    }

}