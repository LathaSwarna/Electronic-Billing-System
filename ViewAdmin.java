package com.ElectronicBillingSystem;

import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ViewAdmin {

	public ViewAdmin()
	 {
		JFrame frame;
	 
		int row=0;
		frame=new JFrame();
		
		try { 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="hr";
			String password="hr";
					
			Connection con=DriverManager.getConnection(url, user, password);
			Statement stmt=con.createStatement();
			 
	 
			ResultSet resultSet=stmt.executeQuery("select count(*) from item");
			 
			while(resultSet.next()) { 
				row=resultSet.getInt(1);
				 
			}
			
			 
			con.close();
			
		} catch (Exception e1) {
			 
			e1.printStackTrace();
		}
	    
		ArrayList <String> [] Stocks=new ArrayList[row];
	    
	    for (int i = 0; i <row; i++) { 
	    	Stocks[i] = new ArrayList<String>(); 
        } 

try { 
	Class.forName("oracle.jdbc.driver.OracleDriver");
	
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="hr";
	String password="hr";
			
	Connection con=DriverManager.getConnection(url, user, password);
	Statement stmt=con.createStatement();
	 

	ResultSet searchResult=stmt.executeQuery("select * from item");
	
	int i=0;
	while(searchResult.next()) {
		
		Stocks[i].add(searchResult.getString(1));
		Stocks[i].add(searchResult.getString(2));
		Stocks[i].add(searchResult.getString(3));
		Stocks[i].add(searchResult.getString(4));
		i++;   
	}

	con.close();
	
} catch (Exception e1) {
	 
	e1.printStackTrace();
}


String data[][]=new String[row][4];

for(int i=0;i<(row);i++) {
	 
	for(int j=0;j<4;j++) {
		data[i][j]=Stocks[i].get(j);
		;
	}
}					




String column[]={"item_id","item_category","price", "stock"};         

JTable jt=new JTable(data,column);    
jt.setBounds(30,60, 800,400);


JScrollPane sp=new JScrollPane(jt);    

frame.add(sp);          
frame.setSize(800,400);    
frame.setVisible(true); 
JButton backToAdminMain=new JButton(" Back ");
backToAdminMain.setBounds(600,300,140,40);
frame.add(backToAdminMain);
backToAdminMain.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {	
		new AdminMenu();
		frame.dispose();
		
		
	}
	});

}
	public static void main(String[] args) {
		ViewAdmin vpa=new ViewAdmin();
		
	}

}

