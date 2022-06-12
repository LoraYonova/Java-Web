package com.example.coffee.service;

import com.example.coffee.model.entity.CategoryEntity;
import com.example.coffee.model.entity.enums.CategoryEnum;

public interface CategoryService {
    void initializeCategories();

    CategoryEntity findByCategoryNameEnum(CategoryEnum categoryNameEnum);
}
