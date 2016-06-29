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

import com.alibaba.fastjson.JSONObject;
import com.wwkj.dao.TopicDaoImpl;
import com.wwkj.utils.CommonUtil;

 

/**
 * Servlet implementation class TopicServlet
 */
@WebServlet(description = "促销快报", urlPatterns = { "/topic" })
public class TopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TopicServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		TopicDaoImpl impl = new TopicDaoImpl();
		List<Map<String, Object>> topicList = impl.getTopicInfos("1", "4");

		List<String> infostr = new ArrayList<String>();
		for (Map<String, Object> map : topicList) {
			JSONObject obj = new JSONObject(map);
			String str = obj.toJSONString();
			infostr.add(str);
		}

		Map<String, Object> data = new HashMap<String, Object>();
		data.put("response", "topic");
		data.put("topic", infostr);
		System.out.println(infostr.toString());

		CommonUtil.renderJson(response, data);

		// Map<String, Object> data=new HashMap<String, Object>();
		// data.put("response","topic");
		//		
		// List<Topic> topics=new ArrayList<Topic>();
		//		
		// Topic detail=new Topic();
		// detail.setId(1);
		// detail.setName("专题一");
		// detail.setPic("/images/topic/topic_1.jpg");
		// detail.setStartTime("2014-03-18");
		// detail.setEndTime("2014-03-28");
		// detail.setStatus(1);
		// topics.add(detail);
		//		
		// detail=new Topic();
		// detail.setId(2);
		// detail.setName("专题二");
		// detail.setPic("/images/topic/topic_2.jpg");
		// detail.setStartTime("2014-03-23");
		// detail.setEndTime("2014-03-28");
		// detail.setStatus(1);
		// topics.add(detail);
		//		
		// detail=new Topic();
		// detail.setId(3);
		// detail.setName("专题三");
		// detail.setPic("/images/topic/topic_3.jpg");
		// detail.setStartTime("2014-03-20");
		// detail.setEndTime("2014-03-23");
		// detail.setStatus(1);
		// topics.add(detail);
		//		
		// detail=new Topic();
		// detail.setId(4);
		// detail.setName("专题四");
		// detail.setPic("/images/topic/topic_4.jpg");
		// detail.setStartTime("2014-03-21");
		// detail.setEndTime("2014-03-25");
		// detail.setStatus(1);
		// topics.add(detail);
		//		
		// List<String> topicstr = new ArrayList<String>();
		// for(Topic item: topics)
		// {
		// topicstr.add(JSONObject.fromObject(item).toString());
		// }
		//		
		// data.put("topic", topicstr);
		// System.out.println(data.toString());
		// CommonUtil.renderJson(response, data);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
