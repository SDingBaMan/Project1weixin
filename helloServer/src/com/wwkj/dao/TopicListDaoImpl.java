package com.wwkj.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.wwkj.utils.DataSourceManager;

 
public class TopicListDaoImpl {
	private QueryRunner runner = new QueryRunner(DataSourceManager
			.getDataSource());

	public List<Map<String, Object>> getTopicListInfos(String page,
			String pageNum, String id, String orderby) {

		// 起始条目：默认从0开始
		// 显示条目：pageNum
		// select * from topiclist order by id desc limit 0,4
		// --从0开始显示4条记录
		//		

		List<Map<String, Object>> infos = null;
		// String sql= "select * from topiclist orderby   limit(,)   product;
		String sql = "select * from product";
		try {
			infos = runner.query(sql, new MapListHandler());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return infos;
	}
}
