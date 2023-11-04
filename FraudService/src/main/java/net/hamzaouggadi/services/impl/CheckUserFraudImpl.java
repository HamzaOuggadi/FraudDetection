package net.hamzaouggadi.services.impl;

import lombok.RequiredArgsConstructor;
import net.hamzaouggadi.entities.AppUser;
import net.hamzaouggadi.repositories.AppUserRepository;
import net.hamzaouggadi.services.CheckUserFraud;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CheckUserFraudImpl implements CheckUserFraud {

    private final AppUserRepository appUserRepository;

    @Override
    public String checkUserForFraud(AppUser appUser) {
        String response = "";
        if (appUserRepository.findAppUserByFullNameIgnoreCase(appUser.getFullName()).isPresent()) {
            response = response.concat("Similar Fullname : " + appUser.getFullName());
        }
        if (appUserRepository.findAppUserByEmailIgnoreCase(appUser.getEmail()).isPresent()) {
            response = response.concat("Similar Email : " + appUser.getEmail());
        }
        if (appUserRepository.findAppUserByAddressIsLikeIgnoreCase(appUser.getAddress()).isPresent()) {
            response = response.concat("Similar Address : " + appUser.getAddress());
        }
        return response;
    }
}
