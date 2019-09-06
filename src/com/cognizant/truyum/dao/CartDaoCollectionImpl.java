package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImpl implements CartDao {

	private static HashMap<Long, Cart> userCarts;
	MenuItemDao menuItemDao;

	public CartDaoCollectionImpl() {
		super();
		if (userCarts == null) {
			userCarts = new HashMap<>();
		}

		try {
			menuItemDao = new MenuItemDaoCollectionImpl();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addCartItem(long userId, long menuItemId) {
		Cart cart = null;
		List<MenuItem> cartItems = null;
		MenuItem menuItem = null;
		if (userCarts.containsKey(userId)) {
			cart = userCarts.get(userId);
			cartItems = cart.getMenuItemList();
			menuItem = menuItemDao.getMenuItem(menuItemId);
			cartItems.add(menuItem);
			double total = cart.getTotal();
			total += menuItem.getPrice();

			cart = new Cart(cartItems, total);
			userCarts.put(userId, cart);
		} else {

			cartItems = new ArrayList<>();
			menuItem = menuItemDao.getMenuItem(menuItemId);
			cartItems.add(menuItem);
			cart = new Cart(cartItems, menuItem.getPrice());
			userCarts.put(userId, cart);
		}
	}

	@Override
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException {
		List<MenuItem> menuList = null;
		
		if(userCarts.get(userId) == null) {
			throw new CartEmptyException("No items are added in the cart");
		} else {
			menuList = userCarts.get(userId).getMenuItemList();
		if (menuList == null || menuList.isEmpty()) {
			throw new CartEmptyException("No items are added in the cart");
		}
		}
		return menuList;
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) {
		MenuItem menuItem = menuItemDao.getMenuItem(menuItemId);
		if(userCarts.get(userId) == null) {
			try {
				throw new CartEmptyException("No items are added in the cart");
			} catch (CartEmptyException e) {
				System.out.println(e.getMessage());
				return;
			}
		}
		userCarts.get(userId).getMenuItemList().remove(menuItem);

	}

}
