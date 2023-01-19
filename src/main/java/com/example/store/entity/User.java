package com.example.store.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @NotNull
    private String name;
    @Id
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String role;

}
