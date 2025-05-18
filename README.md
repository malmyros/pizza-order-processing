# Pizza Ordering System

An example of a Spring boot service for placing pizza orders with Temporal.
The service demonstrates how to leverage Activities for splitting steps of the
order processing workflow and managing them resiliently.

## Running the demo

We first need to start our temporal server.
To do this run the following command in your
terminal.

```
temporal server start-dev
```

The temporal server will acquire a port that is not in use
and will start up providing the following result.

```
CLI 1.3.0 (Server 1.27.1, UI 2.36.0)

Server:  localhost:7233
UI:      http://localhost:8233
Metrics: http://localhost:55724/metrics
```

## Testing

A postman collection can be found [here](./postman/order-pizza-service.postman_collection.json) to
test the ordering pizzas.