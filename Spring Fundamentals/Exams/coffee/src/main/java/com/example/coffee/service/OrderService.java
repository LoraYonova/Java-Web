package com.example.coffee.service;

import com.example.coffee.model.service.OrderServiceModel;
import com.example.coffee.model.view.OrderViewModel;

import java.util.List;

public interface OrderService {
    void addOrder(OrderServiceModel orderServiceModel);

    List<OrderViewModel> findAllOrdersByPriceDesc();

    void readyOrder(Long id);
}
