package LibraryManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;







public class Login extends JFrame implements ActionListener,Runnable{
private JLabel llogin,lusername,lpassword,ldate;
private JTextField tusername;
private JPasswordField tpassword;
private JButton btnlogin,btncancel,btnexit;
private boolean flag;
private Date dt;
private Thread th;
private String name;
private PreparedStatement psti;
private Statement st;
private ResultSet rs;
private Connection cnn;
public final String TBNAME="login";
    Border border=BorderFactory.createLineBorder(Color.BLACK,1);
	JFrame frame=new JFrame();
	
	public Login()
	{
		super("Login");
		setLayout(null);
		setTitle("Login");
		setVisible(true);
		setSize(500,300);
		setResizable(false);
		getContentPane().setBackground(Color.gray);
		
		setLocation(500,300);
		
		llogin=new JLabel("Welcome");
		lusername=new JLabel("Username");
		lpassword=new JLabel("Password");
		tusername=new JTextField(30);
		tpassword=new JPasswordField(30);
		btnlogin=new JButton("Login");
		btncancel=new JButton("Clear");
		btnexit=new JButton("Exit");
		ldate=new JLabel();
		
		add(llogin);
		add(lusername);
		add(lpassword);
		add(tusername);
		add(tpassword);
		add(btnlogin);
		add(btncancel);
		add(btnexit);
		add(ldate);
		
		llogin.setBounds(150,20,150,30);
		llogin.setForeground(Color.GREEN);
		llogin.setFont(new Font("serif",Font.BOLD,20));
		lusername.setBounds(70,60,100,30);
		lpassword.setBounds(70,100,100,30);
		tusername.setBounds(200,60,150,30);
		tpassword.setBounds(200,100,150,30);
		
		btnlogin.setBounds(70,140,100,30);
		btnlogin.setFont(new Font("serif",Font.BOLD,15));
		btnlogin.addActionListener(this);
		
	
		btncancel.setBounds(200,140,100,30);
		btncancel.setFont(new Font("serif",Font.BOLD,15));
		btncancel.addActionListener(this);
		
		btnexit.setBounds(325,140,100,30);
		btnexit.setFont(new Font("serif",Font.BOLD,15));
		btnexit.addActionListener(this);
		ldate.setBounds(100, 180, 250, 50);
	        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		flag=true;
		th=new Thread(this);
		th.start();
		
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
    	Login obj=new Login();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(flag)
		{
			dt=new Date();
			ldate.setText(dt.toString());
			try {
				Thread.sleep(1000);
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,"Error in  Date"); 
			}
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
		
			if(e.getSource()==btnlogin) {
				doname();
				 try{
			            conn c1 = new conn();
			        	String u=tusername.getText();
			    		String p=tpassword.getText();
			            
			            String q = "select * from login where username='"+u+"' and password='"+p+"'";
			            
			            ResultSet rs = c1.s.executeQuery(q); 
			            if(rs.next()){ 
			                new Dashboard().setVisible(true);
			                setVisible(false);
			            }else{
			                JOptionPane.showMessageDialog(null, "Invalid login");
			                setVisible(false);
			            }
			            

			        }catch(Exception ae){
			            ae.printStackTrace();
			        }
				
		
			}	
			 if(e.getSource()==btncancel)
				{
				
					tusername.setText("");
					tpassword.setText("");
			   }
			 if(e.getSource()==btnexit)
			 {
				 try {
					cnn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 System.exit(0);
				 
			 }
	}







	private boolean doname() {
		// TODO Auto-generated method stub
		boolean b=false;
		try
		{
			name=tusername.getText();
			if(name.length()<5)
//				tname.setText("Invalid name too short");
				JOptionPane.showMessageDialog(null,"Invalid name too short");
			else
			{
				NameTest obj=new NameTest(name);
				if(obj.checkLetters()==true)
				{
					if(obj.checkVowel()==true)
					
						b=true;
						
					else
//						tname.setText("Missing vowel");
						JOptionPane.showMessageDialog(null,"Missing vowel");
				}
				else
//					tname.setText("Name contains number");
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
