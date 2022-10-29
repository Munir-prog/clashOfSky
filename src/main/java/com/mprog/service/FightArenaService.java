package com.mprog.service;

import com.mprog.database.model.Clan;
import com.mprog.database.model.User;
import com.mprog.service.clan.ClanService;

public class FightArenaService {

    private final ClanService clans;
    private final UserService userService;

    public FightArenaService(ClanService clans) {
        this.clans = clans;
        userService = UserService.getInstance();
    }

    public void addGoldToClan(long userId, long clanId) {
        var user = userService.getUserById(userId);
        Clan clan = clans.getClan(clanId);
        // clan.[gold] += gold;
        // как-то сохранить изменения
    }

//    private int fightAndGetMoney(User user) {
//    } TODO implement fighting and getting money for type of money (0, 5, 10, 15)

}
