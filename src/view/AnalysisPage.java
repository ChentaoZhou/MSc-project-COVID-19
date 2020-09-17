package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import controller.AnalysisController;
import controller.HomeController;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;

public class AnalysisPage {

	private JFrame frame;
	private AnalysisController controller;
	private JScrollPane scrollPane;
	private JPanel content;
	private JButton IntroduceButton,backButton;
	private JButton analyseButton;
	private JLabel analyseLabel;
	private JLabel analyseLabel2;
	
	
	
	
	public JScrollPane getScrollPane() {return this.scrollPane;}

	public JPanel getContent() {return this.content;}

	public JButton getIntroduceButton() {return this.IntroduceButton;}

	public JButton getBackButton() {return this.backButton;}

	public JButton getAnalyseButton() {return this.analyseButton;}

	public JFrame getFrame() {return this.frame;}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnalysisPage window = new AnalysisPage();
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
	public AnalysisPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		controller = new AnalysisController(this);
		
		frame = new JFrame();
		frame.setTitle("Analyse patient's questionnaire");
		frame.setBounds(100, 100, 735, 526);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		IntroduceButton = new JButton("Information about COVID-19");
		IntroduceButton.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		IntroduceButton.setBounds(416, 386, 273, 46);
		IntroduceButton.addActionListener(controller);
		IntroduceButton.setVisible(false);
		frame.getContentPane().add(IntroduceButton);
		
		backButton = new JButton("Back");
		backButton.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		backButton.setBounds(572, 442, 115, 35);
		backButton.addActionListener(controller);
		frame.getContentPane().add(backButton);
		
		scrollPane = new JScrollPane();
		content = new JPanel();
		content.setLayout(new GridLayout(0,1));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(21, 78, 688, 298);
		frame.getContentPane().add(scrollPane);
		scrollPane.setColumnHeaderView(content);
		
		analyseButton = new JButton("Analyse a questionnaire");
		analyseButton.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		analyseButton.setBounds(42, 386, 259, 46);
		analyseButton.addActionListener(controller);
		frame.getContentPane().add(analyseButton);
		
		analyseLabel = new JLabel("Click the Analysis button to extract and analyze the questionnaire data");
		analyseLabel.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		analyseLabel.setBounds(21, 10, 629, 30);
		frame.getContentPane().add(analyseLabel);
		
		analyseLabel2 = new JLabel("Click the Information button to learn more about relevant information and data");
		analyseLabel2.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		analyseLabel2.setBounds(21, 38, 688, 30);
		frame.getContentPane().add(analyseLabel2);
	}
}
