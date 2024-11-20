package com.todolist.main.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "Tasks")
/**
 * Task entity made to store task data. Annotated to tell mvn how to store it in the db
 * @author Noah Rouse
 * @email noahrouse36@gmail.com
 */
public class Task {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name= "Id")
   private long id;

   @Column(name = "Description")
   private String description;

   @Column(name = "Priority")
   private String priority;

   @Column(name = "Due Date")
   private LocalDate dueDate;

   @Column(name = "Completed")
   private boolean isCompleted;

   @Column(name = "Created")
   private LocalDate created;
   
   @Column(name = "Updated")
   private LocalDate lastUpdated;

   public Task () {}

   public Task (final String description, final String priority, final LocalDate dueDate) {
      this.description = description;
      this.priority = priority;
      this.dueDate = dueDate;
      this.isCompleted = false;
      this.created = LocalDate.now();
      lastUpdated = created;
   }

   public Long getId () {
      return this.id;
   }

   public String getDescription () {
      return this.description;
   }

   public String getPriority () {
      return this.priority;
   }

   public LocalDate getDueDate () {
      return this.dueDate;
   }

   public boolean getIsCompleted () {
      return this.isCompleted;
   }

   public LocalDate getCreated () {
      return this.created;
   }

   public LocalDate getLastUpdated () {
      return this.lastUpdated;
   }

   public void setDescription (final String description) {
      this.description = description;
      lastUpdated = LocalDate.now();
   }

   public void setPriority (final String priority) {
      this.priority = priority;
      lastUpdated = LocalDate.now();
   }

   public void setDueDate (final LocalDate dueDate) {
      this.dueDate = dueDate;
      lastUpdated = LocalDate.now();
   }

   public void setIsCompleted (final boolean isCompleted) {
      this.isCompleted = isCompleted;
      lastUpdated = LocalDate.now();
   }
}
