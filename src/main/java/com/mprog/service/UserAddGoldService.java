package com.mprog.service;

import com.mprog.database.model.Clan;
import com.mprog.database.model.GoldStatistics;
import com.mprog.mapper.UserMapper;
import com.mprog.service.clan.ClanService;

public class UserAddGoldService {

    private final ClanService clans;
    private final UserService userService;

    public UserAddGoldService(ClanService clans) {
        this.clans = clans;
        userService = UserService.getInstance();
    }

    public void addGoldToClan(long userId, long clanId) {
        var user = userService.getUserById(userId);
        int amountToClan = user.getSomeMoneyForClan();
        Clan clan = clans.getClan(clanId);
        clan.addGold(amountToClan);
        boolean success = amountToClan != 0;
        clan.setGoldStatistics(new GoldStatistics(
                UserMapper.entityToDto(user),
                clan.getGold(),
                true,
                amountToClan,
                null,
                true,
                false,
                success
        ));
    }

}
