package com.wwkj.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.wwkj.utils.DataSourceManager;

 

/**
 * 查询pic的信息
 * 
 * @author YUY
 * 
 */
public class PicDaoImpl {
	private QueryRunner runner = new QueryRunner(DataSourceManager.getDataSource());

	/**
	 * 获取pic
	 */
	public List<Map<String, Object>> getPic() {
		String sql = "select * from pic";
		try {
			return runner.query(sql, new MapListHandler());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
