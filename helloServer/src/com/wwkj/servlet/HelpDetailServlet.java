package com.wwkj.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wwkj.bean.HelpDetail;
import com.wwkj.utils.CommonUtil;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
 

/**
 * Servlet implementation class HelpDetailServlet
 */
public class HelpDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HelpDetailServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ceshi");
		data(request, response);
	}

	private void data(HttpServletRequest request, HttpServletResponse response) {
		// ②假数据处理

		/*
		 * { 　"response": "help_detail", 　" help_detaillist":[ {
		 * "title":"怎么购买？", //title "content":" content " //帮助内容 }, {
		 * "title":"怎么配送？", //title "content":" content " //帮助内容 }, ]//内容 }
		 */

		Map<String, Object> data = new HashMap<String, Object>();
		data.put("response", "help_detail");

		List<HelpDetail> details = new ArrayList<HelpDetail>();

		HelpDetail detail = new HelpDetail();
		detail.setTitle("怎么购买？");
		detail.setContent("不知道");

		details.add(detail);

		detail = new HelpDetail();
		detail.setTitle("怎么购买2？");
		detail.setContent("还是不知道");
		details.add(detail);

		List<String> detailstr = new ArrayList<String>();

		// 设置需要过滤掉的字段信息
		JsonConfig config = new JsonConfig();
		config.setExcludes(new String[] { "id" });
		for (HelpDetail item : details) {
			detailstr.add(JSONObject.fromObject(item, config).toString());
		}

		data.put("help_detaillist", detailstr);

		CommonUtil.renderJson(response, data);
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
