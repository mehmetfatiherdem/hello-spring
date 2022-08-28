package com.example.demo.exception;

 public class TodoNotFoundException extends RuntimeException{
    public TodoNotFoundException(Long id){
        super("Could not find the todo with the ID of " + id);
    }
 }
