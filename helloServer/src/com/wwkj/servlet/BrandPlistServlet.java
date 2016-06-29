package com.wwkj.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BrandPlist
 */
@WebServlet(description = "品牌商品列表", urlPatterns = { "/brand/plist" })
public class BrandPlistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BrandPlistServlet() {
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
		String str = "{\"response\":\"brand_productlist\",\"productlist\":[{\"id\":\"1102539\",\"name\":\"雅培金装\",\"pic\":\"images/hotSingle04_milk01.png\",\"marketprice\":\"79\",\"price\":\"78\"},{\"id\":\"1102539\",\"name\":\"雅培金装\",\"pic\":\"images/hotSingle04_milk01.png\",\"marketprice\":\"79\",\"price\":\"78\"}],\"list_count\":\"1500\"}";
		response.getWriter().write(str);
	}

}
