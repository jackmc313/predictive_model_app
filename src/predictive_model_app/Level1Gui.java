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

public class Level1Gui extends Gui
{
	
	public Level1Gui ()
	{
		super("Predictive model app level 1");
		
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
