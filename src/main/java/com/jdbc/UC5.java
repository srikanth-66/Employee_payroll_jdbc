package com.jdbc;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
public class UC5
{
		public static void qury() throws Exception
		{
			String url="jdbc:mysql://localhost:3306/payroll_services";
			String user="root";
			String password="1234";
			Connection con=null;
			PreparedStatement ps=null;
			String qry="select basic_pay from employee_payroll where name='srikanth'";
			String qry1="select name from employee_payroll where start between cast('2018-01-01'as date) and date(now())";

				
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver is loaded");

				
				con=DriverManager.getConnection(url, user, password);
				System.out.println("DB is connected");
				ps=con.prepareStatement(qry);
				ResultSet res=ps.executeQuery();
				res.next();
				Double basic_pay=res.getDouble("basic_pay");
				System.out.println(basic_pay);
				
				ps=con.prepareStatement(qry1);
				ResultSet res1=ps.executeQuery();
				res1.next();
				String	empnames =res1.getString("name");
				System.out.println(empnames);
				

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

