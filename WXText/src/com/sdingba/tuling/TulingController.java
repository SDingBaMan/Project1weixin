package com.sdingba.tuling;

import net.sf.json.JSONObject;

/**
 * 鍥剧伒鏈哄櫒浜烘帴鍙ｆ祦绋嬫帶鍒剁被
 * @author pamchen-1
 *
 */
public class TulingController {
	/**
	 * 璋冪敤鍥剧伒鏈哄櫒浜烘帴鍙ｏ紝骞惰繑鍥炴墍闇?唴瀹?
	 * @param info
	 * @return
	 */
	public String getTulingRe(String info){
		//调用图灵机器人接口api，获取结果
		//http://www.tuling123.com/openapi/api   key:42bca29888818ceea7a214eaadbeb9e7
//				String url = "http://www.tuling123.com/openapi/api?key=需要去图灵官网注册获取&info="+info;
		String url = "http://www.tuling123.com/openapi/api?key=42bca29888818ceea7a214eaadbeb9e7&info="+info;
		String tlResult = HttpGetRequest.get(url);

		//瑙ｆ瀽鍥剧伒缁撴灉鏁版嵁锛屾彁鍙栨墍闇?唴瀹?
		JSONObject json = JSONObject.fromObject(tlResult);
		tlResult = json.getString("text");

		return tlResult;

	}
}
