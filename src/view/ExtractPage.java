package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.ExtractController;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;

public class ExtractPage  {

	private JButton BFButton,CICButton,DAVSButton,CMButton,PACMButton,SSAButton,overallButton,backButton;
	private JFrame frame;
	private ExtractController controller;
	/** Getters */
	public JButton getBFButton() {
		return this.BFButton;
	}
	public JButton getCICButton() {
		return this.CICButton;
	}
	public JButton getDAVSButton() {
		return this.DAVSButton;
	}
	public JButton getCMButton() {
		return this.CMButton;
	}
	public JButton getPACMButton() {
		return this.PACMButton;
	}
	public JButton getSSAButton() {
		return this.SSAButton;
	}
	public JButton getOverallButton() {
		return this.overallButton;
	}
	public JButton getBackButton() {
		return this.backButton;
	}
	public JFrame getFrame() {
		return this.frame;
	}
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
		controller = new ExtractController(this);
		frame = new JFrame();
		frame.setBounds(100, 100, 830, 511);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel titleLabel = new JLabel("Choose which part to extract");
		titleLabel.setFont(new Font("Castellar", Font.BOLD, 17));
		titleLabel.setBounds(10, 10, 369, 54);
		frame.getContentPane().add(titleLabel);

		BFButton = new JButton("Basic Info");
		BFButton.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		BFButton.setBounds(30, 74, 363, 54);
		frame.getContentPane().add(BFButton);

		CICButton = new JButton("Clinical Inclusion Criteria");
		CICButton.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		CICButton.setBounds(30, 138, 363, 54);
		frame.getContentPane().add(CICButton);

		DAVSButton = new JButton("Date of Onset and Admission Vital Signs");
		DAVSButton.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		DAVSButton.setBounds(30, 205, 363, 54);
		frame.getContentPane().add(DAVSButton);

		CMButton = new JButton("Co-Morbidities");
		CMButton.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		CMButton.setBounds(30, 269, 363, 54);
		frame.getContentPane().add(CMButton);

		PACMButton = new JButton("Pre-Admission & Chronic Medication");
		PACMButton.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		PACMButton.setBounds(30, 333, 363, 54);
		frame.getContentPane().add(PACMButton);

		SSAButton = new JButton("Signs and Symptoms on Admission");
		SSAButton.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		SSAButton.setBounds(30, 397, 363, 54);
		frame.getContentPane().add(SSAButton);

		overallButton = new JButton("OVERALL");
		overallButton.setFont(new Font("Century Gothic", Font.BOLD, 18));
		overallButton.setBounds(449, 397, 334, 53);
		frame.getContentPane().add(overallButton);
		
		backButton = new JButton("BACK");
		backButton.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		backButton.setBounds(639, 21, 144, 54);
		backButton.addActionListener(controller);
		frame.getContentPane().add(backButton);
		
		JLabel lblChooseASection = new JLabel("<html>Choose a section to extract<br>or the whole PDF</html>");
		lblChooseASection.setForeground(Color.GRAY);
		lblChooseASection.setFont(new Font("Eras Light ITC", Font.BOLD, 20));
		lblChooseASection.setBounds(449, 112, 273, 80);
		frame.getContentPane().add(lblChooseASection);
	}
}
