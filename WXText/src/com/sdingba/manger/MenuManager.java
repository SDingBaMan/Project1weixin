package com.sdingba.manger;



import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.css.ViewCSS;

import com.sdingba.contecst.Contact;
import com.sdingba.javabean.Button;
import com.sdingba.javabean.ClickButton;
import com.sdingba.javabean.ComplexButton;
import com.sdingba.javabean.Menu;
import com.sdingba.javabean.Token;
import com.sdingba.javabean.ViewButton;
import com.sdingba.util.CommonUtil;
import com.sdingba.util.MenuUtil;

public class MenuManager {

//	private static final String Appid = "wx93e91219b1d0f4ca";
//	private static final String Secret = "d5d5f87b1027b7e007f4410eb7e4cb4e";

	private static Logger logger = LoggerFactory.getLogger(MenuManager.class);
	/**
	 * 自定义  菜单 栏
	 * @return
	 */
	private static Menu getMenu(){
		ClickButton btn11 = new ClickButton();
		btn11.setName("开源中国");
		btn11.setType("click");
		btn11.setKey("oschina");

		ClickButton btn12 = new ClickButton();
		btn12.setName("ITeye");
		btn12.setType("click");
		btn12.setKey("iteye");

		ViewButton btn13 = new ViewButton();
		btn13.setName("CocoaChina");
		btn13.setType("view");
		btn13.setUrl("http://www.iteye.com");

		ViewButton btn21 = new ViewButton();
		btn21.setName("taobao");
		btn21.setType("view");
		btn21.setUrl("http://m.toabao.com");

		ViewButton btn22 = new ViewButton();
		btn22.setName("jingdong");
		btn22.setType("view");
		btn22.setUrl("http://m.jd.com");

		ViewButton btn23 = new ViewButton();
		btn23.setName("唯品会");
		btn23.setType("view");
		btn23.setUrl("http://m.vipshop.com");

		ViewButton btn24 = new ViewButton();
		btn24.setName("当当网");
		btn24.setType("view");
		btn24.setUrl("http://m.dangdang.com");

		ViewButton btn31= new ViewButton();
		btn31.setName("多泡");
		btn31.setType("view");
		btn31.setUrl("http://www.duopao.com");

		ViewButton btn32= new ViewButton();
		btn32.setName("一窝88");
		btn32.setType("view");
		btn32.setUrl("http://www.yi588.com");

		ComplexButton mainbtn1 = new ComplexButton();
		mainbtn1.setName("技术交流");
		mainbtn1.setSub_button(new Button[]{btn11,btn12,btn13});

		ComplexButton mainbtn2 = new ComplexButton();
		mainbtn2.setName("购物");
		mainbtn2.setSub_button(new Button[]{btn21,btn22,btn23,btn24});

		ComplexButton mainbtn3 = new ComplexButton();
		mainbtn3.setName("网页游戏");
		mainbtn3.setSub_button(new Button[]{btn31,btn32});

		Menu menu = new Menu();
		menu.setButton(new Button[]{mainbtn1,mainbtn2,mainbtn3});

		return menu;
	}

	public static void main(String[] args) {
		Token token =  CommonUtil.getToken(Contact.appID, Contact.appsecret);
		if(token != null){
			System.out.println("凭证：");
			System.out.println(token.getAccessToken().toString());
			boolean result = MenuUtil.createMenu(getMenu(), token.getAccessToken());
			//
			if(result){
				logger.info("菜单创建成功！！！");
			}else{
				logger.info("菜单创建失败！！！");
			}
		}
	}

	@Test
	public void test(){
		Token token =  CommonUtil.getToken(Contact.appID, Contact.appsecret);
		if(token != null){
			System.out.println("凭证：");
			System.out.println(token.getAccessToken().toString());
			String aaString = MenuUtil.getMenu(token.getAccessToken());
			System.out.println(aaString);
		}
	}
}
