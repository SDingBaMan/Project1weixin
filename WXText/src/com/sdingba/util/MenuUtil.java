package com.sdingba.util;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sdingba.javabean.Menu;

public class MenuUtil {
	private static Logger logger = LoggerFactory.getLogger(MenuUtil.class);

	// 创建菜单（post）
	public final static String menu_create_url = ""
			+ "https://api.weixin.qq.com/cgi-bin/menu/create?access_token"
			+ "=ACCESS_TOKEN";
	// 菜单查询（get）

	public final static String menu_get_url = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token="
			+ "ACCESS_TOKEN";

	// 菜单删除（GET）
	public final static String menu_delete_url = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token"
			+ "=ACCESS_TOKEN";

	/**
	 * 创建 菜单
	 * @param menu 菜单对象
	 * @param accessToken 凭证
	 * @return 返回是否 成功或者失败
	 */
	public static boolean createMenu(Menu menu, String accessToken) {
		boolean result = false;
		String url = menu_create_url.replace("ACCESS_TOKEN", accessToken);
		// 菜单 对象 转化 成 json字符串
		String jsonMenu = JSONObject.fromObject(menu).toString();
		System.out.println(jsonMenu);
		// 发送post请求
		JSONObject jsonObject = CommonUtil.httpRequest(url, "POST", jsonMenu);

		if (jsonObject != null) {
			int errorCode = jsonObject.getInt("errcode");
			String errorMsg = jsonObject.getString("errmsg");
			if (0 == errorCode) {
				result = true;
			} else {
				result = false;
				logger.error("创建菜单失败 errorCode : {} errmsg : {}", errorCode,
						errorMsg);
			}
		}

		return result;
	}

	/**
	 * 查询 菜单
	 * @param accessToken
	 * @return
	 */
	public static String getMenu(String accessToken){
		String result = null;
		String requestUrl = menu_get_url.replace("ACCESS_TOKEN", accessToken);
		//发起get请求
		JSONObject jsonObject = CommonUtil.httpRequest(requestUrl, "GET", null);
		if(null != jsonObject){
			result = jsonObject.toString();
		}
		return result;
	}

	/**
	 * 删除 菜单 功能
	 * @param accessToken
	 * @return
	 */
	public static boolean deleteMenu(String accessToken){
		boolean result = false;
		String requestUrl = menu_delete_url.replace("ACCESS_TOKEN",accessToken);
		// 
		JSONObject jsonObject = CommonUtil.httpRequest(requestUrl, "GET",null);
		if(jsonObject != null){
			int errorCode = jsonObject.getInt("errcode");
			String errorMsg = jsonObject.getString("errmsg");
			if(errorCode == 0){
				result = true;
			}else{
				result = false;
			}
		}

		return result;
	}





}
