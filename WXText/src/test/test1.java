package test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class test1 {
	/**
	 * post请求
	 *
	 * @param url
	 *            请求地址
	 * @param param
	 *            请求的内容
	 * @return 接口返回的内容
	 */
	private static String post(String url, String param) {
		try {
			HttpPost request = new HttpPost(url);
			request.setEntity(new StringEntity(param));
			HttpResponse response = HttpClients.createDefault()
					.execute(request);

			// 根据返回码判断请求是否成功
			if (200 == response.getStatusLine().getStatusCode()) {
				return EntityUtils.toString(response.getEntity());
			}
			return "";
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	/*
	 * <xml>
	 	* <ToUserName><![CDATA[fromUser]]></ToUserName>
		 * <FromUserName><![CDATA[Alphabet]]></FromUserName>
		 * <CreateTime>1459066680654</CreateTime>
		 * <MsgType>< ![CDATA[text]]></MsgType>
		 * <Content><![CDATA[你也好 嘻嘻]]></Content>
	 * </xml>
	 */

	public static void main(String[] args) throws UnsupportedEncodingException {
		String content = URLEncoder.encode("你 好 ", "UTF-8");
		//<ToUserName><![CDATA[Alphabet]]></ToUserName>"              公共号
		//"<FromUserName><![CDATA[SDingBa]]></FromUserName>"     普通用户
		String param = "<xml><ToUserName><![CDATA[Alphabet]]></ToUserName>"
				+ "<FromUserName><![CDATA[SDingBa]]></FromUserName>"
				+ "<CreateTime>1348831860</CreateTime>"
				+ "<MsgType><![CDATA[text]]></MsgType>"
				+ "<Content><![CDATA["
				+ content
				+ "]]></Content>"
				+ "<MsgId>1234567890123456</MsgId></xml>";
		String url = "http://localhost:8080/WXText/CoreServlet.do";

		String result = post(url, param);
		System.err.println("回来的数据 ： \n\n");
		System.out.println(result);
	}

}