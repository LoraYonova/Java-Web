package com.example.pathfinder.model.entity;

import com.example.pathfinder.model.entity.enums.RoleNameEnum;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class RoleEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private RoleNameEnum role;

    public RoleEntity() {
    }

    public RoleNameEnum getRole() {
        return role;
    }

    public RoleEntity setName(RoleNameEnum role) {
        this.role = role;
        return this;
    }
}
