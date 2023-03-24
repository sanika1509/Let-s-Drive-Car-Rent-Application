import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.*;    
public class JProgressBarExample extends JFrame{    

JProgressBar jb;
JLabel wl1;
JPanel wp2;
int i=0,num=0; 

JProgressBarExample(){ 
	 
	 
     setContentPane(new JLabel(new ImageIcon("C:\\Users\\ketan\\OneDrive\\Pictures\\Car.jpg")));
      
    setLayout(null);
	
	//JLabel background = new JLabel(new ImageIcon("Car rental system.jpg"));
	wl1=new JLabel("Welcome To Car Rental System");
	wl1.setBounds(500,300,700,100);
	wl1.setForeground(Color.YELLOW);
	add(wl1);
	/*wp2=new JPanel();
	wp2.setBounds(0,100,500,750);
    add(wp2);*/
jb=new JProgressBar(0,2000);    
jb.setBounds(500, 400, 400, 60);  
jb.setForeground(Color.BLACK);
jb.setValue(0);    
jb.setStringPainted(true);    
 add(jb);    
 setSize(700,700);    
 setLayout(null);
 setVisible(true);
}    
public void iterate(){    
while(i<=2000){    
  jb.setValue(i);    
  i=i+10;    
  try{Thread.sleep(50);}catch(Exception e){}    
}    
}  

public static void main(String[] args) throws IOException {    
    JProgressBarExample m=new JProgressBarExample();    
    m.setVisible(true); 
    
    m.iterate(); 
    
}    

	}