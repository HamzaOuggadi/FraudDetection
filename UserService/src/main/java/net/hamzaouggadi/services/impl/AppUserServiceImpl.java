package net.hamzaouggadi.services.impl;

import lombok.RequiredArgsConstructor;
import net.hamzaouggadi.entities.AppUser;
import net.hamzaouggadi.repositories.AppUserRepository;
import net.hamzaouggadi.services.AppUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository appUserRepository;

    @Override
    public List<AppUser> getAllAppUsers() {
        return appUserRepository.findAll();
    }

    @Override
    public AppUser getAppUserById(Long appUserId) {
        Optional<AppUser> optionalAppUser = appUserRepository.findById(appUserId);
        if (optionalAppUser.isPresent()) {
            return optionalAppUser.get();
        } else {
            throw new RuntimeException("User Not Found !");
        }
    }

    @Override
    public boolean checkUserFraud(AppUser appUser) {
        return true;
    }

    @Override
    public void createAppUser(AppUser appUser) {
        if (!checkUserFraud(appUser)) {
            appUserRepository.save(appUser);
        } else {

        }
    }

    @Override
    public void deleteAppUserById(Long appUserId) {
        appUserRepository.deleteById(appUserId);
    }
}
