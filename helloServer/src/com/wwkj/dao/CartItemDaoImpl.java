package com.wwkj.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.wwkj.utils.DataSourceManager;

 
/**
 * 查看购物项
 * @author Administrator
 *
 */
public class CartItemDaoImpl {
	
	private QueryRunner runner = new QueryRunner(
			DataSourceManager.getDataSource());

	public List<Map<String, Object>> getCartItemList() {
		String sql = "select * from cartitem";

		try {
			return runner.query(sql, new MapListHandler());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
