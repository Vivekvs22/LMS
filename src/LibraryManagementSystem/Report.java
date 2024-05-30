package LibraryManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Report extends JFrame implements ActionListener {
	private JLabel ltitle,lidno,lname;
	private JTextField tidno,tname;
	private JButton btndelete,btnupdate,btnback;
	private String name;
	private int idno;
	private PreparedStatement psti;
	private ResultSetMetaData rsmd;
	private Connection cnn;
	private Statement st;
	private ResultSet rs;
	public final String TBNAME="members";
	
	Border border=BorderFactory.createLineBorder(Color.BLACK,1);
	JFrame frame=new JFrame();
	
	public Report()
	{
		
		setLayout(null);
		setTitle("Online Library System");
		setVisible(true);
		setSize(700,300);
		setResizable(false);
		getContentPane().setBackground(Color.orange);
		
		setLocation(500,300);
		
		ltitle=new JLabel("Member Report");
		lidno=new JLabel("IDNO");
		lname=new JLabel("Name");
		
		tidno=new JTextField(30);
		tname=new JTextField(30);
		
		
		btnupdate=new JButton("Update");
		btndelete=new JButton("Delete");
		btnback=new JButton("Back");
		
		add(ltitle);
		add(lidno);
		add(lname);
		add(tidno);
		add(tname);

		add(btnupdate);
		add(btndelete);
		add(btnback);
		
		ltitle.setBounds(250,10,150,30);
		ltitle.setForeground(Color.black);
		ltitle.setFont(new Font("serif",Font.BOLD,20));
		
		lidno.setBounds(60, 80, 100, 30);
		tidno.setBounds(150, 80, 150, 30);
		
		lname.setBounds(350, 80, 100, 30);
		tname.setBounds(450, 80, 150, 30);
		
		
		
		btnupdate.setBounds(150, 200, 100, 30);
		btnupdate.setFont(new Font("serif",Font.BOLD,15));
		btnupdate.addActionListener(this);
		btnupdate.setForeground(Color.black);
		
		btndelete.setBounds(250, 200, 100, 30);
		btndelete.setFont(new Font("serif",Font.BOLD,15));
		btndelete.addActionListener(this);
		btndelete.setForeground(Color.red);
		
		
		
		btnback.setBounds(450, 200, 100, 30);
		btnback.setFont(new Font("serif",Font.BOLD,15));
		btnback.addActionListener(this);
		btnback.setForeground(Color.black);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try
		{
		Class.forName("com.mysql.jdbc.Driver");  
	    
	    cnn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","vivek","7338085820");
	    st =cnn.createStatement();  
	    String sql1="INSERT INTO "+TBNAME+" Values(?,?)";
		psti=cnn.prepareStatement(sql1);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Error in Connection ....exiting "+e.toString());
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Report obj=new Report();
	}

	public void lib() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
	 if (e.getSource()==btnupdate)
		{
		
			doidno();
			doname();
		try
        {
			 conn c=new conn();
			 String s1=tidno.getText();
				String s2=tname.getText();
			 String sqli="update "+TBNAME+" set name='"+s2+"'where idno="+s1;
				long lg=st.executeUpdate(sqli);
				if(lg>0)
					JOptionPane.showMessageDialog(null,"Member Updated Successfully");
				else
					JOptionPane.showMessageDialog(null,"Member Not Updated ");
			}
        
         catch(Exception ae){
		 ae.printStackTrace();
         }
      }
		
		else if (e.getSource()==btndelete)
		{
		
			doidno();
	
		try
        {
			 conn c=new conn();
			 String s1=tidno.getText();
			 String sqli="delete from "+TBNAME+" where idno ="+s1;
			 c.s.executeUpdate(sqli);
        JOptionPane.showMessageDialog(null,"Member Deleted Successfully");
        
    
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

		private void doidno() {
		// TODO Auto-generated method stub
			boolean b=false;
			{
				try
				{
					String str=tidno.getText();
					idno=Integer.parseInt(str);
					b=true;
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,"Enter correct Idno!");
					JOptionPane.showMessageDialog(null,"Hint:ID number should be in Numbers");
				}
			}
	}
		private boolean doname() {
			// TODO Auto-generated method stub
			boolean b=false;
			try
			{
				name=tname.getText();
				if(name.length()<5)
//					tname.setText("Invalid name too short");
					JOptionPane.showMessageDialog(null,"Invalid name too short");
				else
				{
					NameTest obj=new NameTest(name);
					if(obj.checkLetters()==true)
					{
						if(obj.checkVowel()==true)
						
							b=true;
							
						else
//							tname.setText("Missing vowel");
							JOptionPane.showMessageDialog(null,"Missing vowel");
					}
					else
//						tname.setText("Name contains number");
						JOptionPane.showMessageDialog(null,"number exist");
					
				}
				b=true;
					
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,"Error in name");
			}
			return b;
		
	}

}
