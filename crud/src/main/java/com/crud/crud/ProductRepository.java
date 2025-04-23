package com.crud.crud;

import com.crud.crud.param.PageableParam;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface ProductRepository extends JpaSpecificationExecutor<Product>, JpaRepository<Product, UUID> {
}
