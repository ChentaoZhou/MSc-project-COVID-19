package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.ExtractPdf;
import model.FileTool;
import view.ExtractPage;
import view.HomePage;

public class ExtractController implements ActionListener{
	private ExtractPage view;

	public ExtractController(ExtractPage view) {
		this.view = view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == view.getBackButton()) {
			view.getFrame().dispose();
			HomePage hp = new HomePage();
			hp.getFrame().setVisible(true);
		}
		if(e.getSource() == view.getOverallButton()) {
			try {
				ArrayList<String> lines = ExtractPdf.extractPdf("ISARIC_M1.pdf");
				String stuff = ExtractPdf.m1_overall(lines);
				String path = "overall.txt";
				FileTool.writeUpdate(path, stuff);
				JOptionPane.showMessageDialog(null, "Please go to the specified location to view", "Extract successful", JOptionPane.DEFAULT_OPTION); 
				view.getOverallButton().setEnabled(false);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource() == view.getBFButton()) {
			try {
				ArrayList<String> lines = ExtractPdf.extractPdf("ISARIC_M1.pdf");
				String stuff = ExtractPdf.m1_basicInfo(lines);
				String path = "M1_basic_info.txt";
				FileTool.writeUpdate(path, stuff);
				JOptionPane.showMessageDialog(null, "Please go to the specified location to view", "Extract successful", JOptionPane.DEFAULT_OPTION); 
				view.getBFButton().setEnabled(false);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource() == view.getDMButton()) {
			try {
				ArrayList<String> lines = ExtractPdf.extractPdf("ISARIC_M1.pdf");
				String stuff = ExtractPdf.m1_Demographics(lines);
				String path = "M1_DEMOGRAPHICS.txt";
				FileTool.writeUpdate(path, stuff);
				JOptionPane.showMessageDialog(null, "Please go to the specified location to view", "Extract successful", JOptionPane.DEFAULT_OPTION); 
				view.getDMButton().setEnabled(false);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource() == view.getCICButton()) {
			try {
				ArrayList<String> lines = ExtractPdf.extractPdf("ISARIC_M1.pdf");
				String stuff = ExtractPdf.m1_Clinical(lines);
				String path = "M1_CLINICAL INCLUSION CRITERIA.txt";
				FileTool.writeUpdate(path, stuff);
				JOptionPane.showMessageDialog(null, "Please go to the specified location to view", "Extract successful", JOptionPane.DEFAULT_OPTION); 
				view.getCICButton().setEnabled(false);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource() == view.getDAVSButton()) {
			try {
				ArrayList<String> lines = ExtractPdf.extractPdf("ISARIC_M1.pdf");
				String stuff = ExtractPdf.m1_Vitalsigns(lines);
				String path = "M1_DATE OF ONSET AND ADMISSION VITAL SIGNS.txt";
				FileTool.writeUpdate(path, stuff);
				JOptionPane.showMessageDialog(null, "Please go to the specified location to view", "Extract successful", JOptionPane.DEFAULT_OPTION); 
				view.getDAVSButton().setEnabled(false);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource() == view.getCMButton()) {
			try {
				ArrayList<String> lines = ExtractPdf.extractPdf("ISARIC_M1.pdf");
				String stuff = ExtractPdf.m1_CoMorbidities(lines);
				String path = "M1_CO-MORBIDITIES.txt";
				FileTool.writeUpdate(path, stuff);
				JOptionPane.showMessageDialog(null, "Please go to the specified location to view", "Extract successful", JOptionPane.DEFAULT_OPTION); 
				view.getCMButton().setEnabled(false);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource() == view.getPACMButton()) {
			try {
				ArrayList<String> lines = ExtractPdf.extractPdf("ISARIC_M1.pdf");
				String stuff = ExtractPdf.m1_ChronicMedication(lines);
				String path = "M1_PRE-ADMISSION & CHRONIC MEDICATION.txt";
				FileTool.writeUpdate(path, stuff);
				JOptionPane.showMessageDialog(null, "Please go to the specified location to view", "Extract successful", JOptionPane.DEFAULT_OPTION); 
				view.getPACMButton().setEnabled(false);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource() == view.getSSAButton()) {
			try {
				ArrayList<String> lines = ExtractPdf.extractPdf("ISARIC_M1.pdf");
				String stuff = ExtractPdf.m1_SymptomsAD(lines);
				String path = "M1_SIGNS AND SYMPTOMS ON ADMISSION.txt";
				FileTool.writeUpdate(path, stuff);
				JOptionPane.showMessageDialog(null, "Please go to the specified location to view", "Extract successful", JOptionPane.DEFAULT_OPTION); 
				view.getSSAButton().setEnabled(false);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
	}
	
	
}
