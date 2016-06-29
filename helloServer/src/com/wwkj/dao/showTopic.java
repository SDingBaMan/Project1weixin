package com.wwkj.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.wwkj.utils.DataSourceManager;

 

public class showTopic {
	private QueryRunner runner = new QueryRunner(
			DataSourceManager.getDataSource());

	/**
	 * 获取帮助列表
	 */
	public List<Map<String, Object>> gettopicList(int id) {
	

		String sql = "select name,id,pic,marketprice,price from product where isbrand =?  ";

		try {
			return runner.query(sql, new MapListHandler(),id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
