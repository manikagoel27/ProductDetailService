package org.example.Repository;

import org.example.Entity.ProductDetails;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDaoImpl{

    @PostConstruct
    public void init() {
        list.add(new ProductDetails("1", "Product1", 100.0, "M", "Design1"));
        list.add(new ProductDetails("2", "Product2", 150.0, "L", "Design2"));
    }
    List<ProductDetails> list= new ArrayList<>();

    public void addProduct(ProductDetails product) {
        list.add(product);
    }

    public void removeProduct(String id) {
        list.removeIf(x-> x.getId().equals(id));
    }

    public List<ProductDetails> getAllProducts() {
        return list;
    }
}
