package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class ExtractPage  {



	private JFrame frame;
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
		frame = new JFrame();
		frame.setBounds(100, 100, 830, 511);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel titleLabel = new JLabel("Choose which part to extract");
		titleLabel.setFont(new Font("Castellar", Font.BOLD, 17));
		titleLabel.setBounds(10, 10, 369, 54);
		frame.getContentPane().add(titleLabel);

		JButton BFButton = new JButton("Basic Info");
		BFButton.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		BFButton.setBounds(30, 74, 363, 54);
		frame.getContentPane().add(BFButton);

		JButton CICButton = new JButton("Clinical Inclusion Criteria");
		CICButton.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		CICButton.setBounds(30, 138, 363, 54);
		frame.getContentPane().add(CICButton);

		JButton DAVSButton = new JButton("Date of Onset and Admission Vital Signs");
		DAVSButton.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		DAVSButton.setBounds(30, 205, 363, 54);
		frame.getContentPane().add(DAVSButton);

		JButton CMButton = new JButton("Co-Morbidities");
		CMButton.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		CMButton.setBounds(30, 269, 363, 54);
		frame.getContentPane().add(CMButton);

		JButton PACMButton = new JButton("Pre-Admission & Chronic Medication");
		PACMButton.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		PACMButton.setBounds(30, 333, 363, 54);
		frame.getContentPane().add(PACMButton);

		JButton SSAButton = new JButton("Signs and Symptoms on Admission");
		SSAButton.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		SSAButton.setBounds(30, 397, 363, 54);
		frame.getContentPane().add(SSAButton);

		JButton overallButton = new JButton("OVERALL");
		overallButton.setFont(new Font("Century Gothic", Font.BOLD, 18));
		overallButton.setBounds(449, 397, 334, 53);
		frame.getContentPane().add(overallButton);
	}
}
