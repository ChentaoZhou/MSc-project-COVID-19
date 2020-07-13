package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class ExtractPage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExtractPage window = new ExtractPage();
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
	public ExtractPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 730, 468);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("Choose which part to extract");
		titleLabel.setFont(new Font("Castellar", Font.PLAIN, 17));
		titleLabel.setBounds(10, 10, 350, 54);
		frame.getContentPane().add(titleLabel);
		
		JButton BFButton = new JButton("BASIC INFO");
		BFButton.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		BFButton.setBounds(30, 74, 323, 39);
		frame.getContentPane().add(BFButton);
		
		JButton CICButton = new JButton("CLINICAL INCLUSION CRITERIA");
		CICButton.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		CICButton.setBounds(30, 123, 323, 39);
		frame.getContentPane().add(CICButton);
		
		JButton DAVSButton = new JButton("DATE OF ONSET AND ADMISSION VITAL SIGNS");
		DAVSButton.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		DAVSButton.setBounds(30, 172, 323, 39);
		frame.getContentPane().add(DAVSButton);
		
		JButton CMButton = new JButton("CO-MORBIDITIES");
		CMButton.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		CMButton.setBounds(30, 220, 323, 39);
		frame.getContentPane().add(CMButton);
		
		JButton PACMButton = new JButton("PRE-ADMISSION & CHRONIC MEDICATION");
		PACMButton.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		PACMButton.setBounds(30, 274, 323, 39);
		frame.getContentPane().add(PACMButton);
		
		JButton SSAButton = new JButton("SIGNS AND SYMPTOMS ON ADMISSION");
		SSAButton.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		SSAButton.setBounds(30, 336, 323, 39);
		frame.getContentPane().add(SSAButton);
		
		JButton overallButton = new JButton("OVERALL");
		overallButton.setFont(new Font("Century Gothic", Font.BOLD, 14));
		overallButton.setBounds(381, 336, 323, 39);
		frame.getContentPane().add(overallButton);
	}
}
