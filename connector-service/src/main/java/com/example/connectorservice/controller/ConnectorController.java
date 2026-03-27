package com.example.connectorservice.controller;

import com.example.connectorservice.dto.UserWithTasksDTO;
import com.example.connectorservice.service.ConnectorService;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/connector")
public class ConnectorController {

    private final ConnectorService connectorService;

    public ConnectorController(ConnectorService connectorService) {
        this.connectorService = connectorService;
    }

    @GetMapping("/users/{id}")
    public UserWithTasksDTO getUserWithTasks (@PathVariable Long id) {
        return connectorService.getUserWithTasks(id);
    }

}
