package com.wwkj.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.wwkj.dao.CartDaoImpl;
import com.wwkj.utils.CommonUtil;
 

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CartServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);System.out.println("测试CartServlet");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("测试CartServlet");
		data(request, response);
	}

	private void data(HttpServletRequest request, HttpServletResponse response) {

//		String sku = request.getParameter("sku");
//		if(StringUtils.isNotBlank(sku)) {
//			String[] items = sku.split("|");
//			 
//		}
//		
//		Map<String,Object> data = new HashMap<String, Object>();
//		
//		CartDaoImpl cartDao = new CartDaoImpl();
//		
//		data.put("response", "cart");
//
//		data.put("cart", cartDao.getCart());
//		CommonUtil.renderJson(response, data);
		CartDaoImpl impl =new CartDaoImpl();
		List<Map<String,Object>> infos = impl.getCartList();
		List<String> cartliststr =new ArrayList<String>();
		for (Map<String, Object> map : infos) {
			JSONObject object =new JSONObject(map);
			cartliststr.add(object.toJSONString());
		}
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("response", "cartitem");
		data.put("cartitem", cartliststr);
		data.put("totalCount", "3");
		data.put("totalPrice", "230");
		data.put("totalPoint", "230");
		System.out.println("CartServlet::::====>  "+cartliststr.toString()); 
		System.out.println(data.toString());
		CommonUtil.renderJson(response, data);

	}

}
