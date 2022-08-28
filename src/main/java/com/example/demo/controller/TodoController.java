package com.example.demo.controller;

import com.example.demo.exception.TodoNotFoundException;
import com.example.demo.model.Todo;
import com.example.demo.repository.TodoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    private final TodoRepository repo;

    public  TodoController(TodoRepository repo){
        this.repo = repo;
    }

    @GetMapping("/todos")
    List<Todo>all(){
     return this.repo.findAll();
    }

    @PostMapping("/todos/create")
    Todo newTodo(@RequestBody Todo todo){
        return repo.save(todo);
    }

    @GetMapping("/todos/{id}")
    Todo one(@PathVariable Long id){
        return repo.findById(id).orElseThrow(()->new TodoNotFoundException(id));
    }

    @PutMapping("/todos/{id}")
    Todo replaceTodo(@RequestBody Todo newTodo, @PathVariable Long id){
        return repo.findById(id).map(todo->{
            todo.setTitle(newTodo.getTitle());
            todo.setDescription(newTodo.getDescription());
            todo.setDone(newTodo.getDone());
           return repo.save(todo);
        }).orElseThrow(()-> new TodoNotFoundException(id));
    }

    @DeleteMapping("/todos/{id}")
    void rmTodo(@PathVariable Long id){
        repo.deleteById(id);
    }

}
