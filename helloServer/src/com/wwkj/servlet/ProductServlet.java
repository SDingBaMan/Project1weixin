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

import com.wwkj.bean.Prod;
import com.wwkj.bean.Product;
import com.wwkj.dao.ProdDaoImpl;
import com.wwkj.dao.ProductDaoImpl;
import com.wwkj.utils.CommonUtil;

import net.sf.json.JSONObject;

 

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TEST PRODUCT");
		data(request,response);
	}

	/**
	 * 组装product数据
	 * @param request
	 * @param response
	 */
	private void data(HttpServletRequest request, HttpServletResponse response) {
		/*
		 	"response": "product",
			"product": 
			{...}
 
		 */
		String productId = "";
		try {
			productId = request.getParameter("id");
		} catch (Exception e) {
			e.printStackTrace();
		}
		//填充数据
		Map<String, Object> data = new HashMap<String, Object>();
		ProductDaoImpl impl = new ProductDaoImpl();
		 
		Product p = impl.getProductDesc(productId);
		if(p!=null){
			data.put("response", "product");
			Prod prod = new Prod();
			prod.setId(p.getId());
			prod.setName(p.getName());
			prod.setMarketprice(p.getMarketprice());
			prod.setPrice(p.getPrice());
			prod.setCommentCount(10);
			List<String> pics = new ArrayList<String>();
			pics.add("/images/productlist/productlist_1.png");
			pics.add("/images/productlist/productlist_2.png");
			pics.add("/images/productlist/productlist_3.png");
			prod.setPic(pics);
			data.put("product", prod);
			
		} else {
			/*
			 * { "response": "error", "error": { "text": "用户名不存在" }
			 */
			data.put("response", "error");
			data.put("error", new HashMap<String, String>().put("text", "商品不存在"));
		}
		 

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
