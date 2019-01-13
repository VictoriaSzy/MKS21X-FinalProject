import java.util.* ;
import java.io.* ;

public class Test {
  public static void main(String[] args) {
    /////////////////////// ATTEMPT AT CONSOLE TO DETERMINE WHICH MODE TO USE /////////////////////////////
    Console console = System.console();
    String input = console.readLine("Enter the level and mode:");
    if (input.equals("NE")) {
      System.out.println("mode = Normal     level = Easy") ;
    }
    if (input.equals("NH")) {
      System.out.println("mode = Normal     level = Hard") ;
    }
    if (input.equals("CE")) {
      System.out.println("mode = Crazy     level = Easy") ;
    }
    if (input.equals("CH")) {
      System.out.println("mode = Crazy     level = Hard") ;
    }
  }
}
