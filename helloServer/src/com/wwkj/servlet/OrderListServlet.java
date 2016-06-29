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

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.wwkj.bean.Order;
import com.wwkj.utils.CommonUtil;

/**
 * Servlet implementation class OrderListServlet
 */
@WebServlet(description = "订单列表", urlPatterns = { "/orderlist" })
public class OrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String str = "{\"response\":\"orderlist\",\"orderlist\":[{\"orderid\":\"412423145\",\"status\":\"未处理\",\"time\":\"2011/10/10012:16:40\",\"price\":\"1234.23\",\"flag\":\"1\"},{\"orderid\":\"412423145\",\"status\":\"交易成功\",\"time\":\"2011/10/10012:16:40\",\"price\":\"1234.23\",\"flag\":\"1\"},{\"orderid\":\"412423145\",\"status\":\"已完成\",\"time\":\"2011/10/10012:16:40\",\"price\":\"1234.23\",\"flag\":\"1\"}]}";
//		
//		response.getWriter().write(str);
		
		/*
		String userId = request.getParameter("userId");
		Map<String, Object> data = new HashMap<String, Object>();
		OrderDaoImpl impl = new OrderDaoImpl();
		data.put("response", "OrderList");
		data.put("OrderList", impl.getOrderInfo(userId));
		
		//将Object（map）转换成Json字符串
		String json = JSONObject.fromObject(data).toString();
		System.out.println(json);*/
		
		int page = 1;
		int type = 1;
		int pageNum = 10;

		try {
			type = Integer.parseInt(request.getParameter("type"));
			page = Integer.parseInt(request.getParameter("page"));
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("response", "orderlist");
		
		List<Order> Orders = new ArrayList<Order>();
		if(type==1){
			Order order = new Order();
			order.setOrderId(412423145);
			order.setStatus("未处理");
			order.setOrdertime("2014/04/10 12:16:40");
			order.setPrice(1234.23);
			order.setFlag(1);
			Orders.add(order);
			
			order.setOrderId(412423146);
			order.setStatus("交易成功");
			order.setOrdertime("2014/04/13 12:16:40");
			order.setPrice(1234.23);
			order.setFlag(1);
			Orders.add(order);
			
			order.setOrderId(412423147);
			order.setStatus("已完成");
			order.setOrdertime("2014/04/12 12:16:40");
			order.setPrice(1234.23);
			order.setFlag(1);
			Orders.add(order);
		}
		if(type==2){
			Order order = new Order();
			order.setOrderId(412423145);
			order.setStatus("未处理");
			order.setOrdertime("2013/10/22 12:16:40");
			order.setPrice(1234.23);
			order.setFlag(2);
			Orders.add(order);
			
			order.setOrderId(412423146);
			order.setStatus("交易成功");
			order.setOrdertime("2013/11/12 12:16:40");
			order.setPrice(1234.23);
			order.setFlag(2);
			Orders.add(order);
			
			order.setOrderId(412423147);
			order.setStatus("已完成");
			order.setOrdertime("2013/12/13 12:16:40");
			order.setPrice(1234.23);
			order.setFlag(2);
			Orders.add(order);
		}
		if(type==3){
			Order order = new Order();
			order.setOrderId(412423145);
			order.setStatus("已取消");
			order.setOrdertime("2012/10/10 12:16:40");
			order.setPrice(1234.23);
			order.setFlag(3);
			Orders.add(order);
			
			order.setOrderId(412423146);
			order.setStatus("已取消");
			order.setOrdertime("2012/10/14 12:16:40");
			order.setPrice(1234.23);
			order.setFlag(3);
			Orders.add(order);
			
			order.setOrderId(412423147);
			order.setStatus("已取消");
			order.setOrdertime("2012/11/11 12:16:40");
			order.setPrice(1234.23);
			order.setFlag(3);
			Orders.add(order);
		}

		// 过滤掉不想要的属性信息
		JsonConfig config = new JsonConfig();
		config.setExcludes(new String[] { "Paymenttype" });
		List<Object> dataList = new ArrayList<Object>();
		for (Order item : Orders) {
			Object itemObj = JSONObject.fromObject(item, config);
			dataList.add(itemObj);
		}
		data.put("orderlist",dataList);
		CommonUtil.renderJson(response, data);
	}

}
