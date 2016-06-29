package com.wwkj.dao;

import java.sql.SQLException;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;

import com.wwkj.utils.DataSourceManager;

 
/**
 * 用户登录的实体类
 * 
 * @author Administrator
 * 
 */
public class UserinfoDaoImpl {
	private QueryRunner runner = new QueryRunner(DataSourceManager
			.getDataSource());

	/**
	 * 用户登录
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public Map<String, Object> UserId(String username, String password) {
		String sql = "select userId from userinfo where username=? and password =?";
		
		Map<String, Object> map = null;
		try {
			System.out.println(sql.toString());
			System.out.println(username+"======"+password);
			map = runner.query(sql, new MapHandler(), username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}
//select userId from userInfo where username='sss' and password ='1231'
	
	/**
	 * 用户中心

	 * @return
	 */
	public Map<String, Object> UserInfo(long id) {
		Map<String, Object> map = null;
		String sql = "select username,bonus,level from userinfo where userid=?";
		try {
			map = runner.query(sql, new MapHandler(),id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 用户注册
	 * 
	 * @param username
	 * @param password
	 */
	public Map<String, Object> register(String username, String password) {
		String sql = "insert into userinfo (username,password,level) values(?,?,1)";
		String sql_userId = "select userId from userinfo where username=?";
		Map<String, Object> userId = null;
		try {
			runner.update(sql, username, password);
			userId = runner.query(sql_userId, new MapHandler(), username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userId;
	}
}
