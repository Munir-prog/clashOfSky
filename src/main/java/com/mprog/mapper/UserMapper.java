package com.mprog.mapper;

import com.mprog.database.model.User;
import com.mprog.dto.UserDto;

public class UserMapper {

    private UserMapper () {
        throw  new RuntimeException("no!");
    }

    public static UserDto entityToDto(User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getMoney(),
                user.getHealth());
    }

}
