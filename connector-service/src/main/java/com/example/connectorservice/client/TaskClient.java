package com.example.connectorservice.client;

import com.example.connectorservice.model.Task;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "task-service", url = "http://localhost:8081")
public interface TaskClient {

    @GetMapping("/tasks/users/{userId}")
    List<Task> getTasksByUserId(@PathVariable("userId") Long userId);
}
