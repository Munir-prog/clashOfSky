package com.mprog.database.model;

import com.mprog.dto.UserDto;

public class GoldStatistics {

    private static long idCounter = 1;

    private long id;
    private UserDto user;
    private int goldAmount;
    // if gold was added by doing some task
    private Task task;

    // if gold was added from users money
    private boolean fromUsersBag;

    //    Успешное пополнение
    private boolean successReplenish;

    public GoldStatistics(UserDto user, int goldAmount, Task task, boolean fromUsersBag, boolean successReplenish) {
        this.id = getCounter();
        this.user = user;
        this.goldAmount = goldAmount;
        this.task = task;
        this.fromUsersBag = fromUsersBag;
        this.successReplenish = successReplenish;
    }

    private static long getCounter() {
        synchronized (GoldStatistics.class) {
            return idCounter++;
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public int getGoldAmount() {
        return goldAmount;
    }

    public void setGoldAmount(int goldAmount) {
        this.goldAmount = goldAmount;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public boolean isFromUsersBag() {
        return fromUsersBag;
    }

    public void setFromUsersBag(boolean fromUsersBag) {
        this.fromUsersBag = fromUsersBag;
    }

    @Override
    public String toString() {
        return "GoldStatistics{" +
                "id=" + id +
                ", user=" + user +
                ", goldAmount=" + goldAmount +
                ", task=" + task +
                ", fromUsersBag=" + fromUsersBag +
                ", successReplenish=" + successReplenish +
                '}';
    }
}
