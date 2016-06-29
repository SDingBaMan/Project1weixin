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
import com.wwkj.dao.HelpDaoImpl;
import com.wwkj.utils.CommonUtil;

 
 
/**
 * Servlet implementation class HelpServlet
 */
@WebServlet("/help")
public class HelpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HelpServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("测试");
		data(request, response);
	}

	private void data(HttpServletRequest request, HttpServletResponse response) {
		// 数据处理
		// ①数据库
		// ②假数据处理

		int version = 0;

		try {
			version = Integer.parseInt(request.getParameter("version"));
		} catch (Exception e) {
			// TODO: handle exception
		}

		/**
		 * { "response": "help", "version":"12", "helplist": [ { "id":"1",
		 * "title":"购物指南", //title },
		 * 
		 * { "id":"2", "title":"配送方式", //title }, ]
		 * 
		 * }
		 */

		
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("response", "help");
		data.put("version", version);

		HelpDaoImpl daoImpl = new HelpDaoImpl();
		List<Map<String, Object>> helpList = daoImpl.getHelpList(version);
		data.put("helplist", helpList);

		// 将map转换成Json字符串信息
		 
		//System.out.println(JSONObject.fromObject(data).toString());
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
