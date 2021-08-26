package com.jdbc;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
//import java.sql.*;
public class UC3
{
		public static void qury() throws Exception
		{
			String url="jdbc:mysql://localhost:3306/payroll_services";
			String user="root";
			String password="1234";
			Connection con=null;
			Statement st=null;
			String qry="update  employee_payroll set basic_pay=590000 where id=1;;";
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver is loaded");

				
				con=DriverManager.getConnection(url, user, password);
				System.out.println("DB is connected");
				st=con.createStatement();
				int res=st.executeUpdate(qry);
				System.out.println("data is inserted in the DB");
				st.close();
				con.close();
				System.out.println("connection closed");


						}

		public static void main(String[] args) throws Exception
		{
			qury();
		}
}

