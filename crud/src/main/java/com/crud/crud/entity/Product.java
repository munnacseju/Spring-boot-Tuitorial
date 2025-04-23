package com.crud.crud.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Product extends BaseEntity {
    private String name;
    private double price;
    private int quantity;
    @Column(columnDefinition = "CLOB")
    private String photo;
}
