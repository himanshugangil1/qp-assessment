package com.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.entity.GroceryItem;
import com.org.service.GroceryItemService;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private GroceryItemService groceryItemService;

    @PostMapping("/add")
    public GroceryItem addGroceryItem(@RequestBody GroceryItem item) {
        return groceryItemService.addGroceryItem(item);
    }

    @GetMapping("/view")
    public List<GroceryItem> viewGroceryItems() {
        return groceryItemService.getAllGroceryItems();
    }

    @DeleteMapping("/remove/{itemId}")
    public ResponseEntity<String> removeGroceryItem(@PathVariable Long itemId) {
        if (groceryItemService.removeGroceryItem(itemId)) {
            return ResponseEntity.ok("Grocery item removed successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Grocery item not found");
        }
    }

    @PutMapping("/update/{itemId}")
    public ResponseEntity<GroceryItem> updateGroceryItem(
            @PathVariable Long itemId,
            @RequestBody GroceryItem updatedItem
    ) {
        GroceryItem updated = groceryItemService.updateGroceryItem(itemId, updatedItem);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/manageInventory/{itemId}/{quantity}")
    public ResponseEntity<GroceryItem> manageInventory(
            @PathVariable Long itemId,
            @PathVariable int quantity
    ) {
        GroceryItem updated = groceryItemService.manageInventory(itemId, quantity);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}

