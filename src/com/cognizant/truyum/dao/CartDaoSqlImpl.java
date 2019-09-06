package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImpl implements CartDao {

	public CartDaoSqlImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addCartItem(long userId, long menuItemId) {
		try (Connection connTruYum = ConnectionHandler.getConncetion();
			PreparedStatement pstTruYum = connTruYum
					.prepareStatement(IcartQueries.INSERT_QUERY); ) {
			pstTruYum.setLong(1, userId);
			pstTruYum.setLong(2, menuItemId);
			pstTruYum.executeUpdate();
		} catch (SQLException excEmployee) {
			System.out.println(excEmployee.getMessage());
		}

	}

	@Override
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException {
		List<MenuItem> menuItemList = null;
		MenuItem menuItem = null;
		try (Connection connTruYum = ConnectionHandler.getConncetion();
				PreparedStatement pstTruYum = connTruYum
						.prepareStatement(IcartQueries.GET_ALL_CART_QUERY); ) {
			menuItemList = new ArrayList<>();
				pstTruYum.setLong(1, userId);
				ResultSet rsMenuItem = pstTruYum.executeQuery();
				while (rsMenuItem.next()) {
					menuItem = new MenuItem();
					menuItem.setId(rsMenuItem.getLong("me_id"));
					menuItem.setName(rsMenuItem.getString("me_name"));
					menuItem.setPrice(rsMenuItem.getFloat("me_price"));
					
					boolean freeDelivery = rsMenuItem.getString("me_free_delivery")
							.equalsIgnoreCase("yes") ? true : false;

					menuItem.setFreeDelivery(freeDelivery);
					menuItemList.add(menuItem);
				}
				if(menuItemList.size() == 0) {
					throw new CartEmptyException("Nothing in cart");
				}
			} catch (SQLException excEmployee) {
				System.out.println(excEmployee.getMessage());
			}
		return menuItemList;
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) {
		try (Connection connTruYum = ConnectionHandler.getConncetion();
				PreparedStatement pstTruYum = connTruYum
						.prepareStatement(IcartQueries.REMOVE_CART_ITEM_QUERY); ) {
				pstTruYum.setLong(1, userId);
				pstTruYum.setLong(2, menuItemId);
				pstTruYum.executeUpdate();
			} catch (SQLException excEmployee) {
				System.out.println(excEmployee.getMessage());
			}

	}

}
