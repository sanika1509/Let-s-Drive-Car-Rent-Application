import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class AdminView extends JFrame implements ActionListener,MouseListener,KeyListener{
	static JTable table;
	JScrollPane scroll ;
JButton add_car,modify_car,delete_car,view_car,add_record;
CardLayout cl;
JPanel adminView,addCarPan;
JLabel l0,al1,al2,al3,al4,al5,al6,al7,al8;
JTextField at1,at2,at3,at4,at5,at6,at7,at8;
JButton ab0;
JLabel ml0,ml1,ml2,ml3,ml4,ml5,ml6,ml7,ml8,dl1;
JTextField mt0,mt1,mt2,mt3,mt4,mt5,mt6,mt7,mt8,dt1;
JButton mb0,db0,vb0;
JFrame f;
	public AdminView()
	{	
  	  
		f=new JFrame();
		f.setSize(800,900);
		f.setLayout(null);
		f.setVisible(true);
		//f.setBackground(Color.LIGHT_GRAY);
		f.setContentPane(new JLabel(new ImageIcon("E:\\AJP WORD File\\carbg.jpg")));
	      
		adminView=new JPanel();
		l0=new JLabel("Admin Login");
		l0.setBounds(250,50,200,50);
		l0.setForeground(Color.WHITE);
		l0.setFont(new Font("Serif", Font.BOLD,36));		
		f.add(l0);
		add_car=new JButton(" Add ");
		add_car.setBounds(70,180,80,40);
		modify_car=new JButton(" Modify ");
		modify_car.setBounds(70,300,80,40);
		delete_car=new JButton(" Delete ");
		delete_car.setBounds(70,450,80,40);
		view_car=new JButton(" View ");
		view_car.setBounds(70,600,80,40);
		adminView.setOpaque(false);
		f.add(add_car);
		f.add(modify_car);
		f.add(delete_car);
		f.add(view_car);
		adminView.setBounds(200,150,500,600);
		//adminView.setBackground(Color.YELLOW);
		//adminView.setOpaque(false);
		f.add(adminView);
		cl=new CardLayout();
		adminView.setLayout(cl);
		addCarPan=new JPanel();
		addCarPan.setLayout(null);
		addCarPan.setBackground(new Color(255,255,255,100));
		
		//Defining Labels
		al1=new JLabel("Enter Car Id :");
		al1.setBounds(50,100,200,30);
		al2=new JLabel("Enter Car Model :");
		al2.setBounds(50,150,200,30);
		al3=new JLabel("Enter Car Number :");
		al3.setBounds(50,200,200,40);
		al4=new JLabel("Enter Car Holder Name :");
		al4.setBounds(50,250,200,40);
		al5=new JLabel("Enter Car Holder Phone :");
		al5.setBounds(50,300,200,40);
		al6=new JLabel("Enter Car Holders Address :");
		al6.setBounds(50,350,200,40);
		al7=new JLabel("Enter Rent Charges :");
		al7.setBounds(50,400,200,40);
		al8=new JLabel("Enter Late Chrges :");
		al8.setBounds(50,450,200,40);
		
		//Defining TextFields
		at1=new JTextField(30);
		at1.setBounds(250,100,200,30);
		at2=new JTextField(30);
		at2.setBounds(250,150,200,30);
		at3=new JTextField(30);
		at3.setBounds(250,200,200,30);
		at4=new JTextField(30);
		at4.setBounds(250,250,200,30);
		at5=new JTextField(30);
		at5.setBounds(250,300,200,30);
		at6=new JTextField(30);
		at6.setBounds(250,350,200,30);
		at7=new JTextField(30);
		at7.setBounds(250,400,200,30);
		at8=new JTextField(30);
		at8.setBounds(250,450,200,30);

		//Adding events
		at1.addKeyListener(this);
		at2.addKeyListener(this);
		at3.addKeyListener(this);
		at4.addKeyListener(this);
		at5.addKeyListener(this);
		at6.addKeyListener(this);
		at7.addKeyListener(this);
		at8.addKeyListener(this);
		
		//Adding Form
		addCarPan.add(al1);
		addCarPan.add(at1);
		addCarPan.add(al2);
		addCarPan.add(at2);
		addCarPan.add(al3);
		addCarPan.add(at3);
		addCarPan.add(al4);
		addCarPan.add(at4);
		addCarPan.add(al5);
		addCarPan.add(at5);
		addCarPan.add(al6);
		addCarPan.add(at6);
		addCarPan.add(al7);
		addCarPan.add(at7);
		addCarPan.add(al8);
		addCarPan.add(at8);
		ab0=new JButton("ADD RECORD");
		ab0.addActionListener(this);
		ab0.setBounds(150,500,200,50);
		addCarPan.add(ab0);
		
		//-------------------------------------------------------------------------------------------
		JPanel modifyCarPan=new JPanel();
		modifyCarPan.setLayout(null);
		ml0=new JLabel("Availability: (Yes / No )");
		ml0.setBounds(50,50,200,30);
		ml1=new JLabel("Enter Car Id :");
		ml1.setBounds(50,100,200,30);
		ml2=new JLabel("Enter Car Model :");
		ml2.setBounds(50,150,200,30);
		ml3=new JLabel("Enter Car Number :");
		ml3.setBounds(50,200,200,40);
		ml4=new JLabel("Enter Car Holder Name :");
		ml4.setBounds(50,250,200,40);
		ml5=new JLabel("Enter Car Holder Phone :");
		ml5.setBounds(50,300,200,40);
		ml6=new JLabel("Enter Car Holders Address :");
		ml6.setBounds(50,350,200,40);
		ml7=new JLabel("Enter Rent Charges :");
		ml7.setBounds(50,400,200,40);
		ml8=new JLabel("Enter Late Chrges :");
		ml8.setBounds(50,450,200,40);
		
		//Defining TextFields
		mt0=new JTextField();
		mt0.setBounds(250,50,200,30);
		mt1=new JTextField(30);
		mt1.setBounds(250,100,200,30);
		mt2=new JTextField(30);
		mt2.setBounds(250,150,200,30);
		mt3=new JTextField(30);
		mt3.setEditable(false);
		mt3.setBounds(250,200,200,30);
		mt4=new JTextField(30);
		mt4.setBounds(250,250,200,30);
		mt5=new JTextField(30);
		mt5.setBounds(250,300,200,30);
		mt6=new JTextField(30);
		mt6.setBounds(250,350,200,30);
		mt7=new JTextField(30);
		mt7.setBounds(250,400,200,30);
		mt8=new JTextField(30);
		mt8.setBounds(250,450,200,30);

		//Adding events
		mt0.addKeyListener(this);
		mt1.addKeyListener(this);
		mt2.addKeyListener(this);
		mt4.addKeyListener(this);
		mt5.addKeyListener(this);
		mt6.addKeyListener(this);
		mt7.addKeyListener(this);
		mt8.addKeyListener(this);
		
		//Adding Form
		modifyCarPan.add(ml0);
		modifyCarPan.add(mt0);
		modifyCarPan.add(ml1);
		modifyCarPan.add(mt1);
		modifyCarPan.add(ml2);
		modifyCarPan.add(mt2);
		modifyCarPan.add(ml3);
		modifyCarPan.add(mt3);
		modifyCarPan.add(ml4);
		modifyCarPan.add(mt4);
		modifyCarPan.add(ml5);
		modifyCarPan.add(mt5);
		modifyCarPan.add(ml6);
		modifyCarPan.add(mt6);
		modifyCarPan.add(ml7);
		modifyCarPan.add(mt7);
		modifyCarPan.add(ml8);
		modifyCarPan.add(mt8);
		
		mb0=new JButton("Modify Record");
		mb0.setBounds(150,500,200,50);
		mb0.addActionListener(this);
		modifyCarPan.add(mb0);
		modifyCarPan.setBackground(new Color(255,255,255,100));
		//-------------------------------------------------------------------------------------------

		JPanel deleteCarPan=new JPanel();
		deleteCarPan.setBackground(new Color(255,255,255,100));
		deleteCarPan.setLayout(null);
		dl1=new JLabel("Enter User Id To Delete:");
		dl1.setBounds(50,100,200,30);
		deleteCarPan.add(dl1);	
		dt1=new JTextField(30);
		dt1.setBounds(250,100,200,30);
		dt1.addKeyListener(this);
		deleteCarPan.add(dt1);
		db0=new JButton("Delete Record");
		db0.setBounds(150,200,200,50);
		db0.addActionListener(this);
		deleteCarPan.add(db0);
		
		//-------------------------------------------------------------------------------------------

		JPanel viewCarPan=new JPanel();
		viewCarPan.setBackground(new Color(255,255,255,100));
		showTableData();
		viewCarPan.add(scroll);
		//frame1.setVisible(true);
		//frame1.setSize(400,300);
		//-----------------------------------------------------------------------------------------------
		adminView.add(addCarPan,"Add new record :");
		adminView.add(modifyCarPan,"Modify record :");
		adminView.add(deleteCarPan,"Delete record :");
		adminView.add(viewCarPan,"View record :");
		add_car.addActionListener(this);
		modify_car.addActionListener(this);
		delete_car.addActionListener(this);
		view_car.addActionListener(this);
		addMouseListener(this);
		
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		cl.next(adminView);
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
				
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == add_car) {
			cl.show(adminView, "Add new record :");
			showTableData();
			}
		else if(ae.getSource() == delete_car) {
			cl.show(adminView, "Delete record :");
			}
		if(ae.getSource() == modify_car) {
			cl.show(adminView, "Modify record :");
			}
		if(ae.getSource() == view_car) {
			cl.show(adminView, "View record :");
			showTableData();
			}
		if(ae.getSource()==ab0)
		{
			addData();
		}
		if(ae.getSource()==mb0)
		{
			modifyData();
		}
		if(ae.getSource()==db0)
		{
			deleteData();
		}
	
	}
	
public void addData()
{
		try
		{
		System.out.println("add Function called");
		
		int carid,r=0;
		float rentcharges,fine;
		
		String carmodel,carnumber,carholdername,carholderphone,carholderaddress,avail="Yes";
			carid=Integer.parseInt(at1.getText());
			carmodel=at2.getText();
			carnumber=at3.getText();
			carholdername=at4.getText();
			carholderphone=at5.getText();
			carholderaddress=at6.getText();
			rentcharges=Float.parseFloat(at7.getText());
			fine=Float.parseFloat(at8.getText());
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/carrentalsystem","root","root");
			System.out.println("Connection created");
			Statement stmt=conn.createStatement();
			String q="insert into carrentalsystem.cars values ("+carid+",'"+carmodel+"','"+carnumber+"','"+carholdername+"',"+rentcharges+","+fine+","+carholderphone+",'"+carholderaddress+"','"+avail+"');";
			r=stmt.executeUpdate(q);
			System.out.println(r+ "Row inserted.\n"+q);
			conn.close();
			showTableData();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();

				
		}
	}
	 
	  public void modifyData()
{
		try
		{
		System.out.println("Modify Function called");//----------
		int carid,r=0;
		float rentcharges,fine;
		String carmodel,carnumber,carholdername,carholderphone,carholderaddress,availability;
			availability=mt0.getText();
			carid=Integer.parseInt(mt1.getText());
			carmodel=mt2.getText();
			carnumber=mt3.getText();
			carholdername=mt4.getText();
			carholderphone=mt5.getText();
			carholderaddress=mt6.getText();
			rentcharges=Float.parseFloat(mt7.getText());
			fine=Float.parseFloat(mt8.getText());
		//----------------------	availability="";
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/carrentalsystem","root","root");
			System.out.println("Connection created"); //---------
			Statement stmt=conn.createStatement();
			String q="update carrentalsystem.cars set cmodel='"+carmodel+"', cholder='"+carholdername+"' , rentperday="+rentcharges+" , rentcharges="+fine+" , cmobileno="+carholderphone+" , cholderaddress='"+carholderaddress+"', Available='"+availability+"' where cid="+carid+" ;";
			r=stmt.executeUpdate(q);
			System.out.println(r+ "Record updated.\n");
			System.out.println(q);//------
			conn.close();
			showTableData();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();

				
		}
	}

	  
	  
	   	  public void deleteData()
{
		try
		{
		System.out.println("Delete Function called");//----------
		int carid,r=0;
			carid=Integer.parseInt(dt1.getText());
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/carrentalsystem","root","root");
			System.out.println("Connection created"); //---------
			Statement stmt=conn.createStatement();
			String q="delete from carrentalsystem.cars where cid="+carid+" ;";
			r=stmt.executeUpdate(q);
			System.out.println(r+ "Record deleted.\n");
			System.out.print(q);//------
			conn.close();
			showTableData();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();

				
		}
	}
	   	  
	   	   public void showTableData()
{
	   		String[] columnNames = {"cid","cmodel","cnumber","cholder","rentperday","rentcharges","cmobileno","cholderaddress","available"};
	   		JFrame frame1;

DefaultTableModel model = new DefaultTableModel();
model.setColumnIdentifiers(columnNames);

table = new JTable();
table.setOpaque(false);
table.setModel(model); 
table.setFillsViewportHeight(true);
scroll = new JScrollPane(table);
table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
int cid;
String cmodel = "";
String cnumber = "";
String cholder="";
double rentperday=0.0;
double rentcharges=0.0;
long cmobileno;
String cholderaddress;
String avail;
try
{ 
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/carrentalsystem", "root", "root");//Crating connection with database
     Statement statement = connection.createStatement();//crating statement object
     String query = "select * from carrentalsystem.cars";//Storing MySQL query in A string variable
     ResultSet rs = statement.executeQuery(query);//executing query and storing result in ResultSet

int i =0;
while(rs.next())
{
//roll = rs.getString("rollno");
//name = rs.getString("name");
//cl = rs.getString("marks");
cid=rs.getInt("cid");
cmodel=rs.getString("cmodel");
cnumber=rs.getString("cnumber");
cholder=rs.getString("cholder");
rentperday=rs.getFloat("rentperday");
rentcharges=rs.getFloat("rentcharges");
cmobileno=rs.getLong("cmobileno");
cholderaddress=rs.getString("cholderaddress");
 avail=rs.getString("Available");
model.addRow(new Object[]{cid,cmodel,cnumber,cholder,rentperday,rentcharges,cmobileno,cholderaddress,avail});
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
	  	@Override
		public void keyPressed(KeyEvent ke) {
			// TODO Auto-generated method stub
			if(ke.getKeyChar()>='0' && ke.getKeyChar()<='9')
			{
				at1.setEditable(true);
				at2.setEditable(true);
				at3.setEditable(true);
				at4.setEditable(false);
				at5.setEditable(true);
				at6.setEditable(false);
				at7.setEditable(true);
				at8.setEditable(true);
				
				mt0.setEditable(false);
				mt1.setEditable(true);
				mt2.setEditable(true);
				//mt3.setEditable(true);
				mt4.setEditable(false);
				mt5.setEditable(true);
				mt6.setEditable(false);
				mt7.setEditable(true);
				mt8.setEditable(true);
					
				dt1.setEditable(true);
					
			}
			else if(ke.getKeyChar()>='a' && ke.getKeyChar()<='z' || ke.getKeyChar()>='A' && ke.getKeyChar()<='Z')
			{
				

				at1.setEditable(false);
				at2.setEditable(true);
				at3.setEditable(true);
				at4.setEditable(true);
				at5.setEditable(false);
				at6.setEditable(true);
				at7.setEditable(false);
				at8.setEditable(false);
				
				mt0.setEditable(true);
				mt1.setEditable(false);
				mt2.setEditable(true);
				//mt3.setEditable(true);
				mt4.setEditable(true);
				mt5.setEditable(false);
				mt6.setEditable(true);
				mt7.setEditable(false);
				mt8.setEditable(false);
				
				dt1.setEditable(false);
				
			}
			else if(ke.getKeyCode()==ke.VK_BACK_SPACE)
			{
				at1.setEditable(true);
				at2.setEditable(true);
				at3.setEditable(true);
				at4.setEditable(true);
				at5.setEditable(true);
				at6.setEditable(true);
				at7.setEnabled(true);
				at8.setEditable(true);
				
				mt0.setEditable(true);
				mt1.setEditable(true);
				mt2.setEditable(true);
				//mt3.setEditable(true);
				mt4.setEditable(true);
				mt5.setEditable(true);
				mt6.setEditable(true);
				mt7.setEnabled(true);
				mt8.setEditable(true);
				
				dt1.setEditable(true);
			}
			else if(ke.getKeyCode()==ke.VK_SHIFT || ke.getKeyChar() == '.' ||  ke.getKeyChar() == ' ')
			{
				at1.setEditable(false);
				at2.setEditable(false);
				at3.setEditable(false);
				at4.setEditable(true);
				at5.setEditable(false);
				at6.setEditable(true);
				at7.setEditable(false);
				at8.setEditable(true);
				
				mt0.setEditable(false);
				mt1.setEditable(false);
				mt2.setEditable(false);
				//mt3.setEditable(false);
				mt4.setEditable(true);
				mt5.setEditable(false);
				mt6.setEditable(true);
				mt7.setEditable(false);
				mt8.setEditable(true);
				
				dt1.setEditable(false);
				
				}
						
			else 
			{
				
			}
			
		}
		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			at1.setEditable(true);
			at2.setEditable(true);
			at3.setEditable(true);
			at4.setEditable(true);
			at5.setEditable(true);
			at6.setEditable(true);
			at7.setEditable(true);
			at8.setEditable(true);
			
			mt0.setEditable(true);
			mt1.setEditable(true);
			mt2.setEditable(true);
			//mt3.setEditable(true);
			mt4.setEditable(true);
			mt5.setEditable(true);
			mt6.setEditable(true);
			mt7.setEditable(true);
			mt8.setEditable(true);
			dt1.setEditable(true);
			
		}
		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		} 	  
		
}
