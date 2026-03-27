package com.example.connectorservice.service;

import com.example.connectorservice.client.TaskClient;
import com.example.connectorservice.client.UserClient;
import com.example.connectorservice.dto.UserWithTasksDTO;
import com.example.connectorservice.model.Task;
import com.example.connectorservice.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConnectorService {

    private final UserClient userClient;
    private final TaskClient taskClient;

    public ConnectorService(UserClient userClient, TaskClient taskClient) {
        this.userClient = userClient;
        this.taskClient = taskClient;
    }

    public UserWithTasksDTO getUserWithTasks(Long userId) {

        User user = userClient.getUserById(userId);

        if(user == null) {
            throw new RuntimeException("User not found");
        }

        List<Task> tasks = taskClient.getTasksByUserId(userId);

        return new UserWithTasksDTO(user, tasks);
    }

}
