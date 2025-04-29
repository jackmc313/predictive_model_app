package predictive_model_app;

import java.util.*;

public class StratifyingData {
	
	private List<String> allOfData;
	private List<String> labelledYes;
	private List<String> labelledNo;
	private int trainingRowsYes;
	private int trainingRowsNo;
	private List<String> trainingData;
	private List<String> testingData;
	private Map<String, List<String>> testAndTrainData;
	
	public Map<String, List<String>> seperateData(List<String> allOfData)
	{
		labelledYes = new ArrayList<>();
		labelledNo = new ArrayList<>();
		
		//seperating to yes and nos 
		for (String line : allOfData)
		{
			if (line.endsWith("no"))
			{
				labelledNo.add(line);
			}
			else if (line.endsWith("yes"))
			{
				labelledYes.add(line);
			}
					
		}
		
		//putting 75 percent of values into training data 
		trainingRowsYes = (int)(labelledYes.size() * 0.75);
		trainingRowsNo = (int)(labelledNo.size() * 0.75);
		
		
		trainingData = new ArrayList<String>();
		testingData = new ArrayList<String>();

		
		//adding to training and testing data to array lists now
		trainingData.addAll(labelledYes.subList(0, trainingRowsYes));
		testingData.addAll(labelledYes.subList(trainingRowsYes, labelledYes.size()));
		
		trainingData.addAll(labelledNo.subList(0, trainingRowsNo));
		testingData.addAll(labelledNo.subList(trainingRowsNo, labelledNo.size()));
		
		//inputting data in hashmap to return
		testAndTrainData = new HashMap<>();
		testAndTrainData.put("training data", trainingData);
		testAndTrainData.put("testing data", testingData);


		//returning hashmap containing the testing and training data 
		return testAndTrainData;


		
	}


}
