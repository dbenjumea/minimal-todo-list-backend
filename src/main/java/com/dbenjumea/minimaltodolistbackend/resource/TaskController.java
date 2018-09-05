package com.dbenjumea.minimaltodolistbackend.resource;

import com.dbenjumea.minimaltodolistbackend.entity.Task;
import com.dbenjumea.minimaltodolistbackend.entity.User;
import com.dbenjumea.minimaltodolistbackend.service.TaskService;
import com.dbenjumea.minimaltodolistbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/")
@CrossOrigin
public class TaskController {

    private TaskService taskService;

    private UserService userService;

    @Autowired
    public TaskController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    @DeleteMapping("/tasks/delete/{id}")
    public void deleteTask(@PathVariable long id) {
        taskService.deleteById(id);
    }

    @PostMapping("/task/save/{userId}")
    public ResponseEntity<Task> saveTask(@RequestBody Task task, @PathVariable Long userId) {
        Optional<User> user = userService.findById(userId);
        task.setUser(user.get());
        task.setLast_update(LocalDate.now());
        Task savedTask = taskService.save(task);

        return ResponseEntity.ok(savedTask);

    }

    @PutMapping("/tasks/update/{id}")
    public ResponseEntity<Object> updateTask(@RequestBody Task task, @PathVariable long id) {

        Optional<Task> taskOptional = taskService.findById(id);

        if (!taskOptional.isPresent())
            return ResponseEntity.notFound().build();

        taskService.save(task);

        return ResponseEntity.ok("task created");
    }
}
