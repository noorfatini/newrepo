package com.example.AssetTracker.dto;

import jakarta.validation.constraints.NotBlank;

/*
 * CreateTicketRequest
 * --------------------
 * DTO used to capture incoming JSON for creating a new Ticket.
 * Validation annotations ensure required fields are provided.
 * When @Valid is used in a controller, Spring will automatically validate
 * the incoming request and throw MethodArgumentNotValidException on failure.
 */
public class CreateTicketRequest {

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Description is required")
    private String description;

    @NotBlank(message = "Category is required")
    private String category;

    @NotBlank(message = "Priority is required")
    private String priority;

    @NotBlank(message = "Created by is required")
    private String createdBy;

    // Standard getters and setters are required for Jackson to bind JSON -> object.
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
