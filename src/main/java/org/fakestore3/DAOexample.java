package org.fakestore3;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;


@Setter
@Getter
public class DAOexample {


     ProductRepository productrepo;
    
    void  ProductCount()  {
        System.err.println("leinoja1="   + productrepo.count());
    }

    List<Product> pagination(int page, int size)  {


        return productrepo.findAll().subList(page*size,(page + 1)*size);


    }
}
