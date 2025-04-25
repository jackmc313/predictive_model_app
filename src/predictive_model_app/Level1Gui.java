/**********************************
 * Author: Jack McCarthy
 * 
 * Description: This first level of my predictive model app takes in hard coded values using a frequency table 
 * and predicts whether a user is verified using the headings of has profile picture, has email, is active and over 100 followers.
 * It uses a gui to take in user input.
 * 
 **********************************/



package predictive_model_app;

import java.awt.*;
import javax.swing.*;

public class Level1Gui extends JFrame 
{
	//attributes
	private JButton predict;
	private JComboBox<String> hasProfilePic;
	private JComboBox<String> hasEmail;
	private JComboBox<String> isActive;
	private JComboBox<String> over100Followers;
	private JLabel results;
	private JLabel hasProfilePicLabel;
	private JLabel hasEmailLabel;
	private JLabel isActiveLabel;
	private JLabel over100FollowersLabel;
	private JPanel topPanel;
	private JPanel bottomPanel;
	
	public Level1Gui ()
	{
		//setting up Gui
		setTitle("Level 1 Predictive model app");
		setSize(600,300);
		setLayout(new FlowLayout());
		
		//top panel created for the user input
		topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(4,2));
		add(topPanel, BorderLayout.CENTER);
		
		//creating checkboxes, labels and buttons
		String[] options = {"yes", "no"};
		hasProfilePic = new JComboBox<>(options);
		hasEmail = new JComboBox<>(options);
		isActive = new JComboBox<>(options);
		over100Followers = new JComboBox<>(options);
		
		results = new JLabel();
		predict = new JButton("Predict");
		
		hasProfilePicLabel = new JLabel("Has Profile Pic");
		hasEmailLabel = new JLabel("Has email");
		isActiveLabel = new JLabel("Is active");
		over100FollowersLabel = new JLabel("Over 100 followers");
		
		//adding to top panel
		topPanel.add(hasProfilePicLabel);
		topPanel.add(hasProfilePic);
		
		topPanel.add(hasEmailLabel);
		topPanel.add(hasEmail);
		
		topPanel.add(isActiveLabel);
		topPanel.add(isActive);
		
		topPanel.add(over100FollowersLabel);
		topPanel.add(over100Followers);
		
		//creating and adding to the bottom panel
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout());
		add(bottomPanel, BorderLayout.SOUTH);
		
		bottomPanel.add(predict);
		bottomPanel.add(results);
		
		
		//for when the predict button is pressed 	
		predict.addActionListener(e -> {
			
			//values are put together
			String enteredValues = hasProfilePic.getSelectedItem() + "," + hasEmail.getSelectedItem() + "," + isActive.getSelectedItem() + "," + over100Followers.getSelectedItem();
			
			//calling the hard coded data 
			String calculate = FrequencyTable.outcome(enteredValues);
			
			//printing out the text
			results.setText(calculate);
		});
		
		setVisible(true);
				
		
		
		
		
		
	}
}
