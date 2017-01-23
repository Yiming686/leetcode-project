package JavaBasics;

import java.io.File;

public class Java_File_Input_Output_Stream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(""+System.getProperty("java.home"));
		System.out.println(""+System.getProperty("java.version"));
		System.out.println(""+System.getProperty("sun.arch.data.model"));

		for(File file : java.io.File.listRoots()){
			System.out.println(""+file.getAbsolutePath());
			System.out.println(""+file.getName());
		}
		
//		new FileSystemResource();
	}

}
