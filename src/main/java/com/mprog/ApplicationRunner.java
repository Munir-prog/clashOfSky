package com.mprog;

import com.mprog.database.model.Clan;
import com.mprog.database.model.GoldStatistics;
import com.mprog.service.FightArenaService;
import com.mprog.service.TaskService;
import com.mprog.service.UserAddGoldService;
import com.mprog.service.UserService;
import com.mprog.service.clan.ClanServiceImpl;
import com.mprog.thread.ClanThread;
import com.mprog.util.RandomUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class ApplicationRunner {

    public static void main(String[] args) throws InterruptedException {
        Map<String, Thread> threads = new ConcurrentHashMap<>();


        var clanService = ClanServiceImpl.getInstance();
        var userService = UserService.getInstance();

//        Сервис с заданиями.
        var taskService = new TaskService(clanService);
//        Сервис который поплняет казну из кармана юзера
        var userAddGoldService = new UserAddGoldService(clanService);
//        Сервис который поплняет казну в зависимости от сражения пользователя(todo нужно реализовать)
        var fightArenaService = new FightArenaService(clanService);

//        Запускаю 200 потоков где в каждом потоке рандомно выбирается сервис и юзер и пополняется казна клана
        for (int i = 0; i < 500; i++) {
            var userId = RandomUtils.getRandom().nextLong(10) + 1;
            var clanThread = new ClanThread(
                    taskService, userAddGoldService,
                    fightArenaService, userId
            );
            clanThread.start();
            threads.put("thread" + i, clanThread);

        }

        for (Thread value : threads.values()) {
            value.join();
        }

//        В конце после выполнения потоков из статистики клана высчитывается сумма внесенных денег и сравнивается с казной.
        int totalIncomeGold = 0;
        var clan = clanService.getClan(1);
//        считаем сумму золота из статистики
        for (GoldStatistics goldStatistic : clan.getGoldStatistics()) {
            totalIncomeGold += goldStatistic.getGoldAmount();
        }
//        выводим статистику
        clan.getGoldStatistics().forEach(System.out::println);
        System.out.println("statistics size:" + clan.getGoldStatistics().size());
        System.out.println("total income:" + totalIncomeGold);
        System.out.println("clan gold amount:" + clan.getGold());
    }
}
