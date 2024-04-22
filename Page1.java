package DBMS;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Page1 extends JFrame {

	//JFrame is a class in Swing library that represents a basic graphical window with a title bar
	//, borders, and the ability to hold other UI components. 
	private JPanel contentPane;//contentPane of type JPanel. This variable will likely hold the content pane (the main area) of the window for this page.
	private JTextField tf1;//a text field where a user can enter some input.
	private JPasswordField tf2;//a text field where a user can enter some input.
	//a special text field that hides the characters as the user types, typically used for passwords.
	
	
	public static void main(String[] args) {
		
		Connection conn=null;
		Statement stmt = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/project","root","root");
			System.out.println("Connection Succeded..............................");
			stmt=conn.createStatement();
			
		}
		catch(Exception e) {
			
		}
		//EventQueue.invokeLater method to schedule the creation and display of the graphical window 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Page1 frame = new Page1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//defines the constructor for the Page1 class.
	public Page1() {
		//This sets the default behavior of the close button (X) on the window frame. Here, it's set to exit the program when clicked.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 25, 1300, 800);
		contentPane = new JPanel();
		//This sets the default behavior of the close button (X) on the window frame. Here, it's set to exit the program when clicked.
		//(1300, 800) specify the width and height of the window (in pixels).
		contentPane.setBackground(new Color(255, 205, 234));
		contentPane.setName("Frame 1");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));//This sets a border around the content pane with a padding of 5 pixels on all sides.
		setContentPane(contentPane);//associates the created content pane with the main window.
		contentPane.setLayout(null);//This means you'll need to manually specify the position of each element you add to the panel.

		
		JLabel lblNewLabel = new JLabel("USERNAME:");//new label object named lblNewLabel with the text "USERNAME:".
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(438, 296, 159, 35);//defines the position and size of the label within the content pane.
		contentPane.add(lblNewLabel);//adds the created label lblNewLabel to the content pane.

		
		JLabel lblNewLabel2_AC = new JLabel("PASSWORD:");
		lblNewLabel2_AC.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel2_AC.setBounds(438, 363, 142, 35);
		contentPane.add(lblNewLabel2_AC);
		
		tf1 = new JTextField();//creates a new JTextField object named tf1. A text field is a component that allows users to enter single-line text input.
		tf1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tf1.setBounds(626, 295, 217, 40);
		contentPane.add(tf1);
		tf1.setColumns(10);//This sets the number of columns (width) that should be displayed for the text field tf1
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setForeground(Color.black);
		btnLogin.setBackground(new Color(255, 62, 165));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLogin.setBounds(400, 524, 187, 57);
		contentPane.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {// adds an action listener to the button btnLogin. An action listener 
			//is an object that gets notified when a user interacts with the button (e.g., clicks it). The following code block defines what happens when the button is clicked.
			public void actionPerformed(ActionEvent e) {
			
				
				ResultSet rs1=null;
	
				try {
						//This line attempts to load the JDBC driver class for connecting to MySQL databases. This line
			            Class.forName("com.mysql.cj.jdbc.Driver");
			            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
			            System.out.println("Connection Succeded..............................");
			            Statement stmt=conn.createStatement();

			            String username = tf1.getText();//retrieves the text entered by the user in the text field tf1
			            String password = new String(tf2.getPassword()); // Using getPassword() to retrieve the password
			            String query = "Select * from Admin where Username = '"+username+"' and Password = '"+password+"'";
			            rs1 = stmt.executeQuery(query);
			            if(rs1.next()) {
			                JOptionPane.showMessageDialog(null, "Success");//This line displays a pop-up message dialog using JOptionPane.showMessageDialog(null, "Success"). The null argument specifies that the message dialog should appear in the center of the application window.
			                new Admin_Crud().setVisible(true);
			            }
			            else {//if condition (finding a matching username and password) is not met.
			                JOptionPane.showMessageDialog(null, "Username or password wrong...");
			                //This line displays a pop-up message dialog indicating that the username or password is incorrect.
			                tf1.setText("");
			                tf2.setText("");
			            }

			    }
				catch(Exception e1) {
					
				}
				
			}
		});
	
		// creates and configures a "RESET" button
		JButton btnReset = new JButton("RESET");
		btnReset.setForeground(Color.black);
		btnReset.setBackground(new Color(255, 62, 165));
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnReset.setBounds(650, 524, 187, 57);
		contentPane.add(btnReset);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf1.setText("");
				tf2.setText("");
			}
		});

		
		JButton btnBack = new JButton("BACK");
		btnBack.setForeground(Color.black);
		btnBack.setBackground(new Color(255, 62, 165));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(900, 524, 187, 57);
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Intro_Page().setVisible(true);
			}
		});

		
		ImageIcon icon0=new ImageIcon("C:\\Users\\hp\\Downloads\\MKSSS-Pune.png");
		JLabel logo0 = new JLabel(icon0);//Creates a JLabel object named logo and associates the icon 
		//object with it, essentially displaying the image on the label.
		logo0.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));		
		logo0.setBounds(20,120,332,340);
		contentPane.add(logo0);
		
		
		//bottom left corner logo
		ImageIcon icon = new ImageIcon("C:\\Users\\hp\\Downloads\\mksss_logo.png");
		JLabel logo = new JLabel(icon);
		logo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));								
		logo.setBounds(20,450, 332, 340);
		contentPane.add(logo);
				
		JLabel l1 = new JLabel("  Samstha Store login Page");
		contentPane.add(l1);
    	l1.setBounds(0,0,1250,115);
    	l1.setFont(new Font ("Serif",Font.BOLD,52));
        l1.setForeground(Color.black);
        l1.setOpaque(true);
        l1.setBackground(new Color(251, 154, 209));
        
        tf2 = new JPasswordField();
        tf2.setBounds(626, 366, 217, 40);
        contentPane.add(tf2);
        
        JLabel lblAdminLogin = new JLabel("ADMIN LOGIN");
        lblAdminLogin.setFont(new Font("Serif", Font.PLAIN, 70));
        lblAdminLogin.setBounds(481, 125, 567, 90);
        contentPane.add(lblAdminLogin);
        
	}
}

