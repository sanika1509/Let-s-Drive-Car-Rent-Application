import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Userlogin extends JFrame implements ActionListener, KeyListener{
	JLabel uname,username,password ,un,up;
    JTextField unamet , usernamet,passwordt ,unt,upt;
	String msg , name , usern , upass ;
	JPanel maccount , login, account ;
	JButton myaccount, ulogin , createmyaccount , Login , start;
	UserView uv;
	
      Userlogin() {
    	
    	  setContentPane(new JLabel(new ImageIcon("E:\\AJP WORD File\\carbg.jpg")));
          
    	maccount = new JPanel();
    	maccount.setLayout(null);
    	maccount.setSize(600,600);
    	maccount.setOpaque(false);
    	        
    	myaccount = new JButton("Create My account");
    	myaccount.setBounds(30,150,150,50);
    	myaccount.addActionListener(this);
    	maccount.add(myaccount);
    	
    	ulogin = new JButton("Login");
    	ulogin.setBounds(30,250,150,50);
    	ulogin.addActionListener(this);
    	
    	
    	maccount.add(ulogin);
    	//----------------------------------------------------------------------
    	account = new JPanel();
    	account.setBounds(250, 150,450,400);
    	//account.setBackground(Color.);
    	account.setBackground(new Color(255,255,255,100));
       	account.setVisible(false);
       	account.setLayout(null);
       	
       	uname = new JLabel("Name:");
  	    uname.setBounds(30, 70, 100, 30);
    	account.add(uname);
    	unamet = new JTextField(50);
    	unamet.setBounds(110, 70, 200, 30);
    	account.add(unamet);
    	
    	username = new JLabel("Username :");
    	username.setBounds(30, 120, 100, 30);
    	account.add(username);
       	usernamet = new JTextField(50);
       	usernamet.setBounds(110, 120, 200, 30);
       	account.add(usernamet);
       	
       	password = new JLabel("Password :");
    	password.setBounds(30, 170, 100, 30);
    	account.add(password);
        passwordt = new JTextField(50);
       	passwordt.setBounds(110, 170, 200, 30);
       	account.add(passwordt);
       	
       	unamet.addKeyListener(this);
       	usernamet.addKeyListener(this);
       	passwordt.addKeyListener(this);
       	
       	createmyaccount = new JButton("Create My Acconut");
       	createmyaccount.setBounds(100, 280, 150, 30);
       	account.add(createmyaccount);
       	createmyaccount.addActionListener(this);
       	
    	maccount.add(account);
    	//----------------------------------------------------------------------
    	login = new JPanel();
    	login.setBounds(250, 150,450,400);
    	login.setBackground(new Color(255,255,255,100));
    	login.setVisible(false);
    	login.setLayout(null);
    	
    	  un = new JLabel("Username :") ;
    	  un.setBounds(30, 70, 100, 30);
    	  login.add(un);
    	  unt = new JTextField(50);
    	  unt.setBounds(110, 70, 200, 30);
    	  login.add(unt);
    	  
    	  up = new JLabel("Password :") ;
    	  up.setBounds(30, 120, 100, 30);
    	  login.add(up);
    	  upt = new JTextField(50);
    	  upt.setBounds(110, 120, 200, 30);
    	  login.add(upt);
    	  
    	  unt.addKeyListener(this);
    	  upt.addKeyListener(this);
    	  
    	  Login = new JButton("Login");
          Login.setBounds(100, 280, 150, 30);
          Login.addActionListener(this);
          login.add(Login);
         
          
    	maccount.add(login);
    	//-----------------------------------------------------------------------
    add(maccount);	
    setLayout(null);
    setVisible(true);
    setSize(700,700);
      }
     
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Userlogin ul = new Userlogin();
       
	}
	public void actionPerformed(ActionEvent ua) {
		// TODO Auto-generated method stub
		if(ua.getSource()== myaccount) {
			account.setVisible(true);
			login.setVisible(false);
		}
		if(ua.getSource()== ulogin) {
			account.setVisible(false);
			login.setVisible(true);
		}
		if(ua.getSource()== createmyaccount) {
			try {
				name = unamet.getText();
				//name = .parseInt(msg);
				usern = usernamet.getText();
				//cust_name = Integer.parseInt(msg);
				upass = passwordt.getText();
				//actual_amount =Integer. parseInt(msg);
				
			 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/carrentalsystem","root", "root");
				String count = "insert into useraccount values (?,?,?)";
			  PreparedStatement stmt= conn.prepareStatement(count);	
			  stmt.setString(1, name);
			  stmt.setString(2, usern);
			  stmt.setString(3, upass);
			  int i =stmt.executeUpdate();
		       // ResultSet count = stmt.e("select * from cust_data");
			  
		        System.out.println(i);
		        
		      } catch (SQLException c) {
				// TODO Auto-generated catch block
				c.printStackTrace();
			}			
			}
		if(ua.getSource() == Login) {
			 usern = unt.getText();
			 upass = upt.getText();
			 displayUsers(usern , upass);
						
		}
			  
	}	
	public void permission() {
		 JOptionPane.showMessageDialog(null, "Login Successful...!");
		 new UserView();
	}
	public void displayUsers(String usern1, String upass1) {
        try {
        	
        	 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/carrentalsystem","root", "root");
             Statement stmt = conn.createStatement();
            String queryString = "SELECT username, password FROM useraccount";
            
            ResultSet results =stmt .executeQuery(queryString);
                        
            while (results.next()) {
            String username = results.getString("username");
            String password =  results.getString("password");

               if ((usern1.equals(username)) && (upass1.equals(password))) {

                 // JOptionPane.showMessageDialog(null, "Username and Password exist");  
                 permission();
                break;
                 
            }
               else {

                  JOptionPane.showMessageDialog(null, "Login Unsucessful.Please Check credentials  ");
            }
       
        }
            results.close();
        }
            catch (SQLException sql) {

            	sql.printStackTrace();
        }

}

	public void keyPressed(KeyEvent ke) {
		// TODO Auto-generated method stub
		if(ke.getKeyChar()>='0' && ke.getKeyChar()<='9')
		{
			unamet.setEditable(false);
	       	usernamet.setEditable(true);
	       	passwordt.setEditable(true);
	    	unt.setEditable(true);
	       	upt.setEditable(true);
			
				
		}
		else if(ke.getKeyChar()>='a' && ke.getKeyChar()<='z' || ke.getKeyChar()>='A' && ke.getKeyChar()<='Z')
		{
			
			unamet.setEditable(true);
	       	usernamet.setEditable(true);
	       	passwordt.setEditable(true);
	       	unt.setEditable(true);
	       	upt.setEditable(true);
					
		}
		else if(ke.getKeyCode()==ke.VK_BACK_SPACE )
		{
			unamet.setEditable(true);
	       	usernamet.setEditable(true);
	       	passwordt.setEditable(true);
	       	unt.setEditable(true);
	       	upt.setEditable(true);
		}
		else if(ke.getKeyCode()==ke.VK_SHIFT  )
		{
			unamet.setEditable(false);
	       	usernamet.setEditable(true);
	       	passwordt.setEditable(true);
	       	unt.setEditable(true);
	       	upt.setEditable(true);
		}
		else if(  ke.getKeyChar() == ' '|| ke.getKeyChar() == '/'|| ke.getKeyChar() == '.'|| ke.getKeyChar()== '\\'|| ke.getKeyChar()=='-' ||ke.getKeyChar()=='=') {
	        unamet.setEditable(false);
	       	usernamet.setEditable(false);
	       	passwordt.setEditable(false);
	       	unt.setEditable(false);
	       	upt.setEditable(false);
	       	if(ke.getKeyChar()== ' ') {
	       		unamet.setEditable(true);
	       	}
		}
					
		else 
		{
			
		}
		

	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		unamet.setEditable(true);
       	usernamet.setEditable(true);
       	passwordt.setEditable(true);
       	unt.setEditable(true);
       	upt.setEditable(true);
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
}