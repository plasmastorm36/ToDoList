package com.todolist.main.controller;

import com.todolist.main.model.Task;
import com.todolist.main.service.TaskService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
   private final TaskService service;
   public TaskController (final TaskService taskService) {
      service = taskService;
   }

   /**
    * 
    * @return all tasks
    */
    @GetMapping
   public List<Task> getAll () {
      return service.findAll();
   }
   
   @GetMapping("/uncompleted")
   /**
    * 
    * @return all uncompleted tasks
    */
   public List<Task> getUncompletedTasks () {
      return service.findByCompletion(false);
   }

   @PostMapping("/add")
   /**
    * Adds a task to the database
    * @param task
    */
   public ResponseEntity<Task> addTask (@RequestBody final Task task) {
      task.setCreated();
      service.save(task);
      return ResponseEntity.status(HttpStatus.CREATED).body(task);
   }

   @PutMapping("/change-completion/{id}/{isCompleted}")
   /**
    * updates task completion
    * @param id
    * @param isCompleted
    */
   public ResponseEntity<String> changeCompletion (@PathVariable final long id, 
         @PathVariable final boolean isCompleted) {
      try {
         final Task task = service.findById(id);
         task.setIsCompleted(isCompleted);
         return ResponseEntity.ok(String.format("Task %d completion updated to %b", id,
               isCompleted));
      } catch (final Exception e) {
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
      }
   }
}
