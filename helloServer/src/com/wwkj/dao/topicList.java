package com.wwkj.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.wwkj.utils.DataSourceManager;

 

public class topicList {
	private QueryRunner runner = new QueryRunner(
			DataSourceManager.getDataSource());

	/**
	 * 获取帮助列表
	 */
	public List<Map<String, Object>> gettopicList(int id) {
		/**
		 * "response": "topic",
  " topic ": [
{
  "id": "专题活动ID",
      "name": "专题活动名称",
      "pic": "图片URL"
    },
{
  "id": "专题活动ID",
      "name": "专题活动名称",
      "pic": "图片URL"
    }
  ]

		 */

		String sql = "select id,name,pic,marketPrice,price from product where ishot =?   ";

		try {
			return runner.query(sql, new MapListHandler(),1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
