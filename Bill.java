package com.ElectronicBillingSystem;



import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jdesktop.swingx.JXDatePicker;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.Statement;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.xml.soap.Text;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.lang.model.element.QualifiedNameable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import org.jdesktop.swingx.JXDatePicker;
import java.awt.Color;

public class Bill {

	private JFrame frmSuperstyleElectronicBillng;
	private JTextField Customertextfeild;
	private JTextField BilltextField;
	private JTextField textField_5;
	private JTextField QuatitytextField1;
	private JTextField Quatitytextfeild2;
	private JTextField QuatitytextField3;
	private JTextField textCustomerField;
	JLabel lblPriceLabel_1,lblPriceLabel_2,lblPriceLable_3;
	double count;
	private JTextField textSearchItemField;
	private JTextField textSearchField;
	
	/**
	 * Launch the application.
	 */



public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bill window = new Bill();
					window.frmSuperstyleElectronicBillng.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
}

	/**
	 * Create the application.
	 */
	public Bill() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSuperstyleElectronicBillng = new JFrame();
		frmSuperstyleElectronicBillng.getContentPane().setBackground(Color.WHITE);
		frmSuperstyleElectronicBillng.getContentPane().setForeground(Color.WHITE);
		frmSuperstyleElectronicBillng.setTitle("SuperTech Electronic Billng System");
		frmSuperstyleElectronicBillng.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 20));
		frmSuperstyleElectronicBillng.setBounds(100, 100, 702, 489);
		frmSuperstyleElectronicBillng.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSuperstyleElectronicBillng.getContentPane().setLayout(null);
		String columnsNames[] = {
				"item_id" , "item_category" , " price" , " quantity"	
		};
	
		JLabel lblbillLabel = new JLabel("Bill");
		lblbillLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblbillLabel.setBounds(286, 31, 35, 20);
		frmSuperstyleElectronicBillng.getContentPane().add(lblbillLabel);
		
		JLabel textNameOfCustomer = new JLabel("Name of Customer:");
		textNameOfCustomer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textNameOfCustomer.setBounds(41, 104, 130, 14);
		frmSuperstyleElectronicBillng.getContentPane().add(textNameOfCustomer);
		
		
		
		JLabel lblBillDate = new JLabel("Bill Date:");
		lblBillDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBillDate.setBounds(48, 146, 102, 20);
		frmSuperstyleElectronicBillng.getContentPane().add(lblBillDate);
		
		JXDatePicker picker = new JXDatePicker();
		 picker.setDate(Calendar.getInstance().getTime());
		 picker.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
		 picker.setBounds(109, 146, 117, 24);
	    frmSuperstyleElectronicBillng.getContentPane().add(picker);
		
		
		JLabel lblItem1 = new JLabel("Item 1:");
		lblItem1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblItem1.setBounds(61, 215, 46, 14);
		frmSuperstyleElectronicBillng.getContentPane().add(lblItem1);
		
		
		JLabel lblItem2 = new JLabel("Item 2:");
		lblItem2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblItem2.setBounds(61, 254, 46, 14);
		frmSuperstyleElectronicBillng.getContentPane().add(lblItem2);
		
		JLabel lblItem3 = new JLabel("Item 3:");
		lblItem3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblItem3.setBounds(61, 291, 46, 14);
		frmSuperstyleElectronicBillng.getContentPane().add(lblItem3);
		
		JLabel lblTotalAmountLabel = new JLabel("Rs.");
		lblTotalAmountLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTotalAmountLabel.setBounds(416, 342, 94, 14);
		frmSuperstyleElectronicBillng.getContentPane().add(lblTotalAmountLabel);
		
		
		
	 QuatitytextField1 = new JTextField();
	QuatitytextField1.setBounds(340, 213, 86, 20);
		frmSuperstyleElectronicBillng.getContentPane().add(QuatitytextField1);
		QuatitytextField1.setColumns(10);
		
		JComboBox comboBox_Item1 = new JComboBox();
		comboBox_Item1.setBounds(122, 213, 140, 20);
		frmSuperstyleElectronicBillng.getContentPane().add(comboBox_Item1);
		
		
		JComboBox comboBox_Item2 = new JComboBox();
		comboBox_Item2.setBounds(122, 252, 140, 20);
		frmSuperstyleElectronicBillng.getContentPane().add(comboBox_Item2);
		
		JComboBox comboBox_Item3 = new JComboBox();
		comboBox_Item3.setBounds(122, 289, 140, 20);
		frmSuperstyleElectronicBillng.getContentPane().add(comboBox_Item3);
		
		
		Quatitytextfeild2 = new JTextField();
		Quatitytextfeild2.setBounds(340, 252, 86, 20);
		frmSuperstyleElectronicBillng.getContentPane().add(Quatitytextfeild2);
		Quatitytextfeild2.setColumns(10);
		
		 QuatitytextField3 = new JTextField();
		QuatitytextField3.setBounds(340, 289, 86, 20);
		frmSuperstyleElectronicBillng.getContentPane().add(QuatitytextField3);
		QuatitytextField3.setColumns(10);
		
		JButton btnNewButton = new JButton("print");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  
					  try {
		            FileWriter writer = new FileWriter("C:\\Users\\MADHAN\\Desktop\\billls\\"+textCustomerField.getText()+" ", true);
		            writer.write("\n------------------Hello to Medical Shop---------------------------------------------");
		            writer.write("\r\n----------------------------------------------------------------------------------");   // write new line
		            writer.write("\r\n-----------------------------------------billing-----------------------------------");
		           // writer.write("\r\n Doctor name : "+customer_Name.getText()+" Customer Name: "+Customer_Name.getText()+"    PhoneNumber  "+phoneNumber.getText()+"");
		            writer.write("\r\n-----------------------------------------------------------------------------------");   // write new line
		            writer.write("\r\n NO                        item name        Quantity                price");
		            writer.write("\r\n-----------------------------------------------------------------------------------");   // write new line
		            writer.write("\r\n");
		            writer.write(Bill.getInt());
		            writer.write("\r\n------------------------------------------------------------------------------------");   // write new line
		            writer.write("\r\n");
		            writer.write("                                                		Total	"+lblTotalAmountLabel.getText());
		            writer.write("\r\n------------------------------------------------------------------------------------");   // write new line

		            writer.close();
		        } catch (IOException e1) {
		            e1.printStackTrace();
		        }
				
			}
		});
		btnNewButton.setBounds(563, 400, 89, 23);
		frmSuperstyleElectronicBillng.getContentPane().add(btnNewButton);
		
		//JLabel QuatitytextField = new JLabel();
		// QuatitytextField.setBounds(287, 216, 46, 14);
		//frame.getContentPane().add( QuatitytextField);
		
		textCustomerField = new JTextField();
		textCustomerField.setBounds(181, 103, 130, 20);
		frmSuperstyleElectronicBillng.getContentPane().add(textCustomerField);
		textCustomerField.setColumns(10);
		
		JButton btnTotalButton = new JButton("Calculate");
		btnTotalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//System.out.println(" :- " +QuatitytextField.getText());
				
          String q1 = QuatitytextField1.getText();
          String p1 = lblPriceLabel_1.getText();
          double qty1 = Double.parseDouble(q1);
          double pr1 = Double.parseDouble(p1);
          System.out.println(qty1);
          System.out.println(pr1);
          
          String q2 = Quatitytextfeild2.getText();
          String p2 = lblPriceLabel_2.getText();
          double qty2 = Double.parseDouble(q2);
          double pr2 = Double.parseDouble(p2);
          System.out.println(qty2);
          System.out.println(pr2);
          
          String q3 = QuatitytextField3.getText();
          String p3 = lblPriceLable_3.getText();
          double qty3 = Double.parseDouble(q3);
          double pr3 = Double.parseDouble(p3);
          System.out.println(qty3);
          System.out.println(pr3);
          
          System.out.println(qty1*pr1);
          System.out.println(qty2*pr2);
          System.out.println(qty3*pr3);
          
          
          
    count=(qty1*pr1)+(qty2*pr2)+(qty3*pr3);

            
            String t = "Rs " + count ;
            lblTotalAmountLabel.setText(t);
            System.out.println("TotalAmount: " +count);
            
			}
			
		});
	

		btnTotalButton.setBounds(122, 353, 117, 23);
		frmSuperstyleElectronicBillng.getContentPane().add(btnTotalButton);
		
		JLabel label = new JLabel("");
		label.setBounds(487, 216, 46, 14);
		frmSuperstyleElectronicBillng.getContentPane().add(label);
		
		 lblPriceLabel_1 = new JLabel("price:");
		lblPriceLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPriceLabel_1.setBounds(505, 202, 63, 14);
		frmSuperstyleElectronicBillng.getContentPane().add(lblPriceLabel_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(548, 195, 94, 23);
		frmSuperstyleElectronicBillng.getContentPane().add(lblNewLabel_1);
		
		lblPriceLabel_2 = new JLabel("price:");
		lblPriceLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPriceLabel_2.setBounds(505, 252, 46, 14);
		frmSuperstyleElectronicBillng.getContentPane().add(lblPriceLabel_2);
		
		lblPriceLable_3 = new JLabel("Price:");
		lblPriceLable_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPriceLable_3.setBounds(505, 292, 46, 14);
		frmSuperstyleElectronicBillng.getContentPane().add(lblPriceLable_3);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(563, 202, 46, 14);
		frmSuperstyleElectronicBillng.getContentPane().add(label_1);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setBounds(332, 188, 63, 14);
		frmSuperstyleElectronicBillng.getContentPane().add(lblQuantity);
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CashierMenu cm=new CashierMenu();
				frmSuperstyleElectronicBillng.setVisible(true);
				frmSuperstyleElectronicBillng.dispose();
			}
		});
		btnNewButton_3.setBounds(563, 35, 89, 23);
		frmSuperstyleElectronicBillng.getContentPane().add(btnNewButton_3);
		
		JButton btnGenerateButton = new JButton("Generate");
		btnGenerateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					System.out.println("in try");
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
					//not inserted cashier id 
					String Query="insert into Bill(bill_id,bill_date,customer_name,total_amount)values(bil.nextval,sysdate,?,?)";	
					PreparedStatement statement=connection.prepareStatement(Query);
					statement.setString(1,  textCustomerField.getText());
				//	statement.setInt(2, Integer.parseInt(lblTotalAmountLabel.getText()));
					statement.setDouble(2, count);
					//statement1.setInt(1, Integer.parseInt(Quatitytextfeild2 .getText()));
 				//statement1.setInt(1, Integer.parseInt(QuatitytextField3 .getText()));
			        int i=statement.executeUpdate();
			      System.out.println("done bill");
					
			      //item 1  
			      String Query1="insert into Bill_description(bill_id,item_quantity,item_price,item_id)"
			        		+ "values(bil.currval,?,?,?)";
			        PreparedStatement statement1=connection.prepareStatement(Query1);
			        statement1.setInt(1, Integer.parseInt(QuatitytextField1 .getText()));
			        System.out.println(QuatitytextField1 .getText());
			        
			        statement1.setInt(2, Integer.parseInt(lblPriceLabel_1 .getText()));
			        System.out.println(lblNewLabel_1 .getText());
			        
			        statement1.setString(3, (String) comboBox_Item1.getSelectedItem());
			        					 
			        int j=statement1.executeUpdate();
		        	 
			        //item 2
			         Query1="insert into Bill_description(bill_id,item_quantity,item_price,item_id)"
			        		+ "values(bil.currval,?,?,?)";
			         statement1=connection.prepareStatement(Query1);
			        statement1.setInt(1, Integer.parseInt(Quatitytextfeild2 .getText()));
			        System.out.println(QuatitytextField1 .getText());
			        
			        statement1.setInt(2, Integer.parseInt(lblPriceLabel_2 .getText()));
			        System.out.println(lblNewLabel_1 .getText());
			        
			        statement1.setString(3, (String) comboBox_Item2.getSelectedItem());
			        					 
			         j=statement1.executeUpdate();
		        	  
			        //item 3
			         Query1="insert into Bill_description(bill_id,item_quantity,item_price,item_id)"
			        		+ "values(bil.currval,?,?,?)";
			         statement1=connection.prepareStatement(Query1);
			        statement1.setInt(1, Integer.parseInt(QuatitytextField3 .getText()));
			        System.out.println(QuatitytextField3 .getText());
			        
			        statement1.setInt(2, Integer.parseInt(lblPriceLable_3.getText()));
			        System.out.println(lblNewLabel_1 .getText());
			        
			        statement1.setString(3, (String) comboBox_Item3.getSelectedItem());
			        					 
			       j=statement1.executeUpdate();
		        	//--
			        
			        if((i>0) && (j>0)){
			        	 JOptionPane.showMessageDialog(null, " Generate Successfully");
			        	 
			         }
					
			         else {
						JOptionPane.showMessageDialog(null, "is Generate UnSeccessfully");
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
		btnGenerateButton.setBounds(285, 400, 89, 23);
		frmSuperstyleElectronicBillng.getContentPane().add(btnGenerateButton);
		
		JButton btnrefreshButton = new JButton("Refresh");
		btnrefreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bill b=new Bill();
				frmSuperstyleElectronicBillng.dispose();
			}
		});
		btnrefreshButton.setBounds(421, 400, 89, 23);
		frmSuperstyleElectronicBillng.getContentPane().add(btnrefreshButton);
		int count1 []=new int[1];
		int count2 []=new int[1];
		int count3 []=new int[1];
		

		
		
		
		
		//to create combo box 
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
					String sql="select * from Item";
			
			PreparedStatement p=connection.prepareStatement(sql);
			ResultSet results=p.executeQuery();
		//	java.sql.Statement statement=connection.createStatement();
			while(results.next()) {
				String itemid=results.getString("item_Category");
				comboBox_Item1.addItem(itemid);
				comboBox_Item2.addItem(itemid);

				comboBox_Item3.addItem(itemid);

			}
		}
		catch(Exception e1) {
			System.out.println(e1);
		}
		//----

		
		ItemListener itemListener1 = new ItemListener() {
			public void itemStateChanged(ItemEvent itemEvent) {
				try
				{
					System.out.println("in listener");
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
    				String sql="select * from Item where item_category = '" + comboBox_Item1.getSelectedItem() + "'";
                    System.out.println(sql);
    				PreparedStatement p=connection.prepareStatement(sql);
					ResultSet results=p.executeQuery();
					System.out.println("after");
				
					if(results.next()) {
						int itemrate=results.getInt("price");
						lblPriceLabel_1.setText(Integer.toString(itemrate));
					}
					System.out.println("after if");
					
				}
				catch(Exception e) {
					System.out.println(e);
				}

				
			}
		};
		comboBox_Item1.addItemListener(itemListener1);
		
		
		ItemListener itemListener2 = new ItemListener() {
			public void itemStateChanged(ItemEvent itemEvent) {
				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
    					String sql="select * from Item where item_category = '" + comboBox_Item2.getSelectedItem() + "'";
									PreparedStatement p=connection.prepareStatement(sql);
					ResultSet results=p.executeQuery();
				
					if(results.next()) {
						int itemrate=results.getInt("price");
						lblPriceLabel_2.setText(Integer.toString(itemrate));
					}
				}
				catch(Exception e) {
					System.out.println(e);
				}

				
			}
		};
		
		comboBox_Item2.addItemListener(itemListener2);


		ItemListener itemListener3 = new ItemListener() {
			public void itemStateChanged(ItemEvent itemEvent) {
				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
    					String sql="select * from Item where item_category = '" + comboBox_Item3.getSelectedItem() + "'";
									PreparedStatement p=connection.prepareStatement(sql);
					ResultSet results=p.executeQuery();
				
					if(results.next()) {
						int itemrate=results.getInt("price");
						lblPriceLable_3.setText(Integer.toString(itemrate));
					}
				}
				catch(Exception e) {
					System.out.println(e);
				}

				
			}
		};
		

		
		comboBox_Item3.addItemListener(itemListener3);
		frmSuperstyleElectronicBillng.setVisible(true);
	
	}

	protected static char[] getInt() {
		// TODO Auto-generated method stub
		return null;
	}
}