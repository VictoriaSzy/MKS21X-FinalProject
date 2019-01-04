import java.util.* ;
import java.io.* ;

public class Board {
  // Variables:
  private Tile[][] layout ;
  private int[] locationsOfBombs ;
  private String mode ;
  private int numberFlagged ;

  // Constructor
  public Board(String mode) {
  }

  // We can use this to print out a visual representation of the board
  public String toString() {
    String result = "";
    for(int i =0; i < layout.length; i++){
      for(int n =0; n < layout[0].length; n++){
        if (layout[i][n].isVisible()){
        result = result + layout[i][n].getIdentifier() + " ";
      }else{
        result = result + "  ";
      }
      }
    }
    return result;
  }

}
