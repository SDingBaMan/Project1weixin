package com.wwkj.dao;

import java.sql.SQLException;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;

import com.wwkj.utils.DataSourceManager;

 

public class GetFavoritesNumDaoImpl {

	private QueryRunner runner = new QueryRunner(DataSourceManager.getDataSource());
	/**
	 * 获取收藏夹中收藏的商品
	 */
	public long getFavoritesNum() {
		String sql = "select count(*) from favorites";
		try {
			Map<String, Object> map = runner.query(sql, new MapHandler());
			Long value = (Long) map.entrySet().iterator().next().getValue();
			return value;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
