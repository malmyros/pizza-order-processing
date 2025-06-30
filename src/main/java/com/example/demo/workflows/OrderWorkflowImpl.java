package com.example.demo.workflows;

import com.example.demo.activities.OrderActivities;
import com.example.demo.common.Workflows;
import com.example.demo.dto.orders.OrderBill;
import com.example.demo.dto.orders.OrderRequest;
import com.example.demo.dto.orders.OrderResponse;
import com.example.demo.exceptions.OutOfServiceAreaException;
import com.example.demo.factory.OrderBillFactory;
import com.example.demo.factory.OrderResponseFactory;
import io.temporal.activity.ActivityOptions;
import io.temporal.common.RetryOptions;
import io.temporal.failure.ApplicationFailure;
import io.temporal.spring.boot.WorkflowImpl;
import io.temporal.workflow.Workflow;
import org.slf4j.Logger;

import java.math.BigDecimal;
import java.time.Duration;

@WorkflowImpl(workers = Workflows.ORDER_WORKER, taskQueues = Workflows.ORDER_TASK_QUEUE)
public class OrderWorkflowImpl implements OrderWorkflow {

    public static final Logger log = Workflow.getLogger(OrderWorkflowImpl.class);

    RetryOptions retryOptions = RetryOptions.newBuilder()
            .setInitialInterval(Duration.ofSeconds(15))
            .setBackoffCoefficient(2.0)
            .setMaximumInterval(Duration.ofSeconds(60))
            .setMaximumAttempts(10)
            .build();

    ActivityOptions options = ActivityOptions.newBuilder()
            .setStartToCloseTimeout(Duration.ofSeconds(5))
            .setRetryOptions(retryOptions)
            .setHeartbeatTimeout(Duration.ofSeconds(3))
            .build();

    private final OrderActivities orderActivities = Workflow
            .newActivityStub(OrderActivities.class, options);

    @Override
    public OrderResponse orderPizza(OrderRequest orderRequest) {

        String orderNumber = orderRequest.orderNumber();

        log.info("Calculating the cost for order {}", orderNumber);
        BigDecimal totalOrderAmount = orderActivities.calculateOrderTotal(orderRequest.orderItems());

        log.info("Estimating order distance for order {}", orderNumber);
        int distance = orderActivities.estimateDeliveryDistance(orderRequest.orderAddress());

        log.info("Verifying order distance");
        if (orderRequest.isDelivery() && distance > 25) {
            String message = "Customer lives outside the service area";
            throw ApplicationFailure.newNonRetryableFailure(
                    message, OutOfServiceAreaException.class.getName());
        }

        log.info("Preparing order {} for delivery", orderNumber);
        Workflow.sleep(Duration.ofMillis(500));

        OrderBill orderBill = OrderBillFactory.getOrderBill(orderRequest, totalOrderAmount);
        String orderConfirmation = orderActivities.sendBill(orderBill);
        log.info("Received order confirmation {}", orderConfirmation);

        return OrderResponseFactory.getOrderResponse(orderNumber, totalOrderAmount);
    }
}
