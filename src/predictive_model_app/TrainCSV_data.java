package predictive_model_app;

import java.util.*;

public class TrainCSV_data {
	
	//attributes
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
	
	
	
	//constructor
	public TrainCSV_data ()
	{
		lineCount = new HashMap<>();
		yes = 0;
		no = 0;
		percentage = 0;
		result = "";
	}
	
	//getters
	public int getYes()
	{
		return yes;
	}
	public int getNo()
	{
		return no;
	}
	public int getPercentage()
	{
		return percentage;
	}
	public String getResult()
	{
		return result;
	}
	
	
	//method to divide data up to yes and nos 
	public void train(List<String> csvData)
	{
		//clear hashmap incase theres lingering data
		lineCount.clear();
		
		//loop to comb through csv file and count how many times a permutation happens 
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
	
	//method to predict outcome from user input
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
			
			//adds to yes or no count depending on what the label equals
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
		
		
		
		//returning result along with percentage of chance
		return result + " Percentage = " + percentage + "%";
	}
	
	
	
	
	

}
