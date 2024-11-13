package com.todo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.todo.demo.Task;

import java.util.List;
import java.time.LocalDate;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
   @Query("select t from Task t where t.priority = :priority order by t.dueDate DESC")
   List<Task> findByPriority (@Param("priority") final String priority);

   @Query("select t from Task t where t.dueDate = :dueDate order by t.dueDate DESC")
   List<Task> findByDueDate (@Param("dueDate") final LocalDate dueDate);

   @Query("select t from Task t where t.completed = :completed order by t.dueDate DESC")
   List<Task> findByCompletedStatus (@Param("completed") final boolean completed);

   @Query("select t from Task t where t.description like %:description% order by t.dueDate")
   List<Task> findByDescription (@Param("description") final String description);
}
