import java.util.*;

class Main {
  // Create PHRASE_LIST String List/Array
    private static String[] PHRASE_LIST = new String[] { "Beating a Dead Horse", "Roll With the Punches","Down And Out", "Dont Mine at Night", "No Ifs Ands or Buts", "Raining Cats and Dogs", "Keep On Truckin","Short End of the Stick", "Like Father Like Son", "Elvis Has Left The Building" };

    private ArrayList<String> guesses;
    private String currentPhrase;
    



  private String pickPhrase() {
    return (PHRASE_LIST[(int) (Math.random() * PHRASE_LIST.length)]);

}
  private String makeGuess(){
    Scanner input = new Scanner(System.in);
    System.out.println("What is your guess?");
    guess = input.nextLine();
    System.out.println(guess);
    
    

    ArrayList<Charachter> charachterList = new ArrayList<Charachter>();
    ArrayList<Integer> guessesRemaining = new ArrayList<Integer>();
    // Sequence through the phrase and check if the the charachter matches the phrase
    for (int i = 0; i < currentPhrase.length(); i++){
      char charachterCheck = currentPhrase.charAt(i);
      int index = -1;
      
    }
    

    
  }


}





