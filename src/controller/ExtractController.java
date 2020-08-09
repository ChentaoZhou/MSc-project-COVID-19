package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.ExtractPdf;
import model.FileTool;
import view.ExtractPage;
import view.HomePage;

/**
 * This class is used to control the responding of ExtractPage, when user click any buttons on the ExtracePage,
 * some reaction will happen here.
 * **/
public class ExtractController implements ActionListener{
	private ExtractPage view;
	File file;

	/**
	 * Constructor of this class, the parameters are the ExtractPage and the file path we need to extract data(The PDF)
	 * **/
	public ExtractController(ExtractPage view, File file) {
		this.view = view;
		this.file =file;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//the button go back to home page
		if(e.getSource() == view.getBackButton()) {
			view.getFrame().dispose();
			HomePage hp = new HomePage();
			hp.getFrame().setVisible(true);
		}
		//Extracting overall data in the PDF
		if(e.getSource() == view.getOverallButton()) {
			try {
				ArrayList<String> lines = ExtractPdf.extractPdf(file);
				String stuff = ExtractPdf.m1_overall(lines);
				//take the file path we want to store the extracted data
				JFileChooser fileChooser = new JFileChooser();
				int res = fileChooser.showSaveDialog(fileChooser);
				File path = fileChooser.getSelectedFile();
				
				//if the user do not choose a file, program should handle this.
				if(path!=null) {
					FileTool.writeUpdate(path, stuff);			//write the data into the file
					//update the extracted data in the GUI
					JLabel result = new JLabel(stuff);
					view.getContent().add(result);
					view.getScrollPane().setViewportView(view.getContent());
					JOptionPane.showMessageDialog(null, "Extracted data have been stored !", "Extract successful", JOptionPane.PLAIN_MESSAGE); 
					view.getOverallButton().setEnabled(false);
				}else {
					JOptionPane.showMessageDialog(null, "No file choosen, please try again","Wrong operation",JOptionPane.ERROR_MESSAGE);
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource() == view.getBFButton()) {
			try {
				ArrayList<String> lines = ExtractPdf.extractPdf(file);
				String stuff = ExtractPdf.m1_basicInfo(lines);
				//take the file path we want to store the extracted data
				JFileChooser fileChooser = new JFileChooser();
				int res = fileChooser.showSaveDialog(fileChooser);
				File path = fileChooser.getSelectedFile();
				
				
				//if the user do not choose a file, program should handle this.
				if(path!=null) {
					FileTool.writeUpdate(path, stuff);			//write the data into the file
					//update the extracted data in the GUI
					JLabel result = new JLabel(stuff);
					view.getContent().add(result);
					view.getScrollPane().setViewportView(view.getContent());
					JOptionPane.showMessageDialog(null, "Extracted data have been stored !", "Extract successful", JOptionPane.PLAIN_MESSAGE); 
					view.getBFButton().setEnabled(false);
				}else {
					JOptionPane.showMessageDialog(null, "No file choosen, please try again","Wrong operation",JOptionPane.ERROR_MESSAGE);
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource() == view.getDMButton()) {
			try {
				ArrayList<String> lines = ExtractPdf.extractPdf(file);
				String stuff = ExtractPdf.m1_Demographics(lines);
				//take the file path we want to store the extracted data
				JFileChooser fileChooser = new JFileChooser();
				int res = fileChooser.showSaveDialog(fileChooser);
				File path = fileChooser.getSelectedFile();
				
				//if the user do not choose a file, program should handle this.
				if(path!=null) {
					FileTool.writeUpdate(path, stuff);			//write the data into the file
					//update the extracted data in the GUI
					JLabel result = new JLabel(stuff);
					view.getContent().add(result);
					view.getScrollPane().setViewportView(view.getContent());
					JOptionPane.showMessageDialog(null, "Extracted data have been stored !", "Extract successful", JOptionPane.PLAIN_MESSAGE); 
					view.getDMButton().setEnabled(false);
				}else {
					JOptionPane.showMessageDialog(null, "No file choosen, please try again","Wrong operation",JOptionPane.ERROR_MESSAGE);
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource() == view.getCICButton()) {
			try {
				ArrayList<String> lines = ExtractPdf.extractPdf(file);
				String stuff = ExtractPdf.m1_Clinical(lines);
				//take the file path we want to store the extracted data
				JFileChooser fileChooser = new JFileChooser();
				int res = fileChooser.showSaveDialog(fileChooser);
				File path = fileChooser.getSelectedFile();
				
				//if the user do not choose a file, program should handle this.
				if(path!=null) {
					FileTool.writeUpdate(path, stuff);			//write the data into the file
					//update the extracted data in the GUI
					JLabel result = new JLabel(stuff);
					view.getContent().add(result);
					view.getScrollPane().setViewportView(view.getContent());
					JOptionPane.showMessageDialog(null, "Extracted data have been stored !", "Extract successful", JOptionPane.PLAIN_MESSAGE); 
					view.getCICButton().setEnabled(false);
				}else {
					JOptionPane.showMessageDialog(null, "No file choosen, please try again","Wrong operation",JOptionPane.ERROR_MESSAGE);
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource() == view.getDAVSButton()) {
			try {
				ArrayList<String> lines = ExtractPdf.extractPdf(file);
				String stuff = ExtractPdf.m1_Vitalsigns(lines);
				//take the file path we want to store the extracted data
				JFileChooser fileChooser = new JFileChooser();
				int res = fileChooser.showSaveDialog(fileChooser);
				File path = fileChooser.getSelectedFile();
				
				//if the user do not choose a file, program should handle this.
				if(path!=null) {
					FileTool.writeUpdate(path, stuff);			//write the data into the file
					//update the extracted data in the GUI
					JLabel result = new JLabel(stuff);
					view.getContent().add(result);
					view.getScrollPane().setViewportView(view.getContent());
					JOptionPane.showMessageDialog(null, "Extracted data have been stored !", "Extract successful", JOptionPane.PLAIN_MESSAGE); 
					view.getDAVSButton().setEnabled(false);
				}else {
					JOptionPane.showMessageDialog(null, "No file choosen, please try again","Wrong operation",JOptionPane.ERROR_MESSAGE);
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource() == view.getCMButton()) {
			try {
				ArrayList<String> lines = ExtractPdf.extractPdf(file);
				String stuff = ExtractPdf.m1_CoMorbidities(lines);
				//take the file path we want to store the extracted data
				JFileChooser fileChooser = new JFileChooser();
				int res = fileChooser.showSaveDialog(fileChooser);
				File path = fileChooser.getSelectedFile();
				
				//if the user do not choose a file, program should handle this.
				if(path!=null) {
					FileTool.writeUpdate(path, stuff);			//write the data into the file
					//update the extracted data in the GUI
					JLabel result = new JLabel(stuff);
					view.getContent().add(result);
					view.getScrollPane().setViewportView(view.getContent());
					JOptionPane.showMessageDialog(null, "Extracted data have been stored !", "Extract successful", JOptionPane.PLAIN_MESSAGE); 
					view.getCMButton().setEnabled(false);
				}else {
					JOptionPane.showMessageDialog(null, "No file choosen, please try again","Wrong operation",JOptionPane.ERROR_MESSAGE);
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource() == view.getPACMButton()) {
			try {
				ArrayList<String> lines = ExtractPdf.extractPdf(file);
				String stuff = ExtractPdf.m1_ChronicMedication(lines);
				//take the file path we want to store the extracted data
				JFileChooser fileChooser = new JFileChooser();
				int res = fileChooser.showSaveDialog(fileChooser);
				File path = fileChooser.getSelectedFile();
				
				//if the user do not choose a file, program should handle this.
				if(path!=null) {
					FileTool.writeUpdate(path, stuff);			//write the data into the file
					//update the extracted data in the GUI
					JLabel result = new JLabel(stuff);
					view.getContent().add(result);
					view.getScrollPane().setViewportView(view.getContent());
					JOptionPane.showMessageDialog(null, "Extracted data have been stored !", "Extract successful", JOptionPane.PLAIN_MESSAGE); 
					view.getPACMButton().setEnabled(false);
				}else {
					JOptionPane.showMessageDialog(null, "No file choosen, please try again","Wrong operation",JOptionPane.ERROR_MESSAGE);
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource() == view.getSSAButton()) {
			try {
				ArrayList<String> lines = ExtractPdf.extractPdf(file);
				String stuff = ExtractPdf.m1_SymptomsAD(lines);
				//take the file path we want to store the extracted data
				JFileChooser fileChooser = new JFileChooser();
				int res = fileChooser.showSaveDialog(fileChooser);
				File path = fileChooser.getSelectedFile();
				
				//if the user do not choose a file, program should handle this.
				if(path!=null) {
					FileTool.writeUpdate(path, stuff);			//write the data into the file
					//update the extracted data in the GUI
					JLabel result = new JLabel(stuff);
					view.getContent().add(result);
					view.getScrollPane().setViewportView(view.getContent());
					JOptionPane.showMessageDialog(null, "Extracted data have been stored !", "Extract successful", JOptionPane.PLAIN_MESSAGE); 
					view.getSSAButton().setEnabled(false);
				}else {
					JOptionPane.showMessageDialog(null, "No file choosen, please try again","Wrong operation",JOptionPane.ERROR_MESSAGE);
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
	}
	
	
}
