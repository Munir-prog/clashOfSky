package com.mprog.service;

import com.mprog.database.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService { // какой-то сервис с заданиями

    private final List<User> userRepository;
    private static final UserService instance = new UserService();

    private UserService() {
        userRepository = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            userRepository.add(new User(i, i + "name", 100)); //todo get some random money
        }
    }

    public User getUserById(long id) {
        return userRepository.stream()
                .filter(user -> user.getId() == id)
                .findAny()
                .orElse(null);
    }

    public static UserService getInstance() {
        return instance;
    }
}
