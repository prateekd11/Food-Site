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
 * Servlet implementation class ShowCartServlet
 */
@WebServlet("/ShowCart")
public class ShowCartServlet extends HttpServlet {
	
	RequestDispatcher rDispatcher;
	private void cartEmpty(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		rDispatcher = request.getRequestDispatcher("cart-empty.jsp");
		rDispatcher.forward(request, response);
	}
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCartServlet() {
        super();
        rDispatcher = null;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		long userId = 1;
		List<MenuItem> cartItems = null;
		double total = 0.0;
		CartDao cartDao = new CartDaoSqlImpl();
		try {
			 cartItems = cartDao.getAllCartItems(userId);
			 if(cartItems.size() == 0) {
					cartEmpty(request, response);
				}
			 rDispatcher = request.getRequestDispatcher("cart.jsp");
				for (Iterator<MenuItem> iterator = cartItems.iterator(); iterator.hasNext();) {
					MenuItem menuItem = (MenuItem) iterator.next();
					total += menuItem.getPrice();
				}
				request.setAttribute("cartItems", cartItems);
				request.setAttribute("total",total);
				rDispatcher.forward(request,response);
			 
		} catch (CartEmptyException e ) {
			System.out.println(e.getMessage());
			cartEmpty(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
