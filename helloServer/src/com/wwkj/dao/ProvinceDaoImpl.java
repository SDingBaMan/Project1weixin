package com.wwkj.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.wwkj.utils.DataSourceManager;

 

public class ProvinceDaoImpl {
	private QueryRunner runner = new QueryRunner(
			DataSourceManager.getDataSource());

	public List<Map<String, Object>> getAddressList(String id) {
		String sql = "select * from address where id="+id;

		try {
			return runner.query(sql, new MapListHandler());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
