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

import com.wwkj.bean.Order;
import com.wwkj.utils.CommonUtil;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

 

@WebServlet("/order")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public OrderServlet() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		data(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
	private void data(HttpServletRequest request, HttpServletResponse response) {
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
		data.put("order_info",dataList);
		CommonUtil.renderJson(response, data);
	}
}
