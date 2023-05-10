package com.codecorn.OrderService.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codecorn.OrderService.entity.Order;
import com.codecorn.OrderService.external.client.ProductService;
import com.codecorn.OrderService.model.OrderRequest;
import com.codecorn.OrderService.repository.OrderRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductService productService;

    @Override
    public long placeOrder(OrderRequest orderRequest) {
        // Order Entity -> save the data with Status Order Created
        // Product Service -> Block Products (Reduce Quantity)
        // Payments Service -> Payments -> Success -> COMPLETE, Else
        // CANCELLED

        log.info("Placing Order Request: {}", orderRequest);

        productService.reduceQuantity(orderRequest.getProductId(), orderRequest.getQuantity());

        log.info("Creating Order with Status CREATED");
        Order order = Order.builder()
                .productId(orderRequest.getProductId())
                .quantity(orderRequest.getQuantity())
                .amount(orderRequest.getTotalAmount())
                .orderDate(Instant.now())
                .orderStatus("CREATED")
                .build();

        order = orderRepository.save(order);

        log.info("Order Place Successfully With Order Id: {}", order.getId());

        return order.getId();

    }
}
