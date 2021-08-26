package com.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
//import java.sql.*;
public class UC2
{
		public static void qury() throws Exception
		{
			String url="jdbc:mysql://localhost:3306/payroll_services";
			String user="root";
			String password="1234";
			Connection con=null;
			Statement st=null;
			String qry="select * from employee_payroll where id=1;";
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver is loaded");

				
				con=DriverManager.getConnection(url, user, password);
				System.out.println("DB is connected");
				st=con.createStatement();
				ResultSet res=st.executeQuery(qry);
				String empdata ="";
				while(res.next())
				{
					int id = res.getInt("id");
	                String name = res.getString("name");
	                String phone_number = res.getString("phone_number");
	                String address = res.getString("address");
	                String department = res.getString("department");
	                String gender = res.getString("gender");
	                Double basic_pay = res.getDouble("basic_pay");
	                Double deductions = res.getDouble("deductions");
	                Double taxable_pay = res.getDouble("taxable_pay");
	                Double tax = res.getDouble("tax");
	                Double net_pay = res.getDouble("net_pay");
	                Date start = res.getDate("start");
	                System.out.println("id = "+ id + " name = "+ name + " phone_number = "+ phone_number + " address = "+ address+ 
	                		" department = "+ department+ "gender = "+ gender + "basic_pay = "+ basic_pay+ "deductions = "+ deductions
	                		+ "taxablepay = "+ taxable_pay+ "tax = "+ tax+ "net_pay = "+ net_pay+ "start = "+ start);
				
					/*empdata=res.getInt(1)+" : "+res.getString(2)+" : "+res.getString(3)+" : "+res.getString(4)
					+" : "+res.getClob(5)+" : "+res.getString(6)+" : "+res.getDouble(7)+" : "+res.getDouble(8)
					+" : "+res.getDouble(9)+" : "+res.getDouble(10)
					+" : "+res.getDouble(11)+" : "+res.getDate(12);
					System.out.println(empdata);*/
					
				}
				
				/*res.next();
				//String result=res.getString("name");//getting one column value at a time 
			//	System.out.println(result);*/

				st.close();
				con.close();
				System.out.println("connection closed");


				/*if(con !=null)
				{
					con.close();
					System.out.println("connection disconnected");

				}*/
		}

		public static void main(String[] args) throws Exception
		{
			qury();
		}
}

