/*
 * create 2016/02/20 by littel
 */
package cn.ucai.demo;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class ConnectionDB {
	 public static void main(String[] args) {
		 Connection connection=null;
		 try {
			//Class.forName("org.sqlite.JDBC");
			 
			//创建数据库连接
			connection=DriverManager.getConnection("jdbc:sqlite:test.db");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getClass().getName()+";"+e.getMessage());
			System.exit(0);
		}
		 System.out.println("opened database successful");
	}
}
