package com.crud.crud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class AppUser extends BaseEntity {
    private String username;
    private String password;
    private String email;
    private String phone;
    private String role;
    @Column(columnDefinition = "CLOB")
    private String photo;
}
