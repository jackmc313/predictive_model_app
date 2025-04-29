Video demo link: https://www.youtube.com/watch?v=TDvmYSecTWA

My name is jack McCarthy student number C23323661 and this is my predictive model app.

Class Design 
Level 1:
Gui - basic Gui class sets up the rest of the gui classes with layouts, sizes, labels, combo boxes and so on
Level1Gui - extends Gui, has predict button functionality
FrequencyTable - hard coded values for each permutation from my dataset

Level2:
Level2Gui - extends gui, has thetrain button functionality 

filemanagement - takes in a csv file and cuts it up into an array list to be sent away as an array list and used in the trainCSv_data class

trainCSV_data - 2 methods in this class one called train and one called forecast result. The first method train loops through the arraylist and takes down whenever a permutation happens if its already happens it adds 1 to its value and keeps going through.

The forecast result method is a bit bigger and what this does is it checks the end value or label for if its a yes or a no and whatever it is it adds it to its respective count. This is used to predict whether the user is verified or not and then calculate the probability of it for example if a certain permutation has 5 yes's and 0 no's the probability is going to be 100% yes.

Level3:
Level3Gui - extends Level2gui, edits layout due to being an extra column, adds panels and an add new row and retrain button - this button adds a new row to the data and retrains it allowing you to update the data and still use it.
--uses TrainCSV_data aswell

Level4:
Level4Gui - This class adds a test accuracy button and instatiates the two classes that im going to talk about below.
StratifyingData - This class breaks up the data into 75% training and 25% testing while making sure one side is not overloaded with yes's or no's. it returns a hashmap with the training data and testing data.

testingAccuracy - This class takes in that hashmap from above predicts the accuracy of this model, it trains the training data by calling the instantiated trainCSV_data class and then it removes the label part from the testing data and stores it, it then rebuilds the features into a string and calls the forecast result method from trainCSV_data. It then compares the label data to the result from that method and adds a plus one if they are the same. it gets this score at the end and divides it by the size of the testing data and multiplies that by 100 to get an accuracy percentage.

Other classes:
Control class so users can pick what level they want to run.


if i had more time i would try to increase my accuracy score higher as its at the mid 60s at the moment and ive just ran out of time to try and figure out how to increase it. I would also maybe make the guis look better as they can be confusing sometimes.

