package com.wwkj.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.wwkj.utils.DataSourceManager;

 

/**
 * 查询分类列表
 * @author YUY
 *
 */
public class CategoryDaoImpl {
	private QueryRunner runner = new QueryRunner(DataSourceManager.getDataSource());
	/**
	 *	获取分类列表
	 */
	public List<Map<String,Object>> getCategory(int version){
		/**
		 * 
			{
			"id":"1",
			"isleafnode":false,
			"name":"奶粉,
			"parentId":"0",
			"pic":"",
			"tag":"孕妇奶粉   幼儿奶粉"
			},
		 */
		String sql = "select id,parentid,name,isleafnode,tag,pic_id from category where state=1 and version>?";
		try {
			return runner.query(sql, new MapListHandler(), 1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
