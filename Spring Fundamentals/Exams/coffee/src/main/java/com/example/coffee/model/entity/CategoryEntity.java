package com.example.coffee.model.entity;

import com.example.coffee.model.entity.enums.CategoryEnum;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity {

    @Column
    @Enumerated(EnumType.STRING)
    private CategoryEnum name;

    @Column(name = "needed_time", nullable = false)
    private Integer neededTime;

    public CategoryEntity() {
    }

    public CategoryEnum getName() {
        return name;
    }

    public CategoryEntity setName(CategoryEnum name) {
        this.name = name;
        return this;
    }

    public Integer getNeededTime() {
        return neededTime;
    }

    public CategoryEntity setNeededTime(Integer neededTime) {
        this.neededTime = neededTime;
        return this;
    }
}
