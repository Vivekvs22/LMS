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

public class AddBooks extends JFrame implements ActionListener {
	public static JLabel ltitle,lbookname,lbookcode,lauthor,ldateofarrival,lprice,lnoofbooks;
	private JTextField tbookname,tbookcode,tauthor,tdateofarrival,tprice,tnoofbooks;
	private JButton btnadd,btndelete,btnback;
	private Connection cnn;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement psti;
	private ResultSetMetaData rsmd;
	public final String TBNAME="Books";
	
	Border border=BorderFactory.createLineBorder(Color.BLACK,1);
	JFrame frame=new JFrame();
	
	public AddBooks() {

		setLayout(null);
		setTitle("Online Library System");
		setVisible(true);
		setSize(700,400);
		setResizable(false);
		getContentPane().setBackground(Color.cyan);
		setLocation(500,300);
	
		ltitle=new JLabel("AddBooks");
		
		lbookname=new JLabel("BookName");
		lauthor=new JLabel("Author");
		lprice=new JLabel("Price");
		
		lbookcode=new JLabel("BookCode");
		ldateofarrival=new JLabel("Date Of Arrival");
		lnoofbooks=new JLabel("No Of Books:");
		
		tbookname=new JTextField(30);
		tauthor=new JTextField(30);
		tprice=new JTextField(30);
		
		tbookcode=new JTextField(30);
		tdateofarrival=new JTextField(30);
		tnoofbooks=new JTextField(30);
		
		btnadd=new JButton("Add");
		btndelete=new JButton("Delete");
		btnback=new JButton("Back");
		
		add(ltitle);
		add(lbookname);
		add(lauthor);
		add(lprice);
		add(lbookcode);
		add(ldateofarrival);
		add(lnoofbooks);
		add(tbookname);
		add(tauthor);
		add(tprice);
		add(tbookcode);
		add(tdateofarrival);
		add(tnoofbooks);
		add(btnadd);
		add(btndelete);
		add(btnback);
		
		ltitle.setBounds(300,10,150,30);
		ltitle.setForeground(Color.BLACK);
		ltitle.setFont(new Font("serif",Font.BOLD,20));
		
		
		lbookname.setBounds(60, 80, 100, 30);
		lauthor.setBounds(60, 120, 100, 30);
		lprice.setBounds(60, 160, 100, 30);
		
		tbookname.setBounds(150, 80, 150, 30);
		tauthor.setBounds(150, 120, 150, 30);
		tprice.setBounds(150, 160, 150, 30);
		
		lbookcode.setBounds(350, 80, 100, 30);
		ldateofarrival.setBounds(350, 120, 100, 30);
		lnoofbooks.setBounds(350, 160, 100, 30);
		
		tbookcode.setBounds(450, 80, 150, 30);
		tdateofarrival.setBounds(450, 120, 150, 30);
		tnoofbooks.setBounds(450, 160, 150, 30);
		
		btnadd.setBounds(150, 220, 100, 30);
		btnadd.setFont(new Font("serif",Font.BOLD,15));
		btnadd.addActionListener(this);
		btnadd.setBackground(Color.BLACK);
		btnadd.setForeground(Color.WHITE);
		
		btndelete.setBounds(350, 220, 100, 30);
		btndelete.setFont(new Font("serif",Font.BOLD,15));
		btndelete.addActionListener(this);
		btndelete.setForeground(Color.red);
		btndelete.setBackground(Color.BLACK);

		
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
	    st =cnn.createStatement();  
	    String sql1="INSERT INTO "+TBNAME+" Values(?,?,?,?,?,?)";
	    String sql2="DELETE FROM "+TBNAME+"  Values(?)";
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
		AddBooks obj=new AddBooks();
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
					String s1=tbookname.getText();
					String s2=tbookcode.getText();
					String s3=tauthor.getText();
					String s4=tdateofarrival.getText();
					String s5=tprice.getText();
					String s6=tnoofbooks.getText();
             String sqli="insert into books values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"')";
             long lg=st.executeUpdate(sqli);		//to make sure record is inserted or not.
      		if(lg>0)
      			JOptionPane.showMessageDialog(null,"Books Added Successfully");
      		else
      			JOptionPane.showMessageDialog(null,"Failed to add Books ");
//      		cnn.close();
            
              } 
               catch(Exception ae){
 			 ae.printStackTrace();
               }
           }
		else if (e.getSource()==btndelete)
		{
		
			 try
            {
				 conn c=new conn();
				 Statement st = cnn.createStatement();

					String s1=tbookcode.getText();
					
            String sqli="DELETE FROM "+TBNAME+" where bookcode="+s1;
            long lg=st.executeUpdate(sqli);		//to make sure record is inserted or not.
      		if(lg>0)
      			JOptionPane.showMessageDialog(null,"Books Deleted Successfully");
      		else
      			JOptionPane.showMessageDialog(null,"Failed to delete Books ");
      		
            
              }
               catch(Exception ae){
 			 ae.printStackTrace();
               }
          }
			
	
		else if(e.getSource()==btnback)
		{
			Dashboard obj1=new Dashboard();
			setVisible(false);
			obj1.lib();
		}
	}

}
