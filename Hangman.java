
// Import all packages inside java.util and java.lang
import java.util.*;
import java.lang.*;

public class Hangman {
	// Main
	// Setup private Array List PHRASE_LIST
	private static String[] PHRASE_LIST = new String[] { "Beating a Dead Horse", "Roll With the Punches", "Down And Out",
			"Dont Mine at Night", "No Ifs Ands or Buts", "Raining Cats and Dogs", "Keep On Truckin", "Short End of the Stick",
			"Like Father Like Son", "Elvis Has Left The Building", "Don't put all your eggs in one basket",
			"A blessing in disguise", "Beat around the bush", "Better late than never", "Break a leg",
			"Its not rocket science", "On the ball", "Your guess is as good as mine", "You can say that again",
			"Live and learn", "Kill two birds with one stone", "Run like the wind", "That ship has sailed",
			"Fit as a fiddle", "Cut the mustard", "As right as rain", "An apple a day keeps the doctor away",
			"Calm before the storm", "Curiosity killed the cat", "When it rains it pours", "Waste not want not",
			"Time is money", "Through thick and thin", "Speak of the devil", "Once in a blue moon", "When pigs fly",
			"Call it a day", "Hit the nail on the head", "The last straw", "A piece of cake", "All ears",
			"Cant judge a book by its cover", "Cool as a cucumber", "Cry over spilled milk", "Easier said than done",
			"Eat like a bird", "Find your feet", "Food for thought", "Keep your chin up", "Lose your marbles",
			"Make ends meet", "Never in a million years", "On cloud nine", "Pull someone’s leg", "Square peg in a round hole",
			"sit tight", "Up in the air", "What goes around comes around" };

	// Create Variables for Game
	private String currentPhraseStr;
	private ArrayList<Character> guessedLetters;
	public ArrayList<Character> guessedPhrase;
	public ArrayList<Character> currentPhrase;

	public Hangman() {
		// Set up the Array lists and variables
		// Call other functions and pass variables into them
		currentPhraseStr = selectPhrase();
		currentPhrase = new ArrayList<Character>();
		guessedLetters = new ArrayList<Character>();
		guessedPhrase = new ArrayList<Character>();
		setupWord(currentPhraseStr);
		playGame();
	}

	private String selectPhrase() {
		// Select a random phrase from the array list and return it
		return (PHRASE_LIST[(int) (Math.random() * PHRASE_LIST.length)]);
	}

	private void setupWord(String phrase) {
		// Sets all charachters to uppercase
		// Add to current Phrase the current Letter
		// Loops through the guessed phrase and fills it with underscores if there is a
		// letter at that position, if not, it fills it in with a space
		// Prints out guessed phrase
		char letter;
		for (int i = 0; i < phrase.length(); i++) {
			letter = phrase.charAt(i);
			letter = Character.toUpperCase(letter);
			currentPhrase.add(letter);
			if (phrase.charAt(i) == ' ') {
				guessedPhrase.add(' ');
			} else {
				guessedPhrase.add('_');
			}

		}

		System.out.println("Guessed Phrase:" + guessedPhrase.toString());

		return;
	}

	private char getLetter() {
		// Gets a letter from the user and stores it in the guess variable
		// Assigns the letter to the guess variable and sets it to uppercase to help
		// with exception handling
		// Create needValidInput variable to ensure that the user only inputs a letter
		// Check if the lett is already entered by comparing the letter guessed to the
		// list of stored letters
		boolean needValidInput = true;
		Scanner input = new Scanner(System.in);
		Character guess = ' ';

		while (needValidInput) {
			System.out.println("Please Enter a Letter that you wish to Guess");
			guess = input.next().charAt(0);
			guess = Character.toUpperCase(guess);

			if (Character.isLetter(guess) == false) {
				System.out.println("You did not enter a letter");
			} else if (guessedLetters.indexOf(guess) != -1) {
				System.out.println("You already Entered That Letter");
			} else {
				// If not -1, letter not found in the list, so letter is valid input
				// Then add to guessedLetters list if found
				needValidInput = false;
				guessedLetters.add(guess);
			}
		}

		return guess;
	}

	private boolean findLetter(char letter) {
		// Increment throught the array list, checking at each index if the letter
		// guessed by the user matches
		boolean found = false;
		for (int i = 0; i <= currentPhrase.size() - 1; i++) {
			if (letter == currentPhrase.get(i)) {
				// This is a letter in the phrase
				guessedPhrase.set(i, letter);
				found = true;
			}
		}
		return found;
	}

	public void playGame() {
		// Set up the variables, 6 guesses to find all the letters

		int guessesRemaining = 6;
		char guess;
		boolean foundLetter;
		boolean didntWin = true;

		// While the user has more than zero guesses remaining, and they havent won yet:
		// Run getLetter() -> This returns your guess
		// Check to see if the letter that the user has entered is in the word -> Run
		// findLetter and store in foundLetter variable
		// If found Letter:
		// Check the filled spaces in the word ('_') and see if they match up with the
		// length of the word, if they do, you win the game
		// Print the guessed Phrase
		while (guessesRemaining > 0 && didntWin) {
			guess = getLetter();
			foundLetter = findLetter(guess);
			int filledSpaces = 0;
			if (foundLetter) {
				System.out.println("You found the Letter: " + guess);
				for (int i = 0; i < guessedPhrase.size(); i++) {
					if (guessedPhrase.get(i) != '_') {
						filledSpaces += 1;
					}
				}
				if (filledSpaces == guessedPhrase.size()) {
					System.out.println("Congratulations, You Win!");
					didntWin = false;

				}
				System.out.println(guessedPhrase.toString());

			}
			// If you do not find the letter, remove one guess remaining.
			// Depending on what guess that the user is on, print out the corresponding
			// Hangman
			else {
				System.out.println("You did not find the Letter: " + guess);
				guessesRemaining = guessesRemaining - 1;
				System.out.println("You lost 1 guess.");
				System.out.println("You have " + guessesRemaining + " guesses remaining");

				if (guessesRemaining == 5) {
					System.out.println("+---+\n" +
							"|   |\n" +
							"|\n" +
							"|\n" +
							"|\n" +
							"|\n" +
							"=========");
				} else if (guessesRemaining == 4) {
					System.out.println("+---+\n" +
							"|   |\n" +
							"|   O\n" +
							"|\n" +
							"|\n" +
							"|\n" +
							"=========\n");
				} else if (guessesRemaining == 3) {
					System.out.println("+---+\n" +
							"|   |\n" +
							"|   O\n" +
							"|  -|\n" +
							"|\n" +
							"|\n" +
							"=========");
				} else if (guessesRemaining == 2) {
					System.out.println("+---+\n" +
							"|   |\n" +
							"|   O\n" +
							"|  -|-\n" +
							"|   \n" +
							"| 	  \n" +
							"=========");
				} else if (guessesRemaining == 1) {
					System.out.println("+---+\n" +
							"|   |\n" +
							"|   O\n" +
							"|  -|-\n" +
							"|  [\n" +
							"|    \n" +
							"=========");
				}
				// If the user has used all of their guesses, they lose the game
				else if (guessesRemaining == 0) {
					System.out.println("+---+\n" +
							"|   |\n" +
							"|   O\n" +
							"|  -|-\n" +
							"|  [ ]\n" +
							"|    \n" +
							"=========");
					System.out.println("Unfortunatley, you did not win! Better luck next time.");
					System.out.println("The Correct Answer was:");
					System.out.println(currentPhraseStr);
				}
			}

		}

	}
}