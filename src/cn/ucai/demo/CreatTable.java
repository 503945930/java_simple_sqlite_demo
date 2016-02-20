/*
 * create 2016/02/20 by littel
 * 创建数据表
 */
package cn.ucai.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class CreatTable {
	public static void main(String[] args) {
		Connection connection = null;//
		Statement statement = null;
		try {
			//Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:test.db");
			System.out.println("Opened database successful");

			statement = connection.createStatement();
			String sql = "CREATE TABLE COMPANY "
					+ "(ID INT PRIMARY KEY NOT NULL," + "NAME   TEXT NOT NULL,"
					+ "AGE  INT NOT NULL," + "ADDRESS  CHAR(50),"
					+ "SALARY  REAL)";
			
			statement.executeUpdate(sql);
			statement.close();
			connection.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getClass().getName()+";"+e.getMessage());
			System.exit(0);
		}
		
		System.out.println("Table created successfully");
	}

}
