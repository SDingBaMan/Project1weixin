package com.wwkj.dao;

import java.sql.SQLException;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;

import com.wwkj.utils.DataSourceManager;

 

/**
 * 用户登录的数据库操作实现类
 * @author 吉友良
 *
 */
public class LoginDaoImpl {
	private QueryRunner runner = new QueryRunner(DataSourceManager.getDataSource());
	
	/**
	 * 用户登录
	 * @param username ：用户名
	 * @param password ： 密码
	 * @return 不为空 : 返回用户的userid，登录成功, 
	 * null : 登录失败
	 */
	public Map<String, Object> login(String username, String password) {
		try {
//			"response": " login",
//			  "userinfo":{
//			    "userId": 30505 
//			}

			String sql = "select userid from userinfo where username = ? and password = ?";
			Map<String, Object> result = runner.query(sql , new MapHandler(), username, password);

			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
