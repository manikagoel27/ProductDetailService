package org.example.Service;

import org.example.Entity.ProductDetails;
import org.example.Exception.InvalidProductException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProductDetailsService {

    public void addProduct(@RequestBody ProductDetails product) throws InvalidProductException;
    public void updateProduct(@RequestBody ProductDetails product) throws InvalidProductException;
    public void removeProduct(@PathVariable String id)throws InvalidProductException ;
    public List<ProductDetails> getAllProducts() ;
}
