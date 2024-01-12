package org.fakestore3;

import lombok.Getter;
import lombok.Setter;
import org.fakestore3.entitys.Basket;
import org.fakestore3.entitys.Orders;
import org.fakestore3.interfaces.CartRepository;
import org.fakestore3.interfaces.OrderRepository;


@Getter
@Setter
public class OrderDao {

    OrderRepository orderRepo;
    CartRepository cartRepo;
    public void order(String username)  {
        Basket basket=cartRepo.findAll().get(0);
        Orders order=new Orders();
        order.setUsername(username);
        order.setTitle(basket.getTitle());
        orderRepo.save(order);
        cartRepo.deleteAll();

    }
 }
