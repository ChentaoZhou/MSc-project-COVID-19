package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import view.AnalysisPage;
import view.ExtractPage;
import view.GeneratPage;
import view.HomePage;

public class HomeController implements ActionListener{
	private HomePage view;

	public HomeController(HomePage view) {
		this.view = view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == view.getExtractButton()) {
			
			JFileChooser fileChooser = new JFileChooser();
			int res = fileChooser.showSaveDialog(fileChooser);
			File file = fileChooser.getSelectedFile();
			//if user do not choose a file, the program need to handle this.
			if(file!=null) {
				view.getFrame().dispose();
				ExtractPage ep = new ExtractPage(file);
				ep.getFrame().setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null, "No file choosen, you need to choose a file","Wrong operation",JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getSource() == view.getAnalyseButton()) {
			view.getFrame().dispose();
			AnalysisPage ap = new AnalysisPage();
			ap.getFrame().setVisible(true);	
		}

		if(e.getSource() == view.getCreateButton()) {
			view.getFrame().dispose();
			GeneratPage gc = new GeneratPage();
			gc.getFrmDataGenerator().setVisible(true);
		}
		
		//exit the program
		if(e.getSource() == view.getExit()) {
			view.getFrame().dispose();
		}
		
	}
}
