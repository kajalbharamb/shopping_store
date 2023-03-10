package com.example.store.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull(message = "Required categoryId")
    private Integer categoryId;
    @NotNull(message = "Required Product Name")
    private String name;
    private long sellingPrice;
    @NotNull(message = "Required NoInStock")
    private int noInStock;
    @NotNull(message = "Required Original Price")
    private long originalPrice;
    @NotNull(message = "Required Discount")
    private int discount;

    public long getSellingPrice(){
        return (getOriginalPrice()-((getOriginalPrice()*getDiscount())/100));
    }

    public void setSellingPrice(long sellingprice){
        sellingPrice=(getOriginalPrice()-((getOriginalPrice()*getDiscount())/100));
    }

}
