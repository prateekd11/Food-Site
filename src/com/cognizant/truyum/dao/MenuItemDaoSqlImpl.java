package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoSqlImpl implements MenuItemDao {

	public MenuItemDaoSqlImpl() {

	}

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		List<MenuItem> menuItemList = null;
		MenuItem menuItem = null;
		try (Connection connTruYum = ConnectionHandler.getConncetion();
				PreparedStatement pstTruYum = connTruYum
						.prepareStatement(IMenuItemQueries.MENUITEM_SELECT_ADMIN);
				ResultSet rsMenuItem = pstTruYum.executeQuery();) {

			menuItemList = new ArrayList<>();

			while (rsMenuItem.next()) {
				menuItem = new MenuItem();
				menuItem.setId(rsMenuItem.getLong("me_id"));
				menuItem.setName(rsMenuItem.getString("me_name"));
				menuItem.setPrice(rsMenuItem.getFloat("me_price"));
				boolean isActive = (rsMenuItem.getString("me_active").equalsIgnoreCase("yes"))
						? true : false;

				menuItem.setActive(isActive);
				menuItem.setCategory(rsMenuItem.getString("me_category"));

				// String dateOfLaunch =
				// rsMenuItem.getString("me_date_of_launch");

				menuItem.setDateOfLaunch(rsMenuItem.getDate("me_date_of_launch"));

				boolean freeDelivery = rsMenuItem.getString("me_free_delivery")
						.equalsIgnoreCase("yes") ? true : false;

				menuItem.setFreeDelivery(freeDelivery);
				menuItemList.add(menuItem);
			}
		} catch ( SQLException excEmployee) {
			System.out.println(excEmployee.getMessage());
		}
		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		List<MenuItem> menuItemList = null;
		MenuItem menuItem = null;
		try (Connection connTruYum = ConnectionHandler.getConncetion();
				PreparedStatement pstTruYum = connTruYum
						.prepareStatement(IMenuItemQueries.MENUITEM_SELECT_CUSTOMER);
				ResultSet rsMenuItem = pstTruYum.executeQuery();) {

			menuItemList = new ArrayList<>();

			while (rsMenuItem.next()) {
				menuItem = new MenuItem();
				menuItem.setId(rsMenuItem.getLong("me_id"));
				menuItem.setName(rsMenuItem.getString("me_name"));
				menuItem.setPrice(rsMenuItem.getFloat("me_price"));
				
				boolean isActive = (rsMenuItem.getString("me_active").equalsIgnoreCase("yes"))
						? true : false;

				menuItem.setActive(isActive);
				menuItem.setCategory(rsMenuItem.getString("me_category"));

				// String dateOfLaunch =
				// rsMenuItem.getString("me_date_of_launch");

				menuItem.setDateOfLaunch(rsMenuItem.getDate("me_date_of_launch"));

				boolean freeDelivery = rsMenuItem.getString("me_free_delivery")
						.equalsIgnoreCase("yes") ? true : false;

				menuItem.setFreeDelivery(freeDelivery);
				menuItemList.add(menuItem);
			}

		} catch ( SQLException excEmployee) {
			System.out.println(excEmployee.getMessage());
		}
		return menuItemList;
	}

	@Override
	public void modifyMenuItemList(MenuItem menuItem) {
		try (Connection connTruYum = ConnectionHandler.getConncetion();
				PreparedStatement pstTruYum = connTruYum
						.prepareStatement(IMenuItemQueries.UPDATE_MENUITEM);) {

			pstTruYum.setString(1, menuItem.getName());
			pstTruYum.setFloat(3, menuItem.getPrice());
			pstTruYum.setString(2, menuItem.getCategory());

			String isActive = menuItem.isActive() ? "Yes" : "No";

			pstTruYum.setString(4, isActive);

			java.sql.Date dateOfLaunch = new java.sql.Date(menuItem.getDateOfLaunch().getTime());

			pstTruYum.setDate(5, dateOfLaunch);

			String isFreeDelivery = menuItem.isFreeDelivery() ? "Yes" : "No";

			pstTruYum.setString(6, isFreeDelivery);
			pstTruYum.setLong(7, menuItem.getId());
			pstTruYum.executeUpdate();

		} catch ( SQLException excEmployee) {
			System.out.println(excEmployee.getMessage());
		}
		// return menuItemList;

	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {

		MenuItem menuItem = null;
		try (Connection connTruYum = ConnectionHandler.getConncetion();
				PreparedStatement pstTruYum = connTruYum
						.prepareStatement(IMenuItemQueries.MENUITEM_SELECT);) {

			pstTruYum.setLong(1, menuItemId);
			ResultSet rsMenuItem = pstTruYum.executeQuery();
			while (rsMenuItem.next()) {
				menuItem = new MenuItem();
				menuItem.setId(rsMenuItem.getLong("me_id"));
				menuItem.setName(rsMenuItem.getString("me_name"));
				menuItem.setPrice(rsMenuItem.getFloat("me_price"));
				boolean isActive = (rsMenuItem.getString("me_active").equalsIgnoreCase("yes"))
						? true : false;

				menuItem.setActive(isActive);
				menuItem.setCategory(rsMenuItem.getString("me_category"));

				// String dateOfLaunch =
				// rsMenuItem.getString("me_date_of_launch");

				menuItem.setDateOfLaunch(rsMenuItem.getDate("me_date_of_launch"));

				boolean freeDelivery = rsMenuItem.getString("me_free_delivery")
						.equalsIgnoreCase("yes") ? true : false;

				menuItem.setFreeDelivery(freeDelivery);
			}

		} catch ( SQLException excEmployee) {
			System.out.println(excEmployee.getMessage());
		}
		return menuItem;
	}

}
