package net.hamzaouggadi.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AppUserDto {
    private String fullName;
    private String email;
    private String password;
    private String address;
    private String phoneNumber;
    private Date birthDate;
}
