package predictive_model_app;

import java.util.*;

public class TrainCSV_data {
	
	private Map<String, Integer> lineCount;
	private String lineOfData;
	private boolean equal;
	private String splitUserInput[];
	private String splitCsvData[];
	private String singleData;
	private int yes;
	private int no;
	private String result;
	private int percentage;
	
	
	
	
	public TrainCSV_data ()
	{
		lineCount = new HashMap<>();
		yes =
	}
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
	
	public String forecastResult(String enteredValues)
	{
		yes = 0;
		no = 0;
		splitUserInput = enteredValues.split(",");
		
		//splitting up Csv data
		for (String singleData : lineCount.keySet())
		{
			equal = true;
			splitCsvData = singleData.split(",");
			
			//checking split if split data is equal
			for (int i = 0; i < splitUserInput.length; i++)
			{
				if (!splitCsvData[i].equals(splitUserInput[i]))
				{
					equal = false;
					break;
				}
			}
			
			if (equal) 
			{
				if (splitCsvData[splitCsvData.length - 1].equals("yes"))
				{
					yes += lineCount.get(singleData);
				}
				else if (splitCsvData[splitCsvData.length - 1].equals("no"))
				{
					no += lineCount.get(singleData);
				}
			}
		}
		
		//checking whether user is verified or not
		if (yes > no)
		{
			result = "User is verified";
		}
		else if (no > yes)
		{
			result = "User is not verified";
		}
		else 
		{
			result = "Data shows an equal chance of being verified or not";
		}
		
		//calculating percentage using math.round to round to nearest whole number
		percentage = (int) Math.round(((double) Math.max(yes, no) / (yes + no)) * 100);
		
		
		
		
		
		
		
		return result + " Percentage = " + percentage + "%";
	}
	
	
	
	
	

}
