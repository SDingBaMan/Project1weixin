//package com.sdingba.util;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.Writer;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.dom4j.Document;
//import org.dom4j.DocumentException;
//import org.dom4j.Element;
//import org.dom4j.io.SAXReader;
//
//import com.sdingba.javabean.messagefromUser.Article;
//import com.sdingba.javabean.messagefromUser.ImageMessage;
//import com.sdingba.javabean.messagefromUser.MusicMessage;
//import com.sdingba.javabean.messagefromUser.NewsMessage;
//import com.sdingba.javabean.messagefromUser.TextMessage;
//import com.sdingba.javabean.messagefromUser.VideoMessage;
//import com.sdingba.javabean.messagefromUser.VoiceMessage;
//
//import com.thoughtworks.xstream.XStream;
//import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
//import com.thoughtworks.xstream.io.xml.XppDriver;
//import com.thoughtworks.xstream.core.util.*;
//import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
//
//public class MessageUtil2 {
//
//	/**
//	 * 解析 微信 发来的请求（xml）
//	 *
//	 * @param request
//	 * @return
//	 * @throws Exception
//	 */
//	public static Map<String, String> parseXml(HttpServletRequest request)
//			throws Exception {
//		// 将解析结果，存储在hashMap中，
//		Map<String, String> map = new HashMap<String, String>();
//		// 从 request 中取出输入流
//		InputStream inputStream = request.getInputStream();
//		// 读取输入流
//		SAXReader reader = new SAXReader();
//		//
//		Document document = reader.read(inputStream);
//
//		// 得到根XML元素
//		Element root = document.getRootElement();
//		// 得到根元素的所有子节点。
//		List<Element> elementList = root.elements();
//
//		//
//		for (Element element : elementList) {
//			map.put(element.getName(), element.getText());
//		}
//		inputStream.close();
//		inputStream = null;
//
//		return map;
//
//	}
//
//	private static XStream xstream = new XStream(new XppDriver() {
//		public HierarchicalStreamWriter createWrite(Writer out) {
//			return new PrettyPrintWriter(out) {
//				// 对所有XML节点 的转化都增加CDATA标记
//				boolean cdata = true;
//
//				public void startNode(String name, Class clazz) {
//					super.startNode(name, clazz);
//				}
//
//				protected void writeText(QuickWriter writer, String text) {
//					if (cdata) {
//						writer.write("<![CDATA[");
//						writer.write("text");
//						writer.write("]]>");
//					} else {
//						writer.write(text);
//					}
//				}
//
//			};
//		}
//
//	});
//
//	/**
//	 * 文本消息对象，转化 XML
//	 */
//	public static String messageToXml(TextMessage textMessage){
//		xstream.alias("xml", textMessage.getClass());
//		return  xstream.toXML(textMessage);
//	}
//
//	/**
//	 * 图像，消息对象 转化成 xml
//	 */
//	public static String messageToXml(ImageMessage imageMessage){
//		xstream.alias("xml", imageMessage.getClass());
//		return xstream.toXML(imageMessage);
//	}
//	/**
//	 * 语音消息 --》 xml
//	 */
//	public static String messageToXml(VoiceMessage voiceMessage){
//		xstream.alias("xml", voiceMessage.getClass());
//		return xstream.toXML(voiceMessage);
//	}
//	/**
//	 * 视频
//	 */
//	public static String messageToXml(VideoMessage videoMessage){
//		xstream.alias("xml", videoMessage.getClass());
//		return xstream.toXML(videoMessage);
//	}
//
//	/**
//	 * 音乐
//	 */
//	public static String messageToXml(MusicMessage musicMessage){
//		xstream.alias("xml", musicMessage.getClass());
//		return xstream.toXML(musicMessage);
//	}
//	/**
//	 * 图文消息
//	 */
//	public static String messageToXml(NewsMessage newsMessage){
//		xstream.alias("xml", newsMessage.getClass());
//		xstream.alias("item", new Article().getClass());
//		return xstream.toXML(newsMessage);
//	}
//}
