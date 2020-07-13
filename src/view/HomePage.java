package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class HomePage {

	private JFrame frame;

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
		frame = new JFrame();
		frame.setBounds(100, 100, 732, 484);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel titleOfHome = new JLabel("Choose a function");
		titleOfHome.setFont(new Font("Castellar", Font.PLAIN, 25));
		titleOfHome.setBounds(48, 39, 317, 57);
		frame.getContentPane().add(titleOfHome);
		
		JButton extractButton = new JButton("<html>Extract Data from PDF<br>(Click here to upload your PDF file)</html>");
		extractButton.setFont(new Font("Bell MT", Font.PLAIN, 17));
		extractButton.setBounds(190, 122, 292, 89);
		frame.getContentPane().add(extractButton);
		
		JButton createButton = new JButton("Generate Data");
		createButton.setFont(new Font("Bell MT", Font.PLAIN, 23));
		createButton.setBounds(190, 237, 292, 89);
		frame.getContentPane().add(createButton);
	}
}
