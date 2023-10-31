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

    /**
     * Method that will be calling RabbitMQ for acquiring the data
     * @param appUser
     * @return
     */
    @Override
    public boolean checkUserFraud(AppUser appUser) {
        return false;
    }

    @Override
    public void createAppUser(AppUser appUser) {
        if (!checkUserFraud(appUser)) {
            appUserRepository.save(appUser);
        } else {
            throw new RuntimeException("The User is suspected for fraudulent activities");
        }
    }

    @Override
    public void deleteAppUserById(Long appUserId) {
        appUserRepository.deleteById(appUserId);
    }
}
