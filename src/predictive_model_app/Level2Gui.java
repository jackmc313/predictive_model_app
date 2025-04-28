package predictive_model_app;

import java.util.List;

import javax.swing.*;

public class Level2Gui extends Gui {
	
	private JButton train;
	private String filename;
	private TrainCSV_data trainData;
	private String enteredValues;
	private String printedResults;
	private List<String> trainedData;
	
	public Level2Gui()
	{
		super("predictive model app Level 2");
		
		
		train = new JButton("Train");
		bottomPanel.add(train);
		
		//instantiating TrainCSV_data 
		trainData = new TrainCSV_data();
		
		//cannot click predict button until train button is clicked 
		predict.setEnabled(false);
		
		setVisible(true);
		
		//taking in file and training data
		train.addActionListener(e -> {
			
			filename = "is_verified_dataset copy.csv";
			trainedData = FileManagementLevel2.takeInData(filename);
			
			trainData.train(trainedData);
			predict.setEnabled(true); 
			
		});
		
		
		//predict button taking in user input and calling forecast result method from TrainCSV_data
		predict.addActionListener(e -> {
			
			enteredValues = hasProfilePic.getSelectedItem() + "," + hasEmail.getSelectedItem() + "," + isActive.getSelectedItem() + "," + over100Followers.getSelectedItem();
			
			printedResults = trainData.forecastResult(enteredValues);
			results.setText(printedResults);
			
		});
	}
	
	

}
