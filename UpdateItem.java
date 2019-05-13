package com.ElectronicBillingSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;

public class UpdateItem {
	static int flag=0;

	public UpdateItem()  {
		JFrame updateitem_frame=new JFrame(" This is Update Product Page....");
		updateitem_frame.getContentPane().setBackground(Color.WHITE);
		updateitem_frame.setSize(400,500);
		
		JLabel ItemCategoryName=new JLabel(" Enter ItemCategoryName ");   
		ItemCategoryName.setBounds(23,45,147,30);
		updateitem_frame.getContentPane().add(ItemCategoryName);
		  
		 JTextField itemName_field=new JTextField();
		 itemName_field.setBounds(230,45,100,30);
		 updateitem_frame.getContentPane().add(itemName_field);
		  
		 JLabel itemId=new JLabel(" Enter Item Id ");
		 itemId.setBounds(23,123,200,30);
		 updateitem_frame.getContentPane().add(itemId);
		 
		 JTextField itemId_field=new JTextField();
		 itemId_field.setBounds(230,123,100,30);
		 updateitem_frame.getContentPane().add(itemId_field);
		 
		 JLabel itemPrice=new JLabel(" Enter Item Price ");
		 itemPrice.setBounds(23,200,250,30);
		 updateitem_frame.getContentPane().add(itemPrice);
		 
		 JTextField itemPrice_field=new JTextField();
		 itemPrice_field.setBounds(230,200,100,30);
		 updateitem_frame.getContentPane().add(itemPrice_field);
		 
		 JButton backToMain=new JButton("Back");
		 backToMain.setBounds(220,280,70,30);
		 updateitem_frame.getContentPane().add(backToMain);
		 backToMain.addActionListener(new ActionListener(){  
			 public void actionPerformed(ActionEvent e){  
				 new AdminMenu();
				 updateitem_frame.dispose();
				 
			 }
		 });
		  
		 JButton Update=new JButton("Update");
		 Update.setBounds(70,280,100,30);
		 updateitem_frame.getContentPane().add(Update);
		 Update.addActionListener(new ActionListener(){  
			 public void actionPerformed(ActionEvent e){  
				 try{  
					 Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
					 String ItemCategoryName =itemName_field.getText();
					 
					 String itemId=itemId_field.getText();
					 String itemPrice=itemPrice_field.getText();
					 if(ItemCategoryName.isEmpty()||itemId.isEmpty()||itemPrice.isEmpty()) {
						 JOptionPane.showMessageDialog(updateitem_frame," Must Enter All Details "); 
						 flag=1;
					 }
					 else {
						 flag=0;
						 
					 }
					 if(flag==0) {
					 System.out.println("hai");
					 String s = "update item set  Item_Category = '" + itemName_field.getText() + "' , Price= "+itemPrice+ "  Where item_Id= "+itemId  ;
					 System.out.println(s);
						
					 PreparedStatement stmt=connection.prepareStatement(s );
			 		  int i=stmt.executeUpdate();  
					 JOptionPane.showMessageDialog(updateitem_frame,i+"record Updated"); 
					 System.out.println(i+" record Updated");    
					 connection.close();  
					 }
				 }
				 catch(Exception e1){ 
						 System.out.println(e1);
						 }  
					 }
		        } );
		 updateitem_frame.getContentPane().setLayout(null);
	
	updateitem_frame.setVisible(true);
	

	}
	public static void main(String[] args) {
		new UpdateItem();
	}

}