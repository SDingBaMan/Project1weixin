package com.wwkj.utils;

import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;
 
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceManager {
	//private static DataSource ds;
//	static{
//		try{
//			InputStream in = DataSourceManager.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
//			//使用DBCP实现的数据源
//			Properties props = new Properties();
//			props.load(in);
//			BasicDataSourceFactory factory = new BasicDataSourceFactory();
//			ds = factory.createDataSource(props);
//		}catch(Exception e){
//			throw new ExceptionInInitializerError();
//		}
//	}
//	public static DataSource getDataSource(){
//		return ds;
//	}
	
	private static DataSource dataSource = new ComboPooledDataSource();
	
	public static DataSource getDataSource() {
		return dataSource;
	}

//	/**
//	 * ��DBUtils��Ҫ�ֶ���������ʱ�����ø÷������һ������?
//	 * 
//	 * @return
//	 * @throws SQLException
//	 */
//	public static Connection getConnection() throws SQLException {
//		return dataSource.getConnection();
//	}
//	
	
}
