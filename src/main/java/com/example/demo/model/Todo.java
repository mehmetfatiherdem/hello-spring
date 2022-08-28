package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id; // TODO: make this UUID
    private String title;
    private String description;
    private Boolean isDone;

    public Todo() {

    }

    public Todo(String title, String description, Boolean isDone){
        this.title = title;
        this.description = description;
        this.isDone = isDone;
    }

    public Long getId(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public Boolean getDone() {
        return this.isDone;
    }

    public void setDone(Boolean isDone) {
        this.isDone = isDone;
    }
}
