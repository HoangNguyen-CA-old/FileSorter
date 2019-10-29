
/*
 * Made by Hoang Nguyen
 * 
 * Sorts files in downloads folder based on file types into 
 * different specified directories.
 * 
 * Run file to sort
 * v1
 */

import java.io.File;

public class Sorter {

	// Downloads file to sort
	// Sorting paths|| MUST MODIFY

	static String downloadpath = "C:/Users/Owner/Downloads";

	static String imagepath = "C:/Users/Owner/Pictures/";
	static String compressedpath = "C:/Users/Owner/Documents/Compressed Files/";
	static String textpath = "C:/Users/Owner/Documents/Text Files/";
	static String audiopath = "C:/Users/Owner/Music/";
	static String executablepath = "C:/Users/Owner/Documents/Exe Files/";
	static String videopath = "C:/Users/Owner/Video/";

	static Boolean found = false;

	public static void main(String[] args) {
		File dir = new File(downloadpath);

		String[] images = { "png", "jpg", "tiff", "tif", "jpeg", "pdf" };
		String[] compressed = { "7z", "arj", "deb", "pkg", "rar", "rpm", "z", "zip" };
		String[] audio = { "mp3", "wav" };
		String[] text = { "txt" };
		String[] executable = { "exe" };
		String[] video = { "mp4", "avi", "mov", "flv", "wmv" };

		File[] files = dir.listFiles();

		for (File file : files) {
			found = false;

			sortFile(file, imagepath, images);
			sortFile(file, compressedpath, compressed);
			sortFile(file, textpath, audio);
			sortFile(file, audiopath, text);
			sortFile(file, executablepath, executable);
			sortFile(file, videopath, video);
		}
	}

	public static String getFileExtension(String fullName) {
		String fileName = new File(fullName).getName();
		int dotIndex = fileName.lastIndexOf('.');
		return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
	}

	public static void sortFile(File file, String path, String[] fileTypes) {
		if (Boolean.TRUE.equals(found)) {
			return;
		}
		String temp = file.getName();
		String type = getFileExtension(temp);
		for (String s : fileTypes) {
			if (type.equals(s)) {
				Boolean success = file.renameTo(new File(path + temp));
				if (Boolean.TRUE.equals(success)) {
					System.out.println("Moved: " + temp + "  -->  " + path);
				} else {
					System.out.println("Failed to move: " + temp);
				}
				found = true;
			}
		}
	}
}
