package com.ElectronicBillingSystem;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.swing.*;

public class PrintFunction {

	public PrintFunction() {
		JFrame f= new JFrame("Medical Shop Management System");  
		ImageIcon img=new ImageIcon("G:\\Java Applns\\manage\\src\\medical\\img2.jpeg");
		f.getContentPane().setLayout(null);
		JLabel background =new JLabel("",img,JLabel.CENTER);
		background.setBounds(10, -19, 1248, 700);
		f.getContentPane().add(background);
		JMenu menu,StocksChecking;  
        JMenuItem add_details, delete_details,Update_details,Remove_details;  
        
        
        JMenuBar mb=new JMenuBar();  
        menu=new JMenu("Admin");  
        StocksChecking=new JMenu("Stocks and Customer details"); 
   
        add_details=new JMenuItem("add_details");  
        delete_details=new JMenuItem("delete_details"); 
        
        delete_details.addActionListener(new ActionListener(){  
			 public void actionPerformed(ActionEvent e){ 
				// new  AdminDeleteDetails();
			 }});
        
        Update_details=new JMenuItem("Update_details");
        
        Update_details.addActionListener(new ActionListener(){  
			 public void actionPerformed(ActionEvent e){ 
				// new AdminUpdate();
			 }});
        
        
        add_details.addActionListener(new ActionListener(){  
			 public void actionPerformed(ActionEvent e){ 
				// new Admin();
			 }});
        
         
        menu.add(add_details); 
        menu.add(delete_details); 
        menu.add(Update_details);  
 
        JMenuItem viewstocks=new JMenuItem("Total Stocks");
        viewstocks.addActionListener(new ActionListener(){  
			 public void actionPerformed(ActionEvent e){ 
				// new P();
			 }});
        JMenuItem Cviewstocks=new JMenuItem("Customer details");
        Cviewstocks.addActionListener(new ActionListener(){  
			 public void actionPerformed(ActionEvent e){ 
				// new CustomerDetails();
			 }});
        
        StocksChecking.add(Cviewstocks);
        StocksChecking.add(viewstocks);
        mb.add(menu);  
        mb.add(StocksChecking);
        f.setJMenuBar(mb);
        
        
        
        
        JTextField SearchBox= new JTextField ();
        SearchBox.setBounds(27, 50, 900, 25);
        
        JButton Searchbutton=new JButton(" Search Medicine");
        Searchbutton.setBounds(1000, 50, 150, 25);
        f.getContentPane().add(SearchBox);
        f.getContentPane().add(Searchbutton);
        
        
        JPanel contentPane =new JPanel(new GridLayout());
        contentPane.setBounds(27, 100, 900, 100);
        contentPane.setBackground(Color.WHITE);
        JTextArea searchResultPane=new JTextArea();
        contentPane.add(searchResultPane);
        
        
        
        
        
        
        int[] count=new  int[1];
        Searchbutton.addActionListener(new ActionListener(){  
			 public void actionPerformed(ActionEvent e){  
				 
				 try {
						
						Class.forName("oracle.jdbc.driver.OracleDriver");
						
						String url="jdbc:oracle:thin:@localhost:1521:xe";
						String user="system";
						String password="admin";
								
						Connection con=DriverManager.getConnection(url, user, password);
						Statement stmt=con.createStatement();
						 
						String key=SearchBox.getText();
						ResultSet searchResult=stmt.executeQuery("select count(*) from tabletdetails where tabletname like '"+key+"%'");
	 		 
						 
						int k=0; 
						while(searchResult.next()) { 
							count[k]=searchResult.getInt(1);
						}
						 
						con.close();
				 
					} catch (Exception e1) {
						 
						e1.printStackTrace();
					}
	 			 
			try {
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				String url="jdbc:oracle:thin:@localhost:1521:xe";
				String user="system";
				String password="admin";
						
				Connection con=DriverManager.getConnection(url, user, password);
				Statement stmt=con.createStatement();
				
				
				String key=SearchBox.getText();
				ResultSet searchResult=stmt.executeQuery("select * from tabletdetails where tabletname like '"+key+"%'");
		 		int i=0;
				String[] Search_result_pane=new  String[count[0]];
				 
				
				String[] value = new  String [count[0]];
				while(searchResult.next()) { 
					Search_result_pane[i]=searchResult.getString(2)+"--------------"+searchResult.getInt(4);
					 
					i++;
				}
				String temp="Search Result\n";
			      for(int j=0;j<count[0];j++) {
			    	  temp+=Search_result_pane[j]+"\n";
			    	  
			      } 
			      
			      
	 		      searchResultPane.setText(temp);
	 		      con.close();
				
			} catch (Exception e1) {
				 
				e1.printStackTrace();
			}
			 }});
        
        f.getContentPane().add(contentPane);
		
		
        JPanel BillingPane=new JPanel(new GridLayout());
        BillingPane.setBounds(27, 300, 900, 300);
        BillingPane.setBackground(Color.WHITE);
        JTextArea Bills= new JTextArea ();
        BillingPane.add(Bills);
        
		
		ArrayList <String> listOfTablet=new <String>ArrayList();
		
		 try { 
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				String url="jdbc:oracle:thin:@localhost:1521:xe";
				String user="system";
				String password="admin";
						
				Connection con=DriverManager.getConnection(url, user, password);
				Statement stmt=con.createStatement();
				 
		 
				ResultSet searchResult=stmt.executeQuery("select tabletname from tabletdetails");
			 
				while(searchResult.next()) {
					listOfTablet.add(searchResult.getString(1));
					 
				}

				con.close();
				
			} catch (Exception e1) {
				 
				e1.printStackTrace();
			}
		
		 
		 
		 
		 
		 String[] ListForComboBox=new String[listOfTablet.size()];   
		
		 
		 for(int i=0;i<listOfTablet.size();i++){
			ListForComboBox[i]=listOfTablet.get(i);
		}
		
		JLabel Total_Label=new JLabel("TOTAL");
		Total_Label.setBounds(800, 610, 700, 25);
		f.getContentPane().add(Total_Label);
		
		JTextField total= new JTextField ("0");
		total.setBounds(860, 610, 70, 25);
		f.getContentPane().add(total);
		
		JComboBox tabletList=new JComboBox(ListForComboBox);
		tabletList.setBounds(27, 250, 800, 25);
		f.getContentPane().add(tabletList);
		
		JLabel No_of_items_Label=new JLabel("X");
		No_of_items_Label.setBounds(840, 250, 700, 25);
		f.getContentPane().add(No_of_items_Label);

		JTextField No_of_items= new JTextField ("1");
		No_of_items.setBounds(860, 250, 70, 25);
		f.getContentPane().add(No_of_items);
		 
		ArrayList <Integer> listOfItems=new ArrayList();
		
		JButton addToCart=new JButton("Add to cart");
		addToCart.setBounds(1000, 250, 150, 25);
		Map <String,Integer> tabletname=new HashMap<String,Integer> ();
		
		ArrayList <String> billing_items=new ArrayList();
		addToCart.addActionListener(new ActionListener(){  
			 public void actionPerformed(ActionEvent e){  
				 
				 try { 
						Class.forName("oracle.jdbc.driver.OracleDriver");
						
						String url="jdbc:oracle:thin:@localhost:1521:xe";
						String user="system";
						String password="admin";
								
						Connection con=DriverManager.getConnection(url, user, password);
						Statement stmt=con.createStatement();
						int no=Integer.parseInt(No_of_items.getText()); 
						String key=(String) tabletList.getSelectedItem();
						ResultSet searchResult=stmt.executeQuery("select tabletprice,tabletname from tabletdetails where tabletname='"+key+"'");
					 
						while(searchResult.next()) {
							tabletname.put(searchResult.getString(2), no);
							System.out.println("-------------->"+searchResult.getInt(1));
							 listOfItems.add(no*searchResult.getInt(1));
						}

						con.close();
						
					} catch (Exception e1) {
						 
						e1.printStackTrace();
					}
	 
				 int temp=0;
				 for(int i=0;i<listOfItems.size();i++) {
					 temp+=listOfItems.get(i); 
				 }
				 total.setText(temp+"");
				 
				 
				 int row=listOfItems.size();
				 System.out.println("row----->"+row);
				 ArrayList <String> [] Stocks=new ArrayList[row];
				    
				    for (int i = 0; i <row; i++) { 
				    	Stocks[i] = new ArrayList<String>(); 
			        }  
				 try { 
						Class.forName("oracle.jdbc.driver.OracleDriver");
						
						String url="jdbc:oracle:thin:@localhost:1521:xe";
						String user="system";
						String password="admin";
								
						Connection con=DriverManager.getConnection(url, user, password);
						Statement stmt=con.createStatement();
						
						
						int no=Integer.parseInt(No_of_items.getText()); 
						String key=(String) tabletList.getSelectedItem();
						ResultSet searchResult=stmt.executeQuery("select * from tabletdetails where tabletname='"+key+"'");
						
						
						int j=0;
						
						while(searchResult.next()) {
						 
							int k= searchResult.getInt(3);
							int price=no*k;
							billing_items.add(row+"\t\t              "+ searchResult.getString(2)+"\t\t"+no+"\t\t\t"+price);
//							Stocks[i].add(""+i+1);
////							System.out.println(Stocks[i]);
//							Stocks[i].add( searchResult.getString(2));
////							System.out.println(Stocks[i]);
//							
//							Stocks[i].add(""+no);
////							System.out.println(Stocks[i]);
////							int values=no*(Integer.toString(searchResult.getInt(3));
//							Stocks[i].add(Integer.toString(searchResult.getInt(3)));
////							System.out.println(Stocks[i]);
							j++;
							  
						}

						con.close();
						
					} catch (Exception e1) {
						 
						e1.printStackTrace();
					}
				 String tempVar="";
				 for(int k=0;k<billing_items.size();k++) {
//				 System.out.println(billing_items.get(k));
				 tempVar+=billing_items.get(k)+"\r\n";

			 		}
				 Bills.setText(tempVar);
				 
				 
//				 int row1=row;
////				 String data[][]=new String[row1][4];
//////				    
////				    for(int i=0;i<data.length;i++) {
////			       	 
////			        	for(int j=0;j<data[i].length;j++) {
////			        		data[i][j]=Stocks[i].get(j);
//////			        		System.out.println(data[i][j]);
////			        		
////			        	}
////			        }
//				 
//				  
//				 String data[][]= {{"1","2","3","4"}};
//			        String column[]={"No","Tablet Name","Tablet Quantity","price"};         
//				    
//				    JTable jt=new JTable(data,column);    
				      
//				    BillingPane.add(jt);; 
				    
	 				 
			 }});
		
		
		f.getContentPane().add(addToCart);
		
		
		
      f.getContentPane().add(BillingPane);
        JLabel NO=new JLabel("NO");
        NO.setBounds(25, 280, 100, 25);
		 f.getContentPane().add(NO);
        
		 JLabel Tablet_Name=new JLabel("Tablet Name");
		 Tablet_Name.setBounds(245, 280, 100, 25);
		 f.getContentPane().add(Tablet_Name);
		 
		 JLabel Quantity=new JLabel("Quantity");
		 Quantity.setBounds(465, 280, 100, 25);
		 f.getContentPane().add(Quantity);
		 
		 
		 JLabel Price=new JLabel("Price");
		 Price.setBounds(725, 280, 100, 25);
		 f.getContentPane().add(Price);
		 
		 JLabel DoctorName=new JLabel("DoctorName");
		 DoctorName.setBounds(1000, 390, 100, 25);
		 f.getContentPane().add(DoctorName);
		 
		 JTextField doctorName= new JTextField ("");
		 doctorName.setBounds(1170, 390, 150, 25);
		f.getContentPane().add(doctorName);
		
		
		JLabel CustomerName=new JLabel("CustomerName");
		CustomerName.setBounds(1000, 460, 100, 25);
		 f.getContentPane().add(CustomerName); 
		
		JTextField CustomerName1= new JTextField ();
		CustomerName1.setBounds(1170, 460, 150, 25);
		f.getContentPane().add(CustomerName1);
		
		
		
		JLabel phoneNumberJLabel=new JLabel("phoneNumber");
		phoneNumberJLabel.setBounds(1000, 510, 100, 25);
		 f.getContentPane().add(phoneNumberJLabel);
		 
		JTextField phoneNumber= new JTextField ();
		phoneNumber.setBounds(1170, 510, 150, 25);
		f.getContentPane().add(phoneNumber);	
		 
		
		 JButton Print =new JButton("Print");
		 Print.setBounds(1170, 610, 150, 25);
	     Print.addActionListener(new ActionListener(){  
			 public void actionPerformed(ActionEvent e){  
				 
				 
				 Date date = new Date();
				 String dateString=date.toString().replace(":"," ");
			 
	     try {
	            FileWriter writer = new FileWriter("C:\\Users\\MADHAN\\Desktop\\billls\\"+CustomerName1.getText()+" "+dateString+".txt", true);
	            writer.write("\n------------------Hello to Medical Shop---------------------------------------------");
	            writer.write("\r\n----------------------------------------------------------------------------------");   // write new line
	            writer.write("\r\n-----------------------------------------billing-----------------------------------");
	            writer.write("\r\n Doctor name : "+doctorName.getText()+" Customer Name: "+CustomerName1.getText()+"    PhoneNumber  "+phoneNumber.getText()+"");
	            writer.write("\r\n-----------------------------------------------------------------------------------");   // write new line
	            writer.write("\r\n NO                        Tablet name        Quantity                price");
	            writer.write("\r\n-----------------------------------------------------------------------------------");   // write new line
	            writer.write("\r\n");
	            writer.write(Bills.getText());
	            writer.write("\r\n------------------------------------------------------------------------------------");   // write new line
	            writer.write("\r\n");
	            writer.write("                                                		Total	"+total.getText());
	            writer.write("\r\n------------------------------------------------------------------------------------");   // write new line

	            writer.close();
	        } catch (IOException e1) {
	            e1.printStackTrace();
	        }
	     
	     try 
		 {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="system";
			String password="admin";
					
			Connection con=DriverManager.getConnection(url, user, password);
			PreparedStatement customerTablet=con.prepareStatement("insert into customerdetails values(?,?,?) "); 
 			
			 Set<Entry<String, Integer>> entrySet = tabletname.entrySet();
			 
			    // Obtaining an iterator for the entry set
			    Iterator it = entrySet.iterator();
			 
			    // Iterate through HashMap entries(Key-Value pairs)
			    System.out.println("HashMap Key-Value Pairs : ");
			    int l=0;
			    while(it.hasNext()){
			       Map.Entry me = (Map.Entry)it.next();
			      
			       System.out.println("Key is: "+me.getKey() + " & " +" value is: "+me.getValue()+"---->"+l);
			       Statement stmt=con.createStatement();
					 
			  	 
					ResultSet searchResult=stmt.executeQuery("select tabetquantity from tabletdetails where tabletname='"+ me.getKey()+"'");
			       int temp=0;
					while(searchResult.next()) {
						 temp= searchResult.getInt(1);
						 
					}
					System.out.println(temp);
					int a=(int) me.getValue();
					int update=temp-a;
					System.out.println(update);
					PreparedStatement updateTablet=con.prepareStatement("update tabletdetails set  tabetquantity="+update+" where tabletname='"+me.getKey()+"'");
		 			 
					int i=updateTablet.executeUpdate();
			       l++;
			    
			    }
			
 			
//				
			 
			customerTablet.setInt(1,Integer.parseInt(phoneNumber.getText()) );
			customerTablet.setString(2, CustomerName1.getText());
			customerTablet.setInt(3,Integer.parseInt(total.getText()));
	 
			
			int i=customerTablet.executeUpdate();
			f.dispose();
			new Bill(); 
			con.close();
		
		} catch (Exception e1) {
			
			e1.printStackTrace();
			
		}	
	     
	     File file=new File("C:\\Users\\MADHAN\\Desktop\\billls\\"+CustomerName1.getText()+" "+dateString+".txt");	 
	     Desktop desktop = Desktop.getDesktop();
	        if(file.exists())
				try {
					desktop.open(file);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        
	        
	        
	        
	        
	        
			 }});
		 f.getContentPane().add(Print);
		 
		 JLabel removeLabel=new JLabel("[ *Nth Items to Remove ]");
		 removeLabel.setBounds(1170, 330, 200, 25);
		 f.getContentPane().add(removeLabel);
		 JTextField removeBox=new JTextField();
		 removeBox.setBounds(1170, 300, 50, 25);
		 f.getContentPane().add(removeBox);
		 JButton removeItems=new JButton("Remove");
		 removeItems.setBounds(1000, 300, 150, 25);
		 removeItems.addActionListener(new ActionListener()
				 {

					 
					public void actionPerformed(ActionEvent arg0) {
						 int index1=Integer.parseInt(removeBox.getText());
						 int index=index1-1;
						 tabletname.remove(index);
						 billing_items.remove(index);
						 listOfItems.remove(index);
						 
						 String tempVar="";
						 for(int k=0;k<billing_items.size();k++) {
//						 System.out.println(billing_items.get(k));
						 tempVar+=billing_items.get(k)+"\r\n";

					 		}
						 Bills.setText(tempVar);
						 int temp=0;
						 for(int i=0;i<listOfItems.size();i++) {
							 temp+=listOfItems.get(i); 
						 }
						 total.setText(temp+"");
					}
					
					
					
			 
				 });
		 
		 
		 f.getContentPane().add(removeItems);
		 JButton Refresh=new JButton("Refresh");
		 Refresh.setBounds(23, 10, 150, 25);
		 Refresh.addActionListener(new ActionListener()
				 {public void actionPerformed(ActionEvent arg0) {
					  
					 
			 new PrintFunction();
					 f.dispose();
					}});
		 
		 f.getContentPane().add(Refresh);
		f.setSize(1366,768);
        f.setVisible(true); 
	}
	 
	

	public static void main(String[] args) {
		PrintFunction a=new PrintFunction();

}
}