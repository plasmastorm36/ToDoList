package com.todolist.main.service;

import com.todolist.main.model.Task;
import com.todolist.main.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
/**
 * Service layer to handle all requests and business logic
 * @author Noah Rouse
 * @email noahrouse35@gmail.com
 */
public class TaskService {
   private final TaskRepository repos;
   public TaskService (final TaskRepository taskRepos) {
      this.repos = taskRepos;
   }

   public List<Task> findAll () {
      return repos.findAll();
   }

   /**
    * 
    * @param isCompleted
    * @return returns a list of all task that follow the completion status
    */
   public List<Task> findByCompletion (final boolean isCompleted) {
      return repos.findByIsCompleted(isCompleted);
   }

   /**
    * finds a task by its id number
    * @param id
    * @return task found
    * @throws Exception when no task is found
    */
   public Task findById (final Long id) throws Exception {
      final Optional<Task> task = repos.findById(id);
      if (task.isPresent()) {
         return task.get();
      }
      throw new Exception (String.format("Task %d not found", id));
   }

   /**
    * save method to add or change a task
    * @param task
    */
   public void save (final Task task) {
      repos.save(task);
   }
}
