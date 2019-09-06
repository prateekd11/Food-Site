package com.cognizant.truyum.dao;

import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImplTest {

	CartDao cartDao;

	@Before
	public void setUp() throws Exception {
		cartDao = new CartDaoCollectionImpl();
	}

	@After
	public void tearDown() throws Exception {
	//	cartDao = null;
	}

	@Test
	public final void testCartDaoCollectionImpl() {

	}

	@Test
	public final void testAddCartItem() {

		cartDao.addCartItem(1, 2);
		cartDao.addCartItem(1, 1);
		cartDao.addCartItem(1, 3);
		cartDao.addCartItem(1, 4);
	}

	@Test
	public final void testGetAllCartItems() {
		try {
			List<MenuItem> list = cartDao.getAllCartItems(1);
			System.out.println(list.size());
			for (Iterator<MenuItem> iterator = list.iterator(); iterator.hasNext();) {
				MenuItem menuItem = (MenuItem) iterator.next();
				System.out.println(menuItem);

			}
		} catch (CartEmptyException e) {
			e.printStackTrace();
		}
	}

	public final void testRemoveCartItem() {
		long userId = 1;
		long menuItemId = 2;
		cartDao.removeCartItem(userId, menuItemId);
	}

}
