package org.fakestore3;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.fakestore3.entitys.Basket;
import org.fakestore3.entitys.Orders;
import org.fakestore3.interfaces.*;
import org.fakestore3.entitys.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@CrossOrigin("*")
@Controller
public class HomeController {

    @Autowired
    OrderRepository orderRepo;
    @Autowired
    CartRepository cartRepo;
    @Autowired
    UserRepository userRepo;

    @Autowired
    ProductRepository productrepo;


    @RequestMapping(value = "/{path:[^.]*}")
    public String redirectSingle() {
        return "forward:/";
    }

    @GetMapping("/*/{path:[^.]*}")
    public String redirectNested() {
        return "forward:/";
    }





    @CrossOrigin("*")
    @PutMapping("/user")
    @ResponseBody
    public ResponseEntity users(@RequestBody Users user) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        userRepo.save(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/login")
    public  String login(){
            return  "login";
    }

    @GetMapping(value = "/products")
    public ResponseEntity get(@RequestParam(name = "page") int page, @RequestParam(name = "size") int size) {
        PaginationDao paginationDao = new PaginationDao();
        paginationDao.setProductRepository(productrepo);
        return ResponseEntity.ok().body(paginationDao.pagination(page, size));
    }
    SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
    @CrossOrigin("*")
    @PostMapping(value = "/order")
    @ResponseBody
    public ResponseEntity  order(Authentication authentication, HttpServletRequest request, HttpServletResponse response) {
        OrderDao orderDao=new OrderDao();
        orderDao.setOrderRepo(orderRepo);
        orderDao.setCartRepo(cartRepo);
        orderDao.order(authentication.getName());
        logoutHandler.logout(request,response,authentication);

        return ResponseEntity.ok().body("ok");
    }


    @CrossOrigin("*")
    @PostMapping(value = "/cart")
    @ResponseBody
    public ResponseEntity deleteFromCart(final Model model, Authentication auth,@RequestBody Deleteproduct deleteproduct) {
        cartRepo.delete( cartRepo.findById(deleteproduct.getId()));
        return ResponseEntity.ok().body("ok");
    }





    @CrossOrigin("*")
    @PutMapping(value = "/cart")
    @ResponseBody
    public ResponseEntity PutCart(Authentication authentication, HttpServletRequest request, HttpServletResponse response, @RequestBody Basket basket) {
        cartRepo.save(basket);
        return ResponseEntity.ok().body("ok");

    }

    @GetMapping(value = "/cart")
    public ResponseEntity getCart(final Model model, Authentication auth) {
        return ResponseEntity.ok().body(cartRepo.findAll());

    }

}