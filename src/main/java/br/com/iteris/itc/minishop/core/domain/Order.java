package br.com.iteris.itc.minishop.core.domain;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

public class Order {
    private UUID id;
    private double amount;
    private ZonedDateTime createdAt;
    private Customer customer;
    private List<OrderItem> orderItems;

    public Order() {
    }

    public Order(double amount, ZonedDateTime createdAt, Customer customer, List<OrderItem> orderItems) {
        this.amount = amount;
        this.createdAt = createdAt;
        this.customer = customer;
        this.orderItems = orderItems;
    }

    public Order(UUID id, double amount, ZonedDateTime createdAt, Customer customer, List<OrderItem> orderItems) {
        this.id = id;
        this.amount = amount;
        this.createdAt = createdAt;
        this.customer = customer;
        this.orderItems = orderItems;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", amount=" + amount +
                ", createdAt=" + createdAt +
                ", customer=" + customer +
                ", orderItems=" + orderItems +
                '}';
    }
}
