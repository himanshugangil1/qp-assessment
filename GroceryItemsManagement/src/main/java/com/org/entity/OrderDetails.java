package com.org.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
//OrderDetails.java
@Entity
public class OrderDetails {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @ManyToMany
 private List<GroceryItem> items = new ArrayList<>();

 private String user; // Add user field
 private LocalDateTime orderDate; // Add order date field

 // Constructors, getters, and setters

 public OrderDetails() {
     // Default constructor
 }

 public OrderDetails(List<GroceryItem> items, String user, LocalDateTime orderDate) {
     this.items = items;
     this.user = user;
     this.orderDate = orderDate;
 }

 // Getters and setters for id and items

 public Long getId() {
     return id;
 }

 public void setId(Long id) {
     this.id = id;
 }

 public List<GroceryItem> getItems() {
     return items;
 }

 public void setItems(List<GroceryItem> items) {
     this.items = items;
 }

 // Getters and setters for user and orderDate

 public String getUser() {
     return user;
 }

 public void setUser(String user) {
     this.user = user;
 }

 public LocalDateTime getOrderDate() {
     return orderDate;
 }

 public void setOrderDate(LocalDateTime orderDate) {
     this.orderDate = orderDate;
 }
}
