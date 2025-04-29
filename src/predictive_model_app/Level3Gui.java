package predictive_model_app;

import java.awt.*;
import javax.swing.*;

public class Level3Gui extends Level2Gui{
	
	//attributes
	private JButton addNewRow;
	private JComboBox<String> isVerified;
	private JLabel isVerifiedLabel;
	private String newAddedData;
	
	public Level3Gui()
	{
		super();
		setTitle("predictive model app level 3");
		//bigger grid due to more labels and checkboxes
		setLayout(new GridLayout(5,2));
		setSize(800,500);
		
		//checkbox options
		String[] options = {"yes","no"};
		
		//adding new add row button
		addNewRow = new JButton("Add new Row and retrain");
		bottomPanel.add(addNewRow);
		
		//adding new combobox and label
		isVerified = new JComboBox<>(options);
		isVerifiedLabel = new JLabel("Is Verified");
		
		//added to panel
		topPanel.add(isVerifiedLabel);
		topPanel.add(isVerified);
		
		
		//same as from level 2 gui except added label for isverifed 
		addNewRow.addActionListener(e -> {
			//if addrow is clicked before train display error 
			if (trainedData == null)
			{
				JOptionPane.showMessageDialog(this, "Please click train first");
				return;
			}
			
			//take in new data from userinput
			newAddedData = hasProfilePic.getSelectedItem() + "," + hasEmail.getSelectedItem() + "," + isActive.getSelectedItem() + "," + over100Followers.getSelectedItem() + "," + isVerified.getSelectedItem();
			
			//retrain data based on new data
			trainedData.add(newAddedData);
			trainData.train(trainedData);
			
			
		});
		
		
	}

}
