package com.ischoolbar.programmer.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.management.loading.PrivateClassLoader;
/**
 * 
 * @author llq
 *���ݿ���util
 */
public class DbUtil {

	private String dbUrl = "jdbc:mysql://rm-uf6rwf8hb58nl4o893o.mysql.rds.aliyuncs.com:3306/db_student_manager_web?useUnicode=true&characterEncoding=utf8";
	private String dbUser = "cyy";
	private String dbPassword = "Cyy19970306";
	private String jdbcName = "com.mysql.jdbc.Driver";
	private Connection connection = null;
	public Connection getConnection(){
		try {
			Class.forName(jdbcName);
			connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
//			System.out.println("连接成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			System.out.println("连接失败");
			e.printStackTrace();
		}
		return connection;
	}
	
	public void closeCon(){
		if(connection != null)
			try {
				connection.close();
//				System.out.println("数据库关闭");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DbUtil dbUtil = new DbUtil();
		dbUtil.getConnection();
	}

}
