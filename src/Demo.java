import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class Demo extends Applet implements ActionListener,MouseListener{
JButton add_car,modify_car,delete_car,view_car,add_record;
CardLayout cl;
Panel adminView;
JLabel l0,al1,al2,al3,al4,al5,al6,al7,al8,ml1;
JTextField t1,t2,t3,t4,t5,t6,t7,t8;

	public void init()
	{	//setLayout(null);
		GridBagLayout gb=new GridBagLayout();
		GridBagConstraints gbc=new GridBagConstraints();
		setLayout(gb);
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridwidth=2;
		l0=new JLabel("Admin Login");
		//l0.setSize(100,100);
		//setVisible(true);
		//setSize(700,700);
		add(l0,gbc);
		gbc.gridx=0;
		gbc.gridy=1;
		gbc.gridwidth=1;
		add_car=new JButton(" Add ");
		//add_car.setBounds(100,100,80,40);
		gbc.gridx=1;
		gbc.gridy=1;
		gbc.gridwidth=1;

		modify_car=new JButton(" Modify ");
		//modify_car.setBounds(200,100,80,40);
		gbc.gridx=0;
		gbc.gridy=2;
		gbc.gridwidth=1;

		delete_car=new JButton(" Delete ");
		//delete_car.setBounds(300,100,80,40);
		gbc.gridx=1;
		gbc.gridy=2;
		gbc.gridwidth=1;

		view_car=new JButton(" View ");
		//view_car.setBounds(400,100,80,40);
		add(add_car,gbc);
		add(modify_car,gbc);
		add(delete_car,gbc);
		add(view_car,gbc);
		cl=new CardLayout();
		adminView=new Panel();
		adminView.setLayout(cl);
		Panel addCarPan=new Panel();
		//addCarPan.setLayout(cl);
		//addCarPan.setBackground(Color.RED);
		//-------------------------------------------------------------------------------------------
		al1=new JLabel("Enter User Id :");
		//al1.setBounds(50,200,200,40);
		al2=new JLabel("Enter Car Model :");
		al3=new JLabel("Enter Car Number :");
		al4=new JLabel("Enter Car Holder Name :");
		al5=new JLabel("Enter Car Holder Phone :");
		al6=new JLabel("Enter Car Holders Address :");
		al7=new JLabel("Enter Rent Charges :");
		al8=new JLabel("Enter Late Chrges :");
		
		addCarPan.add(al1);
		//-------------------------------------------------------------------------------------------
		Panel modifyCarPan=new Panel();
		//-------------------------------------------------------------------------------------------
		ml1=new JLabel("Enter User Id For modify :");
		//ml1.setBounds(50,200,200,40);
		modifyCarPan.add(ml1);
		//-------------------------------------------------------------------------------------------
		modifyCarPan.setBackground(Color.BLUE);
		Panel deleteCarPan=new Panel();
		deleteCarPan.setBackground(Color.GREEN);
		Panel viewCarPan=new Panel();
		viewCarPan.setBackground(Color.MAGENTA);
		adminView.add(addCarPan,"Add new record :");
		adminView.add(modifyCarPan,"Modify record :");
		adminView.add(deleteCarPan,"Delete record :");
		adminView.add(viewCarPan,"View record :");
		add(adminView);
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
			}
		else if(ae.getSource() == delete_car) {
			cl.show(adminView, "Delete record :");
			}
		if(ae.getSource() == modify_car) {
			cl.show(adminView, "Modify record :");
			}
		if(ae.getSource() == view_car) {
			cl.show(adminView, "View record :");
			}
	
	}
}
