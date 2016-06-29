package com.sdingba.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdingba.server.CoreService;
import com.sdingba.util.SignUtil;

public class CoreServlet extends HttpServlet {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 请求校验 （确定请求来自微信服务器）
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("xxx");
		//微信加密签名
		String signature = req.getParameter("signature");
		String timestamp = req.getParameter("timestamp");
		String nonce = req.getParameter("nonce");
		String echostr = req.getParameter("echostr");
		System.out.println("get");
		PrintWriter out = resp.getWriter();
		if(SignUtil.checkSignature(signature,timestamp,nonce)){
			//调用核心服务类接收处理请求
			out.print(echostr);
		}
		out.close();
		out = null;



	}

	/**
	 * 请求校验与处理
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		System.out.println("===========================");
		String signature = req.getParameter("signature");
		String timestamp = req.getParameter("timestamp");
		String nonce = req.getParameter("nonce");

		PrintWriter out =resp.getWriter();
			System.out.println("sdfsdf");
		if(SignUtil.checkSignature(signature,timestamp,nonce)){
		//调用核心服务类接受处理请求
		String respXml = CoreService.processRequest(req);
		out.print(respXml);
			}
		out.close();
		out=null;

	}
}
