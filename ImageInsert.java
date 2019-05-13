package com.ElectronicBillingSystem;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ImageInsert {

	public static void main(String[] args) {
	try{ 
	Class.forName("oracle.jdbc.driver.OracleDriver"); 
	Connection con=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1522:orcl","project","project");
	 

	PreparedStatement ps=con.prepareStatement("insert into ImgTable values(?,?)"); 
	ps.setString(1,"Name"); 

	FileInputStream fin=new FileInputStream("E:\\imag.jpg"); 
	ps.setBinaryStream(2,fin,fin.available()); 
	int i=ps.executeUpdate(); 
	System.out.println(i+" records affected"); 

	con.close(); 
	}catch (Exception e) {e.printStackTrace();} 
	} 

	}


