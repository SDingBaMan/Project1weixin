package com.wwkj.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.wwkj.utils.DataSourceManager;
 

public class HelpDaoImpl {
	private QueryRunner runner = new QueryRunner(DataSourceManager
			.getDataSource());

	/**
	 * 获取帮助列表信息
	 * 
	 * @param version
	 */
	public List<Map<String, Object>> getHelpList(int version) {
		/**
		 * "helplist": [ { "id":"1", "title":"购物指南", //title }, { "id":"2",
		 * "title":"配送方式", //title }, ]
		 */
		String sql = "select id,title from help where version > ? and state = 1";
		try {
			return runner.query(sql, new MapListHandler(), version);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
