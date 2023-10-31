package net.hamzaouggadi;

import com.github.javafaker.Faker;
import net.hamzaouggadi.entities.AppUser;
import net.hamzaouggadi.messaging.Sender;
import net.hamzaouggadi.services.AppUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.time.ZoneId;

@SpringBootApplication
public class UserServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApp.class, args);
    }

    @Bean
    CommandLineRunner start(AppUserService appUserService) {
        return args -> {

            Faker faker = new Faker();

            for (int i=0; i<10; i++) {
                AppUser appUser = AppUser.builder()
                        .fullName(faker.name().fullName())
                        .email(faker.name().firstName() + "@gmail.com")
                        .address(faker.address().fullAddress())
                        .password(faker.funnyName().name())
                        .phoneNumber(faker.phoneNumber().phoneNumber())
                        .birthDate(faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
                        .build();

                appUserService.createAppUser(appUser);
            }
        };
    }

/*    @Bean
    CommandLineRunner send(Sender sender) {
        return args -> {
            sender.sendMessage("Hello");
        };
    }*/

}