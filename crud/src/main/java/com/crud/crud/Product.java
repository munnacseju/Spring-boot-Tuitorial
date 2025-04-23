package com.crud.crud;


import com.crud.crud.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
