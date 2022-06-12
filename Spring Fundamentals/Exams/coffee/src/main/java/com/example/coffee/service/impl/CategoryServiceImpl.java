package com.example.coffee.service.impl;

import com.example.coffee.model.entity.CategoryEntity;
import com.example.coffee.model.entity.enums.CategoryEnum;
import com.example.coffee.repository.CategoryRepository;
import com.example.coffee.service.CategoryService;
import org.springframework.stereotype.Service;
import java.util.Arrays;


@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;


    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;

    }

    @Override
    public void initializeCategories() {
        if (categoryRepository.count() == 0) {

            Arrays.stream(CategoryEnum.values())
                            .forEach(categoryEnum -> {
                                CategoryEntity category = new CategoryEntity();
                                category.setName(categoryEnum);
                                switch (categoryEnum) {
                                    case CAKE -> category.setNeededTime(10);
                                    case DRINK -> category.setNeededTime(1);
                                    case COFFEE -> category.setNeededTime(2);
                                    case OTHER -> category.setNeededTime(5);
                                }

                                categoryRepository.save(category);
                            });


        }
    }

    @Override
    public CategoryEntity findByCategoryNameEnum(CategoryEnum categoryNameEnum) {

        return categoryRepository.findByName(categoryNameEnum).orElse(null);
    }
}
