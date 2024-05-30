package LibraryManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Returning extends JFrame implements ActionListener{
	private JLabel ltitle,lidno,lbookname,ldateofissue,ldateofexpiry;
	private JTextField tidno,tbookname,tdateofissue,tdateofexpiry;
	private JButton btnreturn,btnback;
	
	Border border=BorderFactory.createLineBorder(Color.BLACK,1);
	JFrame frame=new JFrame();
	
	public Returning() {

		setLayout(null);
		setTitle("Online Library System");
		setVisible(true);
		setSize(700,300);
		setResizable(false);
		getContentPane().setBackground(Color.gray);
		
		setLocation(500,300);
		
		ltitle=new JLabel("Return Of Books");
		lidno=new JLabel("IDNO");
		lbookname=new JLabel("Boookname");
		ldateofissue=new JLabel("DateOfIssue");
		ldateofexpiry=new JLabel("DateOfExpiry");
		
		tidno=new JTextField(30);
		tbookname=new JTextField(30);
		tdateofissue=new JTextField(30);
		tdateofexpiry=new JTextField(30);
		
		btnreturn=new JButton("Return");
		btnback=new JButton("Back");
		
		add(ltitle);
		add(lidno);
		add(lbookname);
		add(ldateofissue);
		add(ldateofexpiry);
		add(tidno);
		add(tbookname);
		add(tdateofissue);
		add(tdateofexpiry);
		add(btnreturn); 
		add(btnback);
		
		ltitle.setBounds(300,10,150,30);
		ltitle.setForeground(Color.GREEN);
		ltitle.setFont(new Font("serif",Font.BOLD,20));
		
		lidno.setBounds(60, 80, 100, 30);
		ldateofissue.setBounds(60, 120, 100, 30);
		
		tidno.setBounds(150, 80, 150, 30);
		tdateofissue.setBounds(150, 120, 150, 30);
		
		lbookname.setBounds(350, 80, 100, 30);
		ldateofexpiry.setBounds(350, 120, 100, 30);
		
		tbookname.setBounds(450, 80, 150, 30);
		tdateofexpiry.setBounds(450, 120, 150, 30);
		
		btnreturn.setBounds(150, 220, 100, 30);
		btnreturn.setFont(new Font("serif",Font.BOLD,15));
		btnreturn.addActionListener(this);
		btnreturn.setBackground(Color.BLACK);
		btnreturn.setForeground(Color.WHITE);
		
		btnback.setBounds(450, 220, 100, 30);
		btnback.setFont(new Font("serif",Font.BOLD,15));
		btnback.addActionListener(this);
		btnback.setBackground(Color.BLACK);
		btnback.setForeground(Color.WHITE);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Returning obj=new Returning();
	}

	public void lib() {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==btnreturn)
		{
		
			
			
			
			
			 try
             {
				 conn c=new conn();
				 String s1=tidno.getText();
					String s2=tbookname.getText();
					String s3=tdateofissue.getText();
					String s4=tdateofexpiry.getText();
             String sqli="delete from issue where idno ="+s1;
             c.s.executeUpdate(sqli);
             JOptionPane.showMessageDialog(null,"Book Returned");
             setVisible(false);
         
             }
              catch(Exception ae){
			 ae.printStackTrace();
              }
           }
		if(e.getSource()==btnback)
		{
			Dashboard obj1=new Dashboard();
			setVisible(false);
			obj1.lib();
		}
	}

}
