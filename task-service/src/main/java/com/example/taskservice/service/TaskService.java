package com.example.taskservice.service;

import com.example.taskservice.model.Task;
import com.example.taskservice.model.TaskStatus;
import com.example.taskservice.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return repository.findById(id);
    }

    public Task createTask(Task task) {
        return repository.save(task);
    }

    public Task updateTask(Long id, Task updatedTask) {
        Optional<Task> optionalTask = repository.findById(id);

        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();

            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setStatus(updatedTask.getStatus());

            return repository.save(task);

        } else {
            throw new RuntimeException("Task Not Found with id: " + id);
        }
    }

    @Transactional
    public Task updateStatus(Long id, TaskStatus updatedStatus) {
        Optional<Task> optionalTask = repository.findById(id);

        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();

            task.setStatus(updatedStatus);

            return repository.save(task);

        } else {
            throw new RuntimeException("Task Not Found with id: " + id);
        }
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
    }

}
