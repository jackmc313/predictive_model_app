package predictive_model_app;

import java.util.Scanner;

public class Control {

	public static void main(String[] args) 
	{
		
		Scanner myScanner = new Scanner(System.in);
		
		
		while (true)
		{
			System.out.println("Welcome to my [predictive model app");
			System.out.println("Choose what level you want to start 1, 2, 3 or 4");
			int result = myScanner.nextInt();
			
			switch (result)
			{
			case 1: 
				new Level1Gui();
				break;
			case 2: 
				new Level2Gui();
				break;
			case 3: 
				new Level3Gui();
				break;
			case 4: 
				new Level4Gui();
				break;
			default: 
				System.out.println("Number out of range try again");
				break;
			}
			
		}
		
	}

}
