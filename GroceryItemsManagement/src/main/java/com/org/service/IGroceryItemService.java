	package com.org.service;

import java.util.List;

import com.org.entity.GroceryItem;

// GroceryItemService.java
		public interface IGroceryItemService {
		    List<GroceryItem> getAllGroceryItems();
		    GroceryItem addGroceryItem(GroceryItem item);
		    // Other methods for updating, removing, and managing inventory
		    
		    GroceryItem updateGroceryItem(Long itemId, GroceryItem updatedItem);

		  
		    boolean removeGroceryItem(Long itemId);
		}
