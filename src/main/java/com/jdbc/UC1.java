package com.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.sql.*;
import java.util.Enumeration;

/* 1. import 
 * 2. load and register the driver
 * 3. create connection
 * 4. create a statement
 * 5. execute a query
 * 6. process the results
 * 7. close the connection
 */

public class UC1
{
	public static void main(String[] args)
	{
		String url="jdbc:mysql://localhost:3306/payroll_services";
		String user="root";
		String password="1234";
		Connection con=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver is loaded");

			
		}
		catch (Exception e)
		{
			System.out.println(e);
			e.printStackTrace();
			// TODO: handle exception
		}
		try
		{
			con=DriverManager.getConnection(url, user, password);
			System.out.println("DB is connected");


		} 

		catch (Exception e)
		{
			System.out.println(e);

			// TODO: handle exception
		}
		try
		{
			if(con !=null)
			{
				con.close();
				System.out.println("connection disconnected");

			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		listDrivers();
		

	}
	private static void listDrivers()
	{
		Enumeration<Driver> driverList=DriverManager.getDrivers();
		while(driverList.hasMoreElements())
		{
			Driver DriverClass=(Driver) driverList.nextElement();
			System.out.println(" "+DriverClass.getClass().getName());
		}
	}
	
	

}
