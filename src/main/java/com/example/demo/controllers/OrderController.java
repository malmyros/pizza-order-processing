package com.example.demo.controllers;

import com.example.demo.dto.orders.OrderRequest;
import com.example.demo.dto.orders.OrderResponse;
import com.example.demo.services.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderResponse> orderPizza(
            @Valid @RequestBody OrderRequest orderRequest) throws ExecutionException, InterruptedException {

        OrderResponse orderResponse = orderService.orderPizza(orderRequest);
        return ResponseEntity.ok(orderResponse);
    }
}
