package com.example.shopping.service.impl;

import com.example.shopping.model.entity.ProductEntity;
import com.example.shopping.model.entity.enums.CategoryEnum;
import com.example.shopping.model.service.ProductServiceModel;
import com.example.shopping.model.view.ProductViewModel;
import com.example.shopping.repository.ProductRepository;
import com.example.shopping.service.CategoryService;
import com.example.shopping.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }


    @Override
    public void add(ProductServiceModel productServiceModel) {
        ProductEntity productEntity = modelMapper.map(productServiceModel, ProductEntity.class);
        productEntity.setCategory(categoryService.findByName(productServiceModel.getCategory()));

        productRepository.save(productEntity);
    }

    @Override
    public BigDecimal getTotalSum() {
        return productRepository.findTotalProductsSum();
    }

    @Override
    public List<ProductViewModel> findAllProductsByCategoryEnum(CategoryEnum category) {
        return productRepository.findAllByCategory_Name(category).stream()
                .map(productEntity -> modelMapper.map(productEntity, ProductViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void buyById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void buyAll() {
        productRepository.deleteAll();
    }
}
