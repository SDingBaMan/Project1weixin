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
 * Servlet implementation class UserInfoServlet
 */
@WebServlet(description = "用户登录", urlPatterns = { "/login2" })
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserInfoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		System.out.println("username:" + username + "——password:" + password);
		if ("".equals(password) && "".equals(username)) {
			return;
		}

		UserinfoDaoImpl impl = new UserinfoDaoImpl();
		Map<String, Object> map = impl.UserId(username, password);

		// TODO 输入的用户名密码不正确，需提示用户
		Map<String, Object> data = null;
		if (map == null) {
			Map<String, String> error = new HashMap<String, String>();
			error.put("text", "用户名或密码错误！");

			data = new HashMap<String, Object>();
			data.put("response", "error");
			data.put("error", error);
		} else {
			data = new HashMap<String, Object>();
			data.put("response", "login");
			data.put("userinfo", map);
		}
		/**
		 * {"response":"login","userinfo":{"userId":1}}
		 */
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
