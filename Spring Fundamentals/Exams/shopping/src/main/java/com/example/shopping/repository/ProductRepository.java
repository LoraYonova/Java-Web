package com.example.shopping.repository;

import com.example.shopping.model.entity.ProductEntity;
import com.example.shopping.model.entity.enums.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Query("SELECT SUM(p.price) FROM ProductEntity p ")
    BigDecimal findTotalProductsSum();

    List<ProductEntity> findAllByCategory_Name(CategoryEnum category_name);

}
