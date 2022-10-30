package com.mprog.dto;

public class UserDto {


    private long id;
    private String name;
    private int money;
    private int health;

    public UserDto(long id, String name, int money, int health) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
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
        return "UserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                ", health=" + health +
                '}';
    }
}
