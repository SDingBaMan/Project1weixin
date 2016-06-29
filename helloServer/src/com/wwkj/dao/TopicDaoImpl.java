package com.wwkj.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.wwkj.utils.DataSourceManager;

 

public class TopicDaoImpl {
	private QueryRunner runner = new QueryRunner(DataSourceManager
			.getDataSource());

	public List<Map<String, Object>> getTopicInfos(String page, String pageNum) {
		List<Map<String, Object>> infos = null;

		String sql = "select * from topic where status = 1";
		try {
			infos = runner.query(sql, new MapListHandler());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return infos;
	}
}
