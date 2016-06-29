package com.wwkj.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wwkj.bean.Banner;
import com.wwkj.dao.BannerImpl;
import com.wwkj.utils.CommonUtil;

 


@WebServlet("/home")
public class BannerServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		data(req, resp);
	}

	private void data(HttpServletRequest req, HttpServletResponse resp) {
		
//		{
//			"response": "home"
//			  "home_banner":        //轮转大图 320*125
//			[
//			    {
//			      "id": 123,                  //专题id
//			      "title": "活动1",            //专题标题
//			      "pic": "http://localhost/1.png"  //专题图片URL
//			    },
//			    {

		BannerImpl impl = new BannerImpl();
		List<Banner> queryBanner = impl.queryBanner();
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("response", "home");
		data.put("home_banner", queryBanner);
		CommonUtil.renderJson(resp, data);
	}
}
