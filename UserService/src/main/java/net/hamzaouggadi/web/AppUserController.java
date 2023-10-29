package net.hamzaouggadi.web;

import lombok.RequiredArgsConstructor;
import net.hamzaouggadi.entities.AppUser;
import net.hamzaouggadi.services.AppUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/appUsers")
@RequiredArgsConstructor
public class AppUserController {

    private final AppUserService appUserService;

    @GetMapping
    public ResponseEntity<List<AppUser>> getAllUsers() {
        return ResponseEntity.ok(appUserService.getAllAppUsers());
    }

    @GetMapping("/byId/{appUserId}")
    public ResponseEntity<AppUser> getUserById(@PathVariable Long appUserId) {
        return ResponseEntity.ok(appUserService.getAppUserById(appUserId));
    }

}
