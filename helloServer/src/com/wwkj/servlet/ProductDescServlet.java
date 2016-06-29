package com.wwkj.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wwkj.dao.ProdDaoImpl;
import com.wwkj.utils.CommonUtil;

import net.sf.json.JSONObject;

 

/**
 * Servlet implementation class ProductDescServlet
 */
@WebServlet("/product/description")
public class ProductDescServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDescServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TEST PRODUCTDESC");
		data(request,response);
	}

	/**
	 * 组装商品描述信息
	 * @param request
	 * @param response
	 */
	private void data(HttpServletRequest request, HttpServletResponse response) {
		/**
			"response": "product_description",
			"productdesc": ""   //商品详情描述
		 */
		String productId = "";
		try {
			productId = request.getParameter("pId");
		} catch (Exception e) {
			e.printStackTrace();
		}
		//填充数据
		Map<String, Object> data = new HashMap<String, Object>();
		ProdDaoImpl impl = new ProdDaoImpl();
		data.put("response", "product_description");
		data.put("productdesc", impl.getProductDesc(productId).getProductdesc());

		//将Object（map）转换成Json字符串
		CommonUtil.renderJson(response, data);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
