package com.todo.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class TaskController {
   @GetMapping("/")
   public String homePage () {
      return "Hello User!";
   }
}