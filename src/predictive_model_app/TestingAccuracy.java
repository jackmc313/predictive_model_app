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
	
	
	public double getAccuracy(Map<String, List<String>> testAndTrainData)
	{
		trainingData = testAndTrainData.get("training data");
		testingData = testAndTrainData.get("testing data");
		
		trainData.train(trainingData);

		for (String line : testingData)
		{
			cutUpData = line.split(",");
			endData = cutUpData[cutUpData.length - 1];
			
			stringBuilder = new StringBuilder();
			for (int i = 0; i < cutUpData.length - 1; i++)
			{
				stringBuilder.append(cutUpData[i].trim());
				if (i < cutUpData.length - 2)
				{
					stringBuilder.append(",");
				}
			}
			fullData = stringBuilder.toString();
			forecastingData = trainData.forecastResult(fullData).trim();
			
			
			if (forecastingData.equals(endData))
			{
				score++;
			}
		}
		
		
		
		
		return (double) score / testingData.size();
	}

}
