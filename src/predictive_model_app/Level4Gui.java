package predictive_model_app;

import java.awt.BorderLayout;
import java.util.*;

import javax.swing.*;

public class Level4Gui extends Level3Gui{
	
	private JButton testAccuracy;
	private JLabel testAccuracyLabel;
	private StratifyingData seperateData;
	private TestingAccuracy testing;
	private Map<String, List<String>> dataStratified;
	private double accuracy;
	
	public Level4Gui()
	{
		super();
		setTitle("predictive model app level 4");
		
		testAccuracy = new JButton("Test Accuracy");
		testAccuracyLabel = new JLabel("No accuracy calculated yet, click Test accuracy");
		
		buttonsAndResults.add(testAccuracy);
		bottomPanel.add(testAccuracyLabel, BorderLayout.CENTER);

		//instantiate objects 
		seperateData = new StratifyingData();
		testing = new TestingAccuracy();
		
		testAccuracy.addActionListener(e -> {
			
			if (trainedData == null)
			{
				JOptionPane.showMessageDialog(this, "Please click train first");
				return;
			}
			
			//calling Stratifying data to seperate testing and training data
			dataStratified = seperateData.seperateData(trainedData);
			
			accuracy = testing.getAccuracy(dataStratified);
			
			testAccuracyLabel.setText(String.format("The accuracy of this model is %.2f%%", accuracy * 100));
			
			
		});
	}

}
