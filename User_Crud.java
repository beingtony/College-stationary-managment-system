package DBMS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JList;
import java.awt.SystemColor;

public class User_Crud extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel model ;
	private JTextField rollno;
	private JTextField name;
	private JTextField phno;
	private JTextField department;
	private JTextField t1;
	private JTextField t2;
	private JTextField f1;
	private JTextField f3;
	private JTable table_1;
	private JTextField f2;
	private JTextField tf2;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_Crud frame = new User_Crud();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public User_Crud() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//This line sets the default close operation of the JFrame window.
		//JFrame.EXIT_ON_CLOSE specifies that when the user clicks the close button
		//(or "X" icon) on the window, the entire application will exit.	
		setBounds(100, 25, 1300, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//This line sets the contentPane as the content pane of the JFrame window.
		contentPane.setLayout(null);
		//This line sets the layout manager for the contentPane to null.
		//This means the position and size of child components within the contentPane will be set explicitly using the setBounds method 
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 1, 1350, 800);
		//panel it covers most of the content pane.
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setBackground(new Color(25, 206, 223));//light blue shade.


		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(253, 206, 223));//light pink shade.
		panel_3.setBounds(342, 1, 951, 746);
		panel.add(panel_3);
		panel_3.setLayout(null);
		//login and sign in options on this panel
		
		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		//A JTabbedPane is a component that allows users to switch between different panels with tabs.
		tabbedPane.setBackground(new Color(253, 206, 223));// background color of the tabbedPane to the same light pink shade as panel_3.
		tabbedPane.setBounds(10, -22, 931, 782);
		panel_3.add(tabbedPane);
	
		final JTabbedPane Pane = new JTabbedPane(JTabbedPane.TOP);
		//This line creates a new JTabbedPane object and assigns it to the variable Pane.
		//Similar to the previous tabbedPane, this creates a component with tabs at the top for switching between panels.
		Pane.setBackground(new Color(25, 206, 223));
		Pane.setBounds(0, -22, 1362, 808);
		panel.add(Pane);
		//This line positions and sizes the Pane within the panel. Here, it covers the entire 
		//area of panel with a negative top position (-22) which overlap other elements(post login options).

		JPanel panel_W = new JPanel();
		//This line adds a new tab to the Pane.
		Pane.addTab(null, null, panel_W, null);
		//The first argument (here null) specifies the title to be displayed on the tab. Since it's null, the tab will be blank.
		//The second argument (also null) can be used to specify an icon for the tab. It's not used here.
		//The third argument (panel_W) is the JPanel that will be displayed when the user clicks on the tab.
		//The fourth argument (again null) can be used to specify a tooltip text for the tab when hovered over.
		panel_W.setBorder(null);//This line removes any default border around panel_W.
		panel_W.setBounds(0,0, 1326, 808);
		panel_W.setBackground(new Color(255, 255, 255));//white
		panel_W.setLayout(null);
		
		//top left corner
		ImageIcon icon0 = new ImageIcon("C:\\Users\\hp\\Downloads\\MKSSS-Pune.png");
	    JLabel logo0 = new JLabel(icon0);
		logo0.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		int yCoordinate0 = Pane.getHeight() - 800;
		logo0.setBounds(0, yCoordinate0, 332, 340);
		panel_W.add(logo0);
		
		//bottom left corner logo
		ImageIcon icon = new ImageIcon("C:\\Users\\hp\\Downloads\\mksss_logo.png");
	    JLabel logo = new JLabel(icon);
		logo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		int yCoordinate = Pane.getHeight() - 400;
		logo.setBounds(0, yCoordinate, 332, 340);
		panel_W.add(logo);
			    
		
		JPanel panel_11 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_11, null);
		panel_11.setBackground(SystemColor.window);//This line sets the 
		//background color of panel_11 to the system window color (usually white).
		//the login and user options are embedded in this panel
		panel_11.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("LOG IN");
		btnNewButton_1.setBackground(new Color(247, 65, 143));
		btnNewButton_1.setBounds(330, 275, 233, 51);
		btnNewButton_1.setFont(new Font("Tw Cen MT", Font.BOLD, 26));
		panel_11.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(6);
				//Sets the selected tab index in the tabbedPane to 6. This 
				//switches the view to the seventh tab (since indexing starts from 0).
			}
		});
		
		
		JButton btnLogin2 = new JButton("SIGN UP\r\n");
		btnLogin2.setBackground(new Color(247, 65, 143));
		btnLogin2.setBounds(330, 397, 233, 51);
		panel_11.add(btnLogin2);
		btnLogin2.setFont(new Font("Tw Cen MT", Font.BOLD, 26));
		btnLogin2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(5);
			}
		});
		

		
		JLabel lblNewLabel_1 = new JLabel("Welcome To SamsthaStore!");
		lblNewLabel_1.setForeground(new Color(247, 65, 143));
		lblNewLabel_1.setFont(new Font("Rockwell Condensed", Font.BOLD, 44));
		lblNewLabel_1.setBounds(168, 48, 568, 143);
		panel_11.add(lblNewLabel_1);
		
		//TAB post login-->> enter rno and phno
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(null);
		panel_4.setBackground(new Color(128, 0, 128));//purple
		tabbedPane.addTab("New tab", null, panel_4, null);
		panel_4.setLayout(null);
		
		

		model = new DefaultTableModel();
		Object col[] = {"PId","PName","Price","Category","Quantity","Admin_id"};
		model.setColumnIdentifiers(col);
		
		//has buttons like generate receipt
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_5, null);
		panel_5.setLayout(null);

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		//Receipt Panel--> receipt
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(Color.white);
		panel_12.setBounds(113, 51, 660, 441);
		panel_5.add(panel_12);
		panel_12.setLayout(null);
		
		JLabel lblReceipt = new JLabel("RECEIPT");
		lblReceipt.setForeground((Color.black));
		lblReceipt.setBounds(193, 7, 144, 42);
		panel_12.add(lblReceipt);
		lblReceipt.setFont(new Font("Helvetica Neue", Font.BOLD, 28));
		

		JLabel lbltid = new JLabel("Transaction ID:");
		lbltid.setForeground(Color.black);
		lbltid.setBounds(72, 78, 153, 35);
		panel_12.add(lbltid);
		lbltid.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		
		JLabel lblrollno= new JLabel("Roll Number:");
		lblrollno.setForeground(Color.black);
		lblrollno.setBounds(72, 138, 123, 35);
		panel_12.add(lblrollno);
		lblrollno.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		
		JLabel lblname = new JLabel("Student Name:");
		lblname.setForeground(Color.black);
		lblname.setBounds(72, 199, 153, 35);
		panel_12.add(lblname);
		lblname.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		
		JLabel lblprodname_1 = new JLabel("Product Name:");
		lblprodname_1.setForeground(Color.black);
		lblprodname_1.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		lblprodname_1.setBounds(72, 255, 153, 35);
		panel_12.add(lblprodname_1);
		
		JLabel lblqty = new JLabel("Quantity:");
		lblqty.setForeground(Color.black);
		lblqty.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		lblqty.setBounds(72, 310, 123, 35);
		panel_12.add(lblqty);
		
		JLabel lbltotprice = new JLabel("Total Price:");
		lbltotprice.setForeground(Color.black);
		lbltotprice.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		lbltotprice.setBounds(72, 373, 123, 35);
		panel_12.add(lbltotprice);
		
		
		final JLabel l1 = new JLabel("-");
		l1.setForeground(Color.BLACK);
		l1.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		l1.setBounds(280, 78, 123, 35);
		panel_12.add(l1);
		
		final JLabel l2 = new JLabel("-");
		l2.setForeground(Color.BLACK);
		l2.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		l2.setBounds(280, 138, 123, 35);
		panel_12.add(l2);
		
		final JLabel l3 = new JLabel("-");
		l3.setForeground(Color.BLACK);
		l3.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		l3.setBounds(280, 199, 123, 35);
		panel_12.add(l3);
		
		final JLabel l4 = new JLabel("-");
		l4.setForeground(Color.BLACK);
		l4.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		l4.setBounds(280, 255, 123, 35);
		panel_12.add(l4);
		
		final JLabel l5 = new JLabel("-");
		l5.setForeground(Color.BLACK);
		l5.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		l5.setBounds(280, 310, 123, 35);
		panel_12.add(l5);
		
		
		final JLabel l6 = new JLabel("-");
		l6.setForeground(Color.BLACK);
		l6.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		l6.setBounds(280, 373, 123, 35);
		panel_12.add(l6);
		
	        
		JButton btn1 = new JButton("Generate Receipt");
		btn1.setFont(new Font("Helvetica Neue", Font.PLAIN, 26));
		btn1.setBackground(new Color(160, 118, 249));
		btn1.setForeground(Color.black);
		btn1.setBounds(113, 545, 302, 56);
		panel_5.add(btn1);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn2=DriverManager.getConnection("jdbc:mysql://localhost/project","root","root");
					
					PreparedStatement ps1 = conn2.prepareStatement("Select t_id from transaction order by t_id DESC LIMIT 1");
					ResultSet rs1=ps1.executeQuery();
					rs1.next();
					String tid2 = Integer.toString(rs1.getInt("t_id"));
					System.out.println("tid = "+tid2);
					
					PreparedStatement ps2 = conn2.prepareStatement("Select roll_number from transaction order by t_id DESC LIMIT 1");
					ResultSet rs2=ps2.executeQuery();
					rs2.next();
					String rno = rs2.getString("roll_number");
					System.out.println("rollno = "+rno);
					
					PreparedStatement ps3 = conn2.prepareStatement("Select Student_name from customer where roll_number = '"+rno+"'");
					ResultSet rs3=ps3.executeQuery();
					rs3.next();
					String custName2 = rs3.getString("Student_Name");
					
					PreparedStatement ps4 = conn2.prepareStatement("Select P_name from transaction order by t_id DESC LIMIT 1");
					ResultSet rs4=ps4.executeQuery();
					rs4.next();
					String pname2 = rs4.getString("P_name");
					
					PreparedStatement ps5 = conn2.prepareStatement("Select quantity from transaction order by t_id DESC LIMIT 1");
					ResultSet rs5=ps5.executeQuery();
					rs5.next();
					String quantity2 = Integer.toString(rs5.getInt("quantity"));
					
					PreparedStatement ps6 = conn2.prepareStatement("Select Total_price from transaction order by t_id DESC LIMIT 1");
					ResultSet rs6=ps6.executeQuery();
					rs6.next();
					String Total_price2 = rs6.getString("Total_price");
					
					l1.setText(tid2);
					l2.setText(String.valueOf(rno));
					l3.setText(custName2);
					l4.setText(pname2);
					l5.setText(quantity2);
					l6.setText(Total_price2);
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++	
		
		//panel on cancel order table
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_6, null);
		panel_6.setLayout(null);
		
		JLabel lblOrderCancelled = new JLabel("Enter student roll number, to cancel\n order : ");
		lblOrderCancelled.setForeground(new Color(160, 118, 249));
		lblOrderCancelled.setFont(new Font("Helvetica Neue", Font.BOLD, 28));
		lblOrderCancelled.setBounds(28, 226, 750, 48);
		panel_6.add(lblOrderCancelled);
		
		//roll number
		tf2 = new JTextField();
		tf2.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		tf2.setBounds(656, 226, 202, 48);
		panel_6.add(tf2);
		tf2.setColumns(10);
		
		final JLabel cancellbl = new JLabel("");
		cancellbl.setFont(new Font("Helvetica Neue", Font.PLAIN, 26));
		cancellbl.setBounds(358, 519, 249, 48);
		panel_6.add(cancellbl);
		
		JButton btnCancelConfirm = new JButton("Confirm Cancellation");
		btnCancelConfirm.setBackground(new Color(160, 118, 249));
		btnCancelConfirm.setFont(new Font("Helvetica Neue", Font.BOLD, 22));
		btnCancelConfirm.setBounds(305, 351, 292, 56);
		panel_6.add(btnCancelConfirm);
		btnCancelConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String rno= tf2.getText();
				System.out.println("roll_number : "+rno);
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn2=DriverManager.getConnection("jdbc:mysql://localhost/project","root","root");
					
					String queryx = "select roll_number from log order by sr_no desc limit 1";
					PreparedStatement psx = conn2.prepareStatement(queryx);
					ResultSet rsx = psx.executeQuery();
					String rnum;
					// Check if there are any results before trying to access data
					rsx.next(); 
					rnum = rsx.getString(1); // roll_number is the first column (index 1)
					// Process the retrieved rnum here
					
					if(!rnum.equals(rno)) {
						JOptionPane.showMessageDialog(null,"Invalid roll number");
						tabbedPane.setSelectedIndex(0);
						Pane.setSelectedIndex(0);
						t1.setText("");
						t2.setText("");
					}else {

						PreparedStatement psb = conn2.prepareStatement("Select quantity from transaction where roll_number= '"+rno+"' order by t_id DESC limit 1");
						ResultSet rsb=psb.executeQuery();
						rsb.next();
						int old_quantity = rsb.getInt("quantity");
						System.out.println("old quantity : "+old_quantity);

						PreparedStatement psc = conn2.prepareStatement("Select p_Id from transaction where roll_number= '"+rno+"'order by t_id DESC limit 1");
						ResultSet rsc=psc.executeQuery();
						rsc.next();
						int old_pid = rsc.getInt("p_id");
						System.out.println("pid : "+old_pid);

						PreparedStatement psd = conn2.prepareStatement("Select Quantity from Product where P_Id = "+old_pid);
						ResultSet rsd=psd.executeQuery();
						rsd.next();
						int original_quantity = rsd.getInt("Quantity");
						System.out.println("original quantity : "+original_quantity);

						//Update Product table with previous quantity
						String query1 = "Update Product Set Quantity ="+(original_quantity+old_quantity)+" where P_Id ="+old_pid;
						System.out.println(query1);
						PreparedStatement psa = conn2.prepareStatement(query1);
						psa.executeUpdate();
						//System.out.println("Product table updated.. ");
						
						// delete last record of transaction table 
						String query2 = "Delete from transaction  where roll_number= '"+rno+"'order by t_id DESC limit 1";
						System.out.println(query2);
						PreparedStatement pse = conn2.prepareStatement(query2);
						pse.executeUpdate();
						//System.out.println("Product table updated.. ");
						
						cancellbl.setText("Order cancelled !!");
						JOptionPane.showMessageDialog(null,"Order cancelled !!");
					}
					
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
	
		JPanel panel_7 = new JPanel();// option---> available stock on the navbar
		//Adds a new tab to the TabbedPane named "New tab", with panel_7 as its content. The second and 
		//fourth null arguments are optional and represent an icon and a tooltip for the tab
		tabbedPane.addTab("New tab", null, panel_7, null);
		panel_7.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		//Creates a new JScrollPane object, which is used to provide scrollbars for a component that might not 
		//fit entirely within the available space.
		scrollPane.setBounds(10, 66, 895, 646);
		//10: X-coordinate (horizontal position) in pixels from the left edge of panel_7.
		panel_7.add(scrollPane);
		panel_7.setBackground(Color.BLACK);
		
		table = new JTable();
		Dimension dim1 = new Dimension(20,1);
		//Creates a new Dimension object named dim2 that specifies the width 
		//(20 pixels) and height (1 pixel) for spacing between cells in the table.
		table.setIntercellSpacing(dim1);
		int height1 = table.getRowHeight();
		table.setRowHeight(height1+10);
		table.setColumnSelectionAllowed(false);
		JTableHeader header1 = table.getTableHeader();
		// Gets the table header component from the table
		header1.setBackground(Color.orange);
		
		
		table.setFont(new Font("Helvetica Neue", Font.PLAIN, 17));
		model = new DefaultTableModel();
		Object col1[] = {"PId","PName","Price","Category","Quantity","Admin_id"};
		model.setColumnIdentifiers(col1);
		table.setModel(model);
		scrollPane.setViewportView(table);
		//Sets the viewport of the JScrollPane to the table
		//table will be displayed within the scrollable area of the JScrollPane
		
		JLabel lblAS = new JLabel("Available Stock");
		lblAS.setForeground(new Color(160, 118, 249));
		lblAS.setFont(new Font("Times New Roman", Font.BOLD, 44));
		//lblAS.setBackground(Color.BLACK);
		lblAS.setBounds(288, 0, 385, 66);
		panel_7.add(lblAS);
	
//--->>>>>>>-->>>SIGN UP LABELS
		JPanel panel_8 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_8, null);
		panel_8.setBackground(new Color(251,204,231));//This line sets the background to light pink
		panel_8.setLayout(null);
		
		JLabel lblrno = new JLabel("ROLL NUMBER");
		lblrno.setSize(new Dimension(10, 0));
		lblrno.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
		lblrno.setBounds(238, 115, 123, 35);
		panel_8.add(lblrno);
		
		JLabel lblName = new JLabel("Name");
		lblName.setSize(new Dimension(10, 0));
		lblName.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
		lblName.setBounds(238, 175, 123, 35);
		panel_8.add(lblName);
		
		JLabel lblAddress = new JLabel("phone number");
		lblAddress.setSize(new Dimension(10, 0));
		lblAddress.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
		lblAddress.setBounds(238, 237, 123, 35);
		panel_8.add(lblAddress);
		
		JLabel lblName_1_1 = new JLabel("Department");
		lblName_1_1.setSize(new Dimension(10, 0));
		lblName_1_1.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
		lblName_1_1.setBounds(238, 303, 123, 35);
		panel_8.add(lblName_1_1);
		
		rollno = new JTextField();
		rollno.setBounds(424, 119, 266, 35);
		panel_8.add(rollno);
		rollno.setColumns(10);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(424, 179, 266, 35);
		panel_8.add(name);
		
		phno = new JTextField();
		phno.setColumns(10);
		phno.setBounds(424, 241, 266, 35);
		panel_8.add(phno);
		
		department = new JTextField();
		department.setColumns(10);
		department.setBounds(424, 307, 266, 35);
		panel_8.add(department);
		
		JButton btnLogin = new JButton("SIGN UP");
		btnLogin.setBackground(new Color(247, 65, 143));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String rno,cname,phone_number,departmentName;
				try {
					
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/project","root","root");
					
						rno = rollno.getText();
						cname = name.getText();
						phone_number = phno.getText();
						departmentName = department.getText();
						
						if(rollno.getText().isEmpty() || name.getText().isEmpty() || phno.getText().isEmpty() || department.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null,"Empty fields are not allowed !!","Testing",JOptionPane.ERROR_MESSAGE);
						}
						else {
						
							String query = "Insert into customer(roll_number,Student_name,phno,department) values(?,?,?,?)";
							PreparedStatement ps2 = conn.prepareStatement(query);
							ps2.setString(1,rno);
							ps2.setString(2,cname);
							ps2.setString(3,phone_number);
							ps2.setString(4,departmentName);
							
							ps2.execute();
							
							JOptionPane.showMessageDialog(null,"sign up Successfull!!");
							tabbedPane.setSelectedIndex(0);
							//tabbedPane.setSelectedIndex(7);
							//Pane.setSelectedIndex(1);
						}
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null,"Pl. try again !!");
					e1.printStackTrace();
				}
			}
		});
		btnLogin.setFont(new Font("Tw Cen MT", Font.BOLD, 26));
		btnLogin.setBounds(124, 446, 195, 61);
		panel_8.add(btnLogin);
		
		JButton btnReset = new JButton("RESET");
		btnReset.setBackground(new Color(247, 65, 143));
		btnReset.setFont(new Font("Tw Cen MT", Font.BOLD, 26));
		btnReset.setBounds(374, 446, 195, 61);
		panel_8.add(btnReset);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				phno.setText("");
				name.setText("");
				department.setText("");
				rollno.setText("");
			}
		});
		
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBackground(new Color(247, 65, 143));
		btnBack.setFont(new Font("Tw Cen MT", Font.BOLD, 26));
		btnBack.setBounds(620, 446, 195, 61);
		panel_8.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		
		JLabel lblsu = new JLabel("SIGN UP");
		lblsu.setForeground(new Color(247, 65, 143));
		lblsu.setFont(new Font("Times New Roman", Font.BOLD, 44));
		lblsu.setBackground(Color.BLACK);
		lblsu.setBounds(349, 21, 183, 53);
		panel_8.add(lblsu);
		
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//--->>>>login------>>>>login labels
		JPanel panel_9 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_9, null);
		panel_9.setBackground(new Color(251,204,231));//This line sets the bg to light pink
		panel_9.setBounds(50,50,300,300);
		panel_9.setLayout(null);
		

		JLabel lblrn = new JLabel("Roll number");
		lblrn.setSize(new Dimension(10, 0));
		lblrn.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
		lblrn.setBounds(244, 180, 170, 35);
		panel_9.add(lblrn);
		
		JLabel lblpn = new JLabel("Phone number");
		lblpn.setSize(new Dimension(10, 0));
		lblpn.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
		lblpn.setBounds(244, 258, 170, 35);
		panel_9.add(lblpn);
		
		t1 = new JTextField();
		t1.setColumns(10);
		t1.setBounds(395, 184, 266, 35);
		panel_9.add(t1);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(395, 262, 266, 35);
		panel_9.add(t2);
		
		
		JButton btnLogin_1 = new JButton("LOGIN");
		btnLogin_1.setBackground(new Color(247, 65, 143));
		btnLogin_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tt1,tt2;
				Statement st = null;
				ResultSet rs = null;
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/project","root","root");
					
						tt1 = t1.getText();
						tt2 = t2.getText();
						
						if(t1.getText().isEmpty() || t2.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null,"Empty fields are not allowed !!","Testing",JOptionPane.ERROR_MESSAGE);
						}
						else {
						//Search
							String query = "Select * from customer where roll_number='"+tt1+"'and phno='"+tt2+"'";
							
							String query1 = "Insert into log(roll_number,phno) values(?,?)";
							
							PreparedStatement ps2 = conn.prepareStatement(query1);
							ps2.setString(1,tt1);	
							ps2.setString(2,tt2);
							
							PreparedStatement ps = conn.prepareStatement(query);
							
							rs = ps.executeQuery();
							ps2.execute();
							
							int bool=0;
			
							while(rs.next()) {
								if( ( rs.getString("roll_number").equals(t1.getText()) ) && ( rs.getString("phno").equals(t2.getText()) ) ) {
									JOptionPane.showMessageDialog(null,"LOGIN Successfull !!");
									bool=1;
									tabbedPane.setSelectedIndex(7);
									Pane.setSelectedIndex(1);
								}
							}
							if(bool==0) {
								JOptionPane.showMessageDialog(null,"This UserId is not available !!");
							}
						}
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null,"Please check Your Information Again !!");
					e1.printStackTrace();
				}
			}
		});
		btnLogin_1.setFont(new Font("Tw Cen MT", Font.BOLD, 26));
		btnLogin_1.setBounds(124, 385, 188, 65);
		panel_9.add(btnLogin_1);

		
		JButton btnLoginrs = new JButton("RESET");
		btnLoginrs.setBackground(new Color(247, 65, 143));
		btnLoginrs.setFont(new Font("Tw Cen MT", Font.BOLD, 26));
		btnLoginrs.setBounds(353, 385, 188, 65);
		panel_9.add(btnLoginrs);
		btnLoginrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t1.setText("");
				t2.setText("");
			}
		});
		JButton btnloginBack = new JButton("BACK");
		btnloginBack.setBackground(new Color(247, 65, 143));
		btnloginBack.setFont(new Font("Tw Cen MT", Font.BOLD, 26));
		btnloginBack.setBounds(570, 385, 188, 65);
		panel_9.add(btnloginBack);
		btnloginBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		
		
		
		
		JLabel lbllogin = new JLabel("LOG IN");
		lbllogin.setForeground(new Color(247, 65, 143));
		lbllogin.setFont(new Font("Times New Roman", Font.BOLD, 44));
		lbllogin.setBackground(Color.BLACK);
		lbllogin.setBounds(376, 44, 183, 53);
		panel_9.add(lbllogin);
		
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
//--->>>>tab to place order-->>>place order
		JPanel panel_10 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_10, null);
		panel_10.setBorder(null);
		panel_10.setBackground(new Color(255, 255, 255));
		panel_10.setLayout(null);
		
		
		//panel_X has all the buttons-> back to menu, cancel order.. etc
		JPanel panel_X = new JPanel();
		// Pane is the JTabbedPane instance
		Pane.addTab(null, null, panel_X, null);

		panel_X.setBorder(null);
		panel_X.setBackground(new Color(200, 206, 223));
		panel_X.setBounds(20, 21, 604, 1452);
		panel_X.setLayout(null);
		
		
		
		JLabel lblPlaceOrderHere = new JLabel("PLACE ORDER HERE");
		lblPlaceOrderHere.setForeground(new Color(160, 118, 249));
		lblPlaceOrderHere.setSize(new Dimension(10, 0));
		lblPlaceOrderHere.setFont(new Font("Baskerville Old Face", Font.BOLD, 35));
		lblPlaceOrderHere.setBounds(32, 27, 421, 46);
		panel_10.add(lblPlaceOrderHere);

		
		JLabel lblpid = new JLabel("Product-ID");
		lblpid.setForeground(new Color(0, 0, 0));
		lblpid.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
		lblpid.setBounds(316, 172, 150, 35);
		panel_10.add(lblpid);
	
		
		f3 = new JTextField();
		f3.setColumns(10);
		f3.setBounds(466, 234, 266, 39);
		panel_10.add(f3);
		
		
		JLabel labelqty = new JLabel("Quantity");
		labelqty.setForeground(new Color(0, 0, 0));
		labelqty.setSize(new Dimension(10, 0));
		labelqty.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
		labelqty.setBounds(316, 232, 113, 35);
		panel_10.add(labelqty);
		
//		JList list = new JList();
//		list.setBounds(232, 171, -44, -23);
//		panel_10.add(list);
		
		f2 = new JTextField();
		f2.setColumns(10);
		f2.setBounds(466, 174, 266, 39);
		panel_10.add(f2);
		
		JButton btnConfirmOrder = new JButton("Confirm and Generate Receipt");
		btnConfirmOrder.setBackground(new Color(160, 118, 249));//PURPLE
		btnConfirmOrder.setFont(new Font("Tw Cen MT", Font.BOLD, 26));
		btnConfirmOrder.setBounds(499, 315, 365, 46);
		panel_10.add(btnConfirmOrder);
		btnConfirmOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//ResultSet rs2 = null;
				try {
					
					//1. check if that much quantity is present or not
					//2. Product > Minus the quantity > where user entered id is present
					//3. Transaction = add transaction
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn2=DriverManager.getConnection("jdbc:mysql://localhost/project","root","root");
					
					String pid = f2.getText();
					
					int qty2 = Integer.parseInt(f3.getText());
					System.out.println(qty2);
					
					//int qty3 = Integer.parseInt(rs2.getString("Quantity"));
					
					if( f2.getText().isEmpty() || f3.getText().isEmpty() ) {
							JOptionPane.showMessageDialog(null,"Empty fields are not allowed !!","Testing",JOptionPane.ERROR_MESSAGE);
					}else {
						
							//check if that quantity is available 
							//If yes perform database operation
							
							PreparedStatement ps1 = conn2.prepareStatement("Select Quantity from Product where P_Id=?");
							ps1.setString(1, pid);
							ResultSet rs1=ps1.executeQuery();
							rs1.next();
							int original_quantity = rs1.getInt("Quantity");
							
							if(qty2 <= original_quantity) {
								System.out.println(" qty = "+qty2);
								System.out.println("Original Quantity = "+original_quantity);
								
								PreparedStatement ps = conn2.prepareStatement("Select * from Product where P_Id="+pid);
								ResultSet rs=ps.executeQuery();
								rs.next();
								
								String query1 = "Update Product Set Quantity ="+(rs.getInt("Quantity")-qty2)+" where P_Id="+pid;
								System.out.println(query1);
								PreparedStatement ps2 = conn2.prepareStatement(query1);
								ps2.executeUpdate();
								//JOptionPane.showMessageDialog(null,"Product table Updated Successfully !!");
									
									//calculate pname and total
								
									String query2 = "Select P_name from Product where P_Id ="+pid;
									PreparedStatement ps3 = conn2.prepareStatement(query2);
									String prodName = "";
									ResultSet rs2 = ps3.executeQuery();
									if(rs2.next()) {
										prodName = rs2.getString(1);
									}
									System.out.println("Product name = "+prodName);
									
									//calculate total
									PreparedStatement ps4 = conn2.prepareStatement("Select Price from Product where P_Id="+pid);
									ResultSet rs4=ps4.executeQuery();
									rs4.next();
									int tbl_price = rs4.getInt("Price");
									int total = qty2 * tbl_price;
									System.out.println("Total price = "+total);
									
									
									String queryx = "select roll_number from log order by sr_no desc limit 1";
									PreparedStatement psx = conn2.prepareStatement(queryx);
									ResultSet rsx = psx.executeQuery();
									String rnum;
									// Check if there are any results before trying to access data
									rsx.next(); 
									rnum = rsx.getString(1); // Assuming roll_number is the first column (index 1)
									// Process the retrieved rnum here
									
									
									//add transaction details in table
									String query3 = "Insert into transaction(t_id,p_Id,P_name,quantity,time_date,roll_number,Total_price) values(?,?,?,?,?,?,?)";
									PreparedStatement ps5 = conn2.prepareStatement(query3);
									ps5.setString(1,null);
									ps5.setString(2,pid);
									ps5.setString(3,prodName);
									ps5.setLong(4,qty2);
									Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
									ps5.setTimestamp(5,date);
									ps5.setString(6,rnum);
									ps5.setInt(7,total);
									
									ps5.execute();
									
//									JOptionPane.showMessageDialog(null,"Order confirmed !!");
									tabbedPane.setSelectedIndex(2);
									
							}
							else {
								JOptionPane.showMessageDialog(null,"Quantity Not Available !!");
							}
						}
				
				}
				catch(Exception e3) {
					JOptionPane.showMessageDialog(null,"Pl. try again !!");
					e3.printStackTrace();
				}
			}
		});
	
		
		JButton btnCheckAvailableStock = new JButton("Check Available Stock");
		btnCheckAvailableStock.setBackground(new Color(160, 118, 249));
		btnCheckAvailableStock.setFont(new Font("Tw Cen MT", Font.BOLD, 26));
		btnCheckAvailableStock.setBounds(278, 672, 381, 51);
		panel_10.add(btnCheckAvailableStock);
		btnCheckAvailableStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/project","root","root");
					
					PreparedStatement ps = conn.prepareStatement("Select * from Product");
					ResultSet rs = ps.executeQuery();
					DefaultTableModel tm = (DefaultTableModel)table_1.getModel();
					tm.setRowCount(0);
					while(rs.next()) {
					    
					    Integer pid = Integer.valueOf(rs.getInt("P_Id"));
					    String pname = rs.getString("P_Name");
					    Integer price = Integer.valueOf(rs.getInt("Price"));
					    String category = rs.getString("Category");
					    Integer quantity = Integer.valueOf(rs.getInt("Quantity"));
					    Integer adminId = Integer.valueOf(rs.getInt("Admin_id"));
					    
					    // Create an Object array with converted Integer objects
					    Object o[] = {pid, pname, price, category, quantity, adminId};
					    
					    // Add the Object array to the table model
					    tm.addRow(o);
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(-12, 422, 938, 240);
		panel_10.add(scrollPane_1);
		
		table_1 = new JTable();
		Dimension dim = new Dimension(20,1);
		table_1.setIntercellSpacing(dim);
		int height = table_1.getRowHeight();
		table_1.setRowHeight(height+10);
		table_1.setColumnSelectionAllowed(true);
		JTableHeader header = table_1.getTableHeader();
		
		table_1.setFont(new Font("Helvetica Neue", Font.PLAIN, 17));
		table_1.setModel(model);
		
		scrollPane_1.setViewportView(table_1);

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//--->>>>buttons on panel_X--->>>> cancel order etc
		JButton btnCancelOrder = new JButton("Cancel Order");
		btnCancelOrder.setBorder(null);
		btnCancelOrder.setBorderPainted(false);
		btnCancelOrder.setForeground(new Color(255, 255, 255));
		btnCancelOrder.setBackground(new Color(128, 0, 128));
		btnCancelOrder.setBounds(0, 175, 302, 56);
		panel_X.setLayout(null);
		panel_X.add(btnCancelOrder);
		btnCancelOrder.setFont(new Font("Helvetica Neue", Font.BOLD, 25));
		btnCancelOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(3);
			}
		});
		
		
		JButton btnGenerateReceipt = new JButton("Generate Receipt");
		btnGenerateReceipt.setBorder(null);
		btnGenerateReceipt.setForeground(new Color(255, 255, 255));
		btnGenerateReceipt.setBackground(new Color(128, 0, 128));
		btnGenerateReceipt.setBounds(0,93,302,56);
		panel_X.add(btnGenerateReceipt);
		btnGenerateReceipt.setFont(new Font("Helvetica Neue", Font.BOLD, 25));
		btnGenerateReceipt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tabbedPane.setSelectedIndex(2);
			}
		});
		
		
		JButton b1 = new JButton("Place Order");
		b1.setBorderPainted(false);
		b1.setBorder(null);
		b1.setForeground(new Color(255, 255, 255));
		b1.setBackground(new Color(128, 0, 128));
		b1.setBounds(0, 10, 302, 56);
		panel_X.add(b1);
		b1.setFont(new Font("Helvetica Neue", Font.BOLD, 25));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(7);
			}
		});
		
		JButton btnBackToMenu = new JButton("Available Stock");
		btnBackToMenu.setBorder(null);
		btnBackToMenu.setForeground(new Color(255, 255, 255));
		btnBackToMenu.setBackground(new Color(128, 0, 128));
		btnBackToMenu.setFont(new Font("Helvetica Neue", Font.BOLD, 25));
		btnBackToMenu.setBounds(0, 268, 302, 56);
		panel_X.add(btnBackToMenu);
		btnBackToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(4);
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/","root","root");
					
					PreparedStatement ps = conn.prepareStatement("Select * from Product");
					ResultSet rs = ps.executeQuery();
					DefaultTableModel tm = (DefaultTableModel)table.getModel();
					tm.setRowCount(0);
					while(rs.next()) {
					    // Retrieve integer values from the result set and convert them to Integer objects
					    Integer pid = Integer.valueOf(rs.getInt("P_Id"));
					    String pname = rs.getString("P_Name");
					    Integer price = Integer.valueOf(rs.getInt("Price"));
					    String category = rs.getString("Category");
					    Integer quantity = Integer.valueOf(rs.getInt("Quantity"));
					    Integer adminId = Integer.valueOf(rs.getInt("Admin_id"));
					    
					    // Create an Object array with converted Integer objects
					    Object o[] = {pid, pname, price, category, quantity, adminId};
					    
					    // Add the Object array to the table model
					    tm.addRow(o);
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
		JButton btnBackToMenu_Intro = new JButton("Back To Menu");
		btnBackToMenu_Intro.setBorder(null);
		btnBackToMenu_Intro.setForeground(new Color(255, 255, 255));
		btnBackToMenu_Intro.setBackground(new Color(128, 0, 128));
		btnBackToMenu_Intro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Intro_Page().setVisible(true);
			}
		});
		btnBackToMenu_Intro.setFont(new Font("Helvetica Neue", Font.BOLD, 25));
		btnBackToMenu_Intro.setBounds(0, 355, 302, 56);
		panel_X.add(btnBackToMenu_Intro);
	}
  }
//background colours change rgb(253, 206, 223) rgb(248, 232, 238)
//side buttons color change
////