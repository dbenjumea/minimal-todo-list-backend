package com.dbenjumea.minimaltodolistbackend.service;

import com.dbenjumea.minimaltodolistbackend.entity.Task;
import com.dbenjumea.minimaltodolistbackend.entity.User;
import com.dbenjumea.minimaltodolistbackend.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService implements GenericService<Task>{
    @Autowired
    TaskRepository taskRepository;

    @Override
    public Optional<Task> findById(long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        return optionalTask;
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Task save(Task obj) {
        Task taskSaved = taskRepository.save(obj);
        return taskSaved;
    }
}
