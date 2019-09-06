package com.cognizant.truyum.dao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

import jdk.nashorn.internal.ir.annotations.Ignore;

public class MenuItemDaoSqlImplTest {

	private MenuItemDao menuItemDao;

	@Before
	public void setUp() throws Exception {
		menuItemDao = new MenuItemDaoSqlImpl();
	}

	@After
	public void tearDown() throws Exception {
		menuItemDao = null;
	}

	@Test
	public final void testGetMenuItemListAdmin() {
		List<MenuItem> arrayList = null;
		arrayList = menuItemDao.getMenuItemListAdmin();
		if (arrayList.size() > 0) {
			System.out.println("Test Passed Successfully. List size: " + arrayList.size());
		}
	}

	@Test
	public final void testGetMenuItemListCustomer() {
		List<MenuItem> arrayList = null;
		arrayList = menuItemDao.getMenuItemListCustomer();
		if (arrayList.size() > 0) {
			System.out.println("Test Passed Successfully. List size: " + arrayList.size());
		}
	}

	@Test
	public final void testModifyMenuItemList() {
		/*MenuItem menuItem = null;
		Date date = null;
		date = DateUtil.convertToDate("03/15/2017");
		menuItem = new MenuItem(1, "Sandwich", 199.00f, false, date, "Main Course", true);
		menuItemDao.modifyMenuItemList(menuItem);*/
		long menuItemId = 1;
		MenuItem menuItem = menuItemDao.getMenuItem(menuItemId);
		menuItem.setName("xyz");
		
		menuItemDao.modifyMenuItemList(menuItem);
		menuItem = menuItemDao.getMenuItem(menuItemId);
		assert(menuItem.getName().equals("xyz"));
		
	}

	@Test
	public final void testGetMenuItem() {
		MenuItem menuItem = menuItemDao.getMenuItem(3);
		System.out.println(menuItem);
	}

}
