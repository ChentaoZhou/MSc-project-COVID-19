package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.HomeController;

import java.awt.Font;
import javax.swing.JButton;
/**
 * The first home page GUI that user can select the function. 
 * Extracting Data from PDF or generating random data
 * **/
public class HomePage {

	private HomeController controller;
	private JFrame frmHomepage;
	private JButton extractButton, createButton;
	private JButton exit;
	
	//Getters
	public JFrame getFrame() {return this.frmHomepage;}
	public HomeController getController() {return this.controller;}
	public JButton getExtractButton() {return this.extractButton;}
	public JButton getCreateButton() {return this.createButton;}
	public JButton getExit() {return this.exit;	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage window = new HomePage();
					window.frmHomepage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		controller = new HomeController(this);
		
		frmHomepage = new JFrame();
		frmHomepage.setTitle("HomePage");
		frmHomepage.setBounds(100, 100, 732, 484);
		frmHomepage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHomepage.getContentPane().setLayout(null);
		
		JLabel titleOfHome = new JLabel("Choose a function");
		titleOfHome.setFont(new Font("Castellar", Font.PLAIN, 30));
		titleOfHome.setBounds(164, 10, 387, 102);
		frmHomepage.getContentPane().add(titleOfHome);
		
		extractButton = new JButton("<html>          Extract Data from PDF          <br>Click here to upload your PDF file</html>");
		extractButton.setFont(new Font("Bell MT", Font.BOLD, 20));
		extractButton.setBounds(26, 122, 346, 105);
		extractButton.addActionListener(controller);
		frmHomepage.getContentPane().add(extractButton);
		
		createButton = new JButton("Generate Data");
		createButton.setFont(new Font("Bell MT", Font.BOLD, 23));
		createButton.setBounds(26, 239, 346, 105);
		createButton.addActionListener(controller);
		frmHomepage.getContentPane().add(createButton);
		
		exit = new JButton("EXIT");
		exit.setFont(new Font("Bell MT", Font.PLAIN, 22));
		exit.setBounds(571, 378, 119, 40);
		exit.addActionListener(controller);
		frmHomepage.getContentPane().add(exit);
		
		JLabel extractNotify = new JLabel("You need to choose a PDF file to ");
		extractNotify.setFont(new Font("Eras Light ITC", Font.PLAIN, 20));
		extractNotify.setBounds(382, 141, 308, 40);
		frmHomepage.getContentPane().add(extractNotify);
		
		JLabel extractNotify2 = new JLabel("extract after clicking this button");
		extractNotify2.setFont(new Font("Eras Light ITC", Font.PLAIN, 20));
		extractNotify2.setBounds(382, 171, 308, 40);
		frmHomepage.getContentPane().add(extractNotify2);
	}
}
