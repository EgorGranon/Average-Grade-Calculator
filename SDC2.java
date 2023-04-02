package SDC;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SDC2 {
	
	public static void main(String args[]) {
		// Calling method to print specifications for the project
		projectSpecifications();
		// Initialising scanner
		Scanner scan = new Scanner(System.in);
		// Initialising variable which will track amount of grades user has inputed
		int count = 0;
		// Declaring List which will hold users inputs
		List<Double> scoreList = new ArrayList<Double>();
		// Printing space for better readability
		System.out.println();
		// Printing instructions for user to follow
		System.out.println("Please enter students quiz grades one by one ranging from 0-100. Enter 999 to quit : ");
        // while loop which will stay active until count reaches 10 or user inputs 999
		while (count != 10) {
			        // user input stored in variable
					double quizScore = scan.nextDouble();
					// if statements determining action to take based on user input
					if (quizScore == 999) {
						System.out.println("You have entered " + count + " out of 10 possible grades");
						break;
					}
					else if (quizScore < 0) {
						System.out.println("Please provide value within range 0 - 100");
					}
					else if (quizScore > 100) {
						System.out.println("Please provide value within range 0 - 100");
					}
					else {
						// increment number of grades inputed
						count++;
						// store inputed grades in a list
						scoreList.add(quizScore);
					}
				}
		// close scanner
		scan.close();
		System.out.println("List of all scores : ");
		// Iterate and display all grades in the list
		for (double score : scoreList) {
			System.out.print(score + ", ");
		}
		// calculating the average grade by calling calculateAverageGrade method and then dividing the result by 10
		// we store the double value in an integer variable as value after decimal is negligible because for example "A" grade corresponds to all values from 9.0 to 10.0
		int averageGrade = calculateAverageGrade(scoreList, count) / 10;
		
		System.out.println();
		// Use switch statement to print out users grade
		switch (averageGrade) {
		case 10: // A = 90 - 100
			System.out.println("You scored a perfect A !!!");
			break;
		
		case 9: // A = 90 - 100 
			System.out.println("You scored an A!");
			break;
			
		case 8: // B = 80 - 89
			System.out.println("You scored a B!");
			break;
			
		case 7: // C = 70 - 79
			System.out.println("You scored a C!");
			break;
			
		case 6: // D = 60 - 69
			System.out.println("You scored a D!");
			break;
			
		default: // F = 0 - 59
			System.out.println("You scored an F");
		}
		
	}

	private static int calculateAverageGrade(List<Double> scoreList, int count) {
		int totalScoreCount = 0;
		// Iterate through list and add all scores together
		for(double score : scoreList) {
			totalScoreCount += score;
		}
		// Cannot divide by 0
		if (count != 0) {
			return totalScoreCount / count;
		}
		return 0;
		
	}

	private static void projectSpecifications() {
		// Printing each step describing the programming specifications for the project
		System.out.println("Step 1: Print the programming specifications for the project. ");
		System.out.println("Step 2: Use loop to allow user to enter test quiz scores or until they don't enter 999 to quit");
		System.out.println("Step 3: Populate array of student quiz grades, track total running count, track total number of grades entered without exceeding 10");
		System.out.println("Step 4: Print all grades in array");
		System.out.println("Step 5: Compute average quiz grade");
		System.out.println("Step 6: Find out the letter grade of the average based on given grading scale and print to the console");
	}

}
