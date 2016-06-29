package com.wwkj.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;



import com.wwkj.dao.UserinfoDaoImpl;
import com.wwkj.utils.CommonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(description = "处理用户登录的Servlet", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 获取客户端发过来的参数
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//
//		LoginDaoImpl loginDaoImpl = new LoginDaoImpl();
//		Map<String, Object> login = loginDaoImpl.login(username, password);
//		Map<String, Object> data = new HashMap<String, Object>();
//		data.put("response", "login");
//		data.put("userinfo", login);
//		CommonUtil.renderJson(response, data);


		request.getHeaderNames();


		String username = request.getParameter("username");
		String password = request.getParameter("password");

		System.out.println("username:" + username + "——password:" + password);
		if ("".equals(password) && "".equals(username)) {
			return;
		}
		System.out.println("11111111111111111111111");
		UserinfoDaoImpl impl = new UserinfoDaoImpl();
		System.out.println("========================");

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
			System.out.println("xxx : "+map.toString());
		}
		/**
		 * {"response":"login","userinfo":{"userId":1}}
		 */
		CommonUtil.renderJson(response, data);
	}

}
