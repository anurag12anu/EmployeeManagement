package EmployeM2Packege;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class UpdateEmp extends JFrame implements ActionListener {
	String empid;
	
		JTextField  teducation,tempid,tdob,tname,tfathern,tage,taddress,tphoneno,temail,tjobpost,taddharno;
		JLabel nlempid; 
		 
	
		JButton adds,add,back;
		public UpdateEmp( String empid){
			this.empid=empid;
			 
			 getContentPane().setBackground(Color.white);
			 setLayout(null);
			 JLabel employeein =new JLabel("Update Employee details");
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
			 
			tdob=new JTextField ();
			tdob.setBounds(400,120,100,30);
			 add(tdob);
			 
			 
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
			
			
			teducation=new JTextField();
			teducation.setBounds(400,220,100,30);
			add(teducation);
			
			
			JLabel ljobpost=new JLabel("Job post");
			ljobpost.setBounds(100,270,100,30);
			add(ljobpost);
			 tjobpost=new JTextField();
			tjobpost.setBounds(150,270,100,30);
			add(tjobpost);
			
			JLabel lempid=new JLabel("Empid");
			lempid.setBounds(120,320,100,30);
			add(lempid);
			
			try {
				JdbcClass c=new JdbcClass();
				PreparedStatement ps = c.con.prepareStatement("select * from addemp1 where empid='"+empid+"'");
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					tname.setText(rs.getString("name"));
					tfathern.setText(rs.getString("fname"));
					tage.setText(rs.getString("age"));
					taddress.setText(rs.getString("address"));
					tphoneno.setText(rs.getString("phoneno"));
					temail.setText(rs.getString("email"));
					tjobpost.setText(rs.getString("jobpost"));
					taddharno.setText(rs.getString("addharno"));
					//dcdob.((JTextField)dcdob.setDateEditor().setUiComponent())dcdob.setText(rs.getString("name"));
					//(JTextField)dcdob.setDateFormatCalendar().setUI())dcdob.setText(rs.getString("name"));
					tdob.setText(rs.getString("dob"));
					teducation.setText(rs.getString("education"));
					tempid.setText(rs.getString("name"));
				}
			}
			catch(Exception eu) {
				System.out.println("empid connectioin not success");
			}
			
			JLabel laddharno=new JLabel("Addhar no");
			laddharno.setBounds(300,270,100,30);
			add(laddharno);
			taddharno=new JTextField();
			taddharno.setBounds(400,270,100,30);
			add(taddharno);
			
			adds=new JButton("Add Details");
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
				 dob= tdob.getText();
				  address=taddress.getText();
				  phoneno=tphoneno.getText();
				  emails=temail.getText();
				  jobpost=tjobpost.getText();
				  aadharno=taddharno.getText();
				  education=teducation.getText();
				  empid =tempid.getText();
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
		 new UpdateEmp("");
		

	}

}

