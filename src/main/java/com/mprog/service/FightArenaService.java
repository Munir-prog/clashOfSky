package com.mprog.service;

import com.mprog.database.model.Clan;
import com.mprog.database.model.GoldStatistics;
import com.mprog.database.model.User;
import com.mprog.mapper.UserMapper;
import com.mprog.service.clan.ClanService;
import com.mprog.util.RandomUtils;

public class FightArenaService {

    private final ClanService clans;
    private final UserService userService;

    public FightArenaService(ClanService clans) {
        this.clans = clans;
        userService = UserService.getInstance();
    }

    public void fightForClanGlory(long userId, long clanId) {
        var user = userService.getUserById(userId);
        var award = fightAndGetMoney(user);
        Clan clan = clans.getClan(clanId);
        clan.addGold(award);
        boolean success = award != 0;
        clan.setGoldStatistics(new GoldStatistics(
                UserMapper.entityToDto(user),
                award,
                null,
                false,
                true,
                success
        ));
    }

    private int fightAndGetMoney(User user) {
        int healthLose;
        if (user.getHealth() < 10 && user.getHealth() > 1) {
            healthLose = RandomUtils.getRandom().nextInt(user.getHealth()) + 1;
        } else if (user.getHealth() > 9) {
            healthLose = RandomUtils.getRandom().nextInt(8) + 3;
        } else {
            return 0;
        }
        user.loseHealth(healthLose);
        var health = user.getHealth();
        if (health < 25) {
            return 0;
        } else if (health < 50) {
            return 5;
        } else if (health < 75) {
            return 10;
        } else {
            return 15;
        }

    }
}
