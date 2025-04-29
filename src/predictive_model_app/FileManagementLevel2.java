package predictive_model_app;

import java.io.*;
import java.util.*;

public class FileManagementLevel2 {
	
	private static List<String> fileData;
	private static Scanner myScanner;
	private static File fileName;
	private static String cutUpData;
	
	
	//method to take in file
	public static List<String> takeInData(String filePath)
	{
		fileData = new ArrayList<>();
		
		try {
			//linking scanner to file
			fileName = new File(filePath);
			myScanner = new Scanner(fileName);
			
			while (myScanner.hasNextLine())
			{
				//cutting up and adding line by line
				cutUpData = myScanner.nextLine();
				fileData.add(cutUpData);
				
			}
			
		} catch(FileNotFoundException e)
		{
			System.out.println("Error, file not found");
		}
		
		
		
		return fileData;
	}
	
}
