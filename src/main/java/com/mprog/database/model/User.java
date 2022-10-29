package com.mprog.database.model;

import com.mprog.util.RandomUtils;

public class User {

    private long id;
    private String name;
    private int money;

    public User(long id, String name, int money) {
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

    public int getSomeMoneyForClan() {
        if (money != 0) {
            int moneyToReturn;
            if (money > 10) {
                moneyToReturn = RandomUtils.getRandom().nextInt(10) + 1;
            } else {
                moneyToReturn = RandomUtils.getRandom().nextInt(money) + 1;
            }
            money = money - moneyToReturn;
            return moneyToReturn;
        }
        return 0;
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
