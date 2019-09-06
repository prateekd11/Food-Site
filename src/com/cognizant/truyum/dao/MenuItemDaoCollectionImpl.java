package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImpl implements MenuItemDao {

	private static List<MenuItem> menuItemList;

	public MenuItemDaoCollectionImpl() throws ParseException {
		if (menuItemList == null) {
			menuItemList = new ArrayList<>();
			MenuItem menuItem;
			Date date = null;

			date = DateUtil.convertToDate("03/15/2017");
			menuItem = new MenuItem(1, "Sandwich", 99.00f, true, date, "Main Course", true);
			menuItemList.add(menuItem);

			date = DateUtil.convertToDate("12/23/2017");
			menuItem = new MenuItem(2, "Burger", 129.00f, true, date, "Main Course", false);
			menuItemList.add(menuItem);

			date = DateUtil.convertToDate("08/21/2018");
			menuItem = new MenuItem(3, "Pizza", 149.00f, true, date, "Main Course", false);
			menuItemList.add(menuItem);

			date = DateUtil.convertToDate("07/02/2017");
			menuItem = new MenuItem(4, "French Fries", 57.00f, false, date, "Staters", true);
			menuItemList.add(menuItem);

			date = DateUtil.convertToDate("11/02/2022");
			menuItem = new MenuItem(5, "Chocolate Brownie", 32.00f, true, date, "Dessert", true);
			menuItemList.add(menuItem);
		}

	}

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		List<MenuItem> customerMenuList = new ArrayList<>();

		for (MenuItem menuItem : menuItemList) {
			if (menuItem.getDateOfLaunch().compareTo(new Date()) <= 0) {
				if (menuItem.isActive() == true) {
					customerMenuList.add(menuItem);
				}
			}
		}
		return customerMenuList;
	}

	@Override
	public void modifyMenuItemList(MenuItem menuItem) {
		menuItemList.set((int) (menuItem.getId() - 1), menuItem);
		System.out.println(menuItem);

	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		MenuItem returnValue = null;
		for (MenuItem menuItem1 : menuItemList) {
			if (menuItem1.getId() == (int) menuItemId) {
				returnValue = menuItem1;
			}
		}
		return returnValue;
	}

}
