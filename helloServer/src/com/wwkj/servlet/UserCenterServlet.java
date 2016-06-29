package com.wwkj.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wwkj.dao.UserinfoDaoImpl;
import com.wwkj.utils.CommonUtil;

 

/**
 * Servlet implementation class UserCenterServlet
 */
@WebServlet(description = "用户中心", urlPatterns = { "/userinfo" })
public class UserCenterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserCenterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		/*
		 * { "response": "userinfo", "userinfo":{ 　　"bonus": 3002, //会员积分
		 * 　　"level": "金卡", //会员等级 　　"userId": 30505, "usersession": "MD5",
		 * "ordercount":"20", //所下订单数 "favoritescount":"12" //收藏总数 　} }
		 */
		// http://localhost/02801-ECService/userinfo?username=admin&password=21232f297a57a5a743894a0e4a801fc3
		
		String ids = request.getParameter("ids");
		if ("".equals(ids)) {
			return;
		}
	System.out.println(ids);
	
		UserinfoDaoImpl impl = new UserinfoDaoImpl();
		int userid=Integer.parseInt(ids);
		Map<String, Object> info = impl.UserInfo(userid);

		Map<String, Object> data = null;
		if (info == null) {
			Map<String, String> error = new HashMap<String, String>();
			error.put("text", "用户名或密码错误！");

			data = new HashMap<String, Object>();
			data.put("response", "error");
			data.put("error", error);
		} else {
			data = new HashMap<String, Object>();
			data.put("response", "login");
			data.put("userinfo", info);
		}

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
