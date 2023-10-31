package net.hamzaouggadi.web;

import lombok.RequiredArgsConstructor;
import net.hamzaouggadi.entities.AppUser;
import net.hamzaouggadi.services.AppUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/createUser")
    public ResponseEntity<String> createAppUser(@RequestBody AppUser appUser) {
        appUserService.createAppUser(appUser);
        return ResponseEntity.ok("User Added Successfully");
    }

    @DeleteMapping("/deleteUser/{appUserId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long appUserId) {
        appUserService.deleteAppUserById(appUserId);
        return ResponseEntity.ok("User deleted successfully");
    }
}
