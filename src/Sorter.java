/*
 * Made by Hoang Nguyen
 * 
 * Sorts files in downloads folder based on file types into 
 * different specified directories.
 * 
 * Run file to sort
 * 
 */

import java.io.File;

public class Sorter {
	//Downloads file to sort
	static String downloadpath = "C:/Users/mineh/Downloads/";
	//Sorting paths|| MUST MODIFY
	
	static String imagepath = "C:/Users/mineh/Pictures/";
	static String compressedpath = "C:/Users/USERHERE/Documents/";
	static String textpath = "C:/Users/USERHERE/Documents/";
	static String audiopath = "C:/Users//mineh/Video/";
	static String executablepath = "C:/Users//mineh/Documents/";
	
	
	static Boolean found = false;
	public static void main(String[] args) {
		 File dir = new File(downloadpath);
		 
		 String[] images = {"png", "jpg", "tiff", "tif", "jpeg", "pdf"};
		 String[] compressed = {"7z", "arj", "deb", "pkg", "rar", "rpm", "z", "zip"};
		 String[] audio = {"mp3", "wav"};
		 String[] text = {"txt"};
		 String[] executable = {"exe"};

	      File[] files = dir.listFiles();
	     
	      for (File file: files) {
	    	 found = false;
	 
	    	 sortFile(file, imagepath, images);
	    	 sortFile(file, compressedpath, compressed);
	    	 sortFile(file, textpath, audio);
	    	 sortFile(file, audiopath, text);
	    	 sortFile(file, executablepath, executable);
	      }
	}
	
	public static String getFileExtension(String fullName) {
	    String fileName = new File(fullName).getName();
	    int dotIndex = fileName.lastIndexOf('.');
	    return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
	}
	
	public static void sortFile(File file,String path, String[] fileTypes) {
		if (found) {
			return;
		}
		String temp = file.getName();
   	  	String type = getFileExtension(temp);
   	  	for (String s: fileTypes) {
		  if (type.equals(s)) {
			  file.renameTo(new File(imagepath+temp));
			  System.out.println("Moved: "+temp + "  -->  " +imagepath);
			  found = true;
		  }
	  }
	}
}
