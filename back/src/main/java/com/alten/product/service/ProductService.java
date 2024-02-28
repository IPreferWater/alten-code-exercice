package com.alten.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alten.product.model.Product;
import com.alten.product.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product createProduct(Product product){
        //TODO handle error should be unique
            return productRepository.save(product);
    }

    public List<Product> getAllProducts(){
            return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id){

            return productRepository.findById(id);


    }

    public Product patchProduct(Long id, Product updatedProduct){

            Optional<Product> productToPatchOpt = productRepository.findById(id);

            if (!productToPatchOpt.isPresent()){
               return null;
            }

            var productToPtach = patchFromTo(updatedProduct, productToPatchOpt.get());
            return productRepository.saveAndFlush(productToPtach);
    }

    public boolean deleteProduct(Long id){


            if (!productRepository.existsById(id)) {
                return false;
            }
             productRepository.deleteById(id);
             return true;
        }


        private Product patchFromTo(Product pFrom, Product pToPatch) {

                if (pFrom.getCode() != null) {
                    pToPatch.setCode(pFrom.getCode());
                }

                if (pFrom.getName() != null) {
                    pToPatch.setName(pFrom.getName());
                }

                if (pFrom.getDescription() != null) {
                    pToPatch.setDescription(pFrom.getDescription());
                }

                if (pFrom.getPrice() != null) {
                    pToPatch.setPrice(pFrom.getPrice());
                }

                if (pFrom.getQuantity() != null) {
                    pToPatch.setQuantity(pFrom.getQuantity());
                }

                if (pFrom.getInventoryStatus() != null) {
                    pToPatch.setInventoryStatus(pFrom.getInventoryStatus());
                }

                if (pFrom.getCategory() != null) {
                    pToPatch.setCategory(pFrom.getCategory());
                }

                if (pFrom.getImage() != null) {
                    pToPatch.setImage(pFrom.getImage());
                }

                if (pFrom.getRating() != null) {
                    pToPatch.setRating(pFrom.getRating());
                }

                return pToPatch;
            }


}