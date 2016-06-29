package com.wwkj.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrderListServlet
 */
@WebServlet(description = "订单详情", urlPatterns = { "/orderdetail" })
public class OrderDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderDetailServlet() {
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
		String str = "{\"response\":\"orderdetail\",\"order_info\":{\"orderId\":\"412423145\",\"status\":\"已完成\",\"ordertime\":\"2011/10/10 12:16:40\",\"flag\":\"1\"},\"address_info\":{\"id\":\"1001\",\"phonenumber\":\"13111113333\",\"zipCode\":\"10010\",\"name\":\"肖文\",\"area\":\"北京市海淀区\",\"detail\":\"闵庄路3号\"},\"payment_info\":{\"type\":\"1\"},\"delivery_info\":{\"type\":\"1\"},\"invoice_info\":{\"title\":\"红孩子信息有限公司\",\"content\":\"办公用品\"},\"productlist\":[{\"id\":\"1102539\",\"name\":\"雅培金装\",\"pic\":\"\",\"price\":\"89\",\"product_property\":[{\"key\":\"颜色\",\"value\":\"红色\"},{\"key\":\"大小\",\"value\":\"M\"}],\"number\":0,\"uplimit\":\"10\",\"isgift\":\"yes\"},{\"id\":\"1102539\",\"name\":\"雅培金装\",\"pic\":\"\",\"price\":\"89\",\"product_property\":[{\"key\":\"颜色\",\"value\":\"红色\"},{\"key\":\"大小\",\"value\":\"M\"}],\"number\":0,\"uplimit\":\"10\",\"isgift\":\"yes\"}],\"checkout_prom\":[\"促销信息一\",\"促销信息二\"],\"checkout_addup\":{\"total_count\":\"3\",\"total_price\":\"230\",\"total_point\":\"230\",\"freight\":\"10\",\"prom_cut\":\"20\"}}";
		response.setCharacterEncoding("UTF-8");
		 
		response.getWriter().write(str);
	}

}
