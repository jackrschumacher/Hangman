// Import java.util
import java.util.*;
public class Hangman{
  // Setup private Array List PHRASE_LIST
  private static String[] PHRASE_LIST = new String[]{ "Beating a Dead Horse", "Roll With the Punches","Down And Out", "Dont Mine at Night", "No Ifs Ands or Buts", "Raining Cats and Dogs", "Keep On Truckin","Short End of the Stick", "Like Father Like Son", "Elvis Has Left The Building" };

  // Create Variables for Game
  private String currentPhrase;
  private ArrayList <String> guessedLetters;
  private ArrayList <String> guessedPhrase;
  
  public Hangman() {
    currentPhrase = selectPhrase();
    guessedLetters = new ArrayList<String>();
    guessedPhrase = new ArrayList<String>();
    playGame();
  }

  private String selectPhrase() {
    return (PHRASE_LIST[(int) (Math.random() * PHRASE_LIST.length)]);
  }
  private String findWord{
    Scanner input = new Scanner(System.in);
    ArrayList<Character> charachterList = new ArrayList<Character>();
    ArrayList<Integer> numRemaining = new ArrayList<Integer>();
  }
  private void playGame(){
    
  }
  

}







