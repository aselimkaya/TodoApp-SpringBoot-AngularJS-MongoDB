package com.beam.sample.todo.controller;

import com.beam.sample.todo.model.Task;
import com.beam.sample.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/all")
    public List<Task> all(){
        return taskService.all();
    }

    @GetMapping("/{id}")
    public Task findTaskById(@PathVariable("id") String id){
        return taskService.findById(id);
    }

    @PostMapping("/add")
    public Task addNewTask(@RequestBody Task task){
      return taskService.persist(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable("id") String id){
        taskService.remove(id);
    }
}