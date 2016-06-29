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
 * Servlet implementation class OrderListServlet
 */
@WebServlet(description = "订单取消", urlPatterns = { "/ordercancel" })
public class OrderCancelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderCancelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = "{\"response\": \"ordercancel\"}";
		response.getWriter().write(str);
	}*/
    
    protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		data(request, response);
	}

	private void data(HttpServletRequest request, HttpServletResponse response) {
		long orderid=1112434465;
		try {
			orderid = Integer.parseInt(request.getParameter("orderid"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, String> data = new HashMap<String, String>();
		data.put("response", "ordercancel");

		CommonUtil.renderJson(response, data);
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
