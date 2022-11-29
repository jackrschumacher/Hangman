// Import all packages inside java.util
import java.util.*;

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

  private void getLetter(){
    Scanner input = new Scanner(System.in);
    for(int guessesRemaining = 0; guessesRemaining < 6){
      System.out.println("Please Enter a Letter that you wish to Guess");
      guessedLetters[] = input.nextLine();
      
    }
    // Get the guessed letter
    // Check to make sure that it already has not been guessed
    // Check to make sure that it is a letter -> No spaces, or special characters or numbers
    // To Do:
    // Do loop with input until you get a valid guess

  }
  private boolean findLetter(char letter){
    // Search in the current phrase array for all occurances of letter
    // At each time you find the letter, fill in the value in the guessed phrase array
    // If found, return true, else return false
  }

  // To Do:
  // How to draw the Hangman?
  // Make sure that letters are compared that are of same case -> When input taken, convert all to Upppercase
  

  private void playGame() {
  // To Do: 
  // Come up with main game logic
  // * How to loop through getLetter() and findLetter() then print the Hangman or and reprint the guessed word with the new characters filled in
  // Play until no underscores found in guessed Phrase  = WON
  // All Parts of Hangman Drawn = LOST
  
  }

}
