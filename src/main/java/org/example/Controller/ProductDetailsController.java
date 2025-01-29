package org.example.Controller;

import org.example.Entity.ProductDetails;
import org.example.Exception.InvalidProductException;
import org.example.Service.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/productdetails")
public class ProductDetailsController {
    @Autowired
    ProductDetailsService productDetailsService;
    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody ProductDetails product) {
        try {
            productDetailsService.addProduct(product);
            return ResponseEntity.ok("Product added successfully");
        } catch(InvalidProductException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());

        }
    }

    @PutMapping
    public ResponseEntity<String> updateProduct(@RequestBody ProductDetails product) {
        try{
            productDetailsService.updateProduct(product);
            return ResponseEntity.ok("Product updated successfully");
        } catch (InvalidProductException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeProduct(@PathVariable String id) {
        try{
            productDetailsService.removeProduct(id);
            return ResponseEntity.ok("Product removed successfully");
        } catch (InvalidProductException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    }

    @GetMapping
    public ResponseEntity<List<ProductDetails>> getAllProducts() {
        productDetailsService.getAllProducts();
        return ResponseEntity.ok(new ArrayList<>(productDetailsService.getAllProducts()));
    }
}
