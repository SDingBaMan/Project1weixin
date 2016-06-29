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

import com.wwkj.utils.CommonUtil;

 

/**
 * Servlet implementation class OrderListServlet
 */
@WebServlet(description = "物流查询", urlPatterns = { "/logistics" })
public class LogisticsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogisticsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
/*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = "{\"response\":\"logistics\",\"logistics\":{\"list\":[\"中天\",\"DELL\",\"HELLOP\"],\"expressway\":\"快递\",\"logisticsid\":\"运单编号\",\"logisticscorp\":\"顺丰\"}}";
		response.getWriter().write(str);
	}*/
    
    protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		data(request, response);
	}

	private void data(HttpServletRequest request, HttpServletResponse response) {
		long orderid = 897483741;
		try {
			orderid = Integer.parseInt(request.getParameter("orderid"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("response", "logistics");
		data.put("expressway", "快递");
		data.put("logisticsid", 110220330);
		data.put("logisticscorp", "顺丰");
		List<String> list = new ArrayList<String>();
		list.add("1fdsgdg");
		list.add("dfgdfgdf");
		list.add( "gdfgdfg");
		data.put("list",list);

		CommonUtil.renderJson(response, data);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
    
}
