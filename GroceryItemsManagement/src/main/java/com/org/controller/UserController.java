package com.org.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.entity.GroceryItem;
import com.org.entity.OrderDetails;
import com.org.entity.OrderRequest;
import com.org.service.GroceryItemService;
import com.org.service.OrderDetailsService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private GroceryItemService groceryItemService;

    
    @Autowired
    private OrderDetailsService orderDetailsService;
    
    
    @GetMapping("/viewItems")
    public List<GroceryItem> viewAvailableItems() {
        return groceryItemService.getAllGroceryItems();
    }

    @PostMapping("/createOrder")
    public ResponseEntity<OrderDetails> createOrder(@RequestBody OrderRequest orderRequest) {
        Map<Long, Integer> itemQuantities = orderRequest.getItemQuantities();
        String username = orderRequest.getUsername();
        LocalDateTime orderDate = LocalDateTime.now();

        OrderDetails order = orderDetailsService.createOrder(itemQuantities, username, orderDate);

        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}

