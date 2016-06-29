package com.wwkj.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.wwkj.utils.DataSourceManager;

 

public class OrderDaoImpl {

	private QueryRunner runner = new QueryRunner(
			DataSourceManager.getDataSource());

	/**
	 * 获取帮助列表
	 */
	public Map<String, Object> getOrderInfo(String userId) {
//		"response": "ordersumbit",
//	    "orderinfo":{                 
//	　　　"orderid": "1112111111",               //订单编号
//	　　　"price":"230",                        //订单金额
//	　　　"paymenttype":"1"                    //支付方式
//	    }

		String sql = "select id,price,pay_type from help where user_id=?";
		
		try {
			return runner.query(sql, new MapHandler(), userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
