import java.util.*;
class Main {
  public static void main(String[] args) {
  // Create PHRASE_LIST String List
  Scanner input = new Scanner(System.in);
  String PHRASE_LIST[] = { "Beating a Dead Horse", "Roll With the Punches","Down And Out", "Dont Mine at Night", "No Ifs Ands or Buts", "Raining Cats and Dogs", "Keep On Truckin","Short End of the Stick", "Like Father Like Son", "Elvis Has Left The Building" };
  System.out.println("What is your guess?");
  String userInput = input.nextLine();
  int guessesRemaining = 0;
  int random = math.random * 100;
  string randomWord = PHRASE_LIST[] * random;
  while(guessesRemaining < 6){
    for(int i = 0; i < randomWord.length(); i++){
      char charachterCheck = randomWord.charAt(i);
      int index = -1;
    for(int j = 0; j < randomWord.size(); j++){
      if(charachterCheck == randomWord.get(j)){
        index = j;
      }
      
    }
    }
    
    
  }
  

  
      
      
    
    
  }
}








