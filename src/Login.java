import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{

	JLabel ll1;
	JButton lb1,lb2;
	Login()
	{
		JFrame f=new JFrame();
		f.setLayout(null);
		f.setSize(500,500);
		  f.setContentPane(new JLabel(new ImageIcon("E:\\AJP WORD File\\Carbg.jpg")));
        
		f.setBackground(Color.LIGHT_GRAY);
		ll1=new JLabel("Login As");
		ll1.setForeground(Color.WHITE);
	  	
		ll1.setFont(new Font("Serif", Font.BOLD,50));		

		ll1.setBounds(300,200,250,60);
		f.add(ll1);
		lb1=new JButton("Admin");
		lb1.setBounds(150,450,100,50);
	
		f.add(lb1);
		lb1.addActionListener(this);
		lb2=new JButton("Customer");
		lb2.setBounds(500,450,100,50);
		f.add(lb2);
		lb2.addActionListener(this);
		f.setVisible(true);
		f.setSize(800,900);
	}
	public static void main(String args[])
	{
		
		Login login=new Login();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==lb2)
		{
			new Userlogin();
		}
		if(arg0.getSource()==lb1)
		{
			new adminLogin();
		}
	}

}