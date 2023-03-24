import java.awt.*;
import java.lang.*; 
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.io.IOException;
import java.applet.*;
import java.sql.*;
public class UserView  extends JFrame implements ActionListener , KeyListener,FocusListener {
	JButton ub1,ub2,ub3;
	String tempusername;
	JFrame f1;
	JButton ur1,urt1;
	JPanel panel ,user_viewpanel,user_reservepanel,user_returnpanel;
	JLabel rl0,rl1,rl2,rl3,rl4,rl5,rl6,rl7,rl8,rl9,rl10,urtl0,urtl1,urtl2,urtl3,urtl4,urtl5;
	JTextField rt0,rt1,rt2,rt3,rt4,rt5,rt6,rt7,rt8,rt9,rt10,urtt0,urtt1,urtt2,urtt3,urtt4,urtt5;
	int cust_id ,actual_amount,total_amount,fine,cunod;
	String cuname,cuamount,cutp,msg,cumo;
	int cuid,caid;

	JTable  table;
	JScrollPane scroll;
	    UserView(){
	    	
	    f1 = new JFrame();
	    f1.setContentPane(new JLabel(new ImageIcon("E:\\AJP WORD File\\carbg.jpg")));
    	panel =new JPanel();      
    	panel.setBounds(30,50,700,500);
    //	panel.setSize(700,600);
        panel.setVisible(true); 
        panel.setLayout(null);
        panel.setOpaque(false);
        f1.add(panel);
        
    	ub1 = new JButton("Reserve") ;
    	ub1.setBounds(30,50,100,50);
    	panel.add(ub1);
    	
    	ub2 = new JButton("View");    	
    	ub2.setBounds(30,150,100,50);
    	panel.add(ub2);
    	
    	ub3 = new JButton("Return");    	
    	ub3.setBounds(30,250,100,50);
    	panel.add(ub3);
    	
    	//------------------------------------------------------------------------------------
    	
    	
    	user_reservepanel = new JPanel();
    	user_reservepanel.setBackground(new Color(255,255,255,100));
    	user_reservepanel.setBounds(200,50,350,490);
    	user_reservepanel.setVisible(false);
    
    	user_reservepanel.setLayout(null);
    	
    	
    	
    	rl0 = new JLabel("Customer ID:");
    	rl0.setBounds(30,30,110,35);
    	user_reservepanel.add(rl0);    	
    	rt0= new JTextField( 40);
    	rt0.setBounds(130,30,200,30);
    	user_reservepanel.add(rt0);
    		
			
					 	
    	rl1 = new JLabel("Customer Name:");
    	rl1.setBounds(30,70,110,35);
    	user_reservepanel.add(rl1);
    	rt1= new JTextField( 40);
    	rt1.setBounds(130,70,200,30);
    	user_reservepanel.add(rt1);
    	
    	rl2 =new JLabel("Car ID");
    	rl2.setBounds(30,100,110,50);
    	user_reservepanel.add(rl2);
    	rt2= new JTextField( 40);
    	rt2.setBounds(130,110,200,30);
    	user_reservepanel.add(rt2);
    	rt2.addFocusListener(this);
    	   	
    	rl4 = new JLabel("Customer Mobile: ");
    	rl4.setBounds(30,140,110,50);
    	user_reservepanel.add(rl4);
    	rt4= new JTextField( 40);
    	rt4.setBounds(130,150,200,30);
    	user_reservepanel.add(rt4);
    	
    	rl5 = new JLabel("Rent Per Day:");
    	rl5.setBounds(30,180,110,50);
    	user_reservepanel.add(rl5);
    	rt5= new JTextField( 40);
       	rt5.setBounds(130,190,200,30);
    	user_reservepanel.add(rt5);
    	
    	rl6 = new JLabel("Fine Per Day:");
    	rl6.setBounds(30,220,110,50);
    	user_reservepanel.add(rl6);
    	rt6= new JTextField( 40);
    	rt6.setBounds(130,230,200,30);
    	user_reservepanel.add(rt6);
    	
    	rl7 = new JLabel("Actual Amount:");
    	rl7.setBounds(30,260,110,50);
    	user_reservepanel.add(rl7);    	
    	rt7= new JTextField( 40);
    	rt7.setBounds(130,270,200,30);    	
    	user_reservepanel.add(rt7);
        	
        rl9 = new JLabel("Reserve Date:");
        rl9.setBounds(30,300,110,50);
    	user_reservepanel.add(rl9);
    	rt9= new JTextField( 40);
    	rt9.setBounds(130,310,200,30);
    	user_reservepanel.add(rt9);
    	
        rl10 = new JLabel("No. Of Days:");
        rl10.setBounds(30,340,110,50);
    	user_reservepanel.add(rl10);
    	rt10= new JTextField( 40);
    	rt10.setBounds(130,350,200,30);
    	user_reservepanel.add(rt10);
    	rt10.addFocusListener(this);
    	
    	ur1 = new JButton("Confirm");
    	ur1.setBounds(120,400,100,40);
    	user_reservepanel.add(ur1);
    	
    	ur1.addActionListener(this);
    	rt0.addKeyListener(this);
    	rt1.addKeyListener(this);
    	rt2.addKeyListener(this);
    	rt4.addKeyListener(this);
    	rt5.addKeyListener(this);
    	rt6.addKeyListener(this);
    	rt7.addKeyListener(this);
    	rt9.addKeyListener(this);
    	rt10.addKeyListener(this);
    	
    	panel.add(user_reservepanel);
    	
    	//-------------------------------------------------------------------------------------
    	user_viewpanel =new JPanel();
    	//user_viewpanel.setBounds(200,50,350,490);
    	user_viewpanel.setBounds(200,50,470,500);
    	user_viewpanel.setBackground(new Color(255,255,255,100));
    	user_viewpanel.setVisible(false);
    	
    	adminData();
       
	    
    	
    	panel.add(user_viewpanel);
    	//-------------------------------------------------------------------------------------
    	user_returnpanel = new JPanel();
       	user_returnpanel.setBounds(200,50,350,490);
       	user_returnpanel.setBackground(new Color(255,255,255,100));
    	user_returnpanel.setVisible(false);
    	user_returnpanel.setLayout(null);
    		
    	urtl0 = new JLabel("Car Id:");
       	urtl0.setBounds(30,40,110,50);
       	user_returnpanel.add(urtl0);    	
    	urtt0= new JTextField( 40);
    	urtt0.setBounds(130,50,200,30);
    	user_returnpanel.add(urtt0);
    	urtt0.addKeyListener(this);
    	
    	urtl1 = new JLabel("No. Of Days :");
       	urtl1.setBounds(30,80,110,50);
       	user_returnpanel.add(urtl1);    	
    	urtt1= new JTextField( 40);
    	urtt1.setBounds(130,90,200,30);
    	user_returnpanel.add(urtt1);
    	urtt1.addKeyListener(this);
    	
    	urtl2 = new JLabel("Actual amount:");
       	urtl2.setBounds(30,120,110,50);
       	user_returnpanel.add(urtl2);    	
    	urtt2= new JTextField( 40);
    	urtt2.setBounds(130,130,200,30);
    	user_returnpanel.add(urtt2);
    	urtt2.addKeyListener(this);
    	
    	urtl3 = new JLabel("Fine :");
       	urtl3.setBounds(30,160,110,50);
       	user_returnpanel.add(urtl3);    	
    	urtt3= new JTextField( 40);
    	urtt3.setBounds(130,170,200,30);
    	user_returnpanel.add(urtt3);
    	urtt3.addKeyListener(this);
    	
    	urtl4 = new JLabel("Total Amount :");
       	urtl4.setBounds(30,200,110,50);
       	user_returnpanel.add(urtl4);    	
    	urtt4= new JTextField( 40);
    	urtt4.setBounds(130,210,200,30);
    	user_returnpanel.add(urtt4);
    	urtt4.addKeyListener(this);
    	
    	urtl5 = new JLabel("Cust ID:");
       	urtl5.setBounds(30,240,110,50);
       	user_returnpanel.add(urtl5);    	
    	urtt5= new JTextField( 40);
    	urtt5.setBounds(130,250,200,30);
    	user_returnpanel.add(urtt5);
    	urtt5.addKeyListener(this);
    	urtt5.addFocusListener(this);
    	
    	urt1 = new JButton("Return");
    	urt1.setBounds(120,350,100,40);
    	user_returnpanel.add(urt1);
    	urt1.addActionListener(this);
    	
    	
    	
    	panel.add(user_returnpanel);
    	//-------------------------------------------------------------------------------------
    	ub1.addActionListener(this);
    	ub2.addActionListener(this);
    	ub3.addActionListener(this);
    	
    	
    	f1.setLayout(null);
    	f1.setSize(800,700);
    	f1.setVisible(true);
    	
    	
	    }
       public static void main (String args[]) throws IOException {
    	 UserView u =  new UserView();
    	    	 
    	 
       }
   		  

         
		//--------------------------------------------------------------------------------------
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		    			 
		if(e.getSource() == ub1) {
			
			user_returnpanel.setVisible(false);
			user_viewpanel.setVisible(false);			
			user_reservepanel.setVisible(true);
						
		}
		if(e.getSource()== ub2) {
			
			user_returnpanel.setVisible(false);
			user_reservepanel.setVisible(false);
			user_viewpanel.setVisible(true);
			
		}
		
		if(e.getSource()== ub3) {
			
			user_reservepanel.setVisible(false);
			user_viewpanel.setVisible(false);
			
			user_returnpanel.setVisible(true);
			
		}
if(e.getSource()== urt1) {
			
			//user_reservepanel.setVisible(false);
			//user_viewpanel.setVisible(false);
			
			//user_returnpanel.setVisible(true);
			callReturn();
		}
		
		 if(e.getSource()==ur1) {
			// cuid,cuname,cuamount,cutp,cumo,cunod
			
			cuid = Integer.parseInt(rt0.getText());
			cuname= rt1.getText();
			caid = Integer.parseInt(rt2.getText());
			//msg=rt4.getText();
			cumo = rt4.getText();
			actual_amount =Integer.parseInt(rt7.getText());	
			cunod =Integer.parseInt(rt10.getText());	
			userconfirm();
						
		  }
		
	   }
	public void userconfirm()
	{
		 try {
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/carrentalsystem","root", "root");
				String count = "insert into cust_data values (?,?,?,?,?,?,?)";
			  PreparedStatement stmt= conn.prepareStatement(count);	
			  stmt.setInt(1, cuid);
			  stmt.setString(2, cuname);
			  stmt.setInt(3, actual_amount);
			  stmt.setTimestamp(4, new java.sql.Timestamp(new java.util.Date().getTime()));
			  stmt.setString(5, cumo);
			  stmt.setInt(6, cunod);
			  stmt.setInt(7, caid);
			  
			  int i =stmt.executeUpdate();
		       // ResultSet count = stmt.e("select * from cust_data");
			  
		        System.out.println(i);
		        
		      } catch (SQLException c) {
				// TODO Auto-generated catch block
				c.printStackTrace();
			}	
	}
	
			public void adminData() {
		
			String[] columnNames = {"Car ID","Car model","Car Number","Car holder Name","Rent per day:","Charges  per day" ,"Available or Not"};
    		DefaultTableModel amodel = new DefaultTableModel();
    		 amodel.setColumnIdentifiers(columnNames);
    		 table = new JTable();
    		 table.setBounds(0,50,300,500);
    		 table.setModel(amodel);
    		 table.setFillsViewportHeight(true);
    		 scroll = new JScrollPane(table);
    		 table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    		 scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    		 scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    		 scroll.setBounds(10,10,500,490);
    		 user_viewpanel.add(scroll);
    		 int ci=0;
    		 String cm ="";
    		 String cn ="";
    		 String chn ="";
    		 String aon;
    		 float rpd =0;
    		 float cpd =0;
    	
    		 try
    		 { 
    		 	Connection conn1= DriverManager.getConnection("jdbc:mysql://localhost:3306/carrentalsystem", "root", "root");//Crating connection with database
    		      Statement statement1 = conn1.createStatement();//crating statement object
    		      String query1 = "select * from carrentalsystem.cars";//Storing MySQL query in A string variable
    		      ResultSet ars = statement1.executeQuery(query1);//executing query and storing result in ResultSet

    		 int i =0;
    		 while(ars.next())
    		 {
    			 ci=ars.getInt("cid");
    		 cm=ars.getString("cmodel");
    		 cn=ars.getString("cnumber");
    		 chn=ars.getString("cholder");
    		 rpd=ars.getFloat("rentperday");
    		 cpd=ars.getFloat("rentcharges");
    		 aon=ars.getString("Available");
    		 amodel.addRow(new Object[]{ci,cm,cn,chn,rpd,cpd,aon});
    		 i++; 
    		 }
    		 if(i<1)
    		 {
    		 JOptionPane.showMessageDialog(null, "No Record Found","Error",JOptionPane.ERROR_MESSAGE);
    		 }
    		 if(i ==1)
    		 {
    		 System.out.println(i+" Record Found");
    		 }
    		 else
    		 {
    		 System.out.println(i+" Records Found");
    		 }

    		 }
    		 catch(Exception ex)
    		 {
    		 //JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
    		 //JOptionPane.ERROR_MESSAGE);
    		 	ex.printStackTrace();
    		 }   	 
		}
			
			public void callReturn()
			{
{
		try
		{
		System.out.println("Return Function called");//----------
		int rid;
		int r=0;
		
		String avl="Yes";
			rid=Integer.parseInt(urtt0.getText());
			
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/carrentalsystem","root","root");
			System.out.println("Connection created"); //---------
			Statement stmt=conn.createStatement();
			String q="update carrentalsystem.cars set Available='"+avl+"' where cid="+rid+";";
			r=stmt.executeUpdate(q);
			System.out.println(r+ "Record updated.\n");
			//System.out.println(q);//------
			conn.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();

				
		}
	}
			}
			 

		public void keyPressed(KeyEvent ke) {
			// TODO Auto-generated method stub
			if(ke.getKeyChar()>='0' && ke.getKeyChar()<='9')
			{
				rt0.setEditable(true);
				rt1.setEditable(false);
				rt2.setEditable(true);
				
				rt4.setEditable(true);
				rt5.setEditable(true);
				rt6.setEditable(true);
				rt7.setEditable(true);
				
				rt9.setEditable(true);
				rt10.setEditable(true);
				urtt0.setEditable(true);
				urtt1.setEditable(true);
				urtt2.setEditable(true);
				urtt3.setEditable(true);
				urtt4.setEditable(true);
				urtt5.setEditable(true);
					
			}
			else if(ke.getKeyChar()>='a' && ke.getKeyChar()<='z' || ke.getKeyChar()>='A' && ke.getKeyChar()<='Z')
			{
				

				rt0.setEditable(false);
				rt1.setEditable(true);
				rt2.setEditable(true);
				
				rt4.setEditable(false);
				rt5.setEditable(false);
				rt6.setEditable(false);
				rt7.setEditable(false);
				
				rt9.setEditable(false);
				rt10.setEditable(false);
				urtt0.setEditable(false);
				urtt1.setEditable(false);
				urtt2.setEditable(false);
				urtt3.setEditable(false);
				urtt4.setEditable(false);
				urtt5.setEditable(false);
			}
			else if(ke.getKeyCode()==ke.VK_BACK_SPACE || ke.getKeyChar() == '/')
			{
				rt0.setEditable(false);
				rt1.setEditable(true);
				rt2.setEditable(false);
			
				rt4.setEditable(false);
				rt5.setEditable(false);
				rt6.setEditable(false);
				rt7.setEnabled(false);
				
				rt9.setEditable(true);
				rt10.setEditable(true);
				urtt0.setEditable(false);
				urtt1.setEditable(false);
				urtt2.setEditable(false);
				urtt3.setEditable(false);
				urtt4.setEditable(false);
				urtt5.setEditable(false);
			}
			else if(ke.getKeyCode()==ke.VK_SHIFT || ke.getKeyChar() == '.' ||  ke.getKeyChar() == ' ')
			{
				rt0.setEditable(false);
				rt1.setEditable(false);
				rt2.setEditable(false);
				
				rt4.setEditable(false);
				rt5.setEditable(false);
				rt6.setEditable(false);
				rt7.setEditable(false);
				
				rt9.setEditable(false);
				rt10.setEditable(false);
				urtt0.setEditable(false);
				urtt1.setEditable(false);
				urtt2.setEditable(false);
				urtt3.setEditable(false);
				urtt4.setEditable(false);
				urtt5.setEditable(false);
			}
						
			else 
			{
				
			}
			
		}
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			rt0.setEditable(true);
			rt1.setEditable(true);
			rt2.setEditable(true);
			
			rt4.setEditable(true);
			rt5.setEditable(true);
			rt6.setEditable(true);
			rt7.setEditable(true);
			
			rt9.setEditable(true);
			rt10.setEditable(true);
			urtt0.setEditable(true);
			
		}
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void focusGained(FocusEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void focusLost(FocusEvent arg0) {
			
			if(arg0.getSource()==rt2)
			{
				reserveFindActual();
			}
			if(arg0.getSource()==rt10)
			{
				int no=Integer.parseInt(rt10.getText());
				int m=Integer.parseInt(rt5.getText());
				rt7.setText(""+(no*m));
				rt7.setEditable(false);
			}
			if(arg0.getSource()==urtt5)
			{
				returnfine();
			}
		}
		public void reserveFindActual()
		{
			try
			{
			System.out.println("called");//----------
			
			int rid1=Integer.parseInt(rt2.getText());
				int rpd=0,r=0;
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/carrentalsystem","root","root");
				System.out.println("Connection created"); //---------
				Statement stmt=conn.createStatement();
				String q="select * from carrentalsystem.cars where cid="+rid1+";";
				
				ResultSet roo=stmt.executeQuery(q);
				while(roo.next())
				{
				 rpd=roo.getInt(5);
				 r=roo.getInt(6);
				}
				rt5.setText(""+rpd);
				rt6.setText(""+r);
				
				System.out.println(r+ "Record updated.\n");
					conn.close();
				
			}
			catch(Exception e)
			{
				e.printStackTrace();

					
			}
		}
		public void returnfine()
		{
			int cid=Integer.parseInt(urtt0.getText());
			int unod=Integer.parseInt(urtt1.getText());
			int cusid=Integer.parseInt(urtt5.getText());
			int ufine=0,fnod=0,actualfine=0,urpd=0,tot_amount=0;
			try
			{
				int nod=0,actu_amount=0;
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/carrentalsystem","root","root");
				System.out.println("Connection created"); //---------
				Statement stmt=conn.createStatement();
				String q="select * from carrentalsystem.cust_data where caid="+cid+" and cust_id="+cusid+";";
				String q2="select * from carrentalsystem.cars where cid="+cid+";";
				ResultSet roo=stmt.executeQuery(q);
				
				System.out.println(q+"\n"+q2);
				while(roo.next())
				{
				//actu_amount=roo.getInt(3);
				 nod=roo.getInt(6);
				}
				//urtt2.setText(""+actu_amount);
				ResultSet roo1=stmt.executeQuery(q2);
				while(roo1.next())
				{
					 urpd=roo1.getInt(5);
				 ufine=roo1.getInt(6);
				 
				}
				if(nod>unod)
				{
					fnod=nod-unod;
					actualfine=fnod*ufine;
					
				}
				else
				{
					fnod=unod-nod;
					actualfine=fnod*ufine;
				}
				if(nod>unod)
				{
					actualfine=0;
				}
			
				urtt3.setText(""+actualfine);//Fine Display
				actu_amount=unod*urpd;
				if(actu_amount<=0)
				{actu_amount=0;
				urtt2.setText(""+actu_amount);}
				else
				{
					urtt2.setText(""+actu_amount);
				}
				
				//urtt2.setText(""+actu_amount);
				tot_amount=actu_amount+actualfine;
				if(tot_amount<=0)
				{tot_amount=0;
				urtt4.setText(""+tot_amount);}
				else
				{
					urtt4.setText(""+tot_amount);
				}
				
				//System.out.println(r+ "Record updated.\n");
				urtt2.setEditable(false);
				urtt3.setEditable(false);
				urtt4.setEditable(false);
					conn.close();
				
			}
			catch(Exception e)
			{
				e.printStackTrace();

					
			}

		
		
		}
		
	//-------------------------------------------------------------------------------------------
	}