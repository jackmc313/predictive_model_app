package predictive_model_app;

import java.util.*;

public class TestingAccuracy {

	private TrainCSV_data trainData;
	private List<String> trainingData;
	private List<String> testingData;
	private int score;
	private String[] cutUpData;
	private String endData;
	private StringBuilder stringBuilder;
	private String fullData;
	private String forecastingData;

	
	
	
	public TestingAccuracy()
	{
		trainData = new TrainCSV_data();
		score = 0;
	}
	
	//method to getaccuracy of model
	public double getAccuracy(Map<String, List<String>> testAndTrainData)
	{
		trainingData = testAndTrainData.get("training data");
		testingData = testAndTrainData.get("testing data");
		
		//calling traincsv
		trainData.train(trainingData);
		score = 0;

		//going through the features and labels of testing data
		for (String line : testingData)
		{
			cutUpData = line.split(",");
			endData = cutUpData[cutUpData.length - 1];
			
			//rebuilding string without label
			stringBuilder = new StringBuilder();
			for (int i = 0; i < cutUpData.length - 1; i++)
			{
				stringBuilder.append(cutUpData[i].trim());
				if (i < cutUpData.length - 2)
				{
					stringBuilder.append(",");
				}
			}
			//making predictions here through the traincsv class
			fullData = stringBuilder.toString();
			forecastingData = trainData.forecastResult(fullData).trim();
						
			//reformatting the answers here as in train data the outcome is a whole sentence
			if (forecastingData.contains("User is verified"))
			{
				forecastingData = "yes";
			}
			else if (forecastingData.contains("User is not verified"))
			{
				forecastingData = "no";

			}
			else if (forecastingData.contains("Data shows an equal chance"))
			{
				forecastingData = "no";
			}
			
			//if they are the same add to score 
			if (forecastingData.trim().equals(endData.trim()))
			{
				score++;
			}
		}
		
	    
		
		return (double) score / testingData.size();
	}

}
