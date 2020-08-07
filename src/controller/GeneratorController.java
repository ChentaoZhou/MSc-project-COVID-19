package controller;
//还需要最后写入进文件的代码





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
import view.GeneratPage;

public class GeneratorController implements ActionListener{
	private GeneratPage view;
	String result;
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
		//basic info part
		if(e.getSource() == view.getBasicInfo()) {
			result="";
			String input = JOptionPane.showInputDialog("enter an number" );
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
			String input = JOptionPane.showInputDialog("enter an number" );
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
			String input = JOptionPane.showInputDialog("enter an number" );
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
			String input = JOptionPane.showInputDialog("enter an number" );
			System.out.println(input);			
			int number = Integer.parseInt(input);
			for(int i=0;i<number;i++) {
				String s =DateOnsetAndSignsGenerator.generateData();
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
			String input = JOptionPane.showInputDialog("enter an number" );
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
			String input = JOptionPane.showInputDialog("enter an number" );
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
			String input = JOptionPane.showInputDialog("enter an number" );
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
			String input = JOptionPane.showInputDialog("enter an number" );
			System.out.println(input);			
			int number = Integer.parseInt(input);
			for(int i=0;i<number;i++) {
				String s =BasicInfoGenerator.generateData()+","+CICGenerator.generateData()+","+DEMOGenerator.generateData()+","
						  +DateOnsetAndSignsGenerator.generateData()+","+COMorbiditiesGenerator.generateData()+","+PreCMGenerator.generateData()
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
		if(e.getSource() == view.getStore()) {
			JFileChooser fileChooser = new JFileChooser();
			int res = fileChooser.showSaveDialog(fileChooser);
			File file = fileChooser.getSelectedFile();
			FileTool.writeUpdate(file, result);
			int input = JOptionPane.showConfirmDialog(null, "Stored OK!");
			view.getFrmDataGenerator().dispose();
			GeneratPage gc = new GeneratPage();
			gc.getFrmDataGenerator().setVisible(true);
		}
		
	}
}
