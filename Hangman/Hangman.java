package hangman;

import java.util.Scanner;

public class Hangman {
	private boolean running = true;
	private RandomWord word = new RandomWord();
	private Scanner scanner = new Scanner(System.in);
	private int triesRemaining = 5;
	private char lastGuess;
	
	public void run() {
		do {
			displayWord();
			getUserInput();
			checkUserInput();
		} while(running);
	}
	
	private void displayWord() {
		System.out.println("\nTries remaining " + triesRemaining);
		System.out.println(word);
	}
	
	private void getUserInput() {
		
		System.out.print("Enter your guess: ");
		String guess = scanner.nextLine();
		lastGuess = guess.charAt(0);
	}
	
	private void checkUserInput() {
		boolean isCorrect = word.addGuess(lastGuess);
		
		if(isCorrect) {
			if(word.isComplete()) {
				System.out.println("You have won!");
				System.out.println("The word is " + word);
				running = false;
			}
		}
		else {
			triesRemaining--;
			
			if(triesRemaining == 0) {
				System.out.println("You have lost!");
				running = false;
			}
		}
		
	}

	public void close() {
		scanner.close();
	}
}
