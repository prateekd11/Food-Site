package com.cognizant.truyum.dao;

public interface IMenuItemQueries {

	String MENUITEM_SELECT_ADMIN = "select me_id, me_name,me_price,me_active,me_date_of_launch,"
			+ "me_category,me_free_delivery from menu_item;";
	
	String MENUITEM_SELECT_CUSTOMER = "select me_id, me_name,me_price,me_active,me_date_of_launch,"
			+ "me_category,me_free_delivery from menu_item where me_active = 'Yes' and "
			+ "me_date_of_launch <= curdate();";
	
	String UPDATE_MENUITEM = "UPDATE menu_item SET me_name = ?, me_category = ?, me_price = ?,"
			+ "me_active = ?, me_date_of_launch = ?, me_free_delivery = ? where me_id = ?";

	String MENUITEM_SELECT = "select me_id,me_name,me_price,me_active,me_date_of_launch,me_category"
			+ ",me_free_delivery from menu_item where me_id=?;";

}
