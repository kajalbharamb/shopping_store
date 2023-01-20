package com.example.store.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.hql.internal.ast.tree.IdentNode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    @NotNull(message = "Required")
    private String name;
    @NotNull(message = "Required")
    private long sellingPrice;
    @NotNull(message = "Required")
    private int noInStock;
    @NotNull(message = "Required")
    private long originalPrice;
    @NotNull(message = "Required")
    private int discount;



    //Many to one relationship
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    Category category;

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
        return sellingPrice;
    }

    public void setSellingPrice(long sellingprice) {
        this.sellingPrice = sellingprice;
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

    public void setOriginalPrice(long originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
