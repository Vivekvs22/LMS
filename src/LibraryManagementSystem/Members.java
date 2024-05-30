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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;






public class Members extends JFrame implements ActionListener{
	Connection conn = null;
	
	private JTable table;
	private JLabel lidno,lname,laddress,ldoe,ldoi,lamt;
	private JButton btnloaddata,btnexit;
	private Connection cnn;
	private   ResultSet rs;
	private  Statement st ;
	private ResultSetMetaData rsmd;
	private PreparedStatement psti;
	public final String TBNAME="members";
    

	
public Members()  {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(430, 200, 1000, 600);

	
	setLayout(null);
	setTitle("Online Library System");
	setVisible(true);
	setSize(1000,600);
	
	getContentPane().setBackground(Color.LIGHT_GRAY);
	
	setLocation(100,100);
	
	lidno=new JLabel("Idno");
	lname=new JLabel("Name");
	laddress=new JLabel("Address");
	ldoi=new JLabel("Dateofissue");
	ldoe=new JLabel("DateofExpiry");
	lamt=new JLabel("Amount");
	
	add(lidno);
	add(lname);
	add(laddress);
	add(ldoi);
	add(ldoe);
	add(lamt);
	
	lidno.setBounds(260,10,50,30);
	lname.setBounds(380,10,50,30);
	laddress.setBounds(480,10,50,30);
	ldoi.setBounds(600,10,100,30);
	ldoe.setBounds(720,10,100,30);
	lamt.setBounds(830,10,50,30);
		
	table = new JTable();
	table.setSize(70,50);
	table.setBounds(250, 40, 700, 450);
	add(table);
	
	btnloaddata = new JButton("Load Data");
	btnloaddata.addActionListener(this);
	btnloaddata.setBounds(60, 100, 120, 30);
	
    add(btnloaddata);
    
    btnexit = new JButton("Back");
    btnexit.addActionListener(this);
    btnexit.setBounds(60, 250, 120, 30);
   
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
        	  String idno=String.valueOf(rs.getInt("idno"));
        	  String Name=rs.getString("Name");
        	  String Address=rs.getString("Address");
        	  String Dateofissue=rs.getString("Date of issue");
        	  String Dateofexpiry=rs.getString("Date of expiry");
        	  String Amount=rs.getString("Amount");
        	  
        	 
        	  
        	  AddMembers.lidno.setText(idno);
        	  AddMembers.lname.setText(Name);
        	  AddMembers.laddress.setText(Address);
        	  AddMembers.ldoi.setText(Dateofissue);
        	  AddMembers.ldoe.setText(Dateofexpiry);
        	  AddMembers.lamt.setText(Amount);
        	  
        	  String[] row= {idno,Name,Address,Dateofissue,Dateofexpiry,Amount};
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
			Members obj=new Members();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
		
	

	public void lib() {
		// TODO Auto-generated method stub
		
	}



	

}
