package predictive_model_app;

import java.awt.*;
import javax.swing.*;

public class Level3Gui extends Level2Gui{
	
	//attributes
	private JButton addNewRow;
	private JComboBox<String> isVerified;
	private JLabel isVerifiedLabel;
	private String newAddedData;
	private JPanel buttonsAndResults;
	
	public Level3Gui()
	{
		super();
		setTitle("predictive model app level 3");
		//bigger grid due to more labels and checkboxes
		setSize(600,300);
		setLayout(new BorderLayout(10,10));
		
		//new layout for top panel along with creating a border
		topPanel.setLayout(new GridLayout(5,2));
		topPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		//checkbox options
		String[] options = {"yes","no"};
		
		//adding new combobox and label
		isVerified = new JComboBox<>(options);
		isVerifiedLabel = new JLabel("Is Verified");
		
		//added to panel and editing panel
		topPanel.add(isVerifiedLabel);
		topPanel.add(isVerified);
		
		//adding new add row button and panel
		addNewRow = new JButton("Add new Row and retrain");
		buttonsAndResults = new JPanel(new FlowLayout(FlowLayout.CENTER, 20,10));
		buttonsAndResults.add(predict);
		buttonsAndResults.add(addNewRow);
		buttonsAndResults.add(train);


		//redoing bottom panel to hold all buttons and results
		bottomPanel.removeAll();
		add(bottomPanel, BorderLayout.SOUTH);
		bottomPanel.setLayout(new BorderLayout());
		bottomPanel.add(buttonsAndResults, BorderLayout.NORTH);
		bottomPanel.add(results, BorderLayout.SOUTH);

		
		
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
