package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionOne {
	private Connection conn;
	private String host = "localhost";
	private String port = "3306";
	private String database = "banco_teste_automacao";
	private String user = "root";
	private String passoword = "admin";
	private String url = "jdbc:mysql://" + host + ":" + port + "/";

	public Connection openConnection() {
		try {
			if (conn == null) {
				conn = DriverManager.getConnection(url + database, user, passoword);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
