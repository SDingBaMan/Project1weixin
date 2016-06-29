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
 * Servlet implementation class RegisterServlet
 */
@WebServlet(description = "用户注册", urlPatterns = { "/register" })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
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

		Map<String, Object> userId = impl.UserId(username, password);
		Map<String, Object> data = null;
		if (userId != null) {
			Map<String, String> error = new HashMap<String, String>();
			error.put("text", "用户已经存在！");

			data = new HashMap<String, Object>();
			data.put("response", "error");
			data.put("error", error);
			CommonUtil.renderJson(response, data);
			return;
		}

		Map<String, Object> register = impl.register(username, password);
		if (register != null) {
			data = new HashMap<String, Object>();
			data.put("response", "userinfo");
			data.put("userinfo", register);

			System.out.println(register.toString());

			CommonUtil.renderJson(response, data);
			return;
		}
		// http://localhost/02801-ECService/register?username=lyl&password=123
		// {"response":"userinfo","userinfo":{"userId":4}}

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
