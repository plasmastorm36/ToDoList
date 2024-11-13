package com.todo.demo;

import java.time.LocalDate;
import jakarta.persistence.*;
@Entity
@Table(name = "tasks")
/**
 * @Author Noah Rouse
 * @email: noahrouse36@gmail.com
 * @description: this class is designed to store and represent tasks in a todo list
 */
public class Task {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column
   private long id;
   @Column(name = "description", nullable = false)
   private String description;
   @Column(name = "completed")
   private boolean completed;
   @Column(name = "priority")
   private String priority;
   @Column(name = "due_date")
   private LocalDate dueDate;
   @Column(name = "created")
   private LocalDate created;
   @Column(name = "last_updated")
   private LocalDate lastUpdated;

   public Task () {}

   public Task (final Long id, final String description, final String priority,
         final LocalDate dueDate) {
      this.id = id;
      this.completed = false;
      this.description = description;
      this.priority = priority;
      this.dueDate = dueDate;
      this.created = LocalDate.now();
      this.lastUpdated = created;
   }

   /**
    * @return task id
    */
   public long id () {
      return this.id;      
   }

   /**
    * @return description
    */
   public String description () {
      return this.description;
   }

   /**
    * set task description to new description and changes last updated value
    * @return updated description
    */
   public String description (final String description) {
      this.description = description;
      this.lastUpdated = LocalDate.now();
      return this.description;
   }

   /**
    * @return if the task is completed
    */
   public boolean completed () {
      return this.completed;
   }

   /**
    * Set completed to true or false
    * @return updated completed status
    */
   public boolean completed (final boolean completed) {
      this.completed = completed;
      this.lastUpdated = LocalDate.now();
      return this.completed;
   }

   /**
    * @return priority of task
    */
   public String priority () {
      return this.priority;
   }

   /**
    * sets task to new priority
    * @return new priority
    */
   public String priority (final String priority) {
      this.priority = priority;
      this.lastUpdated = LocalDate.now();
      return this.priority;
   }


   /**
    * @return current task due date
    */
   public LocalDate dueDate () {
      return this.dueDate;
   }

   /**
    * change due date to new local date
    * @return new due date
    */
   public LocalDate dueDate (final LocalDate dueDate) {
      this.dueDate = dueDate;
      this.lastUpdated = LocalDate.now();
      return this.dueDate;
   }

   /**
    * @return when the task was last updated
    */
   public LocalDate lastUpdated () {
      return this.lastUpdated;
   }
}
