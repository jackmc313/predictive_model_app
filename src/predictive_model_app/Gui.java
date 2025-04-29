package predictive_model_app;

import java.awt.*;
import javax.swing.*;

public abstract class Gui extends JFrame {
	
	//attributes
	protected JButton predict;
	protected JComboBox<String> hasProfilePic;
	protected JComboBox<String> hasEmail;
	protected JComboBox<String> isActive;
	protected JComboBox<String> over100Followers;
	protected JLabel results;
	protected JLabel hasProfilePicLabel;
	protected JLabel hasEmailLabel;
	protected JLabel isActiveLabel;
	protected JLabel over100FollowersLabel;
	protected JPanel topPanel;
	protected JPanel bottomPanel;
	
	public Gui(String title)
	{	
		//setting up Gui
		super(title);
		setSize(800,500);
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
	}

}
