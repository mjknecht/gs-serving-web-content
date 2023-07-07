package com.example.servingwebcontent;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class Task {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String description;
    private LocalDate dueDate;
    private boolean complete;

    public Task() {
    }

    public Task(String description, LocalDate dueDate, boolean complete) {
        this.description = description;
        this.dueDate = dueDate;
        this.complete = complete;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(LocalDate date) {
        this.dueDate = date;
    }

    public boolean getComplete() {
        return this.complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
