package com.cognizant.truyum.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

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
import com.cognizant.truyum.util.DateUtil;

/**
 * Servlet implementation class EditMenuItemServlet
 */
@WebServlet("/EditMenuItem")
public class EditMenuItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditMenuItemServlet() {
		super();
		// TODO ;Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MenuItemDao menuItemDao = null;
		MenuItem menuItem = null;
		Date date = null;
		RequestDispatcher rDispatcher = request.getRequestDispatcher("edit-menu-item-status.jsp");
		String name = request.getParameter("firstname");
		float price = Float.parseFloat(request.getParameter("price"));
		String dateString = request.getParameter("date");
		boolean active = Boolean.parseBoolean(request.getParameter("status"));
		String category = request.getParameter("category");
		boolean delivery = Boolean.parseBoolean(request.getParameter("delivery"));
		int id = Integer.parseInt(request.getParameter("menuID"));
		System.out.println(name + " " + id + " " + price + " " + active + " " + dateString + " "
				+ category + " " + delivery);

		try {
			menuItemDao = new MenuItemDaoSqlImpl();
			date = DateUtil.convertToDate(dateString);
			menuItem = new MenuItem(id, name, price, active, date, category, delivery);
			menuItemDao.modifyMenuItemList(menuItem);
			rDispatcher.forward(request, response);
		} catch (Exception e) {
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
