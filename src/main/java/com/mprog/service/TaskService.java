package com.mprog.service;

import com.mprog.database.model.Clan;
import com.mprog.database.model.GoldStatistics;
import com.mprog.database.model.Task;
import com.mprog.service.clan.ClanService;

import java.util.ArrayList;
import java.util.List;

public class TaskService {

    private final ClanService clans;
    private final List<Task> tasks;
    private final UserService userService;


    public TaskService(ClanService clans) {
        this.clans = clans;
        tasks = new ArrayList<>();
        tasks.add(new Task(1, "DoBusiness", 19));
        tasks.add(new Task(2, "DoRob", 8));
        tasks.add(new Task(3, "DoAgronomy", 14));
        userService = UserService.getInstance();
    }

    public void completeTask(long clanId, long taskId, long userId) {
        var user = userService.getUserById(userId);

        var task = tasks.stream()
                .filter(value -> value.getId() == taskId)
                .findAny().orElseThrow(() -> new RuntimeException("no such task by " + taskId + "id"));

        var award = task.doTaskAndGetAward();

        Clan clan = clans.getClan(clanId);
        clan.setGold(clan.getGold() + award);
        clan.setGoldStatistics(new GoldStatistics(user, award, task, false, true));
    }
}
