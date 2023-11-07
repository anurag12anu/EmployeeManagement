package EmployeM2Packege;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class RemoveEmployee extends JFrame implements ActionListener{
	Choice cempid;
	JLabel name,phone,email;
	JButton Delete,back;
	public RemoveEmployee() {
		getContentPane().setBackground(Color.white);
		setLayout(null);
		JLabel lempid=new JLabel("Empid");
		lempid.setBounds(50,100,100,30);
		add(lempid);
		cempid=new Choice();
		cempid.setBounds(150,100,100,30);
		add(cempid);
		
		try {
			JdbcClass jd=new JdbcClass();
		PreparedStatement pre = jd.con.prepareStatement("select * from addemp1");
		ResultSet rs = pre.executeQuery();
		while(rs.next()) {
			cempid.add(rs.getString("empid"));
		}
		System.out.println("Execute success");
		}
		catch(Exception ex) {
			System.out.println("Execute not success");
			
		}
		JLabel lname=new  JLabel("Name");
		lname.setBounds(50,150,100,30);
		add(lname);
		
		 name=new  JLabel();
		name.setBounds(180,150,100,30);
		add(name);
		
		JLabel lphone=new  JLabel("Phoneno");
		lphone.setBounds(50,200,100,30);
		add(lphone);
		
		 phone=new  JLabel();
		phone.setBounds(180,200,100,30);
		add(phone);
		
		JLabel lemail=new  JLabel("EmailId");
		lemail.setBounds(50,250,100,30);
		add(lemail);
		
		 email=new  JLabel();
		email.setBounds(180,250,100,30);
		add(email);
		try {
			JdbcClass jd=new JdbcClass();
			String empid;
		PreparedStatement pre = jd.con.prepareStatement("select * from addemp1 where empid='"+cempid.getSelectedItem()+"'");
		ResultSet rs = pre.executeQuery();
		while(rs.next()) {
			name.setText(rs.getString("name"));
			phone.setText(rs.getString("phoneno"));
			email.setText(rs.getString("emails"));
		}
		System.out.println("Execute success");
		}
		catch(Exception ex) {
			System.out.println("Execute not success");
			
		}
		cempid.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent ie) {
				try {
					JdbcClass jd=new JdbcClass();
					String empid;
				PreparedStatement pre = jd.con.prepareStatement("select * from addemp1 where empid='"+cempid.getSelectedItem()+"'");
				ResultSet rs = pre.executeQuery();
				while(rs.next()) {
					name.setText(rs.getString("name"));
					phone.setText(rs.getString("phoneno"));
					email.setText(rs.getString("emails"));
				}
				System.out.println("Execute success");
				}
				catch(Exception ex) {
					System.out.println("Execute not success");
					
				}
				
			}
			
		});
		Delete=new JButton("Delete");
		Delete.setBounds(250,300,100,30);
		Delete.setBackground(Color.red);
		Delete.addActionListener(this);
		add(Delete);
		
		back=new JButton("Back");
		back.setBounds(400,300,100,30);
		back.setBackground(Color.BLUE);
		back.addActionListener(this);
		add(back);
		
		
	setSize(700,600);
	setLocation(100,50);
	setVisible(true);
	
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==Delete) {
			try {
				JdbcClass jd=new JdbcClass();
				PreparedStatement pre = jd.con.prepareStatement("delete  from addemp1 where empid='"+cempid.getSelectedItem()+"'");
				 pre.executeUpdate();
				JOptionPane.showMessageDialog(null, "successfully Delete");
				setVisible(false);
				new  Home();
			}
			catch(Exception e1) {
				System.out.println("not delete");
				
			}
			
			
		}
		else {
			setVisible(false);
			new Home();
		}
		
	}

	public static void main(String[] args) {
		new RemoveEmployee();
		

	}

}

