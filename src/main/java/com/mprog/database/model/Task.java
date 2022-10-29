package com.mprog.database.model;

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
        return getTaskSalary();
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
