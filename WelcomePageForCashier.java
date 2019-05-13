package com.ElectronicBillingSystem;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JButton;

public class WelcomePageForCashier//implements ActionListener{
{

	private JFrame frmSupertechElectronicBilling;
	private JTextField textField;
	private JTextField textField_1;


		public  WelcomePageForCashier() 
	{
		frmSupertechElectronicBilling = new JFrame();
		frmSupertechElectronicBilling.getContentPane().setBackground(Color.WHITE);
		frmSupertechElectronicBilling.getContentPane().setForeground(Color.WHITE);
		frmSupertechElectronicBilling.setTitle("SuperTech Electronic Billing System");
		frmSupertechElectronicBilling.setBounds(100, 100, 567, 472);
		frmSupertechElectronicBilling.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSupertechElectronicBilling.getContentPane().setLayout(null);
		
		JLabel lblUserid = new JLabel("UserId :");
		lblUserid.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblUserid.setBounds(232, 135, 89, 20);
		frmSupertechElectronicBilling.getContentPane().add(lblUserid);
		
		JTextField textUser_ID = new JTextField();
		textUser_ID.setBounds(368, 138, 148, 20);
		frmSupertechElectronicBilling.getContentPane().add(textUser_ID);
		textUser_ID.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPassword.setBounds(232, 199, 89, 28);
		frmSupertechElectronicBilling.getContentPane().add(lblPassword);
		
		JPasswordField textPassword = new JPasswordField();
		textPassword.setBounds(378, 206, 148, 20);
		frmSupertechElectronicBilling.getContentPane().add(textPassword);
		textPassword.setColumns(10);
		
		JLabel lblCashier = new JLabel("Cashier Login ");
		lblCashier.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCashier.setBounds(237, 61, 279, 28);
		frmSupertechElectronicBilling.getContentPane().add(lblCashier);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogin.setBounds(252, 300, 99, 23);
		frmSupertechElectronicBilling.getContentPane().add(btnLogin);
		
		JButton btnCancle = new JButton("Cancel");
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSupertechElectronicBilling.dispose();
		
			}
			
		});

	
		btnCancle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancle.setBounds(427, 300, 89, 23);
		frmSupertechElectronicBilling.getContentPane().add(btnCancle);
		
		JLabel imageLabel = new JLabel("");
		Image Img = new ImageIcon(this.getClass().getResource("/em.png")).getImage();
		imageLabel.setIcon(new ImageIcon(Img));
		imageLabel.setBounds(10, 26, 208, 366);
		frmSupertechElectronicBilling.getContentPane().add(imageLabel);
		
	 btnLogin.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		System.out.println("login called");
     
     		try {
    				Class.forName("oracle.jdbc.driver.OracleDriver");
    				Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
    			    System.out.println("after connection");
    				Statement st =connection.createStatement();
    				System.out.println(textUser_ID.getText());
    				System.out.println(textPassword.getText());
    				ResultSet rs;
    				String Sql = "Select * from cashier_login  where User_id like '"+textUser_ID.getText()+"' and Password like '"+textPassword.getText()+"'";
    				rs = st.executeQuery(Sql);
    				if(rs.next())
    				{
    				JOptionPane.showMessageDialog(null, "Successfully login..");
    				CashierMenu c = new CashierMenu();
    			     
    				}
    				else
    				{
    					JOptionPane.showMessageDialog(null, "Incorrect Username and Password..");
    				}
    				connection.close();
    						
    						
    		    }		
    			
    			catch(ClassNotFoundException e1)
    						{
    							e1.printStackTrace();
    						}
    			catch(SQLException s) {
    						System.out.println(s);}
    						
	}
    	 });
	
		frmSupertechElectronicBilling.setVisible(true);
	}
    	public static void main(String args[])
    	{
    		
    					WelcomePageForCashier window = new WelcomePageForCashier();
    					
    		
    	}
     } 
	