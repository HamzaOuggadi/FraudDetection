package net.hamzaouggadi.repositories;

import net.hamzaouggadi.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    Optional<AppUser> findAppUserByFullNameIgnoreCase(String fullName);
    Optional<AppUser> findAppUserByEmailIgnoreCase(String email);
    Optional<AppUser> findAppUserByAddressIsLikeIgnoreCase(String address);
}
