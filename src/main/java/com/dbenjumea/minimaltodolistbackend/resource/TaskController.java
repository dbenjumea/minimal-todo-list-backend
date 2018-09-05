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

    @DeleteMapping("/tasks/delete/{id}")
    public void deleteTask(@PathVariable long id) {
        service.deleteById(id);
    }

    @PostMapping("/task/save")
    public ResponseEntity<Task> saveTask(@RequestBody Task task) {
        Task savedTask = service.save(task);

        return ResponseEntity.ok(savedTask);

    }

    @PutMapping("/tasks/update/{id}")
    public ResponseEntity<Object> updateTask(@RequestBody Task task, @PathVariable long id) {

        Optional<Task> taskOptional = service.findById(id);

        if (!taskOptional.isPresent())
            return ResponseEntity.notFound().build();

        service.save(task);

        return ResponseEntity.ok("task created");
    }
}
