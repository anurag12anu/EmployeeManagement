package EmployeM2Packege;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
	JTextField tfusername,tfpassword;
	Login(){
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel lbusername=new JLabel("Username");
		lbusername.setBounds(40,20,100,30);
		add(lbusername);
		
		JLabel lbpassword= new JLabel("password");
		lbpassword.setBounds(40,70,100,30);
		add(lbpassword);

		tfusername=new JTextField();
		tfusername.setBounds(180,20,150,30);
		add(tfusername);
		
		tfpassword=new JTextField();
		tfpassword.setBounds(180,70,150,30);
		add(tfpassword);
		
		 JButton login=new JButton("Login");
		 login.setBounds(150,200,300,30);
		 login.setBackground(Color.black);
		 login.setForeground(Color.white);
		 login.addActionListener(this);
		 add(login);
		 
		 setSize(600,300);
		 setLocation(450,200);
		 setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		try {
			JdbcClass j=new JdbcClass();
			String username=tfusername.getText();
			String password=tfpassword.getText();
			boolean isvalid = j.check(username,password);
			if(isvalid==true) {
				setVisible(false);
				new Home();
			}
			else {
				JOptionPane.showMessageDialog(null, "Invaild username or ");
				setVisible(false);
			}
		}
		catch( Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Login lg= new Login();
	}
}
