package com.hotwax.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotwax.dto.OrderItemRequest;
import com.hotwax.dto.OrderRequest;
import com.hotwax.model.ContactMech;
import com.hotwax.model.Customer;
import com.hotwax.model.OrderHeader;
import com.hotwax.model.OrderItem;
import com.hotwax.model.Product;
import com.hotwax.repository.ContactMechRepository;
import com.hotwax.repository.CustomerRepository;
import com.hotwax.repository.OrderHeaderRepository;
import com.hotwax.repository.OrderItemRepository;
import com.hotwax.repository.ProductRepository;

@Service
public class OrderService {

    @Autowired
    private OrderHeaderRepository orderHeaderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ContactMechRepository contactMechRepository;

    @Autowired
    private ProductRepository productRepository;

    // Create a new order
    public OrderHeader createOrder(OrderRequest request) {
        // Fetch customer and contact mechanisms
        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        ContactMech shippingContact = contactMechRepository.findById(request.getShippingContactId())
                .orElseThrow(() -> new RuntimeException("Shipping contact mechanism not found"));
        ContactMech billingContact = contactMechRepository.findById(request.getBillingContactId())
                .orElseThrow(() -> new RuntimeException("Billing contact mechanism not found"));

        // Create OrderHeader
        OrderHeader orderHeader = new OrderHeader();
        orderHeader.setOrderDate(request.getOrderDate());
        orderHeader.setCustomer(customer);
        orderHeader.setShippingContact(shippingContact);
        orderHeader.setBillingContact(billingContact);

        OrderHeader savedOrder = orderHeaderRepository.save(orderHeader);

        // Add Order Items
        for (OrderItemRequest itemRequest : request.getOrderItems()) {
            Product product = productRepository.findById(itemRequest.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderHeader(savedOrder);
            orderItem.setProduct(product);
            orderItem.setQuantity(itemRequest.getQuantity());
            orderItem.setStatus(itemRequest.getStatus());
            orderItemRepository.save(orderItem);
        }
        return savedOrder;
    }

    // Retrieve order by ID
    public OrderHeader getOrderById(int orderId) {
        return orderHeaderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    // Update an order's shipping or billing details
    public OrderHeader updateOrder(int orderId, int shippingContactId, int billingContactId) {
        OrderHeader order = getOrderById(orderId);

        ContactMech shippingContact = contactMechRepository.findById(shippingContactId)
                .orElseThrow(() -> new RuntimeException("Shipping contact mechanism not found"));
        ContactMech billingContact = contactMechRepository.findById(billingContactId)
                .orElseThrow(() -> new RuntimeException("Billing contact mechanism not found"));

        order.setShippingContact(shippingContact);
        order.setBillingContact(billingContact);

        return orderHeaderRepository.save(order);
    }

    // Delete an order
    public void deleteOrder(int orderId) {
        OrderHeader order = getOrderById(orderId);
        orderHeaderRepository.delete(order);
    }

    // Add an item to an order
    public OrderItem addOrderItem(int orderId, OrderItemRequest itemRequest) {
        OrderHeader order = getOrderById(orderId);
        Product product = productRepository.findById(itemRequest.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        OrderItem orderItem = new OrderItem();
        orderItem.setOrderHeader(order);
        orderItem.setProduct(product);
        orderItem.setQuantity(itemRequest.getQuantity());
        orderItem.setStatus(itemRequest.getStatus());

        return orderItemRepository.save(orderItem);
    }

    // Update an order item
    public OrderItem updateOrderItem(int orderItemSeqId, int quantity, String status) {
        OrderItem orderItem = orderItemRepository.findById(orderItemSeqId)
                .orElseThrow(() -> new RuntimeException("Order item not found"));
        orderItem.setQuantity(quantity);
        orderItem.setStatus(status);

        return orderItemRepository.save(orderItem);
    }

    // Delete an order item
    public void deleteOrderItem(int orderItemSeqId) {
        OrderItem orderItem = orderItemRepository.findById(orderItemSeqId)
                .orElseThrow(() -> new RuntimeException("Order item not found"));
        orderItemRepository.delete(orderItem);
    }
}
