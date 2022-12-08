
// Import all packages inside java.util and java.lang
import java.util.*;
import java.lang.*;

public class Hangman {
	// Main
	// Setup private Array List PHRASE_LIST
	private static String[] PHRASE_LIST = new String[] { "Beating a Dead Horse", "Roll With the Punches", "Down And Out",
			"Dont Mine at Night", "No Ifs Ands or Buts", "Raining Cats and Dogs", "Keep On Truckin", "Short End of the Stick",
			"Like Father Like Son", "Elvis Has Left The Building" };

	// Create Variables for Game
	private String currentPhraseStr;
	private ArrayList<Character> guessedLetters;
	public ArrayList<Character> guessedPhrase;
	public ArrayList<Character> currentPhrase;

	public Hangman() {
		System.out.println("Hello!");
		currentPhraseStr = selectPhrase();
		currentPhrase = new ArrayList<Character>();
		guessedLetters = new ArrayList<Character>();
		guessedPhrase = new ArrayList<Character>();
		setupWord(currentPhraseStr);
		playGame();
	}

	private String selectPhrase() {
		return (PHRASE_LIST[(int) (Math.random() * PHRASE_LIST.length)]);
	}

	private void setupWord(String phrase) {
		// Loops through the phrase and fills it in with underscores (_) and sets up the
		// guessed and current phrase
		for (int i = 0; i < phrase.length(); i++) {
			System.out.println(phrase.charAt(i));
			currentPhrase.add(phrase.charAt(i).toUpperCase());
			if (phrase.charAt(i) == ' ') {
				guessedPhrase.add(' ');
			} else {
				guessedPhrase.add('_');
			}

		}

		System.out.println("Guessed Phrase:" + guessedPhrase.get(1));
		System.out.println(currentPhrase.get(1));
		return;
	}

	private char getLetter() {
		int guessesRemaing = 0;
		Scanner input = new Scanner(System.in);
		Character guess = ' ';
		System.out.println("Please Enter a Letter that you wish to Guess");
		guess = input.next().charAt(0);
		guess = Character.toUpperCase(guess);
		
		

		// Get the guessed letter DONE
		// Check to make sure that it already has not been guessed LATER
		// Check to make sure that it is a letter -> No spaces, or special characters or
		// numbers LATER? - Does java do this w/ out of bounds errors?
		// To Do:
		// Do loop with input until you get a valid guess
		return guess;
	}

	private boolean findLetter(char letter) {
		// Increment throught the array list, checking at each index if the letter guessed by the user matches
		boolean found = false;
		for (int i = 0; i <= currentPhrase.size()-1; i++) {
			if (letter == currentPhrase.get(i)) {
				// This is a letter in the phrase
				guessedPhrase.set(i, letter);
				found = true;
			} 
		}
		return found;
	}

	// To Do:
	// How to draw the Hangman?
	// Make sure that letters are compared that are of same case -> When input
	// taken, convert all to Upppercase

	public void playGame() {
		// System.out.println("Please enter a letter that you would like to find in the
		// phrase.");
			// If guessed Letter is equal to guessedLetters list (list of all the letters that the user has inputted) at the index of the current guess 
			// Search for letter in the PHRASE_LIST
			
		int guessesRemaining = 6;
		char guess;
		boolean foundLetter;
		
		while(guessesRemaining > 0){
			guess = getLetter();
			foundLetter = findLetter(guess);
			if(foundLetter){
				System.out.println("You found the Letter: " + guess);
			}
			else{
				System.out.println("You did not find the Letter: " + guess);
			}
			
	}

}
}