package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import generater.BasicInfoGenerator;
import generater.CICGenerator;
import generater.COMorbiditiesGenerator;
import generater.DEMOGenerator;
import generater.DateOnsetAndSignsGenerator;
import generater.PreCMGenerator;
import generater.SignAndSymGenerator;
import model.FileTool;
import model.Patient;
import view.GeneratPage;
import view.HomePage;

/**
 * This class is used to control the responding of GeneratPage, when user click any buttons on the GeneratPage,
 * some reaction will happen here.
 * **/
public class GeneratorController implements ActionListener{
	private GeneratPage view;
	String result;
	Patient patient = new Patient(true);
	public GeneratorController (GeneratPage view) {
		this.view = view;
	}
	public void muteAll() {
		view.getBasicInfo().setEnabled(false);
		view.getChronicMedication().setEnabled(false);
		view.getCic().setEnabled(false);
		view.getCoMoribidities().setEnabled(false);
		view.getDemographics().setEnabled(false);
		view.getOverall().setEnabled(false);
		view.getSignsSymptoms().setEnabled(false);
		view.getVitalSigns().setEnabled(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//back button
		if(e.getSource() == view.getBack()) {
			view.getFrmDataGenerator().dispose();
			HomePage hp = new HomePage();
			hp.getFrame().setVisible(true);
		}
		//basic info part
		if(e.getSource() == view.getBasicInfo()) {
			result="";
			String input = JOptionPane.showInputDialog("Enter the quantity to be produced:" );
			System.out.println(input);			
			int number = Integer.parseInt(input);
			for(int i=0;i<number;i++) {
				String s =BasicInfoGenerator.generateData();
				result= result+s+"\n";
				JLabel temp = new JLabel(s);
				view.getContent().add(temp);
				view.getScrollPane().setViewportView(view.getContent());
			}
			muteAll();
			view.getStore().setEnabled(true);
		}
		
		//Clinical Inclusion Criteria
		if(e.getSource() == view.getCic()) {
			result="";
			String input = JOptionPane.showInputDialog("Enter the quantity to be produced:" );
			System.out.println(input);			
			int number = Integer.parseInt(input);
			for(int i=0;i<number;i++) {
				String s =CICGenerator.generateData();
				result= result+s+"\n";
				JLabel temp = new JLabel(s);
				view.getContent().add(temp);
				view.getScrollPane().setViewportView(view.getContent());
			}
			muteAll();
			view.getStore().setEnabled(true);
		}
		//Demographics
		if(e.getSource() == view.getDemographics()) {
			result="";
			String input = JOptionPane.showInputDialog("Enter the quantity to be produced:" );
			System.out.println(input);			
			int number = Integer.parseInt(input);
			for(int i=0;i<number;i++) {
				String s =CICGenerator.generateData();
				result= result+s+"\n";
				JLabel temp = new JLabel(s);
				view.getContent().add(temp);
				view.getScrollPane().setViewportView(view.getContent());
			}
			muteAll();
			view.getStore().setEnabled(true);
		}
		//Date of Onset and Admission Vital signs
		if(e.getSource() == view.getVitalSigns()) {
			result="";
			String input = JOptionPane.showInputDialog("Enter the quantity to be produced:" );
			System.out.println(input);			
			int number = Integer.parseInt(input);
			for(int i=0;i<number;i++) {
				String s =DateOnsetAndSignsGenerator.generateData(patient);
				result= result+s+"\n";
				JLabel temp = new JLabel(s);
				view.getContent().add(temp);
				view.getScrollPane().setViewportView(view.getContent());
			}
			muteAll();
			view.getStore().setEnabled(true);
		}
		//Co-Morbidities
		if(e.getSource() == view.getCoMoribidities()) {
			result="";
			String input = JOptionPane.showInputDialog("Enter the quantity to be produced:" );
			System.out.println(input);			
			int number = Integer.parseInt(input);
			for(int i=0;i<number;i++) {
				String s =COMorbiditiesGenerator.generateData();
				result= result+s+"\n";
				JLabel temp = new JLabel(s);
				view.getContent().add(temp);
				view.getScrollPane().setViewportView(view.getContent());
			}
			muteAll();
			view.getStore().setEnabled(true);
		}
		//Pre-Admission & Chronic Medication
		if(e.getSource() == view.getChronicMedication()) {
			result="";
			String input = JOptionPane.showInputDialog("Enter the quantity to be produced:" );
			System.out.println(input);			
			int number = Integer.parseInt(input);
			for(int i=0;i<number;i++) {
				String s =PreCMGenerator.generateData();
				result= result+s+"\n";
				JLabel temp = new JLabel(s);
				view.getContent().add(temp);
				view.getScrollPane().setViewportView(view.getContent());
			}
			muteAll();
			view.getStore().setEnabled(true);
		}
		//Signs and Symptoms on Admission
		if(e.getSource() == view.getSignsSymptoms()) {
			result="";
			String input = JOptionPane.showInputDialog("Enter the quantity to be produced:" );
			System.out.println(input);			
			int number = Integer.parseInt(input);
			for(int i=0;i<number;i++) {
				String s =SignAndSymGenerator.generateData();
				result= result+s+"\n";
				JLabel temp = new JLabel(s);
				view.getContent().add(temp);
				view.getScrollPane().setViewportView(view.getContent());
			}
			muteAll();
			view.getStore().setEnabled(true);
		}
		//overall
		if(e.getSource() == view.getOverall()) {
			result="";
			String input = JOptionPane.showInputDialog("Enter the quantity to be produced:" );
			System.out.println(input);			
			int number = Integer.parseInt(input);
			for(int i=0;i<number;i++) {
				patient = new Patient();
				String s =BasicInfoGenerator.generateData()+","+CICGenerator.generateData()+","+DEMOGenerator.generateData(patient)+","
						  +DateOnsetAndSignsGenerator.generateData(patient)+","+COMorbiditiesGenerator.generateData()+","+PreCMGenerator.generateData()
						  +","+SignAndSymGenerator.generateData();
				result= result+s+"\n";
				JLabel temp = new JLabel(s);
				view.getContent().add(temp);
				view.getScrollPane().setViewportView(view.getContent());
			}
			result = result.substring(0,result.length()-1);
			muteAll();
			view.getStore().setEnabled(true);
		}
		//the store button
		if(e.getSource() == view.getStore()) {
			JFileChooser fileChooser = new JFileChooser();
			int res = fileChooser.showSaveDialog(fileChooser);
			File file = fileChooser.getSelectedFile();
			//if user do not choose a file, the program should handle this
			if(file!=null) {
				FileTool.writeUpdate(file, result);
				JOptionPane.showMessageDialog(null, "Data stored successfully !"); 
				view.getFrmDataGenerator().dispose();
				GeneratPage gc = new GeneratPage();
				gc.getFrmDataGenerator().setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null, "No file choosen,try again!","Wrong operation",JOptionPane.ERROR_MESSAGE); 
			}
		
		}
		
	}
}
