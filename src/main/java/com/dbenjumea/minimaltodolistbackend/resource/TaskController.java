package com.dbenjumea.minimaltodolistbackend.resource;

import com.dbenjumea.minimaltodolistbackend.entity.Task;
import com.dbenjumea.minimaltodolistbackend.repository.TaskRepository;
import com.dbenjumea.minimaltodolistbackend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/")
@CrossOrigin
public class TaskController {

    @Autowired
    TaskRepository repository;

    @Autowired
    TaskService service;

    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable long id) {
        service.deleteById(id);
    }

    @PostMapping("/task/create")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task savedTask = service.save(task);

        return ResponseEntity.ok(savedTask);

    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<Object> updatetask(@RequestBody Task task, @PathVariable long id) {

        Optional<Task> taskOptional = service.findById(id);

        if (!taskOptional.isPresent())
            return ResponseEntity.notFound().build();

        service.save(task);

        return ResponseEntity.ok("task created");
    }
}
