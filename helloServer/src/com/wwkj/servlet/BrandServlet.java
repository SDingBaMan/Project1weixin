package com.wwkj.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BrandServlet
 */
@WebServlet(description = "推荐品牌", urlPatterns = { "/brand" })
public class BrandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BrandServlet() {
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
		String str = "{\"response\":\"brand\",\"brand\":[{\"key\":\"孕妈专区\",\"value\":[{\"id\":\"1201\",\"name\":\"ain\",\"pic\":\"images/hotSingle04_milk01.png\"},{\"id\":\"1201\",\"name\":\"ain\",\"pic\":\"images/hotSingle04_milk01.png\"}]},{\"key\":\"营养食品\",\"value\":[{\"id\":\"1201\",\"name\":\"ain\",\"pic\":\"images/hotSingle04_milk01.png\"},{\"id\":\"1201\",\"name\":\"ain\",\"pic\":\"images/hotSingle04_milk01.png\"}]}]}";
		response.getWriter().write(str);
	}

}
