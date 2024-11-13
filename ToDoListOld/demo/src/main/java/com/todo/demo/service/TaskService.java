package com.todo.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todo.demo.Task;
import com.todo.demo.repository.TaskRepository;


import java.time.LocalDate;
import java.util.Optional;
@Service
@Transactional
public class TaskService {
   public class TaskNotFoundException extends Exception {

   }
   private final TaskRepository taskRepos;

   public TaskService (final TaskRepository taskRepository) {
      taskRepos = taskRepository;
   }

   public void updateTaskDescription (final long taskId, final String description)
         throws TaskNotFoundException {
      final Optional<Task> potentialTask = taskRepos.findById(taskId);

      if (potentialTask.isPresent()) {
         final Task task = potentialTask.get();
         task.description(description);
         taskRepos.save(task);
      } else {
         throw new TaskNotFoundException();
      }
   }

   public void updateTaskCompletion (final long taskId, final boolean completed)
         throws TaskNotFoundException {
      final Optional<Task> potentialTask = taskRepos.findById(taskId);
      
      if (potentialTask.isPresent()) {
         final Task task = potentialTask.get();
         task.completed(completed);
         taskRepos.save(task);
      } else {
         throw new TaskNotFoundException();
      }
   }

   public void updateTaskPriority (final long taskId, final String priority)
         throws TaskNotFoundException {
      final Optional<Task> potentialTask = taskRepos.findById(taskId);

      if (potentialTask.isPresent()) {
         final Task task = potentialTask.get();
         task.priority(priority);
         taskRepos.save(task);
      } else {
         throw new TaskNotFoundException();
      }
   }

   public void updateTaskDueDate (final long taskId, final LocalDate dueDate)
         throws TaskNotFoundException {
      final Optional<Task> potentialTask = taskRepos.findById(taskId);

      if (potentialTask.isPresent()) {
         final Task task = potentialTask.get();
         task.dueDate(dueDate);
         taskRepos.save(task);
      } else {
         throw new TaskNotFoundException();
      }
   }
}
