package com.wwkj.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Checkout
 */
@WebServlet(description = "结算中心", urlPatterns = { "/checkout" })
public class Checkout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Checkout() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = "{\"response\":\"checkout\",\"address_info\":{\"id\":\"1001\",\"name\":\"张辽\",\"addressArea\":\"北京市海淀区\",\"addressDetail\":\"闵庄路3号\"},\"payment_info\":{\"type\":\"1\"},\"delivery_info\":{\"type\":\"1\"},\"productlist\":[{\"id\":\"1102539\",\"name\":\"雅培金装\",\"pic\":\"\",\"price\":\"89\",\"product_property\":[{\"key\":\"颜色\",\"value\":\"红色\"},{\"key\":\"大小\",\"value\":\"M\"}],\"number\":0,\"uplimit\":\"10\"},{\"id\":\"1102539\",\"name\":\"雅培金装\",\"pic\":\"\",\"price\":\"89\",\"product_property\":[{\"key\":\"颜色\",\"value\":\"红色\"},{\"key\":\"大小\",\"value\":\"M\"}],\"number\":0,\"uplimit\":\"10\",\"isgift\":\"yes\"}],\"checkout_prom\":[\"促销信息一\",\"促销信息二\"],\"checkout_addup\":{\"totalCount\":\"3\",\"totalPrice\":\"230\",\"totalPoint\":\"230\",\"freight\":\"10\",\"promCut\":\"20\"}}";
		response.getWriter().write(str);
	}
}
