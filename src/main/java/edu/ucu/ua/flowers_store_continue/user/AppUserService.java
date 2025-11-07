package edu.ucu.ua.flowers_store_continue.user;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AppUserService {
    private final AppUserRepository appUserRepository;
    
    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public List<AppUser> getUsers() {
        return appUserRepository.findAll();
    }

    public AppUser addUser(AppUser appUser) {
        if (appUserRepository.findUserByEmail(appUser.getEmail()).isPresent()) {
            throw new IllegalArgumentException("User with this email already exists");
        }
        return appUserRepository.save(appUser);
    }
}
