package com.wwkj.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.wwkj.utils.DataSourceManager;

 
/**
 * 查询商品评论信息
 * @author YUY
 *
 */
public class CommentDaoImpl {
	private QueryRunner runner = new QueryRunner(DataSourceManager.getDataSource());
	/**
	 *	获取商品评论信息
	 */
	public List<Map<String,Object>> getComment(String productId){
		/**
		 * 
			  {
			    "title":"东西不错",             //评论标题
			    "content":"东西不错",          //评论内容
			    "username":"用户",            //评论用户
			    "time":"2001-12-24 23:00:00"    //评论时间
			},
			{
			    "title":"东西不错",             //评论标题
			    "content":"东西不错",          //评论内容
			    "username":"用户",            //评论用户
			    "time":"2001-12-24 23:00:00"    //评论时间
			}
			"list_count":"1500"         //评论总数
		 */
		String sql = "select id,title,content,username,time,listcount from comment where product_id=?";
		try {
			return runner.query(sql, new MapListHandler(),productId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
