package com.example.shopping.service;

import com.example.shopping.model.entity.enums.CategoryEnum;
import com.example.shopping.model.service.ProductServiceModel;
import com.example.shopping.model.view.ProductViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void add(ProductServiceModel productServiceModel);

    BigDecimal getTotalSum();

    List<ProductViewModel> findAllProductsByCategoryEnum(CategoryEnum category);

    void buyById(Long id);

    void buyAll();

}
