package com.jdbc;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
public class UC7
{
		public static void qury() throws Exception
		{
			String url="jdbc:mysql://localhost:3306/payroll_services";
			String user="root";
			String password="1234";
			Connection con=null;
			PreparedStatement ps=null;
			String qry="select sum(basic_pay) from employee_payroll where gender='m' group by gender";
			String qry1="select avg(basic_pay) from employee_payroll where gender='m' group by gender";
			String qry2="select max(basic_pay) from employee_payroll where gender='m' group by gender";
			String qry3="select min(basic_pay) from employee_payroll where gender='m' group by gender";

				
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver is loaded");

				
				con=DriverManager.getConnection(url, user, password);
				System.out.println("DB is connected");
				ps=con.prepareStatement(qry);
				ResultSet res=ps.executeQuery();
				res.next();
				Double basic_pay=res.getDouble("sum(basic_pay)");
				System.out.println(basic_pay);
				
				ps=con.prepareStatement(qry1);
				ResultSet res1=ps.executeQuery();
				res1.next();
				Double basic_pay1=res1.getDouble("avg(basic_pay)");
				System.out.println(basic_pay1);
				
				ps=con.prepareStatement(qry2);
				ResultSet res2=ps.executeQuery();
				res2.next();
				Double basic_pay2=res2.getDouble("max(basic_pay)");
				System.out.println(basic_pay2);
				
				ps=con.prepareStatement(qry3);
				ResultSet res3=ps.executeQuery();
				res3.next();
				Double basic_pay3=res3.getDouble("min(basic_pay)");
				System.out.println(basic_pay3);
				
				System.out.println("data is retrived  from the DB");
				ps.close();
				con.close();
				System.out.println("connection closed");


						}

		public static void main(String[] args) throws Exception
		{
			qury();
		}
}

