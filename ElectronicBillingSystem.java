package com.ElectronicBillingSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class ElectronicBillingSystem {

	private JFrame frmSupertechElectroinBilling;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ElectronicBillingSystem window = new ElectronicBillingSystem();
					window.frmSupertechElectroinBilling.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ElectronicBillingSystem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSupertechElectroinBilling = new JFrame();
		frmSupertechElectroinBilling.getContentPane().setBackground(Color.WHITE);
		frmSupertechElectroinBilling.getContentPane().setForeground(Color.WHITE);
		frmSupertechElectroinBilling.setTitle("SuperTech Electroin Billing System");
		frmSupertechElectroinBilling.setBounds(100, 100, 604, 445);
		frmSupertechElectroinBilling.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSupertechElectroinBilling.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(117, 32, 46, 14);
		frmSupertechElectroinBilling.getContentPane().add(label);
		
		JLabel lbltext = new JLabel("SuperTech Electronic Billing System");
		lbltext.setBounds(45, 18, 387, 28);
		lbltext.setForeground(Color.BLUE);
		lbltext.setFont(new Font("Tahoma", Font.PLAIN, 23));
		frmSupertechElectroinBilling.getContentPane().add(lbltext);
		
		JButton btnAdminButton = new JButton("AdminLogin");
		btnAdminButton.setBounds(117, 337, 116, 28);
		btnAdminButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WelcomePageForAdmin wpa= new WelcomePageForAdmin();
		
			}
		});
		btnAdminButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frmSupertechElectroinBilling.getContentPane().add(btnAdminButton);
		
		JButton btnCashierButton = new JButton("CashierLogin");
		btnCashierButton.setBounds(382, 337, 116, 28);
		btnCashierButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				WelcomePageForCashier wpa= new WelcomePageForCashier();
				//frame.setVisible(true);
        }       
		});
		btnCashierButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frmSupertechElectroinBilling.getContentPane().add(btnCashierButton);
		
		JLabel lblNewLabel = new JLabel("");
		Image Img = new ImageIcon(this.getClass().getResource("/it.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(Img));
		lblNewLabel.setBounds(10, 71, 568, 255);
		frmSupertechElectroinBilling.getContentPane().add(lblNewLabel);
	//	Image Img = new ImageIcon(this.getClass().getResource("/.jpg")).getImage();
		
	}
}
