package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

// @JsonInclude(JsonInclude.Include.NON_NULL)
public class TodoDTO {
    private String title;
    private String description;
    private Boolean isDone;

    public TodoDTO(){}

    public TodoDTO(String title, String description, Boolean isDone){
        this.title = title != null ? title : null;
        this.description =  description != null ? description : null;
        this.isDone =  isDone != null ? isDone : null;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }
}
