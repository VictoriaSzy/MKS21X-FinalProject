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
      // This is simple code that will be used for easy mode (Phase 1)
      layout = new Tile[5][5] ;
      // This part generates the random locations of the bombs
      Random ran = new Random() ;
      int randomNumberOfBombs = Math.abs(ran.nextInt() % 3) + 3 ;
      locationsOfBombs = new int[randomNumberOfBombs] ;
      int index = 0 ;
      for (int i = 0 ; i < locationsOfBombs.length ; i ++) {
        Random rand = new Random() ;
        int randomBombLocations = Math.abs(rand.nextInt() % 25) ;
        while (!uniqueLocation(randomBombLocations)) {
          // the random integer generated has been used so we need to generate a new int
          rand = new Random() ;
          randomBombLocations = Math.abs(rand.nextInt() % 25) ;
        }
        locationsOfBombs[index] = randomBombLocations ;
        index++ ;
      }
      // This part adds the tiles to layout
      int i = 0 ; // i will be used as a counter
      for (int r = 0 ; r < 5 ; r++) {
        for (int c = 0 ; c < 5 ; c++) {
          layout[r][c] = new Tile(isARandomBomb(i)) ;
          i++ ;
        }
      }
    }
    if (mode.equals("Crazy")) {
      // This is what happens during crazy mode
    }
  }
  // Determines whether the tile that is going to be created is supposed to be a bomb or not
  public boolean isARandomBomb(int counter) {
    for (int x = 0 ; x < locationsOfBombs.length ; x++) {
      if (counter == locationsOfBombs[x]) return true ;
    }
    return false ;
  }
  // Used to determine whether a random location generated for the bomb has already been generated or used
  public boolean uniqueLocation(int location) {
    for (int x =  0; x < locationsOfBombs.length ; x++) {
      if (location == locationsOfBombs[x]) return false ;
    }
    return true ;
  }
  // We can use this to print out a visual representation of the board
  public String toString() {
    return "" ;
  }

}
