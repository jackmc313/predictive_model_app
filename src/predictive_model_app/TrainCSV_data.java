package predictive_model_app;

import java.util.*;

public class TrainCSV_data {
	
	private Map<String, Integer> lineCount = new HashMap<>();
	private String lineOfData;
	
	
	//method to divide data up to yes and nos 
	public void train(List<String> csvData)
	{
		
		lineCount.clear();
		
		for(String lineOfData : csvData)
		{
			if (lineCount.containsKey(lineOfData))
			{
				lineCount.put(lineOfData, lineCount.get(lineOfData) + 1);
			}
			else 
			{
				lineCount.put(lineOfData, 1);
			}
		}
	}
	
	
	
	
	

}
