package com.alten.product.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.alten.product.model.Product;
import com.alten.product.service.ProductService;

/*import com.alten.product.entity.EnumError;
import com.alten.product.entity.Product;
import com.alten.product.entity.ProductException;
import com.alten.product.service.ProductService;*/

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {

            Product savedProduct = productService.createProduct(product);
            return ResponseEntity.ok(savedProduct);

    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
            List<Product> products = productService.getAllProducts();
            return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable Long id) {

                    Optional<Product> optionalProduct = productService.getProductById(id);

                    if (optionalProduct.isEmpty()){
                        return ResponseEntity.notFound().build();
                    }

                    return ResponseEntity.ok(optionalProduct.get());

    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> patchProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {


                    Product patchedProduct = productService.patchProduct(id, updatedProduct);
                    if (patchedProduct == null){
                        return ResponseEntity.notFound().build();
                    }



                        return ResponseEntity.ok(patchedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Long id) {

        Boolean isDeleted =  productService.deleteProduct(id);

        if (!isDeleted){
            return ResponseEntity.notFound().build();
        }

                return ResponseEntity.ok().build();

    }
}