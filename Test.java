import java.util.* ;
import java.io.* ;

public class Test {
  public static void main(String[] args) {
    /////////////////////// ATTEMPT AT CONSOLE TO DETERMINE WHICH MODE TO USE /////////////////////////////
    Console console = System.console();
    String input = console.readLine("Enter the level and mode:");
    Board game = new Board("Normal","Easy") ;
    if (input.equals("NE")) {
      //System.out.println("mode = Normal     level = Easy") ;
      game = new Board("Normal","Easy") ;
    }
    if (input.equals("NH")) {
      //System.out.println("mode = Normal     level = Hard") ;
      game = new Board("Normal","Hard") ;
    }
    if (input.equals("CE")) {
      //System.out.println("mode = Crazy     level = Easy") ;
      game = new Board("Crazy","Easy") ;
    }
    if (input.equals("CH")) {
      //System.out.println("mode = Crazy     level = Hard") ;
      game = new Board("Crazy","Hard") ;
    }
    System.out.println(game.toString()) ;
  }
  /////// END OF MAIN //////////////////////////////////////////////////////////////////////
}
