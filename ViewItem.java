package com.ElectronicBillingSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class ViewItem {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
	/*	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewItem window = new ViewItem();
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
	public ViewItem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 32, 516, 179);
		frame.getContentPane().add(scrollPane);
		
		
		//DefaultTableModel model = new DefaultTableModel();
		//model.setColumnIdentifiers(columnNames);

		//table.setModel(model); 

//		TableColumn soprtColumn=table.getColumnModel().getColumn(3);

	//	soprtColumn.setCellEditor(new DefaultCellEditor (textBox));

		//table.setCellSelectionEnabled(true);
		
		
		table = new JTable();
		scrollPane.setRowHeaderView(table);
		String columnNames[] =  	{
 				"Item_ID", "Item_Category", " Price"
 			};	

		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		//table.setModel(model); 

//		TableColumn soprtColumn=table.getColumnModel().getColumn(3);

	//	soprtColumn.setCellEditor(new DefaultCellEditor (textBox));

		table.setCellSelectionEnabled(true);
		

		table.setModel(model); 
		JButton btnNewButton = new JButton("View");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("in view");
			
				try
				{ 
					 Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
					
					String sql = "select * from item";
				//	String s1= "select * from bill";
				PreparedStatement ps = connection.prepareStatement(sql);
				//PreparedStatement ps = connection.prepareStatement(s1);
				ResultSet rs = ps.executeQuery();
				//ResultSet rs = ps.executeQuery();
				int i =0;
				int item_id= 0;
				String item_category= "";
				int stock=0;
				double price = 0;
				//int qty = 0;
				frame.getContentPane().add(table);
				
			while(rs.next())
				{
				item_id = rs.getInt(1);
				item_category = rs.getString(2);
				price = rs.getInt("price");
				stock =rs.getShort("stock");
				System.out.println(item_id);
				model.addRow(new Object[]{item_id,item_category,price,stock});
				scrollPane.setViewportView(table);
			}
				}
				catch(Exception e1)
				{
					
				}
			}
		});
				
		btnNewButton.setBounds(122, 299, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(248, 299, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		 //viewItem_frame.getContentPane().setLayout(null);
			
			frame.setVisible(true);
			//frame.dispose();
			
	}
	public static void main(String[] args) {
		new ViewItem();
	}
}
