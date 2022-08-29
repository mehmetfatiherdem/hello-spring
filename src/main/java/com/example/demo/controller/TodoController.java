package com.example.demo.controller;

import com.example.demo.dto.TodoDTO;
import com.example.demo.exception.TodoNotFoundException;
import com.example.demo.model.Todo;
import com.example.demo.repository.TodoRepository;

import org.springframework.http.ResponseEntity;
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
    ResponseEntity<?> replaceTodo(@RequestBody Todo newTodo, @PathVariable Long id){
       Todo todo = repo.findById(id).orElseThrow(()-> new TodoNotFoundException(id));

        todo.setTitle(newTodo.getTitle());
        todo.setDescription(newTodo.getDescription());
        todo.setDone(newTodo.getDone());
        repo.save(todo);

        return ResponseEntity.ok("Todo with the ID of " + id + " has been replaced with the info you entered");
    }

    @PatchMapping( "/todos/{id}")
    ResponseEntity<?> updateTodo(@RequestBody TodoDTO dto, @PathVariable Long id){
        Todo todo = repo.findById(id).orElseThrow(()-> new TodoNotFoundException(id));

        todo.setTitle(dto.getTitle());
        todo.setDescription(dto.getDescription());

        repo.save(todo);

        return ResponseEntity.ok("Todo with the ID of " + id + " has been updated");
    }

    @PatchMapping("/todos/{id}/check")
    ResponseEntity<?> completeTask(@PathVariable Long id, @RequestParam Boolean done){
        Todo todo = repo.findById(id).orElseThrow(() -> new TodoNotFoundException(id));

        todo.setDone(done);

        repo.save(todo);

        return ResponseEntity.ok("Done check has been updated...");
    }

    @DeleteMapping("/todos/{id}")
    ResponseEntity<?> rmTodo(@PathVariable Long id){
        repo.deleteById(id);
        return  ResponseEntity.ok("Todo deleted..");
    }

}
