package com.mprog.database.model;

import com.mprog.util.RandomUtils;

import java.util.Random;

public class Task {

    private final long id;
    private final String taskTittle;
    private final int taskSalary;

    public Task(long id, String taskTittle, int taskSalary) {
        this.id = id;
        this.taskTittle = taskTittle;
        this.taskSalary = taskSalary;
    }

    public int doTaskAndGetAward() {
        var result = RandomUtils.getRandom().nextInt(2) + 1;
        if (result == 1)
            return getTaskSalary();
        else
            return 0;
    }

    public long getId() {
        return id;
    }

    public String getTaskTittle() {
        return taskTittle;
    }

    public int getTaskSalary() {
        return taskSalary;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskTittle='" + taskTittle + '\'' +
                ", taskSalary=" + taskSalary +
                '}';
    }
}
