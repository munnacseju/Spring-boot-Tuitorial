package com.crud.crud.controller;

import com.crud.crud.entity.BaseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

public interface BaseController<X extends BaseEntity> {
    @GetMapping
    ResponseEntity<X> save(X entity);
    @PutMapping()
    ResponseEntity<X> update(X entity);
    void delete(X entity);
    ResponseEntity<X> findById(Long id);
    ResponseEntity<X> findByName(String name);
    ResponseEntity findAll();
}
