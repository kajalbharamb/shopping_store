package com.example.store.entity;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sales")
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int salesId;
    @NotNull
    private int productId;
    @NotNull
    private String userId;
    @NotNull
    private int soldStock;


}
