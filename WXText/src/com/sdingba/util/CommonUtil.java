package com.sdingba.util;





import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;
import java.security.SecureRandom;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import net.sf.json.JSONObject;

//import org.junit.Test;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import com.sdingba.javabean.Token;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CommonUtil {
	//	"wx93e91219b1d0f4ca";
//	private static String Secret="d5d5f87b1027b7e007f4410eb7e4cb4e";
	private static final String Appid = "wx93e91219b1d0f4ca";
	private static final String Secret = "d5d5f87b1027b7e007f4410eb7e4cb4e";
	private static Logger logger =  LoggerFactory.getLogger(CommonUtil.class);
	//获取凭证
	public final static String token_url = "https://api.weixin.qq.com/cgi-bin/token?"
			+ "grant_type=client_credential&appid=APPID&secret=APPSECRET";

	/**
	 * 发送 https 请求
	 * @param requestUrl  访问的url
	 * @param requestMethod GET/POST
	 * @param outputStr 是否有输出的数据流
	 * @return JSON对象。服务器返回的数据，json对象
	 */
	public static JSONObject httpRequest(String requestUrl,String requestMethod,
										 String outputStr){
		JSONObject jsonObject = null;
		try {
			//创建SSL对象
			TrustManager[] tm = {new MyX509TrustManager()};
			SSLContext sslContext = SSLContext.getInstance("SSL","SunJSSE");
			sslContext.init(null,  tm, new SecureRandom());

			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection conn =(HttpsURLConnection) url.openConnection();
			conn.setSSLSocketFactory(ssf);

			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			//设置请求方式（get post）
			conn.setRequestMethod(requestMethod);
			//当 outputStr 不为null是 。想输出流写数据
			if(null != outputStr){
				OutputStream outputStream = conn.getOutputStream();
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();

			}
			//从输入流中读取返回的数据
			InputStream inputStream = conn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String str = "";
			StringBuffer buffer = new StringBuffer();
			while ((str = bufferedReader.readLine())!= null) {
				buffer.append(str);
			}
			//释放资源
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			inputStream = null;
			conn.disconnect();
			jsonObject = JSONObject.fromObject(buffer.toString());




		} catch(ConnectException ceException){
			logger.error("链接超过时间：{}",ceException);
		}catch (Exception e) {
			logger.error("https 异常 ：{}",e);
		}



		return jsonObject;

	}

	/**
	 * 获取接口访问的凭证
	 * @param appid
	 * @param appsecret
	 * @return Token的对象数据
	 */
	public static Token getToken(String appid,String appsecret){
		Token token = null;
		String  requestUrl = token_url.replace("APPID", appid).replace(
				"APPSECRET",appsecret);

		JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
		if(jsonObject != null){
			try {
				token = new Token();
				token.setAccessToken(jsonObject.getString("access_token"));
				token.setExpiresIn(jsonObject.getInt("expires_in"));
			} catch (Exception e) {
				token = null;
				logger.error("获取 token 失败，errcode : {} errmsg {}",
						jsonObject.getInt("errcode"),jsonObject.getString("errmsg"));
			}

		}
		return token;

	}

	@Test
	public void test1(){
		CommonUtil aa = new CommonUtil();
		Token token  = aa.getToken(Appid,Secret );
		System.out.println("获取成功");
		System.out.println(token.getAccessToken().toString());
		System.out.println(token.getExpiresIn()+"");
	}








}
