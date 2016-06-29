package com.wwkj.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.wwkj.bean.Filter;
import com.wwkj.bean.FilterValue;
import com.wwkj.bean.Pic;
import com.wwkj.bean.Prod;
import com.wwkj.bean.ProductProperty;
import com.wwkj.utils.DataSourceManager;

 
/**
 * 查询商品
 * 
 * @author YUY
 * 
 */
public class ProdDaoImpl {
	private QueryRunner runner = new QueryRunner(DataSourceManager.getDataSource());

	/**
	 * 查询全部商品
	 * 
	 * @return
	 */
	public List<Prod> getProduct() {
		String sql = "select * from prod";
		try {
			return runner.query(sql, new BeanListHandler<Prod>(Prod.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 查询商品指定内容
	 * 
	 * @return
	 */
	public Prod getProductDesc(String productId) {
		String sql = "select * from prod where id=?";
		try {
			return runner.query(sql, new BeanHandler<Prod>(Prod.class), productId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取商品属性
	 * 
	 * @param productId
	 * @return
	 */
	public Prod getProduct(String productId) {
		Prod product = getProductDesc(productId);
		if (product != null) {
			fillProperty(product);
//			List<String> proms = new ArrayList<String>();
//			proms.add("促销信息1");
//			proms.add("促销信息2");
//			product.setProductProm(proms);
		}
		return product;
	}

	/**
	 * 查询商品列表
	 * 
	 * @return
	 */
	public Map<String, Object> getProductList() {
		// String sql =
		// "select a.id,a.name,a.marketprice,a.commentCount, b.url from product as a left join pic as b on a.id= b.product_id ";
		String sql = "select a.id,a.name,a.marketprice,a.limitprice,a.lefttime,a.score,a.available," + "a.buyLimit,a.commentCount, a.inventoryArea from prod a";
		//String sql="select id,name,marketPrice,price,pic,,number";
		List<Prod> productList = null;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			productList = runner.query(sql, new BeanListHandler<Prod>(Prod.class));
			map.put("productlist", productList);
			map.put("list_count", productList.size());
			filterValues(map);
			// return runner.query(sql, new MapListHandler());
		} catch (SQLException e) {
			/*
			 * { "response": "error", "error": { "text": "用户名不存在" }
			 */
			map.put("response", "error");
			map.put("error", new HashMap<String, String>().put("text", "用户名不存在"));
			e.printStackTrace();
		}
		return map;
	}

	private void filterValues(Map<String, Object> paramMap) {
		String sql = "select `id`, `key` from filter";
		String sql2 = "select id, name from filtervalue where filter_id=?";
		try {
			List<Filter> filters = runner.query(sql, new BeanListHandler<Filter>(Filter.class));
			for (Filter f : filters) {
				List<FilterValue> tempValues = runner.query(sql2, new BeanListHandler<FilterValue>(FilterValue.class), f.getId());
				Map<String, String> map = new HashMap<String, String>();
				for (FilterValue v : tempValues) {
					map.put(v.getId() + "", v.getName());

				}
				f.setValue(map);
			}
			paramMap.put("list_filter", filters);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Map<String, Object> getProductDetail(String productId) {
		Map<String, Object> map = new HashMap<String, Object>();
		String sql = "select a.id,a.name,a.marketprice,a.limitprice,a.lefttime,a.score,a.available," + "a.buyLimit,a.commentCount, a.inventoryArea from prod a where a.id=?";
		try {
			Prod product = runner.query(sql, new BeanHandler<Prod>(Prod.class), productId);
			if (product != null) {
				map.put("response", "product");
				map.put("product", product);

				String sqlPic = "select id,url from pic where product_id=?";
				List<Pic> list = runner.query(sqlPic, new BeanListHandler<Pic>(Pic.class), productId);
				if (list != null && list.size() > 0) {
					product.setPic(list);
					product.setBigPic(list);
				}
				
//				List<String> proms = new ArrayList<String>();
//				if (proms != null && proms.size() > 0) {
//					proms.add("促销信息1");
//					proms.add("促销信息2");
//					product.setProductProm(proms);
//				}
				fillProperty(product);
			} else {
				/*
				 * { "response": "error", "error": { "text": "用户名不存在" }
				 */
				map.put("response", "error");
				map.put("error", new HashMap<String, String>().put("text", "用户名不存在"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 填充商品属性
	 * 
	 * @param p
	 *            ：指定的商品
	 */
	private void fillProperty(Prod p) {
		String sql = "select distinct a.id, a.key,a.value from property " + "a inner join product_property_filter b on "
				+ "a.id = b.property_id inner join prod c on c.id=b.product_id where c.id=?";
		try {
			List<ProductProperty> list = runner.query(sql, new BeanListHandler<ProductProperty>(ProductProperty.class), p.getId());
			if (list != null && list.size() > 0)
				p.setProduct_property(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取商品收藏
	 * 
	 * @param productId
	 * @return
	 */
	private String getProductFavoure(String productId) {
		String sql = "select name from prod where id=?";
		try {
			Prod product = runner.query(sql, new BeanHandler<Prod>(Prod.class), productId);
			if (product != null)
				return product.getName();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}

	public Map<String, Object> getProductList(String keyword) {
		// String sql =
		// "select a.id,a.name,a.marketprice,a.commentCount, b.url from product as a left join pic as b on a.id= b.product_id ";
		String sql = "select a.id,a.name,a.marketprice,a.limitprice,a.lefttime,a.score,a.available,a.price,"
				+ "a.buyLimit,a.commentCount, a.inventoryArea from prod a where a.name like ?";
		List<Prod> productList = null;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			productList = runner.query(sql, new BeanListHandler<Prod>(Prod.class), "%" + keyword +"%");
			map.put("productlist", productList);
			map.put("list_count", productList.size());
			filterValues(map);
			fillMap(productList);
			// return runner.query(sql, new MapListHandler());
		} catch (SQLException e) {
			map.put("response", "error");
			map.put("error", new HashMap<String, String>().put("text", "用户名不存在"));
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 查找图片
	 * @param productList
	 */
	private void fillMap(List<Prod> productList) throws SQLException{
		String sql = "select * from pic where product_id=?";
		for(Prod p : productList) {
			List<Pic> list = runner.query(sql, new BeanListHandler<Pic>(Pic.class), p.getId());
			p.setPic(list);
		}
	}
}
