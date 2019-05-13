package com.ElectronicBillingSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AddItems {

	private JFrame frame;
	private JTextField textManufactureIdField;
	private JTextField textcompanyNameField;
	private JTextField textContactPersonField;
	private JTextField textPhoneNoField;
	private JTextField textEmailField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	
	/* EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManufactureItem window = new ManufactureItem();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddItems() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 530);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblManufactureid = new JLabel("ManufactureId");
		lblManufactureid.setBounds(36, 30, 93, 14);
		frame.getContentPane().add(lblManufactureid);
		
		textManufactureIdField = new JTextField();
		textManufactureIdField.setBounds(139, 27, 86, 20);
		frame.getContentPane().add(textManufactureIdField);
		textManufactureIdField.setColumns(10);
		
		JLabel lblcompanyNameLabel = new JLabel("CompanyName");
		lblcompanyNameLabel.setBounds(36, 87, 93, 14);
		frame.getContentPane().add(lblcompanyNameLabel);
		
		textcompanyNameField = new JTextField();
		textcompanyNameField.setBounds(139, 84, 147, 20);
		frame.getContentPane().add(textcompanyNameField);
		textcompanyNameField.setColumns(10);
		
		JLabel lblContactPersonLabel = new JLabel("contactPerson");
		lblContactPersonLabel.setBounds(36, 137, 98, 14);
		frame.getContentPane().add(lblContactPersonLabel);
		
		textContactPersonField = new JTextField();
		textContactPersonField.setBounds(139, 134, 162, 20);
		frame.getContentPane().add(textContactPersonField);
		textContactPersonField.setColumns(10);
		
		JLabel lblPhoneNoLabel = new JLabel("PhoneNo");
		lblPhoneNoLabel.setBounds(35, 182, 62, 14);
		frame.getContentPane().add(lblPhoneNoLabel);
		
		textPhoneNoField = new JTextField();
		textPhoneNoField.setBounds(139, 179, 134, 20);
		frame.getContentPane().add(textPhoneNoField);
		textPhoneNoField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setBounds(35, 215, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textEmailField = new JTextField();
		textEmailField.setBounds(139, 212, 162, 20);
		frame.getContentPane().add(textEmailField);
		textEmailField.setColumns(10);
		
		
				
		JButton btnNewButton_1 = new JButton("Insert");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					System.out.println("in try");
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
							
					String Query= "insert into manufacture(manufacture_id,email_id,address,phone_no,company_name,contact_person)values(?,?,?,?,?,?)";
					PreparedStatement statement=connection.prepareStatement(Query);					
					System.out.println("in try 1");
					statement.setInt(1, Integer.parseInt( textManufactureIdField.getText()));
					System.out.println("in try 2");
					statement.setString(2,textEmailField.getText());
					System.out.println("in try 3");
					statement.setString(3,  textField.getText());
					System.out.println("in try 4");
					statement.setInt(4, Integer.parseInt(textPhoneNoField .getText()));
					System.out.println("in try 5");
					statement.setString(5, textcompanyNameField.getText());
					System.out.println("in try 6");
					statement.setString(6, textContactPersonField.getText());
					System.out.println("in try 7 ");
					int i=statement.executeUpdate();
		        	
			         if(i>0) {
			        	 JOptionPane.showMessageDialog(null, " Insert Successfully");
			        	 
			         }
					
			         else {
						JOptionPane.showMessageDialog(null, "is unsuccessfull");
						}
					 connection.close();
						
						
	    		    }		
	    			
	    			catch(ClassNotFoundException e1)
	    						{
	    							e1.printStackTrace();
	    						}
	    			catch(SQLException s) {
	    						System.out.println(s);
	    						}
			}
   	 });
			
		btnNewButton_1.setBounds(108, 365, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnCancelButton = new JButton("Cancel");
		btnCancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnCancelButton.setBounds(311, 365, 89, 23);
		frame.getContentPane().add(btnCancelButton);
		
		JLabel lblAddressLabel = new JLabel("Address");
		lblAddressLabel.setBounds(35, 281, 46, 14);
		frame.getContentPane().add(lblAddressLabel);
		
		textField = new JTextField();
		textField.setBounds(139, 266, 234, 47);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		
  frame.setVisible(true);
	 }
	
   public static void main(String[] args) {
			new AddItems();
		}
	

	}
		

		
			  