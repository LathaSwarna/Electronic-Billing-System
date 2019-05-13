package com.ElectronicBillingSystem;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DeleteItem extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldItemid;

	/**
	 * Launch the application.
	 */
/*
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteItem frame = new DeleteItem();
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
	public DeleteItem() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ItemId:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(52, 75, 61, 27);
		contentPane.add(lblNewLabel);
		
		textFieldItemid = new JTextField();
		textFieldItemid.setBounds(139, 80, 139, 20);
		contentPane.add(textFieldItemid);
		textFieldItemid.setColumns(10);
		
		JButton btnDeleteButton = new JButton("Delete");
		btnDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
					 
					String Query="DELETE FROM item WHERE item_id= ?";

					PreparedStatement st = connection.prepareStatement(Query);
		         
		           st.setInt(1, Integer.parseInt(textFieldItemid.getText()));
		          	int i =st.executeUpdate();
		          	
		          	if(i>0) {
			        	 JOptionPane.showMessageDialog(null, " Delete Successfully");
			        	 
			         }
					
			         else {
						JOptionPane.showMessageDialog(null, "Is Not Deleted ");
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

			private int next() {
				// TODO Auto-generated method stub
				return 0;
			}
    	 });
	
		
		btnDeleteButton.setBounds(113, 144, 89, 23);
		contentPane.add(btnDeleteButton);
		
		JButton btnCancelButton = new JButton("Cancle");
		btnCancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		btnCancelButton.setBounds(242, 144, 89, 23);
		contentPane.add(btnCancelButton);
		
	}
		public static void main(String[] args) {
		new DeleteItem();
		}
}
	
  


