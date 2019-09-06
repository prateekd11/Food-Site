package com.cognizant.truyum.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionHandler {

	public ConnectionHandler() {

	}

	public static Connection getConncetion() {
		Connection connTruYum = null;
		try (InputStream is = ConnectionHandler.class
				.getResourceAsStream("/connection.properties");) {
			Properties propConnection = new Properties();
			propConnection.load(is);

			String driver = propConnection.getProperty("driver");
			String url = propConnection.getProperty("url");
			String username = propConnection.getProperty("user");
			String password = propConnection.getProperty("password");

			Class.forName(driver);
			connTruYum = DriverManager.getConnection(url, username, password);
		} catch (IOException | ClassNotFoundException | SQLException exception) {
			System.out.println(exception.getMessage());
		}

		return connTruYum;
	}

}
