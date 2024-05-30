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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Lending  extends JFrame implements ActionListener{
	public static JLabel ltitle,lidno,lbookname,ldateofissue,ldateofexpiry;
	private JTextField tidno,tbookname,tdateofissue,tdateofexpiry;
	private JButton btnadd,btnback;
	private Statement s;
	private Connection cnn;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement psti;
	private ResultSetMetaData rsmd;
	public final String TBNAME="issue";
	
	Border border=BorderFactory.createLineBorder(Color.BLACK,1);
	JFrame frame=new JFrame();
	public Lending() {
		

		setLayout(null);
		setTitle("Online Library System");
		setVisible(true);
		setSize(700,300);
		setResizable(false);
		getContentPane().setBackground(Color.gray);
		
		setLocation(500,300);
		
		ltitle=new JLabel("Issue Of Books"); 
		lidno=new JLabel("IDNO");
		lbookname=new JLabel("BoookName");
		
		ldateofissue=new JLabel("DateOfIssue");
		ldateofexpiry=new JLabel("DateOfExpiry");
		
		
		tidno=new JTextField(30);
		tbookname=new JTextField(30);
		
		tdateofissue=new JTextField(30);
		tdateofexpiry=new JTextField(30);
		
		btnadd=new JButton("Add");
		btnback=new JButton("Back");
		
		add(ltitle);
		add(lidno);
		add(lbookname);
		
		add(ldateofissue);
		add(ldateofexpiry);
		add(tidno);
		add(tbookname);
		add(tbookname);
		add(tdateofissue);
		add(tdateofexpiry);
		add(btnadd);
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
	    String sql1="INSERT INTO "+TBNAME+" Values(?,?,?,?)";
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
		Lending obj=new Lending();
	}

	public void lib() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		
		if (e.getSource()==btnadd)
		{
		
			
			
			
			 try
             {
				 conn c=new conn();
				 Statement st = cnn.createStatement();
					String s1=tidno.getText();
					String s2=tbookname.getText();
					String s3=tdateofissue.getText();
					String s4=tdateofexpiry.getText();
             String sqli="insert into issue values('"+s1+"','"+s2+"','"+s3+"','"+s4+"')";
             long lg=st.executeUpdate(sqli);		//to make sure record is inserted or not.
      		if(lg>0)
      			JOptionPane.showMessageDialog(null,"Book Issued");
      		else
      			JOptionPane.showMessageDialog(null,"Failed to Issue Book ");
//      		cnn.close();
            
              
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
