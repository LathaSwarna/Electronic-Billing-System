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

public class WelcomePageForAdmin//implements ActionListener{
{

	private JFrame frmElectronicBillingSystem;
	private JTextField textField;
	private JTextField textField_1;


		public  WelcomePageForAdmin() 
	{
		frmElectronicBillingSystem = new JFrame();
		frmElectronicBillingSystem.setTitle("SuperTech Electronic Billing System");
		frmElectronicBillingSystem.getContentPane().setBackground(Color.WHITE);
		frmElectronicBillingSystem.getContentPane().setForeground(new Color(0, 0, 0));
		frmElectronicBillingSystem.setBounds(100, 100, 601, 472);
		frmElectronicBillingSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmElectronicBillingSystem.getContentPane().setLayout(null);
		
		JLabel lblUserid = new JLabel("UserId :");
		lblUserid.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblUserid.setBounds(295, 173, 67, 20);
		frmElectronicBillingSystem.getContentPane().add(lblUserid);
		
		JTextField textUser_ID = new JTextField();
		textUser_ID.setBounds(372, 176, 148, 20);
		frmElectronicBillingSystem.getContentPane().add(textUser_ID);
		textUser_ID.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPassword.setBounds(279, 221, 89, 28);
		frmElectronicBillingSystem.getContentPane().add(lblPassword);
		
		JPasswordField textPassword = new JPasswordField();
		textPassword.setBounds(372, 228, 148, 20);
		frmElectronicBillingSystem.getContentPane().add(textPassword);
		textPassword.setColumns(10);
		
		JLabel lblCashier = new JLabel("Admin Login ");
		lblCashier.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCashier.setBounds(300, 85, 205, 28);
		frmElectronicBillingSystem.getContentPane().add(lblCashier);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogin.setBounds(282, 300, 99, 23);
		frmElectronicBillingSystem.getContentPane().add(btnLogin);
		
		JButton btnCancle = new JButton("Cancel");
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmElectronicBillingSystem.dispose();
		
			}
			
		});

	
		btnCancle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancle.setBounds(450, 300, 89, 23);
		frmElectronicBillingSystem.getContentPane().add(btnCancle);
		
		JLabel imageLabel = new JLabel("");
		Image Img = new ImageIcon(this.getClass().getResource("/em.png")).getImage();
		imageLabel.setIcon(new ImageIcon(Img));
		imageLabel.setBounds(10, 26, 208, 366);
		frmElectronicBillingSystem.getContentPane().add(imageLabel);
		
	//	JLabel lblNewLabel_1 = new JLabel("");
		//Image Img11 = new ImageIcon(this.getClass().getResource("/admin.png")).getImage();
		//lblNewLabel_1.setIcon(new ImageIcon(Img11));
		//lblNewLabel_1.setBounds(10, 136, 128, 141);
		//frame.getContentPane().add(lblNewLabel_1);
	
	 btnLogin.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		System.out.println("login called");
     
     		try {
    				Class.forName("oracle.jdbc.driver.OracleDriver");
    				Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");		
    				Statement st =connection.createStatement();
    				System.out.println(textUser_ID.getText());
    				System.out.println(textPassword.getText());
    				ResultSet rs;
    				String Sql = "Select * from Admin_login  where User_id like '"+textUser_ID.getText()+"' and Password like '"+textPassword.getText()+"'";
    				rs = st.executeQuery(Sql);
    				if(rs.next())
    				{
    				JOptionPane.showMessageDialog(null, "Successfully login..");
    				AdminMenu c = new AdminMenu();
    			     
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
	
		frmElectronicBillingSystem.setVisible(true);
	}
	 
    	public static void main(String args[])
    	{
    		
    					WelcomePageForAdmin window = new WelcomePageForAdmin();
    
    		
    	}
     } 
	
	
	
	