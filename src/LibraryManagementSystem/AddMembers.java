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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;



public class AddMembers extends JFrame implements ActionListener {
public static JLabel  ltitle,lidno,lname,laddress,ldoi,ldoe,lamt;
private JTextField tidno,tname,taddress,tdoi,tdoe,tamt;
private JButton btnadd,btnback;

private Statement s;

private Connection cnn;
private Statement st;
private ResultSet rs;
private PreparedStatement psti;
private ResultSetMetaData rsmd;
private String name;
private int idno;
public final String TBNAME="members";

Border border=BorderFactory.createLineBorder(Color.BLACK,1);
	JFrame frame=new JFrame();
	
public AddMembers()
{
	
	setLayout(null);
	setTitle("Online Library System");
	setVisible(true);
	setSize(700,400);
	setResizable(false);
	getContentPane().setBackground(Color.yellow); 
	setLocation(500,300);
	
	ltitle=new JLabel("Membership");
	
	lidno=new JLabel("IDNo:");
	laddress=new JLabel("Address");
	ldoe=new JLabel("Date Of Expiry:");
	
	lname=new JLabel("Name:");
	ldoi=new JLabel("Date Of Issue:");
	lamt=new JLabel("Amount:");
	
	tidno=new JTextField(30);
	taddress=new JTextField(30);
	tdoe=new JTextField(30);
	
	tname=new JTextField(30);
	tdoi=new JTextField(30);
	tamt=new JTextField(30);
	
	btnadd=new JButton("Add");
	btnback=new JButton("Back");
	
	add(ltitle);
	add(lidno);
	add(laddress);
	add(ldoe);
	add(lname);
	add(ldoi);
	add(lamt);
	add(tidno);
	add(taddress);
	add(tdoe);
	add(tname);
	add(tdoi);
	add(tamt);
	add(btnadd);
	add(btnback);
	
	ltitle.setBounds(250,10,150,30);
	ltitle.setForeground(Color.BLACK);
	ltitle.setFont(new Font("serif",Font.BOLD,20));
	
	lidno.setBounds(60, 80, 100, 30);
	laddress.setBounds(60, 120, 100, 30);
	ldoe.setBounds(60, 160, 100, 30);
	
	tidno.setBounds(150, 80, 150, 30);
	taddress.setBounds(150, 120, 150, 30);
	tdoe.setBounds(150, 160, 150, 30);
	
	lname.setBounds(350, 80, 100, 30);
	ldoi.setBounds(350, 120, 100, 30);
	lamt.setBounds(350, 160, 100, 30);
	
	tname.setBounds(450, 80, 150, 30);
	tdoi.setBounds(450, 120, 150, 30);
	tamt.setBounds(450, 160, 150, 30);
	
	btnadd.setBounds(150, 220, 100, 30);
	btnadd.setFont(new Font("serif",Font.BOLD,15));
	btnadd.addActionListener(this);
	btnadd.setBackground(Color.BLACK);
	btnadd.setForeground(Color.WHITE);
	
	btnback.setBounds(450, 220, 100, 30);
	btnback.setFont(new Font("serif",Font.BOLD,15));
	btnback.addActionListener(this);
	btnback.setBackground(Color.BLACK);
	btnback.setForeground(Color.WHITE);
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	try
	{
	Class.forName("com.mysql.jdbc.Driver");  
    
    cnn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","vivek","7338085820");
    s =cnn.createStatement();  
    String sql1="INSERT INTO "+TBNAME+" Values(?,?,?,?,?,?)";
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
		AddMembers	obj=new AddMembers();
		
		
	}

	public void lib() {
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==btnadd)
		{
			doidno();
			doname();
			
			
			
			 try
             {
				
				     conn cl=new conn();
				     
		    	 Statement st = cnn.createStatement();
				    String s1=tidno.getText();
					String s2=tname.getText();
					String s3=taddress.getText();
					String s4=tdoi.getText();
					String s5=tdoe.getText();
					String s6=tamt.getText();
             String sqli="insert into members values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"')";
      
             long lg=st.executeUpdate(sqli);		//to make sure record is inserted or not.
     		if(lg>0)
     			JOptionPane.showMessageDialog(null,"Members Added Successfully");
     		else
     			JOptionPane.showMessageDialog(null,"Failed to add members ");
//     		cnn.close();
           
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

				JOptionPane.showMessageDialog(null,"Invalid name too short");
			else
			{
				NameTest obj=new NameTest(name);
				if(obj.checkLetters()==true)
				{
					if(obj.checkVowel()==true)
					
						b=true;
						
					else

						JOptionPane.showMessageDialog(null,"Missing vowel");
				}
				else

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
      






/*   import java.sql.*;
import javax.servlet.*;

public class addmembers extends GenericServlet
{
                  Connection con;

            public void init(ServletConfig sc)
            {
             try
             {
              super.init(sc);
              Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
              con = DriverManager.getConnection("jdbc:odbc:sri","gscl","granada");
             }
             catch(Exception e){e.printStackTrace();}
            }

            public void service(ServletRequest req,ServletResponse res)
            {
             try
             {
              Statement st = con.createStatement();
              String s1 = req.getParameter("idno");
              String s2 = req.getParameter("mname");
              String s3 = req.getParameter("maddress");
              String s4 = req.getParameter("doi");
              String s5 = req.getParameter("doe");
              String s6 = req.getParameter("som");
              String s7 = req.getParameter("tom");
              String s8 = req.getParameter("amt");
              ServletOutputStream sos = res.getOutputStream();
              int i = st.executeUpdate("insert into members values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')");
              if(i>0)
               sos.println("data is successfully added");
              else
               sos.println("data is not added");
             }
              catch(Exception e){e.printStackTrace();}
           }
}

               

 */
