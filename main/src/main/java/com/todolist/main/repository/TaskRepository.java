package com.todolist.main.repository;

import com.todolist.main.model.Task;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

   public List<Task> findAll ();

   public Optional<Task> findById (Long id);

   @Query("SELECT t FROM Tasks WHERE t.isCompleted = :isCompleted")
   public List<Task> findByCompletion (boolean isCompleted);

   @Query("SELECT t FROM Tasks WHERE t.dueDate = :dueDate")
   public List<Task> findByDueDate (LocalDate dueDate);
}