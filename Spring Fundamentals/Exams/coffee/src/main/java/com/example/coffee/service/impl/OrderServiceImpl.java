package com.example.coffee.service.impl;

import com.example.coffee.model.entity.OrderEntity;
import com.example.coffee.model.service.OrderServiceModel;
import com.example.coffee.model.view.OrderViewModel;
import com.example.coffee.repository.OrderRepository;
import com.example.coffee.service.CategoryService;
import com.example.coffee.service.OrderService;
import com.example.coffee.service.UserService;
import com.example.coffee.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final CategoryService categoryService;

    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper, CurrentUser currentUser, UserService userService, CategoryService categoryService) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
        this.categoryService = categoryService;
    }


    @Override
    public void addOrder(OrderServiceModel orderServiceModel) {
        OrderEntity orderEntity = modelMapper.map(orderServiceModel, OrderEntity.class);
        orderEntity.setEmployee(userService.findById(currentUser.getId()));
        orderEntity.setCategory(categoryService.findByCategoryNameEnum(orderServiceModel.getCategory()));

        orderRepository.save(orderEntity);
    }

    @Override
    public List<OrderViewModel> findAllOrdersByPriceDesc() {
        return orderRepository.findAllByOrderByPriceDesc()
                .stream()
                .map(order -> modelMapper.map(order, OrderViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void readyOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
