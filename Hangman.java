
// Import all packages inside java.util and java.lang
import java.util.*;
import java.lang.*;

public class Hangman {
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

		currentPhraseStr = selectPhrase();
		currentPhrase = new ArrayList<Character>();
		guessedLetters = new ArrayList<Character>();
		guessedPhrase = new ArrayList<Character>();
		setupWord(currentPhraseStr);
		getLetter();
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
			currentPhrase.set(i, phrase.charAt(i));
			if (phrase.charAt(i) == ' ') {
				guessedPhrase.set(i, ' ');
			} else {
				guessedPhrase.set(i, '_');
			}

		}
		System.out.println(guessedPhrase.get(1));
		System.out.println(currentPhrase.get(1));
		return;
	}

	private void getLetter() {
		int guessesRemaing = 0;
		Scanner input = new Scanner(System.in);
		Character guess = ' ';
		for (int guessesRemaining = 0; guessesRemaining < 6; guessesRemaining++) {
			System.out.println("Please Enter a Letter that you wish to Guess");
			guess = input.next().charAt(0);
			guess = Character.toLowerCase(guess);
			// If guessed Letter is equal to guessedLetters list (list of all the letters that the user has inputted) at the index of the current guess 
			// Search for letter in the PHRASE_LIST
			boolean foundLetter = findLetter(guess);
			
			if (foundLetter) {
				System.out.println("You found a new letter!" + guess);
			} 
			else {
				System.out.println("You do not find a letter that matches.");
			}
		}

		// Get the guessed letter DONE
		// Check to make sure that it already has not been guessed LATER
		// Check to make sure that it is a letter -> No spaces, or special characters or
		// numbers LATER? - Does java do this w/ out of bounds errors?
		// To Do:
		// Do loop with input until you get a valid guess
		return;
	}

	private boolean findLetter(char letter) {
		// Increment throught the array list, checking at each index if the letter guessed by the user matches
		boolean found = false;
		for (int i = 0; i <= currentPhrase.size(); i++) {
			if (letter == currentPhrase.get(i)) {
				System.out.println("This is a letter in the phrase.");
				found = true;
			} 
			else {
				System.out.println("This is not a letter in the phrase.");
			}

		}
		return found;
	}

	// To Do:
	// How to draw the Hangman?
	// Make sure that letters are compared that are of same case -> When input
	// taken, convert all to Upppercase

	public void playGame() {
		// int guessesRemaining = 0;
		// while(guessesRemaining < 6){
		// System.out.println("Please enter a letter that you would like to find in the
		// phrase.");
		
	}

}