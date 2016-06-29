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

import com.alibaba.fastjson.JSONObject;
import com.wwkj.dao.TopicListDaoImpl;
import com.wwkj.utils.CommonUtil;

 

/**
 * Servlet implementation class ProductListServlet
 */
@WebServlet(description = "促销快报-商品列表", urlPatterns = { "/topic/plist" })
public class TopicListServlet extends HttpServlet {  
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TopicListServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/*
		 * { "response": "topic_productlist", "productlist": [ { "id":
		 * "1102539", // 商品ID "name": "雅培金装", // 商品名称 "pic": "", // 商品图片URL
		 * "marketprice": "79", // 市场价 "price": "78", // 会员价， }, { "id":
		 * "1102539", // 商品ID "name": "雅培金装", // 商品名称 "pic": "", // 商品图片URL
		 * "marketprice": "79", // 市场价 "price": "78", // 会员价 } ] ,
		 * "list_count":"15" // 商品总数 }
		 */

		

		TopicListDaoImpl impl = new TopicListDaoImpl();
		List<Map<String, Object>> infos = impl.getTopicListInfos(null, null,
				null, null);
		List<String> productliststr = new ArrayList<String>();
		for (Map<String, Object> map : infos) {
			JSONObject object = new JSONObject(map);
			productliststr.add(object.toJSONString());
		}

		Map<String, Object> data = new HashMap<String, Object>();
		data.put("response", "topic_productlist");
		data.put("productlist", productliststr);
		System.out.println("TopicListServlet  ==== >>   "+productliststr.toString());
		CommonUtil.renderJson(response, data);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
