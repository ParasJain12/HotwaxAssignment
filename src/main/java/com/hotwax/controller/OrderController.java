package com.hotwax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotwax.dto.OrderItemRequest;
import com.hotwax.dto.OrderRequest;
import com.hotwax.model.OrderHeader;
import com.hotwax.model.OrderItem;
import com.hotwax.services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // Create an Order
    @PostMapping
    public OrderHeader createOrder(@RequestBody OrderRequest request) {
        return orderService.createOrder(request);
    }

    // Retrieve Order Details
    @GetMapping("/{orderId}")
    public OrderHeader getOrderById(@PathVariable int orderId) {
        return orderService.getOrderById(orderId);
    }

    // Update an Order
    @PutMapping("/{orderId}")
    public OrderHeader updateOrder(@PathVariable int orderId,
                                   @RequestParam int shippingContactId,
                                   @RequestParam int billingContactId) {
        return orderService.updateOrder(orderId, shippingContactId, billingContactId);
    }

    // Delete an Order
    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable int orderId) {
        orderService.deleteOrder(orderId);
    }

    // Add an Order Item
    @PostMapping("/{orderId}/items")
    public OrderItem addOrderItem(@PathVariable int orderId, @RequestBody OrderItemRequest itemRequest) {
        return orderService.addOrderItem(orderId, itemRequest);
    }

    // Update an Order Item
    @PutMapping("/{orderId}/items/{orderItemSeqId}")
    public OrderItem updateOrderItem(@PathVariable int orderId,
                                     @PathVariable int orderItemSeqId,
                                     @RequestParam int quantity,
                                     @RequestParam String status) {
        return orderService.updateOrderItem(orderItemSeqId, quantity, status);
    }

    // Delete an Order Item
    @DeleteMapping("/{orderId}/items/{orderItemSeqId}")
    public void deleteOrderItem(@PathVariable int orderId, @PathVariable int orderItemSeqId) {
        orderService.deleteOrderItem(orderItemSeqId);
    }
}