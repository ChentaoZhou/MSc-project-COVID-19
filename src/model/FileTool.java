package model;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileTool {
	/**
	 * This method update the file by adding a line in the next line of its content. 
	 * @param fileName: The String type path of the file.
	 * @param stuff: The String to be add into the file.
	 **/
	public static void writeUpdate(String fileName, String stuff) {
		FileWriter fw = null;
		File file = new File(fileName);
		 try {
			fw = new FileWriter(file,true);
			fw.write("\n"+stuff);
		} catch (IOException e) {
			System.err.println("!!!Unable to update file "+ fileName);
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * This method update the file by adding a line in the next line of its content. 
	 * @param fileName: The File type path of the file.
	 * @param stuff: The String to be add into the file.
	 **/
	public static void writeUpdate(File file, String stuff) {
		FileWriter fw = null;
		 try {
			fw = new FileWriter(file,true);
			fw.write("\n"+stuff);
		} catch (IOException e) {
			System.err.println("!!!Unable to update file "+ file);
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
