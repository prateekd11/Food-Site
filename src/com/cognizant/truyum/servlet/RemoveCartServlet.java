package com.cognizant.truyum.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.dao.CartDaoCollectionImpl;
import com.cognizant.truyum.dao.CartDaoSqlImpl;
import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;

/**
 * Servlet implementation class RemoveCartServlet
 */
@WebServlet("/RemoveCart")
public class RemoveCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RemoveCartServlet() {
		super();
		// TODO Auto--generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<MenuItem> cartItems = null;
		float total = 0.0f;
		long userId = 1;
		long menuItemId = Long.parseLong(request.getParameter("cartItemId"));
		RequestDispatcher rDispatcher = null;
		CartDao cartDao = new CartDaoSqlImpl();
		cartDao.removeCartItem(userId, menuItemId);
		try {
			cartItems = cartDao.getAllCartItems(userId);
			for (Iterator<MenuItem> iterator = cartItems.iterator(); iterator.hasNext();) {
				MenuItem menuItem = iterator.next();
				total += menuItem.getPrice();
				
			}
			rDispatcher = request.getRequestDispatcher("cart.jsp");
			request.setAttribute("cartStatus", true);
			request.setAttribute("cartItems", cartItems);
			request.setAttribute("total", total);
			rDispatcher.forward(request, response);
			
		} catch (CartEmptyException e) {
			System.out.println(e.getMessage());
			rDispatcher = request.getRequestDispatcher("cart-empty.jsp");
			rDispatcher.forward(request, response);
		}

		
	}

}
