package controller;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.AnalysePdf;
import model.ExtractPdf;
import model.Patient;
import view.AnalysisPage;
import view.ExtractPage;
import view.HomePage;

public class AnalysisController implements ActionListener{
	private AnalysisPage view;
	
	public AnalysisController(AnalysisPage view) {
		this.view = view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == view.getBackButton()) {
			view.getFrame().dispose();
			HomePage hp = new HomePage();
			hp.getFrame().setVisible(true);
		}
		if(e.getSource() == view.getAnalyseButton()) {
			Patient p = new Patient();
			JFileChooser fileChooser = new JFileChooser();
			int res = fileChooser.showSaveDialog(fileChooser);
			File file = fileChooser.getSelectedFile();
			//if user do not choose a file, the program need to handle this.
			if(file!=null) {
				ArrayList<String> lines;
				try {
					lines = AnalysePdf.extractPdf(file);
					String stuff = AnalysePdf.m1_overall(lines, p);
					
				} catch (IOException e1) {e1.printStackTrace();}	
				//Analyze the information stored in the Patient
				String symptoms ="";
				if(p.isFever()) symptoms+="Fever  ";
				if(p.isCough()) symptoms+="Couth  ";
				if(p.isMuscleAches()) symptoms+="Muscle Aches  ";
				if(p.isFatigue()) symptoms+= "Fatigue ";
				
				JLabel label1 = new JLabel("COVID-19 related symptoms: "+symptoms+" ("+p.getNumCovidSym()+")");
				label1.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
				view.getContent().add(label1);
				
				JLabel label2 = new JLabel("Participant age: "+p.getAge());
				label2.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
				view.getContent().add(label2);
				
				JLabel label3 = new JLabel("The number of Co-Morbidities: "+p.getNum_comorbidities());
				label3.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
				view.getContent().add(label3);
				
				if(p.getAge()>=60 && p.getNumCovidSym()>=3) {
					JLabel label4 = new JLabel("Questionnaire analysis rating: S (requires special attention)");
					//JLabel label5 = new JLabel("<html><body><p>Suggestion: the participants belong to high-risk groups</p><br><p>please go to the hospital for COVID-19 check as soon as possible, and avoid contact with others</p><body></html>");
					JLabel label5 = new JLabel("Suggestion: the participant belong to high-risk groups");
					JLabel label6 = new JLabel("please go to the hospital for COVID-19 test as soon as possible, and avoid contact with others");
					
					label4.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
					label5.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
					label6.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
					
					view.getContent().add(label4);
					view.getContent().add(label5);
					view.getContent().add(label6);
				}else if(p.getNumCovidSym()>=3) {
					JLabel label4 = new JLabel("Questionnaire analysis rating: A (requires attention)");
					JLabel label5 = new JLabel("Suggestion: Suspected cases, please observe at home");
					JLabel label6 = new JLabel("Avoid contact with others, Seek medical attention if you have shortness of breath");
					label4.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
					label5.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
					label6.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
					view.getContent().add(label4);
					view.getContent().add(label5);
					view.getContent().add(label6);
				}else {
					JLabel label4 = new JLabel("Questionnaire analysis rating: B (Mild)");
					JLabel label5 = new JLabel("Suggestion: observe at home");
					JLabel label6 = new JLabel("Seek medical attention if you have shortness of breath");
					label4.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
					label5.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
					label6.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
					view.getContent().add(label4);
					view.getContent().add(label5);
					view.getContent().add(label6);
				}
				
				view.getScrollPane().setViewportView(view.getContent());
				
				
			}else {
				JOptionPane.showMessageDialog(null, "No file choosen, you need to choose a file","Wrong operation",JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}

}
