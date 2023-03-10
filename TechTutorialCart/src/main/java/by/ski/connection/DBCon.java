package by.ski.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCon {

	private Connection connection = null;
	private String url = "jdbc:postgresql://localhost:5432/mytrain";
	private String dbUserName = "postgres";
	private String dbPassword = "pospeh";


	public Connection getConnection() throws ClassNotFoundException,
		SQLException {
		if (connection == null) {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(url, dbUserName,
				dbPassword);
			System.out.println("connected successfully");
		}
		return connection;
	}
}
