package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseOperation implements Operation {
	private DatabaseConnect databaseConnect;
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	public DatabaseOperation() {
		initDatabase();
	}
	private void initDatabase(){
		databaseConnect = new DatabaseConnect("localhost:3306", "oa", "root", "root");
		connection = databaseConnect.getConnection();
	}
	public void closeDatabase(){
		try {
			resultSet.close();
			preparedStatement.close();
			databaseConnect.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insert(String sql) {
		int rows=0;
		try {
			preparedStatement = connection.prepareStatement(sql);
			rows = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows;
	}

	@Override
	public int insert(String tableName, String... attributes) {
		int rows=0;
		StringBuilder string = new StringBuilder();
		for(String s : attributes){
			string.append("'");
			string.append(s);
			string.append("'");
			string.append(",");
		}
		string.deleteCharAt(string.length()-1);
		try {
			String sqlString = "insert into " + tableName + " values(" + string.toString() + ")";
			System.out.println(sqlString);
			preparedStatement = connection.prepareStatement(sqlString);
			rows = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows;
	}

	@Override
	public int delete(String sql) {
		int rows=0;
		try {
			preparedStatement = connection.prepareStatement(sql);
			rows = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows;
	}

	@Override
	public int delete(String tableName, String requirement, String value) {
		int rows=0;
		String sql = "delete from " + tableName + " where " + requirement + " = ?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, value);
			rows = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows;
	}

	@Override
	public int update(String sql) {
		int rows=0;
		try {
			preparedStatement = connection.prepareStatement(sql);
			rows = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows;
	}

	@Override
	public int update(String tableName, String setColName, String setValue,
			String reqColName, String reqValue) {
		int rows=0;
		String sql = "update " + tableName + " set " + setColName + " = ? where " + reqColName +" = ?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, setValue);
			preparedStatement.setString(2, reqValue);
			rows = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows;
	}

	@Override
	public ResultSet select(String sql) {
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultSet;
	}

	@Override
	public ResultSet select(String tableName, String requirement, String value) {
		try {
			preparedStatement = connection.prepareStatement("select * from " + tableName + " where " + requirement +"=?");
			preparedStatement.setString(1, value);
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultSet;
	}

	@Override
	public ResultSet selectAll(String tableName) {
		try {
			preparedStatement = connection.prepareStatement("select * from " + tableName);
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return resultSet;
	}

}
