package com.example.gira.service.impl;

import com.example.gira.model.entity.ClassificationEntity;
import com.example.gira.model.entity.enums.ClassificationEnum;
import com.example.gira.repository.ClassificationRepository;
import com.example.gira.service.ClassificationService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ClassificationServiceImpl implements ClassificationService {

    private final ClassificationRepository classificationRepository;

    public ClassificationServiceImpl(ClassificationRepository classificationRepository) {
        this.classificationRepository = classificationRepository;
    }

    @Override
    public void initializeClassification() {
        if (classificationRepository.count() == 0) {
            Arrays.stream(ClassificationEnum.values())
                    .forEach(classificationEnum -> {
                        ClassificationEntity classification = new ClassificationEntity();
                        classification.setClassificationName(classificationEnum);
                        classificationRepository.save(classification);
                    });
        }
    }

    @Override
    public ClassificationEntity findByName(ClassificationEnum classificationName) {
        return classificationRepository.findByClassificationName(classificationName).orElse(null);
    }


}
