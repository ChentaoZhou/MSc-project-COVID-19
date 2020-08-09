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
import javax.swing.JLabel;

/**
 * The GUI for generating random data, contains nine buttons (7 for partial generating, 1 for whole generating, 1 for store these data)
 * There is a big view window for user to view the generated data.
 * User can choose which section they want to generate and the generated data will be shown in the window, after that, user can store these data
 * in local files.
 * **/
public class GeneratPage {

	private JFrame frmDataGenerator;
	private JPanel content;
	private JButton back,basicInfo,demographics,cic,vitalSigns,coMoribidities,chronicMedication,signsSymptoms,overall,store;
	private GeneratorController controller;
	private JScrollPane scrollPane;
	private JLabel defaultLabel;

	/**
	 * Getters for this class
	 * **/
	public JScrollPane getScrollPane() {return this.scrollPane;}
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
	public JButton getBack() {return this.back;}
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
		overall.setBounds(535, 414, 159, 46);
		overall.addActionListener(controller);
		frmDataGenerator.getContentPane().add(overall);
		
		store = new JButton("Confirm & Store");
		store.setFont(new Font("Century Gothic", Font.BOLD, 17));
		store.setBounds(699, 414, 167, 46);
		store.addActionListener(controller);
		store.setEnabled(false);
		frmDataGenerator.getContentPane().add(store);
		
		scrollPane = new JScrollPane();
		content = new JPanel();
		content.setLayout(new GridLayout(0,1));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(21, 25, 853, 323);
		frmDataGenerator.getContentPane().add(scrollPane);
		scrollPane.setViewportView(content);
		
		defaultLabel = new JLabel("Select a section to generate and Generated Data will be shown here : ");
		defaultLabel.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		content.add(defaultLabel);
		
		back = new JButton("BACK");
		back.setFont(new Font("Century Gothic", Font.ITALIC, 17));
		back.setBounds(708, 484, 159, 46);
		back.addActionListener(controller);
		frmDataGenerator.getContentPane().add(back);
	}
}
