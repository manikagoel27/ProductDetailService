package org.example.Service;

import org.example.Entity.ProductDetails;
import org.example.Exception.InvalidProductException;
import org.example.Repository.ProductDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDetailsServiceImpl implements ProductDetailsService {

    @Autowired
    ProductDaoImpl productDaoImpl;

    public void addProduct(ProductDetails product) throws InvalidProductException {
       productDaoImpl.addProduct(product);
    }

    public void updateProduct(ProductDetails product) throws InvalidProductException {
        productDaoImpl.updateProduct(product);
    }


    public void removeProduct(String id) throws InvalidProductException{
         productDaoImpl.removeProduct(id);
    }

    public List<ProductDetails> getAllProducts() {
        return productDaoImpl.getAllProducts();
    }
}
