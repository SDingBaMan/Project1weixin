package com.sdingba.server;


import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.sdingba.javabean.messagefromUser.Article;
import com.sdingba.javabean.messagefromUser.NewsMessage;
import com.sdingba.javabean.messagefromUser.TextMessage;
import com.sdingba.tuling.TulingController;
import com.sdingba.util.MessageUtil;


public class CoreService {

	/**
	 * 核心服务。处理 数据，并且换回数据。
	 * @param request
	 * @return
	 */
	public static String processRequest(HttpServletRequest request) {
		// xml格式消息数据
		String respXml = null;
		// 默认返回文本消息内容
		String respContent = "未知数据类型";
		try {
			// 调用 parseXml 方法解析请求消息
			Map<String, String> requestMap = MessageUtil.parseXml(request);
			// 发送 账号
			String fromUserName = requestMap.get("FromUserName");
			// 开发着微信号
			String toUserName = requestMap.get("ToUserName");
			// 消息类型
			String msgType = requestMap.get("MsgType");

			// 回复文本消息
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);

			/**
			 * 信息类型
			 */
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
				//TODO 乱码   。。。
				respContent = "你发送的是 文本 消息\n";
				respContent += "帅的回复是： " ;
//				if(requestMap.get("Content").equals("n")){
//					System.out.println("xinagtong");
//				}else {
//					System.out.println("不想同");
//				}

				if(requestMap.get("Content").equals("n")){
					Article article = new Article();
					article.setTitle("开源中国");
					article.setDescription("开源中国社区成立于2008.8.8是目前最大的开源社区，"
							+ "\n\n 开源中国的dsfadfadsfadsfasdf多少发多发多少发多发的法规fgsfgaf"
							+ "dafsafad啊的发的发的嘎达"
							+ "dfadadsfadfa。\n\n"
							+ "dsjfkajdkfjad;f空间的发来快点就是拉福建阿斯顿；了大家撒裂缝空间"
							+ "打开来房间里的。");
					article.setPicUrl("");
					article.setUrl("http://m.oschina.net");
					List<Article> articleList = new ArrayList<Article>();
					articleList.add(article);
					//创建图文消息
					NewsMessage newsMessage = new NewsMessage();
					newsMessage.setToUserName(fromUserName);
					newsMessage.setFromUserName(toUserName);
					newsMessage.setCreateTime(new Date().getTime());;
					newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
					newsMessage.setArticleCount(articleList.size());
					newsMessage.setArticles(articleList);
					respXml = MessageUtil.messageToXml(newsMessage);
					return respXml;
				}else{
					//TODO 存在的问题是，有空个的时候，会出现无法返回数据，
					//提示，该公共号暂时无法提供服务，请稍后再试。
					String title = URLDecoder.decode(requestMap.get("Content"), "utf-8");
					title = title.replaceAll(" ", "");
					respContent  += new TulingController().getTulingRe(title);
				}

//				respContent = URLEncoder.encode(respContent, "UTF-8");
//				respContent = "luan ma ??";
			} else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
				respContent = "你发送的是 图片 消息\n";
				respContent += "n : 消息推送\n"
						+ "k : 没啥\n";
			} else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
				respContent = "你发送的是 语音 消息";
			} else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)) {
				respContent = "你发送的是 视频 消息";
			} else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
				respContent = "你发送的是 地址 消息";
			} else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
				respContent = "你发送的是链接片 消息";
				//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			}	else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) { 						//事件推送
				//事件类型
				String eventType = requestMap.get("Event");

				//关注
				if (eventType.equals(MessageUtil.EVENT_MESSAGE_TYPE_SUBSCRIBE)) {
					respContent = "hello ,欢迎关注公告号，我们致力打招最好的东西给你，"
							+ "从现在开始,以修复部公共 20160331 ！！！" ;
					textMessage.setContent(respContent);
					respXml = MessageUtil.messageToXml(textMessage);
					return respXml;
					//将消息对象转化成xml
					//respXml = MessageUtil.messageToXml(textMessage);
				}else if (eventType.equals(MessageUtil.EVENT_MESSAGE_TYPE_UNSUBSCRIBE)) {
					//TODO 取消订阅后，用户不会在收到公共账号发送的消息，因此不需要回复
				}else if (eventType.equals(MessageUtil.EVENT_MESSAGE_TYPE_SCAN) ){
					//TODO 处理二维码扫描事件；
					respContent = "二维码扫";
				}else if (eventType.equals(MessageUtil.EVENT_MESSAGE_TYPE_LOCATION)) {
					//TODO 处理上报的地理位置事件
					respContent = "地理位置事件";
				}else if (eventType.equals(MessageUtil.EVENT_MESSAGE_TYPE_CLICK)) {
					//TODO 处理菜单单击事件
					//事件key值，与创建菜单的key值对应

					String eventKey = requestMap.get("EventKey");
					if(eventKey.equals("oschina")){

						Article article = new Article();
						article.setTitle("开源中国");
						article.setDescription("开源中国社区成立于2008.8.8是目前最大的开源社区，"
								+ "\n\n 开源中国的dsfadfadsfadsfasdf多少发多发多少发多发的法规fgsfgaf"
								+ "dafsafad啊的发的发的嘎达"
								+ "dfadadsfadfa。\n\n"
								+ "dsjfkajdkfjad;f空间的发来快点就是拉福建阿斯顿；了大家撒裂缝空间"
								+ "打开来房间里的。");
						article.setPicUrl("");
						article.setUrl("http://m.oschina.net");

						Article article2 = new Article();
						article2.setTitle("开源中国");
						article2.setDescription("dkfajldjfjgj;ajdfljd 安静就放假啊的积分卡倒计时疯狂"
								+ "的奶粉克拉克；了"
								+ "的刷卡的激发4"
								+ "报告发掘地根据"
								+ "建安费； "
								+ "的深刻了激发的经费拉附近路东方了看见");
						article2.setPicUrl("");

						article2.setUrl("");


						List<Article> articleList = new ArrayList<Article>();

						articleList.add(article);
						articleList.add(article2);
						//创建图文消息
						NewsMessage newsMessage = new NewsMessage();
						newsMessage.setToUserName(fromUserName);
						newsMessage.setFromUserName(toUserName);
						newsMessage.setCreateTime(new Date().getTime());;
						newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
						newsMessage.setArticleCount(articleList.size());
						newsMessage.setArticles(articleList);


						respXml = MessageUtil.messageToXml(newsMessage);
						return respXml;

					}else if (eventKey.equals("iteye")) {
						respContent = "iteye  事件";
						textMessage.setContent("Iteye 创办于 2003,9.javaEye,从最初的讨论java技术为主的技术"
								+ "论坛，已朱静发展成为涵盖整个软件开发领域的综合性网站、\n\n"
								+ "http://www.iteye.com");
						respXml = MessageUtil.messageToXml(textMessage);
						return respXml;
					}
//					else {
//						respContent = "else limian ";
//						//设置文本消息 内容
////						textMessage.setContent("sdsdasda");
////						//将文本消息转化成xml
////						respXml = MessageUtil.messageToXml(textMessage);
//					}
//					respContent = "ccccc";
				}
			}



//			//设置文本消息 内容
			textMessage.setContent(respContent);
			//将文本消息转化成xml
			respXml = MessageUtil.messageToXml(textMessage);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return respXml;
	}
}
