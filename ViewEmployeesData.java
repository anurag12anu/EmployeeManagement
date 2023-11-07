package EmployeM2Packege;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class ViewEmployeesData extends JFrame implements ActionListener{
	JTable table;
	Connection con=null;
	 PreparedStatement prt=null;
	 Choice cempid;
	 JButton search,print,update,back;
	 
	
	ViewEmployeesData(){
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel searchlbl=new JLabel("search by emp id");
		searchlbl.setBounds(20,20,150,20);
		add(searchlbl);
		
		 cempid = new Choice();
		 cempid.setBounds(180,20,150,20);
		 add(cempid);
		 
		
		table=new JTable();
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 System.out.println("Driver loaded");
		 }
		 catch(Exception e1) {
			 System.out.println("Driver not loade");
		 }
		 try {
			   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement?user=root&password=Rewa@123");
		 System.out.println("Connetion success");
		 }
		 
		 catch(Exception e2) {
			 System.out.println("Connection not found");
		 }
		 try {
			
		  prt = con.prepareStatement("select * from addemp1");
		 System.out.println("Prepare sucess");
		 }
		 catch(Exception e3) {
			 System.out.println("Prepare not success");
		 }
		 try {
			 ResultSet rs = prt.executeQuery();
			 
			 
			 while(rs.next()) {
				 cempid.add(rs.getString("empid"));
			}
			  System.out.println("ExcuteUpdate success");
	 }
	 catch(Exception e5) {
		 System.out.println("ExcuteUpdate not success");
	 }
		 
		 try {
				 ResultSet rs = prt.executeQuery();
				 
				 table.setModel(DbUtils.resultSetToTableModel(rs));
				  System.out.println("ExcuteUpdate success");
		 }
		 catch(Exception e5) {
			 System.out.println("ExcuteUpdate not success");
		 }
		 JScrollPane jsp=new JScrollPane(table);
		 jsp.setBounds(0,100,900,600);
		 add(jsp);
		 
		search=new JButton("Search");
		search.setBounds(20,70,80,20);
		search.addActionListener(this);
		add(search);
		
		print=new JButton("Print");
		print.setBounds(120,70,80,20);
		print.addActionListener(this);
		add(print);
		
		update=new JButton("Update");
		update.setBounds(220,70,80,20);
		update.addActionListener(this);
		add(update);
		
		back=new JButton("Back");
		back.setBounds(320,70,80,20);
		back.addActionListener(this);
		add(back);
		
		
		setSize(900,700);
		setLocation(300,50);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==search) {
			//try {
				//JdbcClass  c=new JdbcClass();
			//PreparedStatement ps = c.con.prepareStatement("select * from addemp1 where empid='"+cempid.getSelectedItem()+"'");
			//ResultSet rs = ps.executeQuery();
			///table.setModel(DbUtils.resultSetToTableModel(rs));
			//}
			///catch(Exception pt) {
			//	System.out.println("connect and prepare not seccess");
			//}
		}
		else if(ae.getSource()==print) {
			try {
				table.print();
		}
			catch(Exception ap) {
				System.out.println("print not success");
			}
				
			}
		else if(ae.getSource()==update) {
			setVisible(false);
			new UpdateEmp (cempid.getSelectedItem());
		}
		else {
			setVisible(false);
			new Home();
		}
		}
	public static void main(String[] args) {
		new ViewEmployeesData();
	}
}
