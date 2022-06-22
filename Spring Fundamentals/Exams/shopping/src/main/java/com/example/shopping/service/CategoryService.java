package com.example.shopping.service;

import com.example.shopping.model.entity.CategoryEntity;
import com.example.shopping.model.entity.enums.CategoryEnum;

import java.util.Optional;

public interface CategoryService {
    void initializeCategories();

   CategoryEntity findByName(CategoryEnum categoryEnum);
}
