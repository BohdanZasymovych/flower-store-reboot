package edu.ucu.ua.flowers_store_continue.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ucu.ua.flowers_store_continue.user.AppUser;
import edu.ucu.ua.flowers_store_continue.user.AppUserService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/users")
public class AppUserController {
    private final AppUserService appUserService;

    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping
    public List<AppUser> getAppUsers() {
        return appUserService.getUsers();
    }

    @PostMapping
    public ResponseEntity<AppUser> addUser(@RequestBody AppUser appUser) { 
        AppUser saved = appUserService.addUser(appUser);     
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
