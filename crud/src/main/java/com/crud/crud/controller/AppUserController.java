package com.crud.crud.controller;

import com.crud.crud.entity.AppUser;
import com.crud.crud.repository.AppUserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class AppUserController implements BaseController<AppUser> {

    private final AppUserRepository userRepository;

    public AppUserController(AppUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @PostMapping
    public ResponseEntity<AppUser> save(AppUser entity) {
        entity.setId(UUID.randomUUID());
        userRepository.save(entity);
        return ResponseEntity.ok(entity);
    }

    @Override
    @PutMapping
    public ResponseEntity<AppUser> update(AppUser entity) {
        if(entity.getId() == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.ok(userRepository.save(entity));
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
