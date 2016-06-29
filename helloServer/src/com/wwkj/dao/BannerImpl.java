package com.wwkj.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.wwkj.bean.Banner;
import com.wwkj.utils.DataSourceManager;

 

public class BannerImpl {
	private QueryRunner runner = new QueryRunner(DataSourceManager.getDataSource());

	public List<Banner> queryBanner() {
		String sql = "select * from banner";
		try {
			return runner.query(sql, new BeanListHandler<Banner>(Banner.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
