package com.wwkj.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.wwkj.bean.Product;
import com.wwkj.utils.DataSourceManager;

 

/**
 * 收藏夹数据库实现类
 * 
 * @author 吉友良
 * 
 */
public class FavoritesDaoImpl {
	private QueryRunner runner = new QueryRunner(DataSourceManager.getDataSource());
	/**
	 * 获取收藏夹中收藏的商品
	 */
	public List<Map<String, Object>> getFavorites(int page,int pagecount) {
		String sql = "select product_id as id, name, pic, marketprice, price from favorites limit"+" "+page+", "+pagecount;
			try {
				List<Map<String, Object>> mapList = runner.query(sql, new MapListHandler());
				  return mapList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
		public boolean addFavorites(String productId) {
			String sql = "insert favorites (product_id, name, pic, marketprice, price)  values(?,?,?,?,?)" ;
			Product p = new ProductDaoImpl().getProductDesc(productId);
			if(p!= null){
				try {
				return	runner.update(sql, p.getId(),p.getName(),p.getPic(),p.getMarketprice(),p.getPrice())>0;
				} catch (SQLException e) { 
					e.printStackTrace();
				}
			}
			return false;
		}
	 
	
}
