package net.hamzaouggadi.services;

import net.hamzaouggadi.entities.AppUser;

import java.util.List;

public interface AppUserService {
    List<AppUser> getAllAppUsers();
    AppUser getAppUserById(Long appUserId);
    boolean checkUserFraud(AppUser appUser);
    void createAppUser(AppUser appUser);
    void deleteAppUserById(Long appUserId);
}
