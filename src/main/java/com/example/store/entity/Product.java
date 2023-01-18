package com.example.store.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.hql.internal.ast.tree.IdentNode;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    private String name;
    private long sellingprice;
    private int noInStock;
    private long originalPrice;
    private int discount;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    //Many to one relationship
    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;

}
