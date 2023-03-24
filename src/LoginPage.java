import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class LoginPage extends Applet implements ActionListener,MouseListener{
JButton add_car,modify_car,delete_car,view_car,add_record;
CardLayout cl;
Panel adminView;
JLabel l0,l1,l2,l3,l4,l5,l6,l7,l8;
JTextField t1,t2,t3,t4,t5,t6,t7,t8;

	public void init()
	{
		//setSize(700,700);
		GridBagLayout grid = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		setLayout(grid);
		gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.ipadx=50;
		gbc.ipady=50;
		
		gbc.gridwidth =2;
		l0=new JLabel("Admin Login");
		//l0.setBounds(250,10,200,50);
		add(l0);
		//setLayout(grid);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth=1;
		gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(20,20,20, 20);

		add_car=new JButton(" Add ");
		//add_car.setBounds(100,100,80,40);
		this.add(add_car,gbc);
		
		gbc.gridx =1 ;
		gbc.gridy =1;
		gbc.fill= GridBagConstraints.HORIZONTAL;

		modify_car=new JButton(" Modify ");
		//modify_car.setBounds(200,100,80,40);
		this.add(modify_car,gbc);
		
		gbc.gridx =0 ;
		gbc.gridy =2;
		delete_car=new JButton(" Delete ");
		//delete_car.setBounds(300,100,80,40);
		this.add(delete_car,gbc);
		
		gbc.gridx =1 ;
		gbc.gridy =2;
		view_car=new JButton(" View ");
		//view_car.setBounds(400,100,80,40);
		this.add(view_car,gbc);
		//add(add_car);
		//add(modify_car);
		//add(delete_car);
		//add(view_car);
		cl=new CardLayout();
		adminView=new Panel();
		adminView.setLayout(cl);
		Panel addCarPan=new Panel();
		GridBagLayout acpgrid = new GridBagLayout();
		GridBagConstraints acp = new GridBagConstraints();
		addCarPan.setLayout(acpgrid);
		addCarPan.setBackground(Color.RED);
		//-------------------------------------------------------------------------------------------
		
		l1=new JLabel("Enter User Id :");
		gbc.fill= GridBagConstraints.HORIZONTAL;
		acp.gridx = 0;
		acp.gridy = 0;
		acp.ipadx=50;
		acp.ipady=50;
		
		acp.gridwidth =1;
		//l1.setBounds(50,200,200,40);
		l2=new JLabel("Enter Car Model :");
		acp.gridx = 0;
		acp.gridy = 1;
		acp.ipadx=50;
		acp.ipady=50;
		
		acp.gridwidth =1;
		l3=new JLabel("Enter Car Number :");
		acp.gridx = 0;
		acp.gridy = 2;
		acp.ipadx=50;
		acp.ipady=50;
		
		acp.gridwidth =1;
		l4=new JLabel("Enter Car Holder Name :");
		acp.gridx = 0;
		acp.gridy = 3;
		acp.ipadx=50;
		acp.ipady=50;
		
		acp.gridwidth =1;
		l5=new JLabel("Enter Car Holder Phone :");
		acp.gridx = 0;
		acp.gridy = 4;
		acp.ipadx=50;
		acp.ipady=50;
		
		acp.gridwidth =1;
		l6=new JLabel("Enter Car Holders Address :");
		acp.gridx = 0;
		acp.gridy = 5;
		acp.ipadx=50;
		acp.ipady=50;
		
		acp.gridwidth =1;
		l7=new JLabel("Enter Rent Charges :");
		l8=new JLabel("Enter Late Chrges :");
		
		addCarPan.add(l1,acp);
		addCarPan.add(l2,acp);
		addCarPan.add(l3,acp);

		addCarPan.add(l4,acp);

		addCarPan.add(l5,acp);

		addCarPan.add(l6,acp);

		addCarPan.add(l7,acp);

		//-------------------------------------------------------------------------------------------
		Panel modifyCarPan=new Panel();
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
		//setLayout(null);
		
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