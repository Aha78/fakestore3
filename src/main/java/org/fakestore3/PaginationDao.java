package org.fakestore3;

import lombok.Getter;
import lombok.Setter;
import org.fakestore3.entitys.Product;
import org.fakestore3.interfaces.ProductRepository;

import java.util.List;


@Setter
@Getter
public class PaginationDao {

    ProductRepository productRepository;

    List<Product> pagination(int page, int size) {
        return productRepository.findAll().subList(page * size, (page + 1) * size);
    }
}
