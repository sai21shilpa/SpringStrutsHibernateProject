package edu.iit.fenghuang.ssh.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnector {
	private JdbcConnector() {
	}

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/ssh_project";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "123456";
	static Connection conn = null;

	public static Connection getConn() {
		System.out.println("getting connection");
		// STEP 3: Open a connection
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

}
