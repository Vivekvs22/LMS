package LibraryManagementSystem;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;




public class Books extends JFrame implements ActionListener{
	Connection conn = null;
	
	private JTable table;
	private JLabel l1,l2,l3,l4,l5,l6;
	private JButton btnloaddata,btnexit;
	private Connection cnn;
	private   ResultSet rs;
	private  Statement st ;
	private ResultSetMetaData rsmd;
	private PreparedStatement psti;
	public final String TBNAME="books";
    

	
public Books()  {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(430, 200, 1000, 600);
	Border border=BorderFactory.createLineBorder(Color.BLACK,1);
//	contentPane = new JPanel();
//	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//	setContentPane(contentPane);
//	contentPane.setLayout(null);
//	setVisible(true);
//	setSize(700,300);
	
	setLayout(null);
	setTitle("Online Library System");
	setVisible(true);
	setResizable(false);
	setSize(1000,600);
	
	getContentPane().setBackground(Color.LIGHT_GRAY);
	
	setLocation(100,100);
	

	l1=new JLabel("BookName");
	l2=new JLabel("BookCode");
	l3=new JLabel("Author");
	l4=new JLabel("DateofArrival");
	l5=new JLabel("Price");
	l6=new JLabel("NOofBooks");
	
	add(l1);
	add(l2);
	add(l3);
	add(l4);
	add(l5);
	add(l6);
	
	l1.setBounds(260,10,100,30);
	l2.setBounds(380,10,100,30);
	l3.setBounds(480,10,50,30);
	l4.setBounds(600,10,100,30);
	l5.setBounds(720,10,50,30);
	l6.setBounds(830,10,100,30);
	
	
	table = new JTable();
	table.setSize(100,100);
	table.setBackground(Color.white);
	
	table.setBounds(250, 40, 700, 450);
	add(table);
	
	btnloaddata = new JButton("Load Data");
	btnloaddata.addActionListener(this);
	btnloaddata.setBounds(60, 100, 120, 30);
	
    add(btnloaddata);
    
    btnexit = new JButton("Back");
    btnexit.addActionListener(this);
    btnexit.setBounds(60, 300, 120, 30);
   
    add(btnexit);
    
	 try{  
         Class.forName("com.mysql.jdbc.Driver");  
         
         cnn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","vivek","7338085820");
         st =cnn.createStatement();  
         
        
     }catch(Exception e){  
         System.out.println(e);
     }  
  
    
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
	if(e.getSource()==btnloaddata)
	{
		dodata();
		
		}
	
		if(e.getSource()==btnexit)
		{
			Dashboard obj1=new Dashboard();
			obj1.lib();
			setVisible(false);
		}
		
	}


	
	
	public String[] dodata() {
	// TODO Auto-generated method stub
		conn c=new conn();
		String[] arr=null;
		
        try
        {
        	String sql="select * from "+TBNAME;	
        	
        	
        	 rs=st.executeQuery(sql);
             table.setModel(DbUtils.resultSetToTableModel(rs));
             rsmd=rs.getMetaData();
             DefaultTableModel model=(DefaultTableModel) table.getModel();
             int cols=rsmd.getColumnCount();
             String[] colname=new String[cols];
             for(int i=0;i<cols;i++)
           	  colname[i]=rsmd.getColumnName(i+1);
          model.setColumnIdentifiers(colname);
          
         
          
          if(rs.next())
          {
        	  String bookname=String.valueOf(rs.getInt("bookname"));
        	  String bookcode=rs.getString("bookcode");
        	  String author=rs.getString("author");
        	  String dateofarrival=rs.getString("Date of arrival");
        	  String price=rs.getString("price");
        	  String noofbooks=rs.getString("No of books");
        	  
        	 
        	  
        	 AddBooks.lbookname.setText(bookname);
        	 AddBooks.lbookcode.setText(bookcode);
        	 AddBooks.lauthor.setText(author);
        	 AddBooks.ldateofarrival.setText(dateofarrival);
        	 AddBooks.lprice.setText(price);
        	 AddBooks.lnoofbooks.setText(noofbooks);	
        	  
        	  String[] row= {bookname,bookcode,author,dateofarrival,dateofarrival,price,noofbooks};
        	  model.addRow(row);
     
          }
        
          
               
        }
        catch(Exception ex){
        	arr=new String[2];
        	arr[1]="error in Fieldnames Retrval"+ex.toString();
        	ex.printStackTrace();}
		return arr;
       
}

	public static void main(String[] args){
		// TODO Auto-generated method stub
		try {
			Books obj=new Books();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
		
	

	public void lib() {
		// TODO Auto-generated method stub
		
	}



	

}
