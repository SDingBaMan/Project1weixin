package com.wwkj.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wwkj.dao.CommentDaoImpl;
import com.wwkj.utils.CommonUtil;

import net.sf.json.JSONObject;

 

/**
 * Servlet implementation class CmmentServlet
 */
@WebServlet("/product/comment")
public class CommentServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Test  comment");
		data(request,response);
	}

	/**
	 * 组装数据
	 * @param request
	 * @param response
	 */
	private void data(HttpServletRequest request, HttpServletResponse response) {
		/**
		 {
				"response": "product_comment",
			"comment": [                      //评论列表
			  {
			    "title":"东西不错",             //评论标题
			    "content":"东西不错",          //评论内容
			    "username":"用户",            //评论用户
			    "time":"2001-12-24 23:00:00"    //评论时间
			},
			{
			    "title":"东西不错",             //评论标题
			    "content":"东西不错",          //评论内容
			    "username":"用户",            //评论用户
			    "time":"2001-12-24 23:00:00"    //评论时间
			}
			],
			"list_count":"1500"         //评论总数
			}

		 */
		String productId = "";
		try {
			productId = request.getParameter("pId");
		} catch (Exception e) {
			e.printStackTrace();
		}
		//填充数据
		Map<String, Object> data = new HashMap<String, Object>();
		CommentDaoImpl impl = new CommentDaoImpl();
		data.put("response", "product_comment");
		data.put("comment", impl.getComment(productId));
		
		//将Object（map）转换成Json字符串
		String json = JSONObject.fromObject(data).toString();
		CommonUtil.renderJson(response, data);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
