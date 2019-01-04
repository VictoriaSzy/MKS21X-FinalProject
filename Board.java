import java.util.* ;
import java.io.* ;

public class Board {
  // Variables:
  private Tile[][] layout ;
  private int[] locationsOfBombs ;
  private String mode ;
  private int numberFlagged ;

  public static void main(String[] args) {
    for (int i = 0 ; i < 5; i ++) {
      Random rand = new Random() ;
      int randomBombLocations = Math.abs(rand.nextInt() % 25) ;
      System.out.println(randomBombLocations) ;
    }
  }
  // Constructor
  public Board(String mode) {
    if (mode.equals("Normal")) {
      // This is what happens during normal mode
      // This is simple code that will be used for easy mode (Phase 1)
      layout = new Tile[5][5] ;
      Random ran = new Random() ;
      int randomNumberOfBombs = Math.abs(ran.nextInt() % 3) + 3 ;
      int index = 0 ;
      for (int i = 0 ; i < 5; i ++) {
        Random rand = new Random() ;
        int randomBombLocations = Math.abs(rand.nextInt() % 25) ;
        locationsOfBombs[index] = randomBombLocations ;
        index++ ;
      }
      ////////////////////////////////////////////////////
      int i = 0 ; // i will be used as a counter
      for (int r = 0 ; r < 5 ; r++) {
        for (int c = 0; c < 5 ; c++) {
          if (randomBomb(i)) {
            layout[r][c] = new Tile(true) ;
          }
          else {
            layout[r][c] = new Tile(false) ;
          }
          i++ ;
        }
      }
    }
    if (mode.equals("Crazy")) {
      // this is what happens during crazy mode
    }
  }

  public boolean randomBomb(int counter) {
    for (int x = 0 ; x < locationsOfBombs.length ; x++) {
      if (counter == locationsOfBombs[x]) return true ;
    }
    return false ;
  }
  // We can use this to print out a visual representation of the board
  public String toString() {
    return "" ;
  }

}
