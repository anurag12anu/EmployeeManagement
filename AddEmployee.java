package EmployeM2Packege;

import java.awt.Color;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.toedter.calendar.JDateChooser;


public class AddEmployee extends JFrame implements ActionListener{
	JTextField tname,tfathern,tage,taddress,tphoneno,temail,tjobpost,taddharno;
	JLabel nlempid; 
	JComboBox cbeducation;
	JDateChooser dcdob;
	JButton adds,add,back;
	Random ran=new Random();
	int number =ran.nextInt(999999);
	 public AddEmployee() {
		 
		 getContentPane().setBackground(Color.white);
		 setLayout(null);
		 JLabel employeein =new JLabel("New Employee details");
		 employeein.setBounds(250,20,150,50);
		 employeein.setLocation(250,10);
		 add(employeein);
		 
		 JLabel name=new JLabel("name");
		 name.setBounds(100,70,50,30);
		 add(name);
		 
		  tname=new JTextField();
		 tname.setBounds(150,70,100,30);
		 add(tname);
		 
		 JLabel lfathern=new JLabel("Father name");
		 lfathern.setBounds(300,70,100,30);
		 add(lfathern);
		  tfathern=new JTextField();
		 tfathern.setBounds(400,70,100,30);
		 add(tfathern);
		 
		 JLabel lage=new JLabel("Age");
		 lage.setBounds(100,120,100,30);
		 add(lage);
		  tage=new JTextField();
		 tage.setBounds(150,120,100,30);
		 add(tage);
		 
		 JLabel ldob=new JLabel("Date of birth");
		 ldob.setBounds(300,120,150,30);
		 add(ldob);
		 
		  dcdob=new JDateChooser();
		 dcdob.setBounds(400,120,100,30);
		 add(dcdob);
		 
		 JLabel laddress =new JLabel("Address");
		 laddress.setBounds(100,170,100,30);
		 add(laddress);
		  taddress=new JTextField();
		 taddress.setBounds(150,170,100,30);
		 add(taddress);
		 
		 JLabel lphoneno=new JLabel("Phone no");
		 lphoneno.setBounds(300,170,150,30);
		add(lphoneno);
		 tphoneno=new JTextField();
		tphoneno.setBounds(400,170,100,30);
		add(tphoneno);
		
		JLabel lemail=new JLabel("Email ID");
		lemail.setBounds(100,220,100,30);
		add(lemail);
		temail=new JTextField();
		temail.setBounds(150,220,100,30);
		add(temail);
		
		JLabel leducation=new JLabel("Education");
		leducation.setBounds(300,220,100,30);
		add(leducation);
		
		String courses[]= {"BA","BCA","B.COM","BSC(PLAN)","BSC(CS)","B.TECH(CS)","B.TECH(MECH)"};
		cbeducation=new JComboBox(courses);
		cbeducation.setBounds(400,220,100,30);
		add(cbeducation);
		
		JLabel ljobpost=new JLabel("Job post");
		ljobpost.setBounds(100,270,100,30);
		add(ljobpost);
		 tjobpost=new JTextField();
		tjobpost.setBounds(150,270,100,30);
		add(tjobpost);
		
		JLabel lempid=new JLabel("Empid");
		lempid.setBounds(120,320,100,30);
		add(lempid);
		
		 nlempid=new JLabel(""+number);
		nlempid.setBounds(170,320,100,30);
		add(nlempid);
		
		JLabel laddharno=new JLabel("Addhar no");
		laddharno.setBounds(300,270,100,30);
		add(laddharno);
		taddharno=new JTextField();
		taddharno.setBounds(400,270,100,30);
		add(taddharno);
		
		adds=new JButton("Update Details");
		adds.setBounds(200,400,100,30);
		adds.addActionListener(this);
		add(adds);
		
		 back=new JButton("back");
		back.setBounds(350,400,100,30);
		back.addActionListener(this);
		add(back);
		 
		 setSize(700,600);
		 setVisible(true);
		 setLocation(200,70);
	 }
	 public void actionPerformed(ActionEvent ae) {
		 Connection con=null;
		 PreparedStatement prt=null;
		 String name,empid, fname, age, dob, address, phoneno, emails, jobpost, aadharno, education;
		 if(ae.getSource()==adds) {
			 
			  name=tname.getText();
			  fname=tfathern.getText();
			 age=tage.getText();
			 dob= ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
			  address=taddress.getText();
			  phoneno=tphoneno.getText();
			  emails=temail.getText();
			  jobpost=tjobpost.getText();
			  aadharno=taddharno.getText();
			  education=(String)cbeducation.getSelectedItem();
			  empid =nlempid.getText();
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
				
			  prt = con.prepareStatement("insert into addemp1 values('"+name+"','"+fname+"','"+age+"','"+dob+"','"+address+"','"+phoneno+"','"+emails+"', '"+jobpost+"','"+aadharno+"','"+education+"','"+empid+"')");
			 System.out.println("Prepare sucess");
			 }
			 catch(Exception e3) {
				 System.out.println("Prepare not success");
			 }
			 
			 try {
					  prt.executeUpdate();
					  System.out.println("ExcuteUpdate success");
			 }
			 catch(Exception e5) {
				 System.out.println("ExcuteUpdate not success");
			 }
			 try {
				JOptionPane.showMessageDialog(null,"Details add");
				setVisible(false);
				new Home();
				System.out.println(" DailogMessae success");
			 }
			 catch(Exception e) {
				 System.out.println("DailogMessage not success");
			 }
		 }
		 else {
			 setVisible(false);
			 new Home();
		 }
	 }

	public static void main(String[] args) {
		AddEmployee a=new AddEmployee();
	}

}

