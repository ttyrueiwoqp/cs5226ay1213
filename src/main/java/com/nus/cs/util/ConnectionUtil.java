package com.nus.cs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

	public static Connection createConnection() throws SQLException,
			InstantiationException, IllegalAccessException,
			ClassNotFoundException {

		String driverClass = "oracle.jdbc.driver.OracleDriver";
		String connectionURL = "jdbc:oracle:thin:@dbtune.comp.nus.edu.sg:40953:a0040953";
		String userID = "system";
		String userPassword = "system";
		Connection conn = null;

		Properties conProps = new Properties();
		conProps.put("user", userID);
		conProps.put("password", userPassword);
		conProps.put("defaultRowPrefetch", "15");

		Class.forName(driverClass).newInstance();
		conn = DriverManager.getConnection(connectionURL, conProps);

		return conn;
	}
}