package Project1;
import java.util.Scanner;

public class quiz {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("\u001B[37m Welcome to the Quiz of Codegnan Destination\u001B[0m");

		System.out.print("\u001B[31mEnter your NAME: \u001B[0m");
		String name = sc.nextLine();

		System.out.print("\u001B[31mEnter ID: \u001B[0m");
		String USN = sc.nextLine();

		System.out.println("\n\u001B[33mRules of the Game:\u001B[0m");
		System.out.println("\u001B[33m1. You will be asked 10 questions.\u001B[0m");
		System.out.println("\u001B[33m2. Each question has four options, only one is correct.\u001B[0m");
		System.out.println("\u001B[33m3. You have two lifelines: 50/50 and Phone of Friend, but each can be used only once.\u001B[0m");
		System.out.println("\u001B[33m4. Answer incorrectly, and the game ends.\u001B[0m");
		System.out.println("\u001B[33m5. Use lifelines wisely!\u001B[0m");
		System.out.println("\n\u001B[37mAre you ready for the quiz? (yes/no)\u001B[0m");

		String ready = sc.nextLine().trim().toLowerCase();
		if (!ready.equals("yes")) {
			System.out.println("\u001B[31mCome back when you're ready!\u001B[0m");
			sc.close();
			return; // returns nothing and exits the program
		}

		System.out.println("\u001B[36mThank you, \u001B[31m" + name + "\u001B[36m. Let's start the quiz!");


		int score = 0;
		boolean PhoneOfFriend = false;
		boolean fiftyFiftyUsed = false;

		for (int i = 1; i <= 10; i++) {
			String question = getQuestion(i);
			String[] options = getOptions(i);
			String correctAnswer = getCorrectAnswer(i);

			System.out.println("\n\u001B[37mQuestion :\u001B[31m" + i+"." + question + " \u001B[0m");
			for (int j = 0; j < options.length; j++) {
				System.out.println("\u001B[37m" + (char) ('A' + j) + ". " + options[j] + "\u001B[0m");
			}

			System.out.print("\u001B[34mEnter your choice (or 'E' for a lifeline) : \u001B[0m");
			String answer = sc.nextLine().trim();

			if (answer.equalsIgnoreCase("E")) {
				System.out.println("\u001B[33mYou selected a lifeline! Choose from:\u001B[0m");
				if (!PhoneOfFriend) System.out.println("\u001B[33m1. Phone of Friend\u001B[0m");
				if (!fiftyFiftyUsed) System.out.println("\u001B[33m2. Fifty Fifty\u001B[0m");

				System.out.print("\u001B[37mChoose one from Above : \u001B[0m");
				String lifeline = sc.nextLine().trim();
				if (lifeline.equals("1") && !PhoneOfFriend) {
					PhoneOfFriend = true;
					System.out.println("\u001B[31m Calling Bheemesh Raghupathy..Sir...📞📞📞📞📞.......");
					System.out.println("\u001B[34mCall received......");
					System.out.println("📞...\u001B[0mSir!, Please give me answer in beautiful manner ....😆😆😆");
					System.out.println("\u001B[31mBheemesh Raghupathy:\u001B[33mThe most likely correct option is: ");
					System.out.println("Option: \u001B[32m" + correctAnswer + "\u001B[0m");

				} else if (lifeline.equals("2") && !fiftyFiftyUsed) {
					fiftyFiftyUsed = true;
					System.out.println("\u001B[33mFifty Fifty: Remaining options are:\u001B[0m");
					System.out.println("\u001B[33mOption 1: " + correctAnswer + "\u001B[0m");
					System.out.println("\u001B[33mOption 2: D\u001B[0m");
				} else {
					System.out.println("\u001B[31mlifeline already used........\u001B[0m");
				}

				System.out.print("\u001B[36mEnter your final choice: \u001B[0m");
				answer = sc.nextLine().trim();
			}

			if (answer.equalsIgnoreCase(correctAnswer)) {
				score++;
				System.out.println("\u001B[32mCorrect!\u001B[0m");
			} else {
				System.out.println("\u001B[31mWrong! The correct answer is " + correctAnswer + ".\u001B[0m");
				System.out.println("\u001B[31mExiting the quiz. Better luck next time!\u001B[0m");
				break; // Exit the loop on a wrong answer
			}
		}

		score = 100 * score;
		System.out.println("\n\u001B[35mQuiz Over! Your final score is: \u001B[0m" + score + "/1000");
		System.out.println("\u001B[35mYou earned " + score + ".\u001B[0m");
		sc.close();
	}

	private static String getQuestion(int questionNumber) {
		String[] questions = {
				"What is the default value of a boolean variable in Java?",
				"Which keyword is used to define a constant in Java?",
				"What does the 'public' keyword signify in Java?",
				"Which method is used to find the length of an array in Java?",
				"What does the 'static' keyword mean in Java?",
				"Which of the following is a primitive data type in Java?",
				"What does 'java.lang' package contain?",
				"Which of these is a valid loop in Java?",
				"Which of the following is used to handle exceptions in Java?",
				"What does JVM stand for in Java?"

		};
		return questions[questionNumber - 1];
	}

	private static String[] getOptions(int questionNumber) {
		String[][] options = {
				{"true", "false", "0", "undefined", "\u001B[32mUse Lifeline"},
				{"const", "final", "static", "constant", "\u001B[32mUse Lifeline"},
				{"It defines a method", "It defines a class", "It allows access to methods and variables", "It defines a constructor", "\u001B[32mUse Lifeline"},
				{"length()", "size()", "length", "getSize()", "\u001B[32mUse Lifeline"},
				{"It defines an instance variable", "It defines a method", "It defines a class", "It makes variables and methods class-level", "\u001B[32mUse Lifeline"},
				{"int", "Integer", "String", "Object", "\u001B[32mUse Lifeline"},
				{"String handling functions", "Math functions", "Core Java classes", "Swing classes for UI", "\u001B[32mUse Lifeline"},
				{"for", "while", "do-while", "all of the above", "\u001B[32mUse Lifeline"},
				{"try-catch", "if-else", "switch-case", "for-each", "\u001B[32mUse Lifeline"},
				{"Java Virtual Machine", "Java Variable Memory", "Java Variable Model", "Java Virtual Method", "\u001B[32mUse Lifeline"}
		};
		return options[questionNumber - 1];
	}

	private static String getCorrectAnswer(int questionNumber) {
		String[] correctAnswers = {"B", "B", "C", "C", "D", "A", "C", "D", "A", "A"};
		return correctAnswers[questionNumber - 1];
	}
}