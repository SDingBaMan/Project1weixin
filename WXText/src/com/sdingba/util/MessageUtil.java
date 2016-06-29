

package com.sdingba.util;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.sdingba.javabean.messagefromUser.Article;
import com.sdingba.javabean.messagefromUser.ImageMessage;
import com.sdingba.javabean.messagefromUser.MusicMessage;
import com.sdingba.javabean.messagefromUser.NewsMessage;
import com.sdingba.javabean.messagefromUser.TextMessage;
import com.sdingba.javabean.messagefromUser.VideoMessage;
import com.sdingba.javabean.messagefromUser.VoiceMessage;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;


public class MessageUtil {

	/**
	 * 请求消息的类型 文本
	 */
	public static final String REQ_MESSAGE_TYPE_TEXT="text";
	/**
	 * 请求消息类型 图片
	 */
	public static final String REQ_MESSAGE_TYPE_IMAGE = "image";
	/**
	 * 请求消息类型 语音
	 */
	public static final String REQ_MESSAGE_TYPE_VOICE = "voice";
	/**
	 * 请求消息类型 视频
	 */
	public static final String REQ_MESSAGE_TYPE_VIDEO = "video";
	/**
	 * 请求消息类型 地理位置
	 */
	public static final String REQ_MESSAGE_TYPE_LOCATION = "location";
	/**
	 * 请求消息类型 链接
	 */
	public static final String REQ_MESSAGE_TYPE_LINK = "link";

	/**
	 * 请求消息类型 事件的推送
	 */
	public static final String REQ_MESSAGE_TYPE_EVENT = "event";
	////////////////////////////////////////////////////////////////


	/**
	 * 事件类型  订阅 subscribe
	 */
	public static final String EVENT_MESSAGE_TYPE_SUBSCRIBE = "subscribe";

	/**
	 * 事件类型  取消订阅  unsubscribe
	 */
	public static final String EVENT_MESSAGE_TYPE_UNSUBSCRIBE = "unsubscribe";
	/**
	 * 事件类型  scan 关注用户扫描参数二维码
	 */
	public static final String EVENT_MESSAGE_TYPE_SCAN = "scan";
	/**
	 * 事件类型  scan 关注用户扫描参数二维码
	 */
	public static final String EVENT_MESSAGE_TYPE_LOCATION = "LOCATION";
	/**
	 * 事件类型  click 自定义菜单
	 */
	public static final String EVENT_MESSAGE_TYPE_CLICK = "CLICK";

	/**
	 * 响应消息类型 文本
	 */
	public static final String RESP_MESSAGE_TYPE_TEXT = "text";
	/**
	 * 响应消息类型 图片
	 */
	public static final String RESP_MESSAGE_TYPE_IMAGE = "image";

	/**
	 * 响应消息类型 语音
	 */
	public static final String RESP_MESSAGE_TYPE_VOICE  =  "voice";
	/**
	 * 响应消息类型 视频
	 */
	public static final String RESP_MESSAGE_TYPE_VIDEO = "video";
	/**
	 * 响应消息类型 音乐
	 */
	public static final String RESP_MESSAGE_TYPE_MUSIC = "music";
	/**
	 * 响应消息类型 图文
	 */
	public static final String RESP_MESSAGE_TYPE_NEWS = "news";




	/**
	 * 解析 微信 发来的请求（xml）
	 *
	 * xml - - >  MAP
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static Map<String, String> parseXml(HttpServletRequest request)
			throws Exception {
		// 将解析结果，存储在hashMap中，
		Map<String, String> map = new HashMap<String, String>();
		// 从 request 中取出输入流
		InputStream inputStream = request.getInputStream();
		// 读取输入流
		SAXReader reader = new SAXReader();
		//
		Document document = reader.read(inputStream);

		// 得到根XML元素
		Element root = document.getRootElement();
		// 得到根元素的所有子节点。
		List<Element> elementList = root.elements();

		//
		for (Element element : elementList) {
			map.put(element.getName(), element.getText());
		}
		inputStream.close();
		inputStream = null;

		return map;

	}

	/**
	 * 扩展 xsstream 使其支持 cdata
	 */
	private static XStream xstream = new XStream(new XppDriver(){
		@Override
		public HierarchicalStreamWriter createWriter(Writer out) {
			// TODO Auto-generated method stub
			return new PrettyPrintWriter(out){
				boolean cdata = true;
				@Override
				public void startNode(String name, Class clazz) {
					// TODO Auto-generated method stub
					super.startNode(name, clazz);
				}

				@Override
				protected void writeText(QuickWriter writer, String text) {
					if (cdata) {
						writer.write("<![CDATA[");
						writer.write(text);
						writer.write("]]>");
//						System.out.println(" cdate = true");
					} else {
						writer.write(text);
//						System.out.println(" cdate = false");
					}
				}

			};
		}




	});
	private static XStream xstream1 = new XStream(new XppDriver() {

		public HierarchicalStreamWriter createWrite(Writer out) {
			return new PrettyPrintWriter(out) {
				// 对所有XML节点 的转化都增加CDATA标记
				boolean cdata = true;
				@Override
				public void startNode(String name, Class clazz) {
					super.startNode(name, clazz);
				}

				protected void writeText(QuickWriter writer, String text) {
					if (cdata) {
						writer.write("<![CDATA[");
						writer.write(text);
						writer.write("]]>");
//						System.out.println(" cdate = true");
					} else {
						writer.write(text);
//						System.out.println(" cdate = false");
					}
				}

			};
		}

	});

	/**
	 * 文本消息对象，转化 XML
	 */
	public static String messageToXml(TextMessage textMessage){
		xstream.alias("xml", textMessage.getClass());
		return  xstream.toXML(textMessage);
	}

	/**
	 * 图像，消息对象 转化成 xml
	 */
	public static String messageToXml(ImageMessage imageMessage){
		xstream.alias("xml", imageMessage.getClass());
		return xstream.toXML(imageMessage);
	}
	/**
	 * 语音消息 --》 xml
	 */
	public static String messageToXml(VoiceMessage voiceMessage){
		xstream.alias("xml", voiceMessage.getClass());
		return xstream.toXML(voiceMessage);
	}
	/**
	 * 视频
	 */
	public static String messageToXml(VideoMessage videoMessage){
		xstream.alias("xml", videoMessage.getClass());
		return xstream.toXML(videoMessage);
	}

	/**
	 * 音乐
	 */
	public static String messageToXml(MusicMessage musicMessage){
		xstream.alias("xml", musicMessage.getClass());
		return xstream.toXML(musicMessage);
	}
	/**
	 * 图文消息
	 */
	public static String messageToXml(NewsMessage newsMessage){
		xstream.alias("xml", newsMessage.getClass());
		xstream.alias("item", new Article().getClass());
		return xstream.toXML(newsMessage);
	}
}