package com.sdingba.util;

import com.sdingba.javabean.messagefromUser.Article;
import com.sdingba.javabean.messagefromUser.Music;




import net.sf.json.JSONObject;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class CustomMessage {
	private static Logger log =  LoggerFactory.getLogger(CommonUtil.class);

	/**
	 * 客服的接口。
	 */
	/**
	 * 发送客服消息
	 * @param accessToken	借口访问凭证
	 * @param jsonMsg json 格式的客服消息。消息内容，
	 * @return	boolean
	 */
	public static boolean sendCustomMessage(String accessToken,
											String jsonMsg){
		log.info("消息内容：{}",jsonMsg);
		boolean result = false;
		//拼接请求地址
		String requestUrl = "https://api.weixin.qq.com/cgi-bin/message"
				+ "custom/send?access_token=ACCESS_TOKEN";
		requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken);
		//发送客服消息
		JSONObject jsonObject = CommonUtil.httpRequest(requestUrl, "POST", jsonMsg);
		if(jsonObject != null){
			int errorCode = jsonObject.getInt("errcode");
			String errorMsg = jsonObject.getString("errmsg");
			if (errorCode == 0) {
				result = true;
				log.info("客服消息成功 errcode:{} errmsg :{}",errorCode,errorMsg);
			}else{
				log.info("客服消息失败 errcode:{} errmsg :{}",errorCode,errorMsg);
			}
		}
		return result;
	}





	/**
	 * 组装 文本客服消息
	 * @param openId 消息发送的对象
	 * @param content  文本消息内容
	 * @return
	 */
	public static String makeTextCustomMessage(String openId,
											   String content){
		//对消息 内容的双引号进行转意
		content = content.replace("\"", "\\\"");
		String jsonMsg = "{\"touser\":\"%s\",\"msgtype\":\"text"
				+ "\",\"text\":{\"content\":\"%s\"}}";
		return String.format(jsonMsg, openId,content);
	}

	/**
	 * 组装 图片 客服消息
	 * @param openId 发送对象
	 * @param mediaId	媒体文件Id
	 * @return
	 */
	public static String makeImageCustomMessage(String openId,
												String mediaId){
		String jsonMsg = "{\"touser\":\"%s\",\"msgtype\":\"image\","
				+ "\"image\":{\"media_id\":\"%s\"}}";
		return String .format(jsonMsg, openId,mediaId);
	}

	/**
	 * 组装 语音客服消息
	 * 发送对象
	 *
	 */
	public static String makeVoiceCustomMessage(String openId,String
			mediaId){
		String jsonMsg = "{\"touser\":\"%s\",\"msgtype\":\"voice\","
				+ "\"voice\":{\"media_id\":\"%s\"}}";
		return String.format(jsonMsg, openId,mediaId);

	}

	/**
	 * 组装 视频消息
	 * @param openId 对象
	 * @param mediaId	媒体文件id
	 * @param thumbMediaId	视频消息缩略图的媒体Id
	 * @return
	 */
	public static String makeVideoCustomMessage(String openId,
												String mediaId,String thumbMediaId){
		String jsonMsg ="{\"touser\":\"%s\",\"msgtype\":\"video\","
				+ "\"video\":{\"media_id\":\"%s\",\"thumb_media_id\""
				+ ":\"%s\"}";
		return String.format(jsonMsg,openId,mediaId,thumbMediaId);
	}

	/**
	 * 组装 音乐 客服 消息
	 * @param openId 对象
	 * @param music	音乐对象
	 * @return
	 */
	public static String makeMusicCustomMessage(String openId,Music music){
		String jsonMsg = "{\"touser\":\"%s\",\"msgtype\":\"music\","
				+ "\"music\":%s}";
		jsonMsg = String.format(jsonMsg, openId,JSONObject.fromObject(music).toString());
		//将jsonMsg 中的 thumbMedia 代替 thumd_media_id
		jsonMsg = jsonMsg.replace("thumdmedia", "thumd_media_id");
		return jsonMsg;
	}

	/**
	 * 组装 图片客服 消息
	 * @param openId	消息发送的对象
	 * @param articleList	图片消息的列表
	 * @return
	 */
	public static String makeNewsCustomMessage(String openId,
											   List<Article> articleList ){
		String jsonMsg = "{\"touser\":\"%s\",\"msgtype\":\"news\","
				+ "\"news\":{\"artcles\":%s}}";
		jsonMsg = String.format(jsonMsg, openId,JSONObject.fromObject(articleList).toString()
				.replaceAll("\"", "\\\""));
		// 将 jsonMsg 中的 picUrl 替换 picurl
		jsonMsg = jsonMsg.replace("picUrl", "picurl");
		return jsonMsg;
	}


	@Test
	public void test(){
		//获取 接口的访问凭证
		String accessToken = CommonUtil.getToken("wx93e91219b1d0f4ca", "d5d5f87b1027b7e007f4410eb7e4cb4e").getAccessToken();
		System.out.println(accessToken);
		System.out.println();
		//组装 文本客服的消息
		String jsonTextMsg = makeTextCustomMessage("oEdzejiHCDqafJbz4WNJtWTMbDcE", "测试发送客服消息");

		sendCustomMessage(accessToken, jsonTextMsg);
	}
}
