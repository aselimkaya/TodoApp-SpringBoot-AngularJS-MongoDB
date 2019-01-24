package com.beam.sample.todo.service;

import com.beam.sample.todo.model.Task;
import com.beam.sample.todo.repository.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService {
    private Logger logger = LoggerFactory.getLogger(TaskService.class);

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> all(){
        return taskRepository.findAll();
    }

    public Task findById(String id){
        Optional<Task> task = taskRepository.findById(id);
        return task.orElse(null);
    }

    public Task persist(Task task){
        if(task.getId() == null){
            task.setId(UUID.randomUUID().toString());
            logger.info("New task created");
        }else{
            logger.info("Task updated");
        }
        return taskRepository.save(task);
    }

    public void remove(String id){
        taskRepository.deleteById(id);
        logger.info("User deleted");
    }
}