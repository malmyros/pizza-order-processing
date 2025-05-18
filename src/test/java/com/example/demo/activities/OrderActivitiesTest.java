package com.example.demo.activities;

import com.example.demo.dto.orders.OrderAddress;
import com.example.demo.dto.orders.OrderBill;
import com.example.demo.dto.orders.OrderItem;
import com.example.demo.fixtures.OrderAddressFixtures;
import com.example.demo.fixtures.OrderBillFixtures;
import com.example.demo.fixtures.OrderItemFixtures;
import io.temporal.testing.TestActivityEnvironment;
import io.temporal.testing.TestEnvironmentOptions;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class OrderActivitiesTest {

    private TestActivityEnvironment testEnv;

    @Before
    public void setup() {
        testEnv = TestActivityEnvironment.newInstance(
                TestEnvironmentOptions.newBuilder()
                        .setUseTimeskipping(false)
                        .build());
    }

    @Test
    public void shouldCalculateTheOrderTotal() {

        List<OrderItem> orderItems = OrderItemFixtures.getOrderItems();
        testEnv.registerActivitiesImplementations(new OrderActivitiesImpl());

        OrderActivities orderActivities = testEnv.newActivityStub(OrderActivities.class);
        BigDecimal orderTotal = orderActivities.calculateOrderTotal(orderItems);
        assertEquals(new BigDecimal("25.00"), orderTotal);
    }

    @Test
    public void shouldEstimateDeliveryDistance() {

        OrderAddress orderAddress = OrderAddressFixtures.getOrderAddress();
        testEnv.registerActivitiesImplementations(new OrderActivitiesImpl());

        OrderActivities orderActivities = testEnv.newActivityStub(OrderActivities.class);
        int distance = orderActivities.estimateDeliveryDistance(orderAddress);
        assertEquals(15, distance);
    }

    @Test
    public void shouldSendTheBill() {

        OrderBill orderBill = OrderBillFixtures.getOrderBill();
        testEnv.registerActivitiesImplementations(new OrderActivitiesImpl());

        OrderActivities orderActivities = testEnv.newActivityStub(OrderActivities.class);
        String confirmation = orderActivities.sendBill(orderBill);
        assertEquals("Send order 1747568868", confirmation);
    }
}