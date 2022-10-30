package com.mprog.dto;

import com.mprog.util.RandomUtils;

public class UserDto {


    private long id;
    private String name;
    private int money;

    public UserDto(long id, String name, int money) {
        this.id = id;
        this.name = name;
        this.money = money;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoney(int money) {
        this.money = money;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
