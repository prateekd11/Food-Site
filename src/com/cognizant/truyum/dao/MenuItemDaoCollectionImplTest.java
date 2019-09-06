package com.cognizant.truyum.dao;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoCollectionImplTest {

	private MenuItemDao menuItemDao;

	@Before
	public void setUp() throws Exception {
		menuItemDao = new MenuItemDaoCollectionImpl();
	}

	@After
	public void tearDown() throws Exception {
		menuItemDao = null;
	}

	@Test
	public final void testGetMenuItemListAdmin() {
		List<MenuItem> menuItemList;
		menuItemList = menuItemDao.getMenuItemListAdmin();
		for (MenuItem menuItem : menuItemList) {
			System.out.println(menuItem);
		}
	}

	@Test
	public final void testGetMenuItemListCustomer() {
		List<MenuItem> menuItemList;
		menuItemList = menuItemDao.getMenuItemListCustomer();
		for (MenuItem menuItem : menuItemList) {
			System.out.println(menuItem);
		}
	}

	@Test
	public final void testModifyMenuItemList() {
		MenuItem menuItem1 = new MenuItem(2, "Burger with cheese", 129.00f, true, null,
				"Main Course", false);

		menuItemDao.modifyMenuItemList(menuItem1);

		List<MenuItem> menuItemList;
		menuItemList = menuItemDao.getMenuItemListAdmin();
		for (MenuItem menuItem : menuItemList) {
			System.out.println(menuItem);
		}

	}

	@Test
	public final void testGetMenuItem() {
		final long id = 2;
		MenuItem menuItem = menuItemDao.getMenuItem(id);
		System.out.println(menuItem);
	}

}
