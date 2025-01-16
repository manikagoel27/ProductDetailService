package org.example.Controller;

import org.example.Entity.ProductDetails;
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
        productDetailsService.addProduct(product);
        return ResponseEntity.ok("Product added successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeProduct(@PathVariable String id) {
        productDetailsService.removeProduct(id);
        return ResponseEntity.ok("Product removed successfully");
    }

    @GetMapping
    public ResponseEntity<List<ProductDetails>> getAllProducts() {
        productDetailsService.getAllProducts();
        return ResponseEntity.ok(new ArrayList<>(productDetailsService.getAllProducts()));
    }
}
