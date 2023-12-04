package com.org.service;

import java.time.LocalDateTime;
import java.util.List;

import com.org.entity.GroceryItem;
import com.org.entity.OrderDetails;

//OrderService.java


	public interface IOrderDetailsService {

	    /**
	     * Retrieves a list of all available grocery items.
	     *
	     * @return List of grocery items.
	     */
	    List<GroceryItem> getAllGroceryItems();

	    /**
	     * Creates an order with multiple grocery items.
	     *
	     * @param itemIds The IDs of the grocery items to include in the order.
	     * @return The created order.
	     */
//	    OrderDetails createOrder(List<Long> itemIds);
	    
	    public OrderDetails createOrder(List<Long> itemIds, String username, LocalDateTime orderDate);
	    
//	    OrderDetails createOrder(List<GroceryItem> items);

	    /**
	     * Retrieves details of a specific order.
	     *
	     * @param orderId The ID of the order to retrieve.
	     * @return The order details.
	     */
	    OrderDetails getOrderDetails(Long orderId);

	    /**
	     * Cancels an existing order.
	     *
	     * @param orderId The ID of the order to cancel.
	     * @return True if the cancellation was successful, false otherwise.
	     */
	    boolean cancelOrder(Long orderId);

	    /**
	     * Retrieves a list of orders for a specific user.
	     *
	     * @param userId The ID of the user for whom to retrieve orders.
	     * @return List of orders for the specified user.
	     */
	    List<OrderDetails> getOrdersForUser(Long userId);

	    // Other methods for order-related operations
	}


