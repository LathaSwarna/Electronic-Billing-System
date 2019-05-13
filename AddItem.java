package com.ElectronicBillingSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AddItem extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCategory;
	private JTextField textFieldItemId;
	private JTextField textFieldStock;
	private JTextField textFieldWarranty;
	private JTextField textFieldPrice;

	/**
	 * Launch the application.
	 */
	/*
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddItem frame = new AddItem();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddItem() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblItemLabel = new JLabel("ItemCategory:");
		lblItemLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblItemLabel.setBounds(33, 49, 109, 19);
		contentPane.add(lblItemLabel);
		
		textFieldCategory = new JTextField();
		textFieldCategory.setBounds(141, 50, 135, 20);
		contentPane.add(textFieldCategory);
		textFieldCategory.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
							
					String Query= "insert into item(Item_id,Item_Category,Price,Warranty,Stock)values(?,?,?,?,?)";
					PreparedStatement statement=connection.prepareStatement(Query);					
					System.out.println("in try 1");
					statement.setInt(1, Integer.parseInt(textFieldItemId .getText()));
					System.out.println("in try 2");
					statement.setString(2,  textFieldCategory.getText());
					System.out.println("in try 3");
					statement.setInt(3, Integer.parseInt( textFieldPrice.getText()));
					System.out.println("in try 4");
					statement.setInt(4, Integer.parseInt( textFieldWarranty.getText()));
					System.out.println("in try 5");
					statement.setInt(5, Integer.parseInt( textFieldStock.getText()));
					System.out.println("in try 6 ");
					int i=statement.executeUpdate();
		        	
			         if(i>0) {
			        	 JOptionPane.showMessageDialog(null, " add Successfully");
			        	 
			         }
					
			         else {
						JOptionPane.showMessageDialog(null, "is not added");
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
		
			
		btnNewButton.setBounds(55, 186, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		btnNewButton_1.setBounds(217, 186, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblItemIdLabel = new JLabel("ItemId:");
		lblItemIdLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblItemIdLabel.setBounds(33, 11, 68, 14);
		contentPane.add(lblItemIdLabel);
		
		textFieldItemId = new JTextField();
		textFieldItemId.setBounds(141, 10, 86, 20);
		contentPane.add(textFieldItemId);
		textFieldItemId.setColumns(10);
		
		JLabel lblStockLabel = new JLabel("Stock:");
		lblStockLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblStockLabel.setBounds(33, 150, 50, 14);
		contentPane.add(lblStockLabel);
		
		textFieldStock = new JTextField();
		textFieldStock.setBounds(141, 148, 86, 20);
		contentPane.add(textFieldStock);
		textFieldStock.setColumns(10);
		
		JLabel lblWarrantyLabel = new JLabel("Warranty:");
		lblWarrantyLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblWarrantyLabel.setBounds(32, 116, 69, 14);
		contentPane.add(lblWarrantyLabel);
		
		textFieldWarranty = new JTextField();
		textFieldWarranty.setBounds(141, 114, 108, 20);
		contentPane.add(textFieldWarranty);
		textFieldWarranty.setColumns(10);
		
		JLabel lblPriceLabel = new JLabel("Price:");
		lblPriceLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPriceLabel.setBounds(33, 81, 68, 14);
		contentPane.add(lblPriceLabel);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setBounds(141, 79, 86, 20);
		contentPane.add(textFieldPrice);
		textFieldPrice.setColumns(10);
	
      setVisible(true);
	}
	public static void main(String[] args) {
		new AddItem();
	}
}
