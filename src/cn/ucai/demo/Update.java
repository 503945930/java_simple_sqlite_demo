/*
 * create 2016/02/20 by littel
 * 更新数据
 */
package cn.ucai.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Update {
	public static void main(String[] args) {
		Connection connection = null;//
		Statement statement = null;
		try {
			// Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:test.db");
			System.out.println("Opened database successful");

			statement = connection.createStatement();
			String sql = "UPDATE COMPANY set SALARY = 26000.00 where ID=1;";

			statement.executeUpdate(sql);

			ResultSet rs = statement
					.executeQuery("SELECT * FROM COMPANY");
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String address = rs.getString("address");
				float salary = rs.getFloat("salary");
				System.out.println("ID = " + id);
				System.out.println("NAME = " + name);
				System.out.println("AGE = " + age);
				System.out.println("ADDRESS = " + address);
				System.out.println("SALARY = " + salary);
				System.out.println();

			}

			statement.close();
			// connection.commit();
			connection.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getClass().getName() + ";" + e.getMessage());
			System.exit(0);
		}

		System.out.println("data update successfully");
	}
}
