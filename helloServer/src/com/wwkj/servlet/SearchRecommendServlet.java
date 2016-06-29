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
 * Servlet implementation class SearchRecommendServlet
 */
@WebServlet(description = "搜索推荐", urlPatterns = { "/search/recommend" })
public class SearchRecommendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchRecommendServlet() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		List<String> keys = new ArrayList<String>();
		keys.add("adidas");
		keys.add("361");
		keys.add("nike");
		map.put("response", "searchrecommend");
		map.put("search_keywords", keys);
		CommonUtil.renderJson(response, map);
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
}
