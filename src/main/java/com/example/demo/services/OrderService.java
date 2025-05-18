package com.example.demo.services;

import com.example.demo.common.Workflows;
import com.example.demo.dto.orders.OrderRequest;
import com.example.demo.dto.orders.OrderResponse;
import com.example.demo.workflows.OrderWorkflow;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private WorkflowClient workflowClient;

    public OrderResponse orderPizza(
            OrderRequest orderRequest) {

        String orderWorkflowId = "process-order-number-" + orderRequest.orderNumber();
        WorkflowOptions workflowOptions = WorkflowOptions.newBuilder()
                .setWorkflowId(orderWorkflowId)
                .setTaskQueue(Workflows.ORDER_TASK_QUEUE)
                .build();

        OrderWorkflow orderWorkflow = workflowClient.newWorkflowStub(OrderWorkflow.class, workflowOptions);
        return orderWorkflow.orderPizza(orderRequest);
    }
}
