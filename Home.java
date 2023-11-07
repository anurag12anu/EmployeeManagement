package EmployeM2Packege;

import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;

public class Home extends JFrame implements ActionListener{
	JButton view,update,remove,add;
	public Home() {
		getContentPane().setBackground(Color.white);
		setLayout(null);
		JLabel employee=new JLabel("Employee Details in home page");
		employee.setBounds(280,50,200,50);
		add(employee);
	
		 add=new JButton("add");
		add.setBounds(280,150,100,50);
		add.addActionListener(this);
		add(add);
		
		 update =new JButton("update");
		update.setBounds(280,300,100,50);
		 update.addActionListener(this);
		add(update);
		
		 remove =new JButton("remove");
		remove.setBounds(400,150,100,50);
		 remove.addActionListener(this);
		add(remove);
		
		view=new JButton("view");
		view.setBounds(400,300,100,50);
		 view.addActionListener(this);
		add(view);
		
		setSize(800,550);
		setVisible(true);
		setLocation(200,80);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==add) {
			setVisible(false);
			new AddEmployee();
			
		}else if(ae.getSource()==view) {
			setVisible(false);
			new ViewEmployeesData();
		}
		else if(ae.getSource()==update) {
			setVisible(false);
			new ViewEmployeesData();
			
		}
		else {
			setVisible(false);
			new  RemoveEmployee();
		}
	}

	public static void main(String[] args) {
		Home hm=new Home();
		
	}

}
