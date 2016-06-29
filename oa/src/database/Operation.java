package database;

import java.sql.ResultSet;

public interface Operation {
	/*
	 * 增、删、改、查，分别按sql和参数
	 * */
	int insert(String sql);
	//insert into tableName values(attributes[1], attributes[2],...);
	int insert(String tableName, String... attributes);
	
	int delete(String sql);
	//delete from tableName where requirement = value;
	int delete(String tableName, String requirement, String value);
	
	int update(String sql);
	//update tableName set setColName=setValue where reqColName=reqValue;
	int update(String tableName, String setColName, String setValue, String reqColName, String reqValue);

	ResultSet select(String sql);
	//select * from tableName where requirement = value;
	ResultSet select(String tableName, String requirement, String value);
	ResultSet selectAll(String tableName);
}
