package com.wwkj.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.wwkj.bean.Cart;
import com.wwkj.bean.CartItem;
import com.wwkj.bean.Prod;
import com.wwkj.utils.DataSourceManager;

 

/**
 * 查询购物车
 * 
 * @author Administrator
 * 
 */
public class CartDaoImpl {

	private QueryRunner runner = new QueryRunner(DataSourceManager.getDataSource());

	public Cart getCart() {
		int cartId = 1;
		Cart cart = null;
		String sql = "select a.id,a.totalcount,a.totalprice,a.totalpoint from cart a where id=?";
		try {
			cart = runner.query(sql, new BeanHandler<Cart>(Cart.class), cartId);
			if(cart != null) {
				fillCartItem(cart);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cart;
	}
	
	public List<Map<String, Object>> getCartList() {
		String sql = "select * from product";
		try { 
			return runner.query(sql, new MapListHandler());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private void fillCartItem(Cart cart) throws SQLException {
		String sql = "select * from cartItem where id=?";
		List<CartItem> list = runner.query(sql, new BeanListHandler<CartItem>(CartItem.class), cart.getId());
		ProdDaoImpl daoImpl = new ProdDaoImpl();
		for(CartItem ci : list) {
			Prod product = daoImpl.getProduct(ci.getProduct_id() + "");
			ci.setProduct(product);
			ci.setProdNum(2);
			
		}
		cart.setCartitem(list);
		
		List<String> proms = new ArrayList<String>();
		proms.add("促销信息1");
		proms.add("促销信息2");
		cart.setProms(proms);
	}
}
