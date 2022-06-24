package com.example.gira.service;

import com.example.gira.model.entity.ClassificationEntity;
import com.example.gira.model.entity.enums.ClassificationEnum;

public interface ClassificationService {
    void initializeClassification();


    ClassificationEntity findByName(ClassificationEnum classificationName);
}
