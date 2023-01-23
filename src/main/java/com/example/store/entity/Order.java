package com.example.store.entity;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "Required ProductId")
    private int product_id;
    @NotNull(message = "Required UserId")
    private String user_id;
    @NotNull(message = "Required Quantity")
    private int quantity;



}
