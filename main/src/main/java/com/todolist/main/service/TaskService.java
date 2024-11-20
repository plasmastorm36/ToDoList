package com.todolist.main.service;

import com.todolist.main.model.Task;
import com.todolist.main.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

   /**
    * 
    * @param isCompleted
    * @return returns a list of all task that follow the completion status
    */
   public List<Task> findByCompletion (final boolean isCompleted) {
      return repos.findByCompletion(isCompleted);
   }
}
