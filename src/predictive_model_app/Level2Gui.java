package predictive_model_app;

import java.util.List;

import javax.swing.*;

public class Level2Gui extends Gui {
	
	protected JButton train;
	protected String filename;
	protected TrainCSV_data trainData; //due to being used in level3gui it is set to protected
	protected String enteredValues;
	protected String printedResults;
	protected List<String> trainedData; //same as above
	
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
