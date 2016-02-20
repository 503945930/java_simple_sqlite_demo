/*
 * create 2016/02/20 by littel
 * 查询数据
 */
package cn.ucai.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Select {
	public static void main(String[] args) {
		Connection connection = null;//
		Statement statement = null;
		try {
			// Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:test.db");
			System.out.println("Opened database successful");

			statement = connection.createStatement();
			// * 代表查询所有字段
			ResultSet rs = statement.executeQuery("SELECT * FROM COMPANY");
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

			System.out.println("---------------");

			// 查询指定字段
			ResultSet rs1 = statement
					.executeQuery("SELECT COMPANY.ID,COMPANY.NAME FROM COMPANY");
			while (rs1.next()) {
				int id = rs1.getInt("id");
				String name = rs1.getString("name");
				System.out.println("ID = " + id);
				System.out.println("NAME = " + name);
			}

			System.out.println("---------------");

			// * where 查询
			ResultSet rs2 = statement
					.executeQuery("SELECT * FROM COMPANY WHERE ID=3");
			while (rs2.next()) {
				int id = rs2.getInt("id");
				String name = rs2.getString("name");
				int age = rs2.getInt("age");
				String address = rs2.getString("address");
				float salary = rs2.getFloat("salary");
				System.out.println("ID = " + id);
				System.out.println("NAME = " + name);
				System.out.println("AGE = " + age);
				System.out.println("ADDRESS = " + address);
				System.out.println("SALARY = " + salary);
				System.out.println();

			}

			System.out.println("like---------------");
			// * like 查询
			// 百分号（%）代表零个、一个或多个数字或字符。下划线（_）代表一个单一的数字或字符。这些符号可以被组合使用。
			ResultSet rs3 = statement
					.executeQuery("SELECT * FROM COMPANY WHERE NAME LIKE  'pa%' ");
			while (rs3.next()) {
				int id = rs3.getInt("id");
				String name = rs3.getString("name");
				int age = rs3.getInt("age");
				String address = rs3.getString("address");
				float salary = rs3.getFloat("salary");
				System.out.println("ID = " + id);
				System.out.println("NAME = " + name);
				System.out.println("AGE = " + age);
				System.out.println("ADDRESS = " + address);
				System.out.println("SALARY = " + salary);
				System.out.println();

			}

			System.out.println("Glob---------------");

			// * Glob 查询
			// 星号（*）代表零个、一个或多个数字或字符。问号（?）代表一个单一的数字或字符。这些符号可以被组合使用。
			// 与 LIKE 运算符不同的是，GLOB 是大小写敏感的
			ResultSet rs4 = statement
					.executeQuery("SELECT * FROM COMPANY WHERE NAME Glob  'Pa*' ");
			while (rs4.next()) {
				int id = rs4.getInt("id");
				String name = rs4.getString("name");
				int age = rs4.getInt("age");
				String address = rs4.getString("address");
				float salary = rs4.getFloat("salary");
				System.out.println("ID = " + id);
				System.out.println("NAME = " + name);
				System.out.println("AGE = " + age);
				System.out.println("ADDRESS = " + address);
				System.out.println("SALARY = " + salary);
				System.out.println();

			}

			System.out.println("and or---------------");

			// * and or 查询 条件查询
			
			
			
			
			

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

/*
 * 只是列举出常用查询 
 * 其余查询  limit、order by 、 group by 、having 、distinct 、
 * 后面再加入
 */

