package com.wwkj.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wwkj.dao.ProdDaoImpl;
import com.wwkj.utils.CommonUtil;

 

/**
 * Servlet implementation class Search
 */
@WebServlet(description = "搜索商品", urlPatterns = { "/search" })
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		{
			"response": "search",
			"productlist":            //搜索商品列表
			[
				{
		            "id": "1102539",        //商品ID
					"name": "雅培金装",    //商品名称
					"pic": "",              //商品图片URL
					"marketprice": "79",     //市场价
		            "price": "78",          //会员价
				},  
				{
		            "id": "1102539",        //商品ID
					"name": "雅培金装",    //商品名称
					"pic": "",              //商品图片URL
					"marketprice": "79",     //市场价
		            "price": "78",          //会员价
				}
			],
		    "list_count":"15"         //商品总数
		}*/
		ProdDaoImpl prodDaoImpl = new ProdDaoImpl();
		String keyword = request.getParameter("keyword");
		Map<String, Object> productList = prodDaoImpl.getProductList(keyword);
		CommonUtil.renderJson(response, productList);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
