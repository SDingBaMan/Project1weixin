package com.wwkj.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;

 
import com.mysql.jdbc.ResultSet;
import com.wwkj.utils.DataSourceManager;

/**
 * 用户注册的数据库操作实现类
 * @author 吉友良
 *
 */
public class RegisterDaoImpl {
	private QueryRunner runner = new QueryRunner(DataSourceManager.getDataSource());
	
	/**
	 * 用户注册
	 * @param username ：用户名
	 * @param password ： 密码
	 */
	public Map register(String username, String password) {
		try {
			int id = runner.update("insert into userinfo (username, password) values(?,?)",username, password);
			String sql = "select userid from userinfo where username = ?";
			Map<String, Object> result = runner.query(sql , new MapHandler(), username);
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
