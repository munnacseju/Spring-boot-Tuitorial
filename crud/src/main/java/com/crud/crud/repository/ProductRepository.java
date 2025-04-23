package com.crud.crud.repository;

import com.crud.crud.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface ProductRepository extends JpaSpecificationExecutor<Product>, JpaRepository<Product, UUID> {
}
