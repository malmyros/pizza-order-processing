package com.example.demo.workflows;

import com.example.demo.activities.OrderActivitiesImpl;
import com.example.demo.dto.orders.OrderRequest;
import com.example.demo.dto.orders.OrderResponse;
import com.example.demo.fixtures.OrderRequestFixtures;
import io.temporal.client.WorkflowOptions;
import io.temporal.testing.TestWorkflowRule;
import org.junit.Rule;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class OrderWorkflowTest {

    @Rule
    public TestWorkflowRule testWorkflowRule =
            TestWorkflowRule.newBuilder()
                    .setWorkflowTypes(OrderWorkflowImpl.class)
                    .setActivityImplementations(new OrderActivitiesImpl())
                    .build();

    @Test
    public void shouldReturnTheOrderResponse() {

        WorkflowOptions workflowOptions = WorkflowOptions.newBuilder()
                .setTaskQueue(testWorkflowRule.getTaskQueue())
                .build();

        OrderWorkflow orderWorkflow = testWorkflowRule
                .getWorkflowClient()
                .newWorkflowStub(
                        OrderWorkflow.class,
                        workflowOptions);

        OrderRequest orderRequest = OrderRequestFixtures.getOrderRequest();
        OrderResponse orderResponse = orderWorkflow.orderPizza(orderRequest);

        assertNotNull(orderWorkflow);
        assertEquals(orderRequest.orderNumber(), orderResponse.orderNumber());
        assertEquals(new BigDecimal("25.00"), orderResponse.totalAmount());
        assertNotNull(orderResponse.orderDate());

        testWorkflowRule.getTestEnvironment().shutdown();
    }
}