package com.example.demo.workflows;

import com.example.demo.activities.OrderActivitiesImpl;
import com.example.demo.common.Workflows;
import com.example.demo.dto.orders.OrderRequest;
import com.example.demo.dto.orders.OrderResponse;
import com.example.demo.fixtures.OrderRequestFixtures;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.testing.TestWorkflowEnvironment;
import io.temporal.worker.Worker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class OrderWorkflowTest {

    private TestWorkflowEnvironment testEnv;
    private Worker worker;
    private WorkflowClient client;

    @Before
    public void setup() {

        testEnv = TestWorkflowEnvironment.newInstance();
        worker = testEnv.newWorker(Workflows.ORDER_TASK_QUEUE);
        worker.registerWorkflowImplementationTypes(OrderWorkflowImpl.class);
        client = testEnv.getWorkflowClient();
    }

    @After
    public void tearDown() {
        testEnv.close();
    }

    @Test
    public void testIntegrationGetGreeting() {

        worker.registerActivitiesImplementations(new OrderActivitiesImpl());
        testEnv.start();

        OrderWorkflow orderWorkflow = client
                .newWorkflowStub(OrderWorkflow.class, WorkflowOptions.newBuilder()
                        .setTaskQueue(Workflows.ORDER_TASK_QUEUE).build());

        OrderRequest orderRequest = OrderRequestFixtures.getOrderRequest();
        OrderResponse orderResponse = orderWorkflow.orderPizza(orderRequest);

        assertNotNull(orderWorkflow);
        assertEquals(orderRequest.orderNumber(), orderResponse.orderNumber());
        assertEquals(new BigDecimal("25.00"), orderResponse.totalAmount());
        assertNotNull(orderResponse.orderDate());
    }
}