package LibraryManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;





public class LibraryManagement extends JFrame implements ActionListener{

	JLabel l1;
	JButton b1;
	
	public LibraryManagement() {
		 setSize(1366,500);          
         setLayout(null); 
         setLocation(30,200);
     	l1 = new JLabel("");
        b1 = new JButton("Next");
        
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
        
        ImageIcon i1=new ImageIcon(getClass().getResource("pexels-janko-ferlic-590493.jpg"));
        Image i3 = i1.getImage().getScaledInstance(1366, 500,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        l1 = new JLabel(i2);
        
        JLabel lid=new JLabel("Library Management System");
        lid.setBounds(30,300,1500,100);
        lid.setFont(new Font("serif",Font.PLAIN,70));
        lid.setForeground(Color.red);
        l1.add(lid);
        
        
        b1.setBounds(1170,400,100,30);
        l1.setBounds(0, 0, 1366, 500);
        
        l1.add(b1);
        add(l1);
        
        b1.addActionListener(this);
        setVisible(true);
        
        while(true){
                lid.setVisible(false); // lid =  j label
            try{
                Thread.sleep(500); //1000 = 1 second
            }catch(Exception e){} 
                lid.setVisible(true);
            try{
                Thread.sleep(500);
            }catch(Exception e){}
        }
        
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		      new Login();
	}

	 public static void main(String[] args) {
		 LibraryManagement window=new LibraryManagement();
		 window.setVisible(true);
	 
	 }
	 
}
