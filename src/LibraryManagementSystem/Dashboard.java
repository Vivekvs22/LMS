package LibraryManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;



public class Dashboard extends JFrame implements ActionListener,Runnable{

	public JButton btnmembers,btnaddmembers,btnbooks,btnaddbooks;
	public JButton btnlend,btnreturn,btnreport,btnissued,btnlogout;
	public boolean flag;
	private ImageIcon icon;
	private Connection cnn;
	
	 Border border=BorderFactory.createLineBorder(Color.BLACK,1);
		JFrame frame=new JFrame();
		
public Dashboard()
{
	
	setLayout(null);
	setTitle("Online Library System");
	setVisible(true);
	setSize(600,400); 
	setResizable(false);
	setForeground(Color.CYAN);
	setLocation(500,300);
	getContentPane().setBackground(Color.magenta);
	
	btnmembers=new JButton("MEMBERS");
	btnaddmembers=new JButton("ADDMEMBERS");
	btnbooks=new JButton("BOOKS");
	btnaddbooks=new JButton("UpdateBOOKS");
	btnlend=new JButton("LENDING");
	btnreturn=new JButton("RETURNING");
	btnissued=new JButton("Issued");
	btnreport=new JButton("Membership Report");
	btnlogout=new JButton("LOGOUT");
	
	add(btnmembers);
	add(btnaddmembers);
	add(btnbooks);
	add(btnaddbooks);
	add(btnlend);
	add(btnreturn);
	add(btnissued);
	add(btnreport);
	add(btnlogout);
	
	
	
	
	btnmembers.setBounds(100,40,150,30);
	btnmembers.setFont(new Font("serif",Font.BOLD,15));
	btnmembers.addActionListener(this);
	
	
	btnaddmembers.setBounds(300,40,150,30);
	btnaddmembers.setFont(new Font("serif",Font.BOLD,15));
	btnaddmembers.addActionListener(this);
	
	
	btnbooks.setBounds(100,100,150,30);
	btnbooks.setFont(new Font("serif",Font.BOLD,15));
	btnbooks.addActionListener(this);
	
	
	btnaddbooks.setBounds(300,100,150,30);
	btnaddbooks.setFont(new Font("serif",Font.BOLD,15));
	btnaddbooks.addActionListener(this);

	btnlend.setBounds(100,150,150,30);
	btnlend.setFont(new Font("serif",Font.BOLD,15));
	btnlend.addActionListener(this);
	
	btnreturn.setBounds(300,150,150,30);
	btnreturn.setFont(new Font("serif",Font.BOLD,15));
	btnreturn.addActionListener(this);
	
	btnissued.setBounds(200,200,150,30);
	btnissued.setFont(new Font("serif",Font.BOLD,15));
	btnissued.addActionListener(this);
	
	btnreport.setBounds(180,250,200,30);
	btnreport.setFont(new Font("serif",Font.BOLD,15));
	btnreport.addActionListener(this);
	
	btnlogout.setBounds(400,300,100,30);
	btnlogout.setFont(new Font("serif",Font.BOLD,15));
	btnlogout.addActionListener(this);
	btnlogout.setForeground(Color.RED);
	
	
	
//	 ImageIcon i1=new ImageIcon(getClass().getResource("pexels-janko-ferlic-590493.jpg"));
//     Image i2 = i1.getImage().getScaledInstance(1950, 1000,Image.SCALE_DEFAULT);
//     ImageIcon i3 = new ImageIcon(i2); 
//	JLabel NewLabel = new JLabel(i3);
//	NewLabel.setSize(600, 400);
//	NewLabel.setLocation(600, 300);
//     add(NewLabel);
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dashboard obj=new Dashboard();
	}


	public void lib() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try
		{
			if(e.getSource()==btnmembers)
			{
				Members obj=new Members();
				obj.lib();
				this.dispose();
			}
			if(e.getSource()==btnaddmembers)
			{
				AddMembers obj0=new AddMembers();
				obj0.lib();
				dispose();
			}
			if(e.getSource()==btnbooks)
			{
				Books obj1=new Books();
				obj1.lib();
				dispose();
			}
			if(e.getSource()==btnaddbooks)
			{
				AddBooks obj2=new AddBooks();
				obj2.lib();
				dispose();
			}
			if(e.getSource()==btnlend)
			{
				Lending obj3=new Lending();
				obj3.lib();
				dispose();
			}
			if(e.getSource()==btnreturn)
			{
				Returning obj4=new Returning();
				obj4.lib();
				dispose();
			}
			if(e.getSource()==btnissued)
			{
				Issued obji=new Issued();
			}
			if(e.getSource()==btnreport)
			{
				Report obj5=new Report();
				obj5.lib();
				dispose();
			}
			if(e.getSource()==btnlogout)
			{
				
				 new Login().setVisible(true);
                 setVisible(false);


			}
		}
		catch(Exception ae)
		{
			ae.printStackTrace();
		}
		if(e.getSource()==btnlogout)
		{
			
			 new Login().setVisible(true);
             setVisible(false);


		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}



}
