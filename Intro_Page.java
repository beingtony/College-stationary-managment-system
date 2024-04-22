package DBMS;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.JTextArea;


public class Intro_Page extends JFrame {

	private JPanel contentPane;
	
	public static void main(String[] args) {
		
		//declare requiured variables
		Connection conn=null;
		ResultSet rs=null;	
		PreparedStatement ps=null;
		Statement stmt = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/project","root","root");
			System.out.println("Connection Succeded..............................");
			stmt=conn.createStatement();
			
			//PRINT ADMIN INFORMATION
			String query = "select * from admin" ;
			rs= ps.executeQuery(query);
			
			while(rs.next())
			{
				int id=rs.getInt("admin_id");
				String uname=rs.getString("username");	
				String pwd=rs.getString("password");
				
				System.out.println("id : "+id+" \nusername : "+uname+" \npassword : "+pwd);

			}
		}
		catch(Exception e) {
			
		}
		//class EventQueue which is part of the Java AWT (Abstract Window Toolkit) library.
		//It manages the queue of events for the graphical 
		//user interface (GUI) components.
		
		//The invokeLater method schedules the execution of the provided Runnable object to happen later, 
		//after all pending events have been processed by the Event Dispatch Thread (EDT)
		EventQueue.invokeLater(new Runnable() {
			//This creates an anonymous instance of the Runnable interface. The Runnable
			//interface has a single method called run().
			public void run() {
				//This is where the code that you want to execute later gets placed.
				try {
					
                    //class named Intro_Page. This id a custom class that represents the main window of your application.
					Intro_Page frame = new Intro_Page();
					//his calls the setVisible(true) method on the frame object.
					frame.setVisible(true);
					
				} catch (Exception e) {
					// This method prints the stack trace of the exception to the console, which can be helpful for debugging purposes.
					e.printStackTrace();
				}
			}
		});
	}

///This line defines a constructor for a class named Intro_Page.
	public Intro_Page() {
		//This sets the default behavior of the close button (X) on the window frame. Here, it's set to exit the program when clicked.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//This defines the position and size of the window on the screen.
		//The first two numbers (100, 25) specify the window's location 
		//from the top-left corner of the screen (in pixels). The last 
		//two numbers (1300, 800) specify the width and height of the window (in pixels).
		setBounds(100, 25, 1300, 800);
		//This creates a new panel object which will hold the contents of the window.
		contentPane = new JPanel();
		contentPane.setBackground(new Color(215, 187, 245));// sets the background color of the panel to a light purple color. 
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// sets a border around the content pane with a padding of 5 pixels on all sides.
		
		// the content pane is a special container that acts as the main area where you place all the visual elements like labels, buttons, text fields, etc., that the user interacts with.
		//This is a method provided by the JFrame class (which represents the main window in Swing).
		
		setContentPane(contentPane);//If this method not used, then nothing is displayed on the window that appears
		
		//This sets the layout manager for the content pane to be null. This means you'll need to manually specify the position of each element you add to the panel.
		contentPane.setLayout(null); //If this not written, then elements will be placed anywhere , no matter where you want them to be
		
//++++++++++++++++++++++++++++++++++++++++++++++++++++
		//creates a new label object named title with the text "WELCOME TO THE SAMSTHA STORE" and centers the text within the label.
		JLabel title = new JLabel("WELCOME TO THE SAMSTHA STORE",JLabel.CENTER);    	
		
		title.setName("title");
		title.setBounds(391,0,900,85);
        title.setFont(new Font ("Serif",Font.BOLD,48));
        title.setForeground(Color.black);//This sets the color of the label text to a dark purple color.
        title.setOpaque(true);//This makes the label background opaque
        title.setBackground(new Color(188, 127, 205)); //MAGENTA , darkGray ,
		contentPane.add(title);
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		//This creates an ImageIcon object named img. It attempts to load the image from the specified path on the user's computer
		ImageIcon img=new ImageIcon("C:\\Users\\hp\\Downloads\\MKSSS-Pune.png");
		int w=img.getIconWidth();
    	int h=img.getIconHeight();
    	setPreferredSize(new Dimension(w,h));
    	//This creates a new label object named i and sets its icon to the img object (the loaded image). This effectively creates an image label.
    	JLabel i = new JLabel(img);
    	//This sets a lowered bevel border around the image label. Bevel borders create a 3D raised or lowered effect.
		i.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));		
		//t's placed at (0, 0) in the top-left corner with a width of 391 pixels and a height of 398 pixels.
		i.setBounds(0, 0, 391, 398);
		contentPane.add(i);
		
		
		JPanel panel = new JPanel();//creates a new panel object named panel
		panel.setBackground(new Color(188, 127, 205));//This sets the background color of the panel to a light magenta color.
		panel.setBounds(0, 396, 391, 900); // defines the position and size of the panel within the content pane
		contentPane.add(panel);
		panel.setLayout(null);
		
		//bottom left corner logo
		ImageIcon icon = new ImageIcon("\"C:\\Users\\Mahesh\\Downloads\\MKSSS-Pune.png\"");
		JLabel logo = new JLabel(icon);
		logo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));								
		logo.setBounds(25, 25, 332, 340);
		panel.add(logo);
				
		
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
		JButton btnLogin = new JButton("ADMIN LOGIN");
		btnLogin.setBounds(600, 500, 200, 80);
		contentPane.add(btnLogin);
        btnLogin.setForeground(Color.BLACK); // Set text color to black
        btnLogin.setBorder(new LineBorder(Color.BLACK)); // Set border color to black
        btnLogin.setBackground(new Color(188, 127, 205));
		btnLogin.setFont(new Font("Helvetica Neue", Font.BOLD, 24));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Page1().setVisible(true);
			}
		});
		
		
		JButton btnUserLogin = new JButton("USER LOGIN");
		btnUserLogin.setBounds(900, 500, 200, 80);
		contentPane.add(btnUserLogin);
		btnUserLogin.setForeground(Color.BLACK); // Set text color to black
		btnUserLogin.setBorder(new LineBorder(Color.BLACK)); // Set border color to black
		btnUserLogin.setBackground(new Color(188, 127, 205));
		btnUserLogin.setFont(new Font("Helvetica Neue", Font.BOLD, 24));
		btnUserLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new User_Crud().setVisible(true);
			}
		});


		//A JTextArea is a component in Swing that allows for multi-line text input or display.
		JTextArea txt = new JTextArea();
		
		txt.setLineWrap(true);//This line enables line wrapping for the text area txtrE. When enabled, text will automatically go to the next line if it reaches the end of the visible area instead of overflowing the width.
        //txt.setBackground(new Color(215, 187, 245)); //MAGENTA , darkGray ,

		txt.setFont(new Font("Helvetica Neue", Font.BOLD, 25));
		txt.setText(""
				+ "\n\n\n     Empower Your College Journey with Must-Have "
				+ "\n\n\n     Stationery Essentials!"
				+ "\n\n\n     AT REASONABLE PRICES FOR ALL SAMSTHA STUDENTS ");
		txt.setBounds(401, 95, 860, 626);
		contentPane.add(txt);
	}	
}