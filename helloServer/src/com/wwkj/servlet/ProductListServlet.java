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
 * Servlet implementation class ProductListServlet
 */
@WebServlet("/productlist")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TEST productList");
		data(request, response);
	}

	//TODO 这里还有问题，对于筛选属性还没搞定
	/**
	 * 组装商品列表的数据
	 * @param request
	 * @param response
	 */
	private void data(HttpServletRequest request, HttpServletResponse response) {
		/*
		 * "response": "category_productlist",
	"productlist":
	[
		{
            "id": "1102539",        //商品ID
			"name": "雅培金装",    //商品名称
			"pic": "",              //商品图片URL
			"marketprice": "79",     //市场价
            "price": "78",          //会员价
      "commentCount":"23",   //商品评论数
		},  
		{
            "id": "1102539",        //商品ID
			"name": "雅培金装",    //商品名称
			"pic": "",              //商品图片URL
			"marketprice": "79",     //市场价
            "price": "78",          //会员价
            " commentCount":"23",   //商品评论数
		}
	] ,
	"list_count":"1500" 

		 */
		//填充数据
		Map<String, Object> data = new HashMap<String, Object>();
		ProdDaoImpl impl = new ProdDaoImpl();
		data.put("response", "category_productlist");
		data.put("productlist", impl.getProductList());
		//data.put("list_filter", impl)

		//将Object（map）转换成Json字符串
		String json = JSONObject.fromObject(data).toString();
		//System.out.println(json);
		CommonUtil.renderJson(response, data);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
