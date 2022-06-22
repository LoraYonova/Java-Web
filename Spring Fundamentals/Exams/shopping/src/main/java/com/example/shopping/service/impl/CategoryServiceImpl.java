package com.example.shopping.service.impl;

import com.example.shopping.model.entity.CategoryEntity;
import com.example.shopping.model.entity.enums.CategoryEnum;
import com.example.shopping.repository.CategoryRepository;
import com.example.shopping.service.CategoryService;
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
                        categoryRepository.save(category);
                    });
        }
    }

    @Override
    public CategoryEntity findByName(CategoryEnum categoryEnum) {
        return categoryRepository.findByName(categoryEnum).orElse(null);
    }


}
