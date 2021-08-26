package com.jdbc;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
public class UC4_Refactor
{
		public static void qury() throws Exception
		{
			String url="jdbc:mysql://localhost:3306/payroll_services";
			String user="root";
			String password="1234";
			Connection con=null;
			PreparedStatement ps=null;
			String qry="select name from employee_payroll where id=1;";
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver is loaded");

				
				con=DriverManager.getConnection(url, user, password);
				System.out.println("DB is connected");
				ps=con.prepareStatement(qry);
				ResultSet res=ps.executeQuery();
				res.next();
				String names=res.getString("name");
				System.out.println(names);

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

