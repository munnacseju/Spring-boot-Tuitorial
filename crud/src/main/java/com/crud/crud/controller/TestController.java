package com.crud.crud.controller;

import com.crud.crud.entity.AppUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController implements BaseController<AppUser> {
    @Override
    public ResponseEntity<AppUser> save(AppUser entity) {
        return null;
    }

    @Override
    public ResponseEntity<AppUser> update(AppUser entity) {
        return null;
    }

    @Override
    public void delete(AppUser entity) {

    }

    @Override
    public ResponseEntity<AppUser> findById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<AppUser> findByName(String name) {
        return null;
    }

    @Override
    public ResponseEntity findAll() {
        return null;
    }
}
