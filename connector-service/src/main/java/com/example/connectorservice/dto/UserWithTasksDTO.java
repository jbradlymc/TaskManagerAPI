package com.example.connectorservice.dto;

import com.example.connectorservice.model.Task;
import com.example.connectorservice.model.User;

import java.util.List;

public class UserWithTasksDTO {

    private User user;
    private List<Task> tasks;

    public UserWithTasksDTO(User user, List<Task> tasks) {
        this.user = user;
        this.tasks = tasks;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
