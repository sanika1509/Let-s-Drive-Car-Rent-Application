import javax.swing.*;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class adminLogin extends JFrame implements ActionListener{
	JLabel usernamel,passwordl;
	JPanel l;
    JTextField usernamet1,passwordt2;
	JButton login;
	String usern,upass;

	
     adminLogin() {
    	 JFrame f=new JFrame();
    	 f.setLayout(null);
 		f.setSize(700,700);
 		  f.setContentPane(new JLabel(new ImageIcon("E:\\AJP WORD File\\Carbg.jpg")));
       
    	//----------------------------------------------------------------------
    	
    	//----------------------------------------------------------------------
    	
    	l=new JPanel();
    	l.setBounds(100,100,500,500);
    	l.setLayout(null);
    	l.setVisible(true);
    	l.setBackground(new Color(255,255,255,100));
        
    	  usernamel= new JLabel("Username :") ;
    	  usernamel.setBounds(50,150, 100,40);
    	 l.add(usernamel);
    	  usernamet1= new JTextField(50);
    	  usernamet1.setBounds(200,150, 250,40);
    	  l.add(usernamet1);
    	  
    	  passwordl= new JLabel("Password :") ;
    	  passwordl.setBounds(50, 250, 100, 40);
    	  l.add(passwordl);
    	  passwordt2= new JTextField(50);
    	  passwordt2.setBounds(200, 250, 250, 40);
    	 l.add( passwordt2);
    	  
    	  login = new JButton("Login");
          login.setBounds(180, 350, 150, 50);
          login.addActionListener(this);
          l.add(login);
          f.add(l);
         // f.setLayout(null);
          f.setVisible(true);
        
    	//-----------------------------------------------------------------------
    	
   
      }
     
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       adminLogin ul = new adminLogin();
       
	}
	public void actionPerformed(ActionEvent ua) {
		// TODO Auto-generated method stub
		
		if(ua.getSource() == login) {
			 usern = usernamet1.getText();
			 upass = passwordt2.getText();
			 displayUsers(usern , upass);
						
		}
			  
	}	
	
	public void displayUsers(String usern1, String upass1) {
        try {
        	
        	
               if ((usern1.equals("Admin")) && (upass1.equals("Admin1234"))) 
               {
         			 JOptionPane.showMessageDialog(null, "Login Successful...!");
         			 new AdminView();
               }
                 
               else {

                  JOptionPane.showMessageDialog(null, "Login Unsucessful.Please Check credentials  ");
            }
        
        }
            catch (Exception e) {

            	 JOptionPane.showMessageDialog(null, "Ooops ...! Something went wrong ...!");
                 
        }

}

	public void keyPressed(KeyEvent ke) {
		// TODO Auto-generated method stub
		if(ke.getKeyChar()>='0' && ke.getKeyChar()<='9')
		{
			usernamet1.setEditable(false);
			passwordt2.setEditable(true);
				
		}
		else if(ke.getKeyChar()>='a' && ke.getKeyChar()<='z' || ke.getKeyChar()>='A' && ke.getKeyChar()<='Z')
		{
			
			usernamet1.setEditable(true);
			passwordt2.setEditable(true);
		}
		else if(ke.getKeyCode()==ke.VK_BACK_SPACE )
		{
			usernamet1.setEditable(true);
			passwordt2.setEditable(true);
		}
		else if(ke.getKeyCode()==ke.VK_SHIFT  )
		{
			usernamet1.setEditable(false);
			passwordt2.setEditable(false);
		}
		else if(  ke.getKeyChar() == ' '|| ke.getKeyChar() == '/'|| ke.getKeyChar() == '.'|| ke.getKeyChar()== '\\'|| ke.getKeyChar()=='-' ||ke.getKeyChar()=='=') {
			usernamet1.setEditable(false);
			passwordt2.setEditable(false);
	       	}
		
					
		else 
		{
			
		}
		

	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		usernamet1.setEditable(true);
		passwordt2.setEditable(true);
      
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
}