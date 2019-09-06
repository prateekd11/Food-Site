package com.cognizant.truyum.dao;

public interface IcartQueries {
	
	String INSERT_QUERY = "INSERT INTO cart (ct_us_id, ct_pr_id) values(?,?)";
	
	String GET_ALL_CART_QUERY = "select m.me_id,m.me_name,m.me_free_delivery,m.me_price from "
			+ "menu_item m, cart c where c.ct_us_id = ? and m.me_id = c.ct_pr_id;";
	
	String GET_CART_TOTAL_QUERY = "select sum(m.me_price) from "
			+ "menu_item m, cart c where c.ct_us_id = ? and m.me_id = c.ct_pr_id;";
	
	String REMOVE_CART_ITEM_QUERY = "delete from cart where ct_id = (select min(ct_id) from "
			+ "(select * from cart) as c where c.ct_us_id = ? and c.ct_pr_id = ?)";
}
