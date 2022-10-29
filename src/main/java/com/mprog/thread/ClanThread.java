package com.mprog.thread;

import com.mprog.database.model.User;
import com.mprog.service.FightArenaService;
import com.mprog.service.TaskService;
import com.mprog.service.UserAddGoldService;
import com.mprog.util.RandomUtils;


public class ClanThread extends Thread{

    private final TaskService taskService;
    private final UserAddGoldService userAddGoldService;
    private final FightArenaService fightArenaService;
    private final User user;

    public ClanThread(TaskService taskService, UserAddGoldService userAddGoldService, FightArenaService fightArenaService, User user) {
        this.taskService = taskService;
        this.userAddGoldService = userAddGoldService;
        this.fightArenaService = fightArenaService;
        this.user = user;
    }

    @Override
    public void run() {
        var serviceId = RandomUtils.getRandom().nextInt(2) + 1;
        if (serviceId == 1) {
            var taskId = RandomUtils.getRandom().nextInt(3) + 1;
            taskService.completeTask(1, taskId, user.getId());
        } else {
            userAddGoldService.addGoldToClan(user.getId(), 1);
        }
    }
}
