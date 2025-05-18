package com.example.demo.workflows;

import com.example.demo.dto.orders.OrderRequest;
import com.example.demo.dto.orders.OrderResponse;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface OrderWorkflow {

    @WorkflowMethod
    OrderResponse orderPizza(OrderRequest orderRequest);
}
