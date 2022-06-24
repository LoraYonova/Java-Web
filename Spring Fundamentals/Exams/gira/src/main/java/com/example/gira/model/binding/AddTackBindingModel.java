package com.example.gira.model.binding;

import com.example.gira.model.entity.enums.ClassificationEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class AddTackBindingModel {

    @NotBlank
    @Size(min = 3, max = 20, message = "Name length must be between 3 and 20 characters!")
    private String name;

    @NotBlank
    @Size(min = 5, message = "Description length must be more than 5 characters!")
    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "The date cannot be in the past!")
    private LocalDate dueDate;

    @NotNull(message = "Classification cannot be null!")
    private ClassificationEnum classification;

    public AddTackBindingModel() {
    }

    public String getName() {
        return name;
    }

    public AddTackBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AddTackBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public AddTackBindingModel setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public ClassificationEnum getClassification() {
        return classification;
    }

    public AddTackBindingModel setClassification(ClassificationEnum classification) {
        this.classification = classification;
        return this;
    }
}
