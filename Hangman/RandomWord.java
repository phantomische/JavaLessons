package hangman;

import java.util.Random;

public class RandomWord {
	private String[] words = { "excitement", "memorandum", "message", "cutting", "tank", "threshold", "genuine",
			"manufacturer", "decoration", "fountain", "bank", "absence", "ceremony", "sympathetic", "atmosphere",
			"recognize", "sacrifice" };
	
	private String chosenWord;
	private Random random = new Random();
	private char[] characters;
	
	public RandomWord() {
		chosenWord = words[random.nextInt(words.length)];
		characters = new char[chosenWord.length()];
	}
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
			
		for(char c: characters) {
			sb.append(c == '\u0000' ? '_' : c);
			sb.append(' ');
		}
		return sb.toString();
	}
	
	public boolean isComplete() {
		
		for(char c: characters) {
			if(c == '\u0000') {
				return false;
			}
		}
		return true;
	}

	public boolean addGuess(char c) {
		boolean correct = false;
		
		for(int i = 0; i < chosenWord.length(); i++) {
			if(c == chosenWord.charAt(i)) {
				characters[i] = c;
				correct = true;
			}
		}
		
		return correct;
	}
}
