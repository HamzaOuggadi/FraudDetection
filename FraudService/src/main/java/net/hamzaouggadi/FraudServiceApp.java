package net.hamzaouggadi;

import net.hamzaouggadi.entities.AppUser;
import net.hamzaouggadi.repositories.AppUserRepository;
import net.hamzaouggadi.services.CheckUserFraud;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class FraudServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(FraudServiceApp.class, args);
    }

    @Bean
    CommandLineRunner start(AppUserRepository appUserRepository,
                            CheckUserFraud checkUserFraud) {
        return args -> {
            AppUser appUser1 = AppUser.builder()
                    .email("hamza@email.com")
                    .phoneNumber("0606060606")
                    .fullName("Hamza L3alawi")
                    .address("address address")
                    .birthDate(new Date())
                    .build();

            AppUser appUser2 = AppUser.builder()
                    .email("l3alawi@email.com")
                    .phoneNumber("0707070707")
                    .fullName("L3alawi Chdid")
                    .address("address2 address2")
                    .birthDate(new Date())
                    .build();

            appUserRepository.save(appUser1);
            appUserRepository.save(appUser2);

            AppUser appUser3 = AppUser.builder()
                    .email("hamza@email.com")
                    .phoneNumber("0606060606")
                    .fullName("Hamza L3alawi")
                    .address("address address")
                    .birthDate(new Date())
                    .build();

            System.out.println(checkUserFraud.checkUserForFraud(appUser3));

        };
    }
}