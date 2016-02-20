/*
 * create 2016/02/20 by littel
 * 新增数据
 */
package cn.ucai.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Insert {
	public static void main(String[] args) {
		Connection connection = null;//
		Statement statement = null;
		try {
			// Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:test.db");
			System.out.println("Opened database successful");

			statement = connection.createStatement();
			String sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
					+ "VALUES (1, 'Paul', 32, 'California', 20000.00 );";
			statement.executeUpdate(sql);

			sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
					+ "VALUES (2, 'Allen', 25, 'Texas', 15000.00 );";
			statement.executeUpdate(sql);

			sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
					+ "VALUES (3, 'Teddy', 23, 'Norway', 20000.00 );";
			statement.executeUpdate(sql);

			sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
					+ "VALUES (4, 'Mark', 25, 'Rich-Mond ', 65000.00 );";

			statement.executeUpdate(sql);
			statement.close();
			//connection.commit();
			connection.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getClass().getName() + ";" + e.getMessage());
			System.exit(0);
		}

		System.out.println("data insert successfully");
	}
}
