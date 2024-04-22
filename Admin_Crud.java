package DBMS;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Admin_Crud extends JFrame {

	private JPanel contentPane;
	private JTextField pid;
	private JTextField pname;
	private JTextField price;
	private JTextField category;
	private JTextField quantity;
	private JTextField adminid;
	private static JTable table;
	DefaultTableModel model ;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			//EventQueue class, which is part of Swing for managing the event queue in a graphical user interface (GUI) application. The invokeLater method schedules the execution of a 
			//Runnable object (an object that has a run method) on the event 
			public void run() {
				try {
					Admin_Crud frame = new Admin_Crud();//creates a new instance of a class named Admin_Crud
					frame.setVisible(true);//makes the Admin_Crud window visible by calling its setVisible(true) method.
					
					Class.forName("com.mysql.cj.jdbc.Driver");//load the JDBC driver class for connecting to MySQL databases.
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/project","root","root");
					
					PreparedStatement pst = conn.prepareStatement("Select * from product");
					ResultSet rs = pst.executeQuery();
					DefaultTableModel tm = (DefaultTableModel)table.getModel();
					//This line assumes there's a table component named table in the GUI.
					//This line casts the model associated with the table to a DefaultTableModel object named tm. The DefaultTableModel 
					//class is commonly used to manage data in tables within Swing
					
					tm.setRowCount(0);
					// sets the number of rows in the table model tm to 0. This essentially clears any existing data in the
					//table before populating it with new data from the database.
					
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
					    //This line creates an array of objects named o and assigns values retrieved from the database.
					    //The array holds these values in the same order they appear in the table columns.
					    
					    tm.addRow(o);
					    //This line adds the o array (containing data from a single row in the database) to the table model tm using the addRow method. This essentially populates a 
					    //new row in the table with the retrieved data.
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Admin_Crud() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 25, 1300, 800);
		contentPane = new JPanel();
        contentPane.setBackground(new Color(237, 228, 255)); // Light Pink color (RGB: 255, 182, 193)
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADMIN OPERATIONS");
		lblNewLabel.setFont(new Font("Palatino", Font.BOLD, 48));
		lblNewLabel.setBounds(50, 10, 800, 90);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLablel1_AC = new JLabel("Product ID:");
		lblNewLablel1_AC.setFont(new Font("Georgia", Font.BOLD, 18));
		lblNewLablel1_AC.setBounds(35, 125, 180, 37);
		contentPane.add(lblNewLablel1_AC);
		
		JLabel lblNewLabel2_AC = new JLabel("Product Name:");
		lblNewLabel2_AC.setFont(new Font("Georgia", Font.BOLD, 18));
		lblNewLabel2_AC.setBounds(35, 182, 190, 37);
		contentPane.add(lblNewLabel2_AC);
		
		JLabel lblNewLablel3_AC = new JLabel("Price:");
		lblNewLablel3_AC.setFont(new Font("Georgia", Font.BOLD, 18));
		lblNewLablel3_AC.setBounds(35, 249, 108, 37);
		contentPane.add(lblNewLablel3_AC);
		
		JLabel lblNewLabel4_AC = new JLabel("Category:");
		lblNewLabel4_AC.setFont(new Font("Georgia", Font.BOLD, 18));
		lblNewLabel4_AC.setBounds(35, 319, 108, 37);
		contentPane.add(lblNewLabel4_AC);
		
		JLabel lblNewLabel5_AC = new JLabel("Quantity:");
		lblNewLabel5_AC.setFont(new Font("Georgia", Font.BOLD, 18));
		lblNewLabel5_AC.setBounds(35, 378, 108, 37);
		contentPane.add(lblNewLabel5_AC);
		
		JLabel lblNewLabel6_AC = new JLabel("Admin ID:");
		lblNewLabel6_AC.setFont(new Font("Georgia", Font.BOLD, 18));
		lblNewLabel6_AC.setBounds(31, 442, 108, 37);
		contentPane.add(lblNewLabel6_AC);
		
		pid = new JTextField();
		pid.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
		pid.setBounds(188, 128, 198, 37);
		contentPane.add(pid);
		pid.setColumns(10);
		
		pname = new JTextField();
		pname.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
		pname.setColumns(10);
		pname.setBounds(188, 182, 198, 37);
		contentPane.add(pname);
		
		price = new JTextField();
		price.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
		price.setColumns(10);
		price.setBounds(188, 249, 198, 37);
		contentPane.add(price);
		
		category = new JTextField();
		category.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
		category.setColumns(10);
		category.setBounds(188, 319, 198, 37);
		contentPane.add(category);
		
		quantity = new JTextField();
		quantity.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
		quantity.setColumns(10);
		quantity.setBounds(188, 378, 198, 37);
		contentPane.add(quantity);
		
		adminid = new JTextField();
		adminid.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
		adminid.setColumns(10);
		adminid.setBounds(188, 442, 198, 37);
		contentPane.add(adminid);
		
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
		table = new JTable();//This line creates a new JTable object named table. A JTable is a Swing component used to 
		//display data in a two-dimensional grid of rows and columns.
		table.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
		JTableHeader header1 = table.getTableHeader();
		//This line gets the table header component (JTableHeader) associated 
		//with the table object and stores it in a variable named header2.
		header1.setBackground(Color.orange);
		
		//SET SPACING AND SIZE OF CELLS IN TABLE
		Dimension dim1 = new Dimension(20,1);
		//creates a new Dimension object named dim1 and sets its width to 20 pixels and height to 1 pixel. 
		table.setIntercellSpacing(dim1);//sets the spacing between cells in the table using the dim2 dimension object created earlier.
		int height1 = table.getRowHeight();//retrieves the current row height of the table and stores it in an integer variable height1.
		table.setRowHeight(height1+10);// increases the row height of the table by 10 pixels 
	
		model = new DefaultTableModel();
		Object col[] = {"PId","PName","Price","Category","Quantity","Admin_id"};
		model.setColumnIdentifiers(col);//This line sets the column identifiers (names) for the table model model using the col array containing column names.
		table.setModel(model);//associates the model (containing table data and column names) with the table component.


		JScrollPane scrollPane_1 = new JScrollPane();//creates a new scroll pane component named scrollPane_1. A scroll pane is used 
		//to add scrollbars to a component, allowing users to view content that is larger than the visible area.
		scrollPane_1.setBackground(new Color(135, 206, 235));
		scrollPane_1.setBounds(437, 125, 816, 476);
		contentPane.add(scrollPane_1);
		scrollPane_1.setViewportView(table);
		//setViewportView method: This method of the JScrollPane object takes a component as an argument 
		//and sets that component as the viewable content within the scroll pane.
		
		
		//Add data in table
		JButton btnAdd = new JButton("ADD");
		btnAdd.setForeground(Color.BLACK);
		btnAdd.setBackground(new Color(255, 62, 165));
		btnAdd.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
		btnAdd.setBounds(51, 527, 140, 63);
		contentPane.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pid.getText().equals("")||
				pname.getText().equals("")||
				price.getText().equals("")||
				category.getText().equals("")||
				quantity.getText().equals("")||
				adminid.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Complete The Information !!");
				}
		
				
				else {	
					
					String pid2,pname2,price2,category2,quantity2,adid2;
					try {
							
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
							
						pid2 = pid.getText();
						pname2 = pname.getText();
						price2 = price.getText();
						category2 = category.getText();
						quantity2 = quantity.getText();
						adid2 = adminid.getText();
								
						String query = "Insert into Product(P_Id,P_Name,Price,Category,Quantity,Admin_id) values(?,?,?,?,?,?)";
						PreparedStatement ps = conn.prepareStatement(query);
						ps.setString(1,pid2);
						ps.setString(2,pname2);
						ps.setString(3,price2);
						ps.setString(4,category2);
						ps.setString(5,quantity2);
						ps.setString(6,adid2);
						ps.execute();
								
						JOptionPane.showMessageDialog(null,"Data Inserted Successfully !!");
							
					}
					catch(Exception e3) {
						JOptionPane.showMessageDialog(null,"Check values again !!");
						e3.printStackTrace();
					}
				}
				
			} 

		});

		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setForeground(Color.BLACK);
		btnUpdate.setBackground(new Color(255, 62, 165));
		btnUpdate.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
		btnUpdate.setBounds(230, 527, 140, 63);
		contentPane.add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(pid.getText().equals("")||
				pname.getText().equals("")||
				price.getText().equals("")||
				category.getText().equals("")||
				quantity.getText().equals("")||
				adminid.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Complete The Information !!");
					//parentComponent (null in this case): This argument specifies the component (like a window or another dialog) that the new dialog is dependent on.
					//By passing null, you're indicating that this dialog isn't attached to any other specific component.
					//The operating system will then create a default window to display the message.
				}
				
				else {
					String pid2,pname2,price2,category2,quantity2,adid2;
				
					try {
					
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");

						pid2 = pid.getText();
						pname2 = pname.getText();
						price2 = price.getText();
						category2 = category.getText();
						quantity2 = quantity.getText();
						adid2 = adminid.getText();
						
						String query = "Update Product Set P_Id ='"+pid2+"',P_Name='"+pname2+"',Price='"+price2+"', Category='"+category2+"', Quantity='"+quantity2+"',Admin_id='"+adid2+"' where P_Id = '"+pid2+"' ";
						PreparedStatement ps = conn.prepareStatement(query);
					
						ps.executeUpdate();
					}
					catch(Exception e1) {
						JOptionPane.showMessageDialog(null,"Unable to Update !!\n\nPlease check data again..");
						e1.printStackTrace();
					}
				}
			}
		});
		
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBackground(Color.BLACK);
		btnDelete.setForeground(new Color(251, 136, 180));
		btnDelete.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
		btnDelete.setBounds(51, 622, 140, 61);
		contentPane.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(pid.getText().equals("")||
				pname.getText().equals("")||
				price.getText().equals("")||
				category.getText().equals("")||
				quantity.getText().equals("")||
				adminid.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Complete The Information !!");
				}
				
				else {
					String pid2,pname2,price2,category2,quantity2,adid2;
					try {
						
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
						
						pid2 = pid.getText();
						pname2 = pname.getText();
						price2 = price.getText();
						category2 = category.getText();
						quantity2 = quantity.getText();
						adid2 = adminid.getText();
						String query = "";
						
						query = "delete from Product where P_Id = '"+pid2+"' ";
						PreparedStatement ps = conn.prepareStatement(query);
				
						ps.execute();
						
					}
					catch(Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setForeground(new Color(255, 62, 165));
		btnClear.setBackground(Color.BLACK);
		btnClear.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
		btnClear.setBounds(230, 622, 140, 61);
		contentPane.add(btnClear);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pid.setText("");
				pname.setText("");
				price.setText("");
				category.setText("");
				quantity.setText("");
				adminid.setText("");
			}
		});
		
		
		JButton btnLoad = new JButton("LOAD DATA");
		btnLoad.setForeground(Color.BLACK);
		btnLoad.setBackground(new Color(160, 118, 249));
		btnLoad.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
		btnLoad.setBounds(677, 645, 170, 56);
		contentPane.add(btnLoad);
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
					
					PreparedStatement ps = conn.prepareStatement("Select * from Product");
					ResultSet rs = ps.executeQuery();
					DefaultTableModel tm = (DefaultTableModel)table.getModel();
					// The table model manages the data displayed in the table.
					tm.setRowCount(0);
					//This line clears any existing data in the JTable represented by table. It sets the number of rows in the table model (tm) 
					//to zero, effectively removing all previously displayed data.
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
					    //This line creates an array of objects (o) and assigns values retrieved from the database to each element. The order of elements in the array needs
					    //to match the order of columns you want to display in the JTable.
					    
					    tm.addRow(o);// Add the Object array to the table model
					}


				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
		JButton btnBack = new JButton("BACK");
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
		btnBack.setBackground(new Color(160, 118, 249));
		btnBack.setBounds(881, 645, 170, 56);
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Intro_Page().setVisible(true);
			}
		});
		
	}
}

