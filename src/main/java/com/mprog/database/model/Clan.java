package com.mprog.database.model;

import java.util.ArrayList;
import java.util.List;

public class Clan {

    private long id;
    private String name;
    private int gold;
    private List<GoldStatistics> goldStatistics;

    public Clan(long id, String name, int gold) {
        this.id = id;
        this.name = name;
        this.gold = gold;
        goldStatistics = new ArrayList<>();
    }

    public List<GoldStatistics> getGoldStatistics() {
        return goldStatistics;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getGold() {
        return gold;
    }

    public synchronized void addGold(int gold) {
        this.gold = this.gold + gold;
    }

    public synchronized void setGoldStatistics(GoldStatistics goldStatistics) {
        this.goldStatistics.add(goldStatistics);
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}
