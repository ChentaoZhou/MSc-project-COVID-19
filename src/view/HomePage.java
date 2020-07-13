package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.HomeController;

import java.awt.Font;
import javax.swing.JButton;

public class HomePage {


	private HomeController controller;
	private JFrame frame;
	private JButton extractButton, createButton;
	
	public JFrame getFrame() {
		return this.frame;
	}
	public HomeController getController() {
		return this.controller;
	}
	public JButton getExtractButton() {
		return this.extractButton;
	}

	public JButton getCreateButton() {
		return this.createButton;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage window = new HomePage();
					window.frame.setVisible(true);
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
		
		frame = new JFrame();
		frame.setBounds(100, 100, 732, 484);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel titleOfHome = new JLabel("Choose a function");
		titleOfHome.setFont(new Font("Castellar", Font.PLAIN, 25));
		titleOfHome.setBounds(48, 39, 317, 57);
		frame.getContentPane().add(titleOfHome);
		
		extractButton = new JButton("<html>-------- Extract Data from PDF --------<br>(Click here to upload your PDF file)</html>");
		extractButton.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		extractButton.setBounds(161, 122, 346, 105);
		extractButton.addActionListener(controller);
		frame.getContentPane().add(extractButton);
		
		createButton = new JButton("Generate Data");
		createButton.setFont(new Font("Bell MT", Font.PLAIN, 23));
		createButton.setBounds(190, 237, 292, 89);
		createButton.addActionListener(controller);
		frame.getContentPane().add(createButton);
	}
}
