package com.example.gira.util;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CurrentUser {

    private Long Id;
    private String emil;


    public CurrentUser() {
    }

    public Long getId() {
        return Id;
    }

    public CurrentUser setId(Long id) {
        Id = id;
        return this;
    }

    public String getEmil() {
        return emil;
    }

    public CurrentUser setEmil(String emil) {
        this.emil = emil;
        return this;
    }
}
