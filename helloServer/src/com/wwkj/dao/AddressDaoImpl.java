package com.wwkj.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.wwkj.utils.DataSourceManager;
 

public class AddressDaoImpl {
	private QueryRunner runner = new QueryRunner(
			DataSourceManager.getDataSource());

	public List<Map<String, Object>> getAddressList(String userid) {
		/*
		 * "response": " addresslist", "addresslist": [ //地址列表 { "id": "1001",
		 * //地址簿ID "name": "肖文", //收货人姓名 "phonenumber": "15801477821", //手机号码
		 * "fixedtel":"010-88496666" //固定电话 "provinceId": "102", //省ID
		 * 
		 * "cityId": "10203", //市ID "areaId": "1020304", //地区ID "areaDetail":
		 * "闵庄路3号", //订单地址 "zipCode": "100195", //邮编 },
		 */
		String sql = "select * from address where user_id=" + userid;

		try {
			return runner.query(sql, new MapListHandler());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
