package com.cognizant.truyum.dao;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
 
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImplTest {

	CartDao cartDao;
	@Before
	public void setUp() throws Exception {
		cartDao = new CartDaoSqlImpl();
	}

	@After
	public void tearDown() throws Exception {
		cartDao = null;
	}


	@Test
	public final void testAddCartItem() {
		long userId = 1;
		List<MenuItem> menuItems = null; 
		int sizeBefore = 0;
		int sizeAfter = 0;
		try {
			menuItems = cartDao.getAllCartItems(userId);
			sizeBefore = menuItems.size();
			
			cartDao.addCartItem(userId, 4);
			
			menuItems = cartDao.getAllCartItems(userId);
			sizeAfter = menuItems.size();
			
			assert(sizeAfter == sizeBefore + 1);
		}catch(CartEmptyException ce){
			ce.printStackTrace();
		}
	}

	@Test
	public final void testGetAllCartItems() {
		long userId = 1;
		List<MenuItem> menuItems = null;
		try {
			menuItems = cartDao.getAllCartItems(userId);
			assert(menuItems.size() > 0);
		}catch(CartEmptyException ce) {
			ce.printStackTrace();
		}
	}

	@Test
	public final void testRemoveCartItem() {
		long userId = 1;
		List<MenuItem> menuItems = null; 
		int sizeBefore = 0;
		int sizeAfter = 0;
		try {
			menuItems = cartDao.getAllCartItems(userId);
			sizeBefore = menuItems.size();
			
			cartDao.removeCartItem(userId, 4);;
			
			menuItems = cartDao.getAllCartItems(userId);
			sizeAfter = menuItems.size();
			
			assert(sizeAfter == sizeBefore - 1);
		}catch(CartEmptyException ce){
			ce.printStackTrace();
		}
	}

}
