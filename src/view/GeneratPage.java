package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import controller.GeneratorController;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridLayout;

public class GeneratPage {

	private JFrame frmDataGenerator;
	private JPanel content;
	private JButton basicInfo,demographics,cic,vitalSigns,coMoribidities,chronicMedication,signsSymptoms,overall,store;
	private GeneratorController controller;

	public JFrame getFrmDataGenerator() {return this.frmDataGenerator;}
	
	public JPanel getContent() {return this.content;}
	
	public JButton getBasicInfo() {return this.basicInfo;}
	
	public JButton getDemographics() {return this.demographics;}
	
	public JButton getCic() {return this.cic;}

	public JButton getVitalSigns() {return this.vitalSigns;}

	public JButton getCoMoribidities() {return this.coMoribidities;}

	public JButton getChronicMedication() {return this.chronicMedication;}

	public JButton getSignsSymptoms() {return this.signsSymptoms;}

	public JButton getOverall() {return this.overall;}

	public JButton getStore() {return this.store;}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GeneratPage window = new GeneratPage();
					window.frmDataGenerator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GeneratPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		controller = new GeneratorController(this);
		
		frmDataGenerator = new JFrame();
		frmDataGenerator.setTitle("Data Generator");
		frmDataGenerator.setBounds(100, 100, 912, 596);
		frmDataGenerator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDataGenerator.getContentPane().setLayout(null);
		
		basicInfo = new JButton("Basic Info");
		basicInfo.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		basicInfo.setBounds(21, 358, 159, 46);
		basicInfo.addActionListener(controller);
		frmDataGenerator.getContentPane().add(basicInfo);
		
		demographics = new JButton("Demographics");
		demographics.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		demographics.setBounds(21, 414, 159, 46);
		demographics.addActionListener(controller);
		frmDataGenerator.getContentPane().add(demographics);
		
		cic = new JButton("Clinical Inclusion Criteria");
		cic.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		cic.setBounds(190, 414, 335, 46);
		cic.addActionListener(controller);
		frmDataGenerator.getContentPane().add(cic);
		
		vitalSigns = new JButton("Date of Onset Admin Vital Signs");
		vitalSigns.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		vitalSigns.setBounds(190, 358, 335, 46);
		vitalSigns.addActionListener(controller);
		frmDataGenerator.getContentPane().add(vitalSigns);
		
		coMoribidities = new JButton("Co-Morbidities");
		coMoribidities.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		coMoribidities.setBounds(21, 470, 159, 46);
		coMoribidities.addActionListener(controller);
		frmDataGenerator.getContentPane().add(coMoribidities);
		
		chronicMedication = new JButton("Pre-Admission & Chronic Medication");
		chronicMedication.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		chronicMedication.setBounds(190, 470, 335, 46);
		chronicMedication.addActionListener(controller);
		frmDataGenerator.getContentPane().add(chronicMedication);
		
		signsSymptoms = new JButton("Signs and Symptoms on Adminssion");
		signsSymptoms.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		signsSymptoms.setBounds(535, 358, 332, 46);
		signsSymptoms.addActionListener(controller);
		frmDataGenerator.getContentPane().add(signsSymptoms);
		
		overall = new JButton("OVERALL");
		overall.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 17));
		overall.setBounds(640, 414, 159, 46);
		overall.addActionListener(controller);
		frmDataGenerator.getContentPane().add(overall);
		
		store = new JButton("Confirm & Store");
		store.setFont(new Font("Century Gothic", Font.BOLD, 17));
		store.setBounds(635, 470, 175, 46);
		store.addActionListener(controller);
		frmDataGenerator.getContentPane().add(store);
		
		JScrollPane scrollPane = new JScrollPane();
		content = new JPanel();
		content.setLayout(new GridLayout(0,1));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(21, 25, 853, 323);
		frmDataGenerator.getContentPane().add(scrollPane);
		
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(content);
	}
}
