package com.mprog.thread;

import com.mprog.service.FightArenaService;
import com.mprog.service.TaskService;
import com.mprog.service.UserAddGoldService;
import com.mprog.util.RandomUtils;


public class ClanThread extends Thread {

    private static final int DEFAULT_CLAN_ID = 1;
    private final TaskService taskService;
    private final UserAddGoldService userAddGoldService;
    private final FightArenaService fightArenaService;
    private final Long userId;

    public ClanThread(TaskService taskService, UserAddGoldService userAddGoldService, FightArenaService fightArenaService, Long userId) {
        this.taskService = taskService;
        this.userAddGoldService = userAddGoldService;
        this.fightArenaService = fightArenaService;
        this.userId = userId;
    }

    @Override
    public void run() {
        var serviceId = RandomUtils.getRandom().nextInt(3) + 1;
        if (serviceId == 1) {
            taskService.completeTask(DEFAULT_CLAN_ID, userId);
        } else if (serviceId == 2) {
            userAddGoldService.addGoldToClan(userId, DEFAULT_CLAN_ID);
        } else {
            fightArenaService.fightForClanGlory(userId, DEFAULT_CLAN_ID);
        }
    }
}
