package com.codecorn.OrderService.service;

import com.codecorn.OrderService.model.OrderRequest;

public interface OrderService {

    long placeOrder(OrderRequest orderRequest);

}
