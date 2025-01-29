package org.example.Repository;

import org.example.Entity.ProductDetails;
import org.example.Exception.InvalidProductException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductDaoImpl{

    @PostConstruct
    public void init() {
        map.put("1",new ProductDetails("1", "Product1", 100.0, "M", "Design1"));
        map.put("2",new ProductDetails("2", "Product2", 150.0, "L", "Design2"));
    }
    HashMap<String, ProductDetails> map= new HashMap<>();

    public void addProduct(ProductDetails product) throws InvalidProductException{
        if (map.containsKey(product.getId())) {
            throw new InvalidProductException("Product Already Exists");
        }else {
            map.put(product.getId(), product);
        }
    }

    public void updateProduct(ProductDetails product) throws InvalidProductException{
        if (!map.containsKey(product.getId())) {
            throw new InvalidProductException("Invalid Product");
        }
        ProductDetails current = map.get(product.getId());
        if(product.getName() != null) {
            current.setName(product.getName());
        }
        if(product.getSize() != null) {
            current.setSize(product.getSize());
        }
        if(product.getDesign() != null) {
            current.setDesign(product.getDesign());
        }
    }


    public void removeProduct(String id) throws InvalidProductException{
        if (!map.containsKey(id)) {
            throw new InvalidProductException("Invalid Product");
        }
        map.remove(id);
    }

    public List<ProductDetails> getAllProducts() {
        return map.entrySet().stream().map(x-> x.getValue()).collect(Collectors.toList());
    }
}
