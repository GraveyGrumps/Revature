package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	private static ConnectionUtil conUtil = new ConnectionUtil();

	private ConnectionUtil() {
		super();
	}
	public static ConnectionUtil getConnectionUtil()
	{
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conUtil;
	}
	public Connection getConnection() throws SQLException, FileNotFoundException, IOException {
		Properties prop = new Properties();
		prop.load(new FileReader("C:\\Users\\TheOwner\\eclipse-workspace\\FrontController\\src\\main\\resources\\DB.properties"));

		return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"),
				prop.getProperty("password"));
	}
}
