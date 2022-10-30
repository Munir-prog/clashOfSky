package com.mprog.mapper;

import com.mprog.database.model.User;
import com.mprog.dto.UserDto;

public class UserMapper {

    private final static UserMapper instance = new UserMapper();

    private UserMapper () {
    }

    public UserDto entityToDto(User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getMoney()
        );
    }

    public static UserMapper getInstance() {
        return instance;
    }
}
