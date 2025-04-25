package predictive_model_app;

import java.awt.*;
import javax.swing.*;

public class Level1Gui extends JFrame 
{
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
	
	public Level1Gui ()
	{
		//setting up Gui
		setTitle("Level 1 Predictive model app");
		setSize(600,300);
		setLayout(new FlowLayout());
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5, 2));
		add(panel);
		
		String[] options = {"yes", "no"};
		hasProfilePic = new JComboBox<>(options);
		hasEmail = new JComboBox<>(options);
		isActive = new JComboBox<>(options);
		over100Followers = new JComboBox<>(options);
		
		results = new JLabel("Prediction below");
		predict = new JButton("Predict");
		
		hasProfilePicLabel = new JLabel("Has Profile Pic");
		hasEmailLabel = new JLabel("Has email");
		isActiveLabel = new JLabel("Is active");
		over100FollowersLabel = new JLabel("Over 100 followers");
		
		
		
		
		panel.add(hasProfilePicLabel);
		panel.add(hasProfilePic);
		
		panel.add(hasEmailLabel);
		panel.add(hasEmail);
		
		panel.add(isActiveLabel);
		panel.add(isActive);
		
		panel.add(over100FollowersLabel);
		panel.add(over100Followers);
		
		panel.add(results);
		panel.add(predict);
		
		
		
		
		predict.addActionListener(e -> {
			
			String enteredValues = hasProfilePic.getSelectedItem() + "," + hasEmail.getSelectedItem() + "," + isActive.getSelectedItem() + "," + over100Followers.getSelectedItem();
			
			String calculate = FrequencyTable.outcome(enteredValues);
			
			results.setText(calculate);
		});
		
		setVisible(true);
				
		
		
		
		
		
	}
}
