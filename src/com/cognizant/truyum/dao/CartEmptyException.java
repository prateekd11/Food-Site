package com.cognizant.truyum.dao;

public class CartEmptyException extends Exception {

	private static final long serialVersionUID = 3872957278470474553L;
	
	public CartEmptyException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public CartEmptyException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 */

	public CartEmptyException() {
		super();
	}

	public CartEmptyException(String message) {
		super(message);
	}

	public CartEmptyException(Throwable message) {
		super(message);
	}
	
	

}
