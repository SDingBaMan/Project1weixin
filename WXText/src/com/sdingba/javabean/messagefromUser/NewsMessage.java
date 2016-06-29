package com.sdingba.javabean.messagefromUser;

import java.util.List;



public class NewsMessage extends BaseMessage{
	//图文消息个数，限制 10 以内
	private int ArticleCount;
	//多消息图文消息信息，默认第一个为item为大图
	private List<Article> Articles;

	public int getArticleCount() {
		return ArticleCount;
	}
	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}
	public List<Article> getArticles() {
		return Articles;
	}
	public void setArticles(List<Article> articles) {
		Articles = articles;
	}

}
