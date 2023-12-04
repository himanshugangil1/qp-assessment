package com.org.entity;

import java.util.List;
import java.util.Map;
public class OrderRequest {
    private Map<Long, Integer> itemQuantities;
    private String username;

    // Constructors, getters, and setters

    public OrderRequest() {
        // Default constructor
    }

    public OrderRequest(Map<Long, Integer> itemQuantities, String username) {
        this.itemQuantities = itemQuantities;
        this.username = username;
    }

    public Map<Long, Integer> getItemQuantities() {
        return itemQuantities;
    }

    public void setItemQuantities(Map<Long, Integer> itemQuantities) {
        this.itemQuantities = itemQuantities;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
