package com.sdingba.util;


import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *c3p0 管理池 单例类
 *。
 * @author su
 *
 */
public class DaoUtils {
	private static DataSource source = new ComboPooledDataSource();
	private DaoUtils() {
	}

	public static DataSource getSource(){
		return source;
	}

	public static Connection getConn(){
		try {
			return source.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
