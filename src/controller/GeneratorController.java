package controller;
//还需要最后写入进文件的代码





import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import generater.BasicInfoGenerator;
import generater.CICGenerator;
import generater.COMorbiditiesGenerator;
import generater.DEMOGenerator;
import generater.DateOnsetAndSignsGenerator;
import generater.PreCMGenerator;
import generater.SignAndSymGenerator;
import view.GeneratPage;

public class GeneratorController implements ActionListener{
	private GeneratPage view;

	public GeneratorController (GeneratPage view) {
		this.view = view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//basic info part
		if(e.getSource() == view.getBasicInfo()) {
			String result="";
			String input = JOptionPane.showInputDialog("enter an number" );
			System.out.println(input);			
			int number = Integer.parseInt(input);
			for(int i=0;i<number;i++) {
				String s =BasicInfoGenerator.generateData();
				result= result+s;
				JLabel temp = new JLabel(s);
				view.getContent().add(temp);
				view.getScrollPane().setViewportView(view.getContent());
			}
		}
		
		//Clinical Inclusion Criteria
		if(e.getSource() == view.getCic()) {
			String result="";
			String input = JOptionPane.showInputDialog("enter an number" );
			System.out.println(input);			
			int number = Integer.parseInt(input);
			for(int i=0;i<number;i++) {
				String s =CICGenerator.generateData();
				result= result+s;
				JLabel temp = new JLabel(s);
				view.getContent().add(temp);
				view.getScrollPane().setViewportView(view.getContent());
			}
		}
		//Demographics
		if(e.getSource() == view.getDemographics()) {
			String result="";
			String input = JOptionPane.showInputDialog("enter an number" );
			System.out.println(input);			
			int number = Integer.parseInt(input);
			for(int i=0;i<number;i++) {
				String s =CICGenerator.generateData();
				result= result+s;
				JLabel temp = new JLabel(s);
				view.getContent().add(temp);
				view.getScrollPane().setViewportView(view.getContent());
			}
		}
		//Date of Onset and Admission Vital signs
		if(e.getSource() == view.getVitalSigns()) {
			String result="";
			String input = JOptionPane.showInputDialog("enter an number" );
			System.out.println(input);			
			int number = Integer.parseInt(input);
			for(int i=0;i<number;i++) {
				String s =DateOnsetAndSignsGenerator.generateData();
				result= result+s;
				JLabel temp = new JLabel(s);
				view.getContent().add(temp);
				view.getScrollPane().setViewportView(view.getContent());
			}
		}
		//Co-Morbidities
		if(e.getSource() == view.getCoMoribidities()) {
			String result="";
			String input = JOptionPane.showInputDialog("enter an number" );
			System.out.println(input);			
			int number = Integer.parseInt(input);
			for(int i=0;i<number;i++) {
				String s =COMorbiditiesGenerator.generateData();
				result= result+s;
				JLabel temp = new JLabel(s);
				view.getContent().add(temp);
				view.getScrollPane().setViewportView(view.getContent());
			}
		}
		//Pre-Admission & Chronic Medication
		if(e.getSource() == view.getChronicMedication()) {
			String result="";
			String input = JOptionPane.showInputDialog("enter an number" );
			System.out.println(input);			
			int number = Integer.parseInt(input);
			for(int i=0;i<number;i++) {
				String s =PreCMGenerator.generateData();
				result= result+s;
				JLabel temp = new JLabel(s);
				view.getContent().add(temp);
				view.getScrollPane().setViewportView(view.getContent());
			}
		}
		//Signs and Symptoms on Admission
		if(e.getSource() == view.getSignsSymptoms()) {
			String result="";
			String input = JOptionPane.showInputDialog("enter an number" );
			System.out.println(input);			
			int number = Integer.parseInt(input);
			for(int i=0;i<number;i++) {
				String s =SignAndSymGenerator.generateData();
				result= result+s;
				JLabel temp = new JLabel(s);
				view.getContent().add(temp);
				view.getScrollPane().setViewportView(view.getContent());
			}
		}
		//overall
		if(e.getSource() == view.getOverall()) {
			String result="";
			String input = JOptionPane.showInputDialog("enter an number" );
			System.out.println(input);			
			int number = Integer.parseInt(input);
			for(int i=0;i<number;i++) {
				String s =BasicInfoGenerator.generateData()+","+CICGenerator.generateData()+","+DEMOGenerator.generateData()+","
						  +DateOnsetAndSignsGenerator.generateData()+","+COMorbiditiesGenerator.generateData()+","+PreCMGenerator.generateData()
						  +","+SignAndSymGenerator.generateData();
				result= result+s;
				JLabel temp = new JLabel(s);
				view.getContent().add(temp);
				view.getScrollPane().setViewportView(view.getContent());
			}
		}
		
	}
}
