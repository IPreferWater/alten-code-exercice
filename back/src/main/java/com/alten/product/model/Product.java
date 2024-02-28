package com.alten.product.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
@Table(name = "products")
public class Product {

  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private String inventoryStatus;

    @Column(nullable = false)
    private String category;

    private String image;

    // if the rating is in style 1/5
    private Integer rating;


     public Product() {
    }

    public Product(Long id, String code, String name, String description, Double price, Integer quantity,
        String inventoryStatus, String category, String image, Integer rating) {
      this.id = id;
      this.code = code;
      this.name = name;
      this.description = description;
      this.price = price;
      this.quantity = quantity;
      this.inventoryStatus = inventoryStatus;
      this.category = category;
      this.image = image;
      this.rating = rating;
    }

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public String getCode() {
      return code;
    }

    public void setCode(String code) {
      this.code = code;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getDescription() {
      return description;
    }

    public void setDescription(String description) {
      this.description = description;
    }

    public Double getPrice() {
      return price;
    }

    public void setPrice(Double price) {
      this.price = price;
    }

    public Integer getQuantity() {
      return quantity;
    }

    public void setQuantity(Integer quantity) {
      this.quantity = quantity;
    }

    public String getInventoryStatus() {
      return inventoryStatus;
    }

    public void setInventoryStatus(String inventoryStatus) {
      this.inventoryStatus = inventoryStatus;
    }

    public String getCategory() {
      return category;
    }

    public void setCategory(String category) {
      this.category = category;
    }

    public String getImage() {
      return image;
    }

    public void setImage(String image) {
      this.image = image;
    }

    public Integer getRating() {
      return rating;
    }

    public void setRating(Integer rating) {
      this.rating = rating;
    }

}
