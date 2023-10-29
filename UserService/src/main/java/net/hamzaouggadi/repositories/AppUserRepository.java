package net.hamzaouggadi.repositories;

import net.hamzaouggadi.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

}
