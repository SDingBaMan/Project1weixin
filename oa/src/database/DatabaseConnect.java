package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnect {
	private Connection connection;
	
	public DatabaseConnect(String url, String databaseName ,String username, String password){
		initDatabase(url, databaseName, username, password);
	}
	
	/**
	 * 初始化数据库
	 * 根据url和databaseName找到数据库，根据username和password连接数据库。
	 * @param url
	 * @param databaseName
	 * @param username
	 * @param password
	 */
	private void initDatabase(String url, String databaseName ,String username, String password){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection("jdbc:mysql://" + url + "/" + databaseName + "?useUnicode=true&characterEncoding=UTF-8", username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void closeConnection(){
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return connection;
	}

}
