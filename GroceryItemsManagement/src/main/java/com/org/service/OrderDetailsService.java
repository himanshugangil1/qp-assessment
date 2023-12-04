package com.org.service;



import com.org.entity.GroceryItem;
import com.org.entity.OrderDetails;
import com.org.exceptions.InsufficientInventoryException;
import com.org.exceptions.ItemNotFoundException;
import com.org.repository.OrderDetailsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderDetailsService implements IOrderDetailsService {

    @Autowired
    private GroceryItemService groceryItemService;  // Assuming you have a GroceryItemService

    @Autowired
    private OrderDetailsService orderDetailsService;  // Assuming you have an OrderDetailsService
    
    @Autowired
    OrderDetailsRepository orderDetailsRepository;

    @Override
    public List<GroceryItem> getAllGroceryItems() {
        return groceryItemService.getAllGroceryItems();
    }
//    @Override
//    public OrderDetails createOrder(List<Long> itemIds) {
//        List<GroceryItem> items = groceryItemService.getAllGroceryItems();
//        List<Long> selectedItems = items.stream()
//                .filter(item -> itemIds.contains(item.getId()))
//                .map(GroceryItem::getId)
//                .collect(Collectors.toList());
//
//        return orderDetailsService.createOrder(selectedItems);
//    }
    

    public OrderDetails createOrder(Map<Long, Integer> itemQuantities, String username, LocalDateTime orderDate) {
        List<GroceryItem> items = groceryItemService.getAllGroceryItemsByIds(new ArrayList<>(itemQuantities.keySet()));

        if (items.size() != itemQuantities.size()) {
            throw new ItemNotFoundException("One or more items not found");
        }

        // Check and reduce inventory
        for (GroceryItem item : items) {
            int requestedQuantity = itemQuantities.get(item.getId());
            if (item.getInventory() < requestedQuantity) {
                throw new InsufficientInventoryException("Insufficient inventory for item: " + item.getName());
            }
            item.setInventory(item.getInventory() - requestedQuantity);
        }

        OrderDetails order = new OrderDetails(items, username, orderDate);
        return orderDetailsRepository.save(order);
    }
    @Override
    public OrderDetails getOrderDetails(Long orderId) {
        return orderDetailsService.getOrderDetails(orderId);
    }

    @Override
    public boolean cancelOrder(Long orderId) {
        return orderDetailsService.cancelOrder(orderId);
    }

    @Override
    public List<OrderDetails> getOrdersForUser(Long userId) {
        return orderDetailsService.getOrdersForUser(userId);
    }


	@Override
	public OrderDetails createOrder(List<Long> itemIds, String username, LocalDateTime orderDate) {
		// TODO Auto-generated method stub
		return null;
	}




    // Other methods for order-related operations
}

