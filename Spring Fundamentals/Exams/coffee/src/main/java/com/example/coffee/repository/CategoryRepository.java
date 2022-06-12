package com.example.coffee.repository;

import com.example.coffee.model.entity.CategoryEntity;
import com.example.coffee.model.entity.enums.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    Optional<CategoryEntity> findByName(CategoryEnum name);

}
