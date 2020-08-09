package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import controller.ExtractController;

import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.JButton;
import java.awt.Color;

/**
 * The GUI for extracting data from PDF,contains 8 major buttons for different section and all of them
 * There is a small window for user to watch the extracted result.
 * After the extraction process, the extracted data will be stored in the specialized file which is selected by user.
 * */
public class ExtractPage  {

	private JButton BFButton,CICButton,DAVSButton,CMButton,PACMButton,SSAButton,overallButton,backButton,DMButton;
	private JFrame frmExtractingDataFrom;
	private JPanel content;
	private ExtractController controller;
	public File file;
	private JScrollPane scrollPane;
	private JLabel resultLabel;
	
	
	public JLabel getResultLabel() {return this.resultLabel;}
	public JPanel getContent() {return this.content;}
	public void setResultLabel(JLabel resultLabel) {this.resultLabel = resultLabel;}


	public JScrollPane getScrollPane() {return this.scrollPane;}
	
	public ExtractPage(File file) {
		this.file = file;
		initialize();
	}
	/** Getters */
	public JButton getBFButton() {
		return this.BFButton;
	}
	public JButton getDMButton() {
		return this.DMButton;
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
		return this.frmExtractingDataFrom;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExtractPage window = new ExtractPage();
					window.frmExtractingDataFrom.setVisible(true);
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
		controller = new ExtractController(this, file);
		frmExtractingDataFrom = new JFrame();
		frmExtractingDataFrom.setTitle("Extracting Data From PDF");
		frmExtractingDataFrom.setBounds(100, 100, 830, 511);
		frmExtractingDataFrom.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmExtractingDataFrom.getContentPane().setLayout(null);

		JLabel titleLabel = new JLabel("Choose which part to extract");
		titleLabel.setFont(new Font("Castellar", Font.BOLD, 17));
		titleLabel.setBounds(10, 10, 369, 54);
		frmExtractingDataFrom.getContentPane().add(titleLabel);

		BFButton = new JButton("Basic Info");
		BFButton.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		BFButton.setBounds(30, 74, 363, 54);
		BFButton.addActionListener(controller);
		frmExtractingDataFrom.getContentPane().add(BFButton);

		CICButton = new JButton("Clinical Inclusion Criteria");
		CICButton.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		CICButton.setBounds(30, 205, 363, 54);
		CICButton.addActionListener(controller);
		frmExtractingDataFrom.getContentPane().add(CICButton);

		DAVSButton = new JButton("Date of Onset and Admission Vital Signs");
		DAVSButton.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		DAVSButton.setBounds(30, 269, 363, 54);
		DAVSButton.addActionListener(controller);
		
		frmExtractingDataFrom.getContentPane().add(DAVSButton);

		CMButton = new JButton("Co-Morbidities");
		CMButton.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		CMButton.setBounds(420, 74, 363, 54);
		CMButton.addActionListener(controller);
		frmExtractingDataFrom.getContentPane().add(CMButton);

		PACMButton = new JButton("Pre-Admission & Chronic Medication");
		PACMButton.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		PACMButton.setBounds(420, 138, 363, 54);
		PACMButton.addActionListener(controller);
		frmExtractingDataFrom.getContentPane().add(PACMButton);

		SSAButton = new JButton("Signs and Symptoms on Admission");
		SSAButton.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		SSAButton.setBounds(420, 205, 363, 54);
		SSAButton.addActionListener(controller);
		frmExtractingDataFrom.getContentPane().add(SSAButton);

		overallButton = new JButton("OVERALL");
		overallButton.setFont(new Font("Century Gothic", Font.BOLD, 18));
		overallButton.setBounds(420, 269, 363, 53);
		overallButton.addActionListener(controller);
		frmExtractingDataFrom.getContentPane().add(overallButton);
		
		backButton = new JButton("BACK");
		backButton.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		backButton.setBounds(639, 387, 144, 54);
		backButton.addActionListener(controller);
		frmExtractingDataFrom.getContentPane().add(backButton);
		
		JLabel lblChooseASection = new JLabel("<html>Choose a section to extract or the <br>whole PDF, and select a file to store</html>");
		lblChooseASection.setForeground(Color.GRAY);
		lblChooseASection.setFont(new Font("Eras Light ITC", Font.BOLD, 20));
		lblChooseASection.setBounds(409, 10, 405, 54);
		frmExtractingDataFrom.getContentPane().add(lblChooseASection);
		
		DMButton = new JButton("Demographics");
		DMButton.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		DMButton.setBounds(30, 138, 363, 54);
		DMButton.addActionListener(controller);
		frmExtractingDataFrom.getContentPane().add(DMButton);
		
		resultLabel = new JLabel();
		resultLabel.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		resultLabel.setText("View the extracted data here: ");
		scrollPane = new JScrollPane();
		content = new JPanel();
		content.setLayout(new GridLayout(0,1));
		content.add(resultLabel);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(30, 356, 577, 85);
		frmExtractingDataFrom.getContentPane().add(scrollPane);
		scrollPane.setViewportView(content);
	}
	public void success() {
		JOptionPane.showInternalMessageDialog(null, "All done","extract sucess!", JOptionPane.INFORMATION_MESSAGE); 
	}
}
