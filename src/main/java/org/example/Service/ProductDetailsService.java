package org.example.Service;

import org.example.Entity.ProductDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProductDetailsService {

    public void addProduct(@RequestBody ProductDetails product) ;
    public void removeProduct(@PathVariable String id) ;
    public List<ProductDetails> getAllProducts() ;
}
