package com.ElectronicBillingSystem;
import java.sql.*;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
public class AdminMenu //implements ActionListene
{

	private JFrame frame;
	protected AbstractButton textitem_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMenu window = new AdminMenu();
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
	public AdminMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @param <AddItem>
	 */
	private  void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 835, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnMenuForAdmin = new JMenu(" Menu For Admin");
		menuBar.add(mnMenuForAdmin);
		
		JMenu mnNewMenu = new JMenu("Item");
		mnMenuForAdmin.add(mnNewMenu);

		JMenuItem mntmAdd = new JMenuItem("AddItem");
		mntmAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddItem item =new AddItem();
				 item.setVisible(true);
			
				
			}
		
		});
		mnNewMenu.add(mntmAdd);
        
		JMenuItem mntmModify = new JMenuItem("Update");
		mntmModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UpdateItem upitem=new UpdateItem();
			
				
			}
		});
		mnNewMenu.add(mntmModify);
		
		//JLabel lblNewLabel = new JLabel("View");
		//mnNewMenu.add(lblNewLabel);
		
	
		
		JMenuItem mntmDelete = new JMenuItem("Delete");
		mntmDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteItem item=new DeleteItem();
				 item.setVisible(true);
				
			}
				
				});
		
			
		JMenuItem mntmView = new JMenuItem("View");
		mntmView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ViewAdmin viewadmin= new ViewAdmin();
				frame.setVisible(true);
				
			}
		});
		mnNewMenu.add(mntmView);
				
		mnNewMenu.add(mntmDelete);
		
		JMenu mnManaf = new JMenu("Manufacture");
		mnMenuForAdmin.add(mnManaf);
		
		JMenuItem mntmAdd_1 = new JMenuItem("AddItems");
		mntmAdd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddItems items=new AddItems(); 			
           frame.setVisible(true);
           
			}
		});
		mnManaf.add(mntmAdd_1);
		frame.setVisible(true);
	}
	
}
	

