package com.wwkj.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wwkj.dao.FavoritesDaoImpl;
import com.wwkj.dao.ProdDaoImpl;
import com.wwkj.utils.CommonUtil;

import net.sf.json.JSONObject;

 

/**
 * Servlet implementation class FavouritesServler
 */
@WebServlet("/product/favorites")
public class FavouritesServler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FavouritesServler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 *"response": "product_favorites " 
		 */
		String productId = "";
		try {
			productId = request.getParameter("id");
		} catch (Exception e) {
			e.printStackTrace();
		}
		//填充数据
		Map<String, Object> data = new HashMap<String, Object>();
		boolean flag = new FavoritesDaoImpl().addFavorites(productId);
		if(flag){
			data.put("response", "product_favorites");
		}else{
			data.put("response", "error");
			data.put("error", new HashMap<String, String>().put("text", "收藏商品失败"));
		}
		String json = JSONObject.fromObject(data).toString();
		CommonUtil.renderJson(response, data);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
