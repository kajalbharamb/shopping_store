package com.example.store.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Products")
public class Product {
    //Many to one relationship
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    Category category;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    @NotNull(message = "Required Product name")
    private String name;
    @NotNull(message = "Required Selling Price")
    private long sellingPrice;
    @NotNull(message = "Required NoInStock")
    private int noInStock;
    @NotNull(message = "Required Original Price")
    private long originalPrice;
    @NotNull(message = "Required Discount")
    private int discount;

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSellingPrice() {
        return getOriginalPrice()-((getOriginalPrice()*getDiscount())/100);
    }

    public void setSellingPrice(long sellingprice) {
        sellingprice=(getOriginalPrice()-((getOriginalPrice()*getDiscount())/100));
    }

    public int getNoInStock() {
        return noInStock;
    }

    public void setNoInStock(int noInStock) {
        this.noInStock = noInStock;
    }

    public long getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(long originalPrice) { this.originalPrice = originalPrice; }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
