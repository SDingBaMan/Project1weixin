package com.wwkj.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wwkj.utils.CommonUtil;

 
/**
 * 用户注销的Servlet
 * @author Dream
 *
 */
@WebServlet(description = "用户注销的Servlet", urlPatterns = { "/logout" })
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LogoutServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("response", "logout");
		CommonUtil.renderJson(response, data);
	}

}
