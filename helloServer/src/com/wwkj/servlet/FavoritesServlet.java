package com.wwkj.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.wwkj.dao.FavoritesDaoImpl;
import com.wwkj.dao.GetFavoritesNumDaoImpl;
import com.wwkj.dao.ProdDaoImpl;
import com.wwkj.utils.CommonUtil;
 

/**
 * 收藏夹Servlet
 * 
 * @author 
 * 
 */
@WebServlet(description = "收藏夹的Servlet", urlPatterns = { "/favorites" })
public class FavoritesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FavoritesServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		date(request, response);
	}

	private void date(HttpServletRequest request, HttpServletResponse response) {
//		String page = request.getParameter("page");	// 第几页
//		String pageNum = request.getParameter("pageNum");	// 每页个数
		// 获取收藏夹信息
		String productId = "";
		try {
			productId = request.getParameter("pId");
		} catch (Exception e) {
			e.printStackTrace();
		}
		//濉厖鏁版嵁
		Map<String, Object> data = new HashMap<String, Object>();
		FavoritesDaoImpl impl = new FavoritesDaoImpl();
		data.put("response", "favorites");
		List<Map<String, Object>> favorites = impl.getFavorites(1, 30);
		data.put("productlist",favorites);
		String json = JSONObject.fromObject(data).toString();
		CommonUtil.renderJson(response, data);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
