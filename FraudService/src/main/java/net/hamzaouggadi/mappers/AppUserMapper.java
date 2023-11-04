package net.hamzaouggadi.mappers;

import net.hamzaouggadi.dtos.AppUserDto;
import net.hamzaouggadi.entities.AppUser;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AppUserMapper {
    AppUserDto toAppUserDto(AppUser appUser);
    AppUser toAppUser(AppUserDto appUserDto);
}
