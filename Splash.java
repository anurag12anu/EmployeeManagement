package EmployeM2Packege;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Splash extends JFrame implements ActionListener{
	
	JButton click;
	 public Splash(){
		 getContentPane().setBackground(Color.white);
		 JLabel heading=new JLabel("Employee Management System");
		 add(heading);
		 setLayout(null);
		 heading.setBounds(180,10,1200,60);
		 heading.setFont(new Font("seres",Font.PLAIN,20));
		 heading.setForeground(Color.red);
		 heading.setVisible(true);
		 
		 //ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
		 //Image i2=i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
		 //ImageIcon i3=new ImageIcon(i2);
		 //JLabel image=new JLabel(i3);
		 //image.setBounds(50,100,1050,500);
		 //add(image);
		
		  click=new JButton("click here continue");
		 click.setBounds(150,250,300,70);
		 click.setBackground(Color.black);
		 click.setForeground(Color.white);
		 click.addActionListener(this);
		 add(click);
		 click.setVisible(true);
	
		setSize(600,500);
		setVisible(true);
		setLocation(200,50);
		while(true) {
			heading.setVisible(false);
			try {
				Thread.sleep(500);
			}
			catch(Exception e) {
				
			}
			heading.setVisible(true);
			try {
				Thread.sleep(500);
			}
			catch(Exception e) {
				
			}
		}
	}
	 public void actionPerformed(ActionEvent ae) {
		 if(ae.getSource()==click){
		 setVisible(false);
		 new Login();
	 }
		 else {
		 }
	 }

	public static void main(String[] args) {
		Splash sp=new Splash();
	}
}
