package com.mprog.database.model;

import com.mprog.dto.UserDto;

public class GoldStatistics {

    private static long idCounter = 1;

    private long id;

    private UserDto user;

    private int goldAmount;

    //    пополнение или снятие денег
    private boolean replenish;

    private int clanGoldAmount;

    // if gold was added by doing some task
    private Task task;

    // if gold was added from users money
    private boolean fromUsersBag;

    // if gold was added from arena where user fought
    private boolean fromArena;

    //    Успешное пополнение
    private boolean successReplenish;

    public GoldStatistics(UserDto user, int clanGoldAmount, boolean replenish,
                          int goldAmount, Task task, boolean fromUsersBag,
                          boolean fromArena, boolean successReplenish) {
        this.fromArena = fromArena;
        this.id = getCounter();
        this.user = user;
        this.goldAmount = goldAmount;
        this.task = task;
        this.fromUsersBag = fromUsersBag;
        this.successReplenish = successReplenish;
        this.clanGoldAmount = clanGoldAmount;
        this.replenish = replenish;
    }

    public boolean isReplenish() {
        return replenish;
    }

    public void setReplenish(boolean replenish) {
        this.replenish = replenish;
    }

    public int getClanGoldAmount() {
        return clanGoldAmount;
    }

    public void setClanGoldAmount(int clanGoldAmount) {
        this.clanGoldAmount = clanGoldAmount;
    }

    public boolean isFromArena() {
        return fromArena;
    }

    public void setFromArena(boolean fromArena) {
        this.fromArena = fromArena;
    }

    public static long getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(long idCounter) {
        GoldStatistics.idCounter = idCounter;
    }

    public boolean isSuccessReplenish() {
        return successReplenish;
    }

    public void setSuccessReplenish(boolean successReplenish) {
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
                ", replenish=" + replenish +
                ", clanGoldAmount=" + clanGoldAmount +
                ", task=" + task +
                ", fromUsersBag=" + fromUsersBag +
                ", fromArena=" + fromArena +
                ", successReplenish=" + successReplenish +
                '}';
    }
}
