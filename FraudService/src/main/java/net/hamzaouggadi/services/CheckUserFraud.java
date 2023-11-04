package net.hamzaouggadi.services;

import net.hamzaouggadi.entities.AppUser;

public interface CheckUserFraud {
    String checkUserForFraud(AppUser appUser);
}
