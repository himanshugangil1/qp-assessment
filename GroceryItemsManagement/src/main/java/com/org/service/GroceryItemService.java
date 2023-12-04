package com.org.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.entity.GroceryItem;
import com.org.repository.GroceryItemRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GroceryItemService implements IGroceryItemService {

    @Autowired
    private GroceryItemRepository groceryItemRepository;
    public List<GroceryItem> getAllGroceryItemsByIds(List<Long> itemIds) {
        return groceryItemRepository.findAllById(itemIds);
    }

    
    public List<GroceryItem> getAllGroceryItems() {
        return groceryItemRepository.findAll();
    }

    public GroceryItem addGroceryItem(GroceryItem item) {
        return groceryItemRepository.save(item);
    }

    public GroceryItem updateGroceryItem(Long itemId, GroceryItem updatedItem) {
        Optional<GroceryItem> existingItemOptional = groceryItemRepository.findById(itemId);

        if (existingItemOptional.isPresent()) {
            GroceryItem existingItem = existingItemOptional.get();
            existingItem.setName(updatedItem.getName());
            existingItem.setPrice(updatedItem.getPrice());
            existingItem.setInventory(updatedItem.getInventory());
            return groceryItemRepository.save(existingItem);
        } else {
            // Handle not found case, throw exception or return null depending on your requirements
            return null;
        }
    }

    public boolean removeGroceryItem(Long itemId) {
        Optional<GroceryItem> itemOptional = groceryItemRepository.findById(itemId);

        if (itemOptional.isPresent()) {
            groceryItemRepository.delete(itemOptional.get());
            return true;
        } else {
            return false; // Item not found
        }
    }

    public GroceryItem manageInventory(Long itemId, int quantity) {
        Optional<GroceryItem> itemOptional = groceryItemRepository.findById(itemId);

        if (itemOptional.isPresent()) {
            GroceryItem item = itemOptional.get();
            int updatedInventory = item.getInventory() + quantity;
            item.setInventory(updatedInventory);
            return groceryItemRepository.save(item);
        } else {
            // Handle not found case, throw exception or return null depending on your requirements
            return null;
        }
    }

    // Other methods for updating, removing, and managing inventory
}
