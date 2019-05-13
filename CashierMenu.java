package com.ElectronicBillingSystem;
import java.sql.*;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Color;
public class CashierMenu //implements ActionListene
{

	private JFrame frmSupertechElecronicBilling;
	protected AbstractButton textitem_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CashierMenu window = new CashierMenu();
					window.frmSupertechElecronicBilling.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CashierMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @param <AddItem>
	 */
	private  void initialize() {
		frmSupertechElecronicBilling = new JFrame();
		frmSupertechElecronicBilling.getContentPane().setBackground(Color.WHITE);
		frmSupertechElecronicBilling.setTitle("SuperTech Elecronic Billing System");
		frmSupertechElecronicBilling.getContentPane().setForeground(Color.WHITE);
		frmSupertechElecronicBilling.setBounds(100, 100, 835, 500);
		frmSupertechElecronicBilling.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmSupertechElecronicBilling.setJMenuBar(menuBar);
		
		JMenu mnMenuForAdmin = new JMenu(" Menu For Cashier");
		menuBar.add(mnMenuForAdmin);
		
		JMenu mnNewMenu = new JMenu("CreateBill");
		mnMenuForAdmin.add(mnNewMenu);

		JMenuItem mntmAdd = new JMenuItem("Bill");
		mntmAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Bill b =new Bill();
				//frame.setVisible(true);
			
				
			}
		
		});
		mnNewMenu.add(mntmAdd);
		
		JMenu mnManaf = new JMenu("ViewItem");
		mnMenuForAdmin.add(mnManaf);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("View");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewItem vi= new ViewItem();
				frmSupertechElecronicBilling.setVisible(true);
			}
		});
		mnManaf.add(mntmNewMenuItem);
		frmSupertechElecronicBilling.setVisible(true);
	}
	
}
	

