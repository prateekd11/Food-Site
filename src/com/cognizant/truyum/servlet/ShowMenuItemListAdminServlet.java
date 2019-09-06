package com.cognizant.truyum.servlet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.dao.MenuItemDaoCollectionImpl;
import com.cognizant.truyum.dao.MenuItemDaoSqlImpl;
import com.cognizant.truyum.model.MenuItem;

/**
 * Servlet implementation class ShowMenuItemListAdminServlet
 */
@WebServlet("/ShowMenuListAdmin")
public class ShowMenuItemListAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowMenuItemListAdminServlet() {
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
		MenuItemDao menuItemDao = null;
		List<MenuItem> menuItems = null;
		RequestDispatcher rdMenu = request.getRequestDispatcher("menu-item-list-admin.jsp");
		try {
			menuItemDao = new MenuItemDaoSqlImpl();
			menuItems = menuItemDao.getMenuItemListAdmin();
			request.setAttribute("menuItems", menuItems);
			for (MenuItem menuItem : menuItems) {
				System.out.println(menuItem );
			}
			rdMenu.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
