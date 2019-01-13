import java.util.* ;
import java.io.* ;

public class Board {
  // Variables:
  private Tile[][] layout ;
  private int[][] neighbors;
  private int[] locationsOfBombs ;
  private String mode,level ;
  private int numberFlagged, numberOfBombsClicked, numberOfChances, neighbor ;

  public static void main(String[] args) {
    Board test = new Board("Normal","Easy") ;
    System.out.println(test.toString()) ;
  }
  // Constructor
  public Board(String m, String l) {
    numberOfBombsClicked = 0 ;
    numberFlagged = 0 ;
    mode = m ;
    level = l ;
    if (mode.equals("Normal")) {
      numberOfChances = 1 ; // will be decreased if a bomb goes off in normal mode
      ///////////// EASY LEVEL //////////////////////////////////////////////////
      if (level.equals("Easy")) {
        // This is simple code that will be used for easy mode (Phase 1)
        layout = new Tile[5][5] ;
        // This part generates the random locations of the bombs (3 to 5 bombs)
        Random ran = new Random() ;
        int randomNumberOfBombs = Math.abs(ran.nextInt() % 3) + 3 ;
        locationsOfBombs = new int[randomNumberOfBombs] ;
        // This part stores the locations of the generated bombs in the array locationsOfBombs
        for (int i = 0 ; i < locationsOfBombs.length ; i ++) {
          Random rand = new Random() ;
          int randomBombLocation = Math.abs(rand.nextInt() % 25) ;
          while (!uniqueLocation(randomBombLocation)) {
            // the random integer generated has been used so we need to generate a new int
            rand = new Random() ;
            randomBombLocation = Math.abs(rand.nextInt() % 25) ;
          }
          locationsOfBombs[i] = randomBombLocation ;
        }
        // This part adds the tiles to layout
        int i = 0 ; // i will be used as a counter that we will check with the array locationsOfBombs
        for (int r = 0 ; r < 5 ; r++) {
          for (int c = 0 ; c < 5 ; c++) {
            layout[r][c] = new Tile(isARandomBomb(i)) ;
            layout[r][c].setNumber(i) ;
            i++ ;
          }
        }
      }

      ///////////// HARD LEVEL //////////////////////////////////////////////////
      if (level.equals("Hard")) {
        layout = new Tile[8][8] ;
        // This part generates the random locations of the bombs (6 to 12 bombs)
        Random ran = new Random() ;
        int randomNumberOfBombs = Math.abs(ran.nextInt() % 7) + 6 ;
        // This part stores the locations of the generated bombs in the array locationsOfBombs
        for (int i = 0 ; i < locationsOfBombs.length ; i ++) {
          Random rand = new Random() ;
          int randomBombLocation = Math.abs(rand.nextInt() % 64) ;
          while (!uniqueLocation(randomBombLocation)) {
            // the random integer generated has been used so we need to generate a new int
            rand = new Random() ;
            randomBombLocation = Math.abs(rand.nextInt() % 64) ;
          }
          locationsOfBombs[i] = randomBombLocation ;
        }
        // This part adds the tiles to layout
        int i = 0 ; // i will be used as a counter that we will check with the array locationsOfBombs
        for (int r = 0 ; r < 8 ; r++) {
          for (int c = 0 ; c < 8 ; c++) {
            layout[r][c] = new Tile(isARandomBomb(i)) ;
            i++ ;
          }
        }
      }
    }
    ///////////// CRAZY MODE //////////////////////////////////////////////////
    if (mode.equals("Crazy")) {
      ///////////// EASY LEVEL //////////////////////////////////////////////////
      if (level.equals("Easy")) {
        numberOfChances = 2 ;
        // This is just for easy mode:
        layout = new Tile[8][8] ;
        // This part generates the random locations of the bombs (10 to 20 bombs)
        Random ran = new Random() ;
        int randomNumberOfBombs = Math.abs(ran.nextInt() % 11) + 10 ;
        locationsOfBombs = new int[randomNumberOfBombs] ;
        // This part stores the locations of the generated bombs in the array locationsOfBombs
        for (int i = 0 ; i < locationsOfBombs.length ; i ++) {
          Random rand = new Random() ;
          int randomBombLocation = Math.abs(rand.nextInt() % 64) ;
          while (!uniqueLocation(randomBombLocation)) {
            // the random integer generated has been used so we need to generate a new int
            rand = new Random() ;
            randomBombLocation = Math.abs(rand.nextInt() % 64) ;
          }
          locationsOfBombs[i] = randomBombLocation ;
        }
        // This part adds the tiles to layout
        int i = 0 ; // i will be used as a counter that we will check with the array locationsOfBombs
        for (int r = 0 ; r < 8 ; r++) {
          for (int c = 0 ; c < 8 ; c++) {
            layout[r][c] = new Tile(isARandomBomb(i)) ;
            i++ ;
          }
        }
      }
      ///////////// HARD LEVEL //////////////////////////////////////////////////
      if (level.equals("Hard")) {
        numberOfChances = 1 ;
        layout = new Tile[10][10] ;
        // This part generates the random locations of the bombs (5 to 10 bombs)
        Random ran = new Random() ;
        int randomNumberOfBombs = Math.abs(ran.nextInt() % 6) + 5 ;
        locationsOfBombs = new int[randomNumberOfBombs] ;
        // This part stores the locations of the generated bombs in the array locationsOfBombs
        for (int i = 0 ; i < locationsOfBombs.length ; i ++) {
          Random rand = new Random() ;
          int randomBombLocation = Math.abs(rand.nextInt() % 100) ;
          while (!uniqueLocation(randomBombLocation)) {
            // the random integer generated has been used so we need to generate a new int
            rand = new Random() ;
            randomBombLocation = Math.abs(rand.nextInt() % 100) ;
          }
          locationsOfBombs[i] = randomBombLocation ;
        }
        // This part adds the tiles to layout
        int i = 0 ; // i will be used as a counter that we will check with the array locationsOfBombs
        for (int r = 0 ; r < 10 ; r++) {
          for (int c = 0 ; c < 10 ; c++) {
            layout[r][c] = new Tile(isARandomBomb(i)) ;
            i++ ;
          }
        }
      }
    }
  }

  public String getMode(){
    return this.mode;
  }
  public String getLevel(){
    return this.level;
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
  /*
  // counts the number of bombs on the board
  public int numberOfBombs(){
    int bombs = 0;
    for(int r=0; r < layout.length; r++){
      for(int c=0; c < layout.length; c++){
        if(layout[r][c].getIdentifier().equals("*")){
          bombs = bombs + 1;
        }
      }
    }
    return bombs;
  }
  */
<<<<<<< HEAD
  // Determines the number of bombs around Tile n based off its "number" which we use to find its row and column in layout
  public int numberOfBombsAround(Tile n) {
    if (n.isBomb()) {
      n.setIdentifier("*") ;
      return 0 ;
    }
    int result = 0 ;
    int tileLocation = n.getNumber() ;
    int roww = tileLocation / layout.length ;
    int coll = tileLocation % layout.length ;
    ///////////// TOP ROW ////////////////////////////
    if (roww == 0) {
      // the tile is in the top row
      if (coll == 0) {
        // the tile is in the upper left corner
        Tile tileToTheRight = layout[roww][coll + 1] ;
        Tile tileDirectlyBelow = layout[roww + 1][coll] ;
        Tile tileDiagonallyRight = layout[roww + 1] [coll + 1] ;
        if (tileToTheRight.isBomb()) result++ ;
        if (tileDirectlyBelow.isBomb()) result++ ;
        if (tileDiagonallyRight.isBomb()) result ++ ;
        if (result == 0) {
          // there are no bombs around this tile
          n.setIdentifier(" ") ;
        }
        else {
          n.setIdentifier(Integer.toString(result)) ;
        }
        return result ;
      }
      if (coll == layout.length - 1) {
        // the tile is in the upper right corner
        Tile tileToTheLeft = layout[roww][coll - 1] ;
        Tile tileDirectlyBelow = layout[roww + 1][coll] ;
        Tile tileDiagonallyLeft = layout[roww + 1] [coll - 1] ;
        if (tileToTheLeft.isBomb()) result++ ;
        if (tileDirectlyBelow.isBomb()) result++ ;
        if (tileDiagonallyLeft.isBomb()) result ++ ;
        if (result == 0) {
          // there are no bombs around this tile
          n.setIdentifier(" ") ;
        }
        else {
          n.setIdentifier(Integer.toString(result)) ;
        }
        return result ;
      }
      // Otherwise, we can check the tiles to the left, diagonally left, directly below, diagonally right, and to the right
      Tile tileToTheLeft = layout[roww][coll - 1] ;
      Tile tileDiagonallyLeft = layout[roww + 1] [coll - 1] ;
      Tile tileDirectlyBelow = layout[roww + 1][coll] ;
      Tile tileDiagonallyRight = layout[roww + 1] [coll + 1] ;
      Tile tileToTheRight = layout[roww][coll + 1] ;
      if (tileToTheLeft.isBomb()) result++ ;
      if (tileDiagonallyLeft.isBomb()) result ++ ;
      if (tileDirectlyBelow.isBomb()) result++ ;
      if (tileDiagonallyRight.isBomb()) result ++ ;
      if (tileToTheRight.isBomb()) result++ ;
      if (result == 0) {
        // there are no bombs around this tile
        n.setIdentifier(" ") ;
      }
      else {
        n.setIdentifier(Integer.toString(result)) ;
      }
      return result ;
    }
    /////////// BOTTOM ROW ///////////////////////////
    if (roww == layout.length - 1) {
      // the tile is in the bottom row
      if (coll == 0) {
        // the tile is in the upper left corner
        Tile tileDirectlyAbove = layout[roww - 1][coll] ;
        Tile tileDiagonallyRight = layout[roww - 1][coll + 1] ;
        Tile tileToTheRight = layout[roww][coll + 1] ;
        if (tileDirectlyAbove.isBomb()) result++ ;
        if (tileDiagonallyRight.isBomb()) result++ ;
        if (tileToTheRight.isBomb()) result++ ;
        if (result == 0) {
          // there are no bombs around this tile
          n.setIdentifier(" ") ;
        }
        else {
          n.setIdentifier(Integer.toString(result)) ;
        }
        return result ;
      }
      if (coll == layout.length - 1) {
        // the tile is in the upper right corner
        Tile tileDirectlyAbove = layout[roww - 1][coll] ;
        Tile tileDiagonallyLeft = layout[roww - 1][coll - 1] ;
        Tile tileToTheLeft = layout[roww][coll - 1] ;
        if (tileDirectlyAbove.isBomb()) result++ ;
        if (tileDiagonallyLeft.isBomb()) result++ ;
        if (tileToTheLeft.isBomb()) result++ ;
        if (result == 0) {
          // there are no bombs around this tile
          n.setIdentifier(" ") ;
        }
        else {
          n.setIdentifier(Integer.toString(result)) ;
=======
  // public int numberOfBombsAround(Tile n){
  //   int result = 0 ;
  //   int tileLocation = n.getNumber() ;
  //   int roww = tileLocation / layout.length ;
  //   int coll = tileLocation % layout.length ;
    /*for(int r=0; r < layout.length ; r++){
      for(int c=0; c < layout.length ; c++){
        if(r == 0 && c == 0){
          if(layout[1][0].getIdentifier().equals("*")){
            result = result + 1;
          }
          if(layout[1][1].getIdentifier().equals("*")){
            result = result + 1;
          }
          if(layout[0][1].getIdentifier().equals("*")){
            result = result + 1;
          }
>>>>>>> workonprintout
        }
        return result ;
      }
<<<<<<< HEAD
      // Now, we can check tile to left, tile diagonally left, tile above, tile diagonally right, and tile to the right
      Tile tileToTheLeft = layout[roww][coll - 1] ;
      Tile tileDiagonallyLeft = layout[roww - 1][coll - 1] ;
      Tile tileDirectlyAbove = layout[roww - 1][coll] ;
      Tile tileDiagonallyRight = layout[roww - 1][coll + 1] ;
      Tile tileToTheRight = layout[roww][coll + 1] ;
      if (tileToTheLeft.isBomb()) result++ ;
      if (tileDirectlyAbove.isBomb()) result++ ;
      if (tileDiagonallyRight.isBomb()) result++ ;
      if (tileToTheRight.isBomb()) result++ ;
      if (result == 0) {
        // there are no bombs around this tile
        n.setIdentifier(" ") ;
      }
      else {
        n.setIdentifier(Integer.toString(result)) ;
      }
      return result ;
    }
    // Otherwise, we are able to check all 8 tiles around the specific tile
    Tile tileDiagonallyLeftUp = layout[roww - 1][coll - 1] ;
    Tile tileDirectlyAbove = layout[roww - 1][coll] ;
    Tile tileDiagonallyRightUp = layout[roww - 1][coll + 1] ;
    Tile tileToTheRight = layout[roww][coll + 1] ;
    Tile tileDiagonallyRightDown = layout[roww + 1][coll + 1] ;
    Tile tileDirectlyBelow = layout[roww + 1][coll] ;
    Tile tileDiagonallyLeftDown = layout[roww + 1][coll - 1] ;
    Tile tileToTheLeft = layout[roww][coll - 1] ;
    if (tileDiagonallyLeftUp.isBomb()) result++ ;
    if (tileDirectlyAbove.isBomb()) result++ ;
    if (tileDiagonallyRightUp.isBomb()) result++ ;
    if (tileToTheRight.isBomb()) result++ ;
    if (tileDiagonallyRightDown.isBomb()) result++ ;
    if (tileDirectlyBelow.isBomb()) result++ ;
    if (tileDiagonallyLeftDown.isBomb()) result++ ;
    if (tileToTheLeft.isBomb()) result++ ;
    return result ;
  }
=======
    }*/
  //}
>>>>>>> workonprintout
  //contains method to check inside locationsofbomb
  public boolean contains( int[] ary, int number){
    for (int r = 0 ; r < ary.length ; r++) {
      if(ary[r] == number){
        return true;
      }
    }
    return false;
  }
  public boolean isbombNeighbor(int x1, int y1, int x2, int y2 ){
    if(x1 - x2 < 2 && x1 - x2 > -2 && y1 - y2 < 2 && y1 - y2 < -2 ){
      return true;
    }
    return false;
  }
  public int numberOfBombsAround(int x, int y){
    int result = 0;
    if(x != 0 && y != 0 && x != 4 && y != 4){
      if(contains(locationsOfBombs,((y-1)*5) + x )) {
        result = result + 1;
      }
      if(contains(locationsOfBombs, ((y-1)*5) + (x + 1) )) {
        result = result + 1;
      }
      if(contains(locationsOfBombs,((y-1)*5) + (x + 2) )){
        result = result + 1;
      }
      if(contains(locationsOfBombs, (y*5) + x )){
        result = result + 1;
      }
      if(contains(locationsOfBombs , (y*5) + (x + 2))) {
        result = result + 1;
      }
      if(contains(locationsOfBombs,((y+1)*5) + x)){
        result = result + 1;
      }
      if(contains(locationsOfBombs,((y+1)*5) + (x + 1))){
        result = result + 1;
      }
      if(contains(locationsOfBombs,((y+1)*5) + (x + 2) )){
        result = result + 1;
      }
    }
    if(x == 0 && y == 0){
      if(contains(locationsOfBombs , (y*5) + (x + 2))) {
        result = result + 1;
      }
      if(contains(locationsOfBombs,((y+1)*5) + (x + 1))){
        result = result + 1;
      }
      if(contains(locationsOfBombs,((y+1)*5) + (x + 2) )){
        result = result + 1;
      }
    }
    return result;
  }

  // We can use this to print out a visual representation of the board
  public String toString() {
    String result = "";
    for(int r=0; r < layout.length; r++){
      for(int c=0; c < layout.length; c++){
        if (layout[r][c].isVisible()) {
          result += layout[r][c].getIdentifier() + " ";
        }
        else {
          result += "  ";
        }
      }
      result += "\n" ;
    }
    return result;
  }

  public void gameOverMessage() {
    System.out.println();
    System.out.println(" That's a Mine :(") ;
    System.out.println("_____");
    System.out.println("|  __ \\  ");
    System.out.println("| |  \\/ __ _ _ __ ___   ___  _____   _____ _ __");
    System.out.println("| | __ / _` | '_ ` _ \\ / _ \\/ _ \\ \\ / / _ \\ '__|");
    System.out.println("| |_\\ \\ (_| | | | | | |  __/ (_) \\ V /  __/ |");
    System.out.println(" \\____/\\__,_|_| |_| |_|\\___|\\___/ \\_/ \\___|_|");
    System.out.println();
    System.exit(0) ;
  }
  public void welcomeMessage() {
    System.out.println(" _    _      _                          _ ");
    System.out.println("| |  | |    | |                        | |");
    System.out.println("| |  | | ___| | ___ ___  _ __ ___   ___| |");
    System.out.println("| |/\\| |/ _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\ |");
    System.out.println("\\  /\\  /  __/ | (_| (_) | | | | | |  __/_|");
    System.out.println(" \\/  \\/ \\___|_|\\___\\___/|_| |_| |_|\\___(_)") ;
  }
  public void winMessage() {
    System.out.println("__   __            _    _ _       _");
    System.out.println("\\ \\ / /           | |  | (_)     | |");
    System.out.println(" \\ V /___  _   _  | |  | |_ _ __ | |");
    System.out.println("  \\ // _ \\| | | | | |/\\| | | '_ \\| |");
    System.out.println("  | | (_) | |_| | \\  /\\  / | | | |_|");
    System.out.println("  \\_/\\___/ \\__,_|  \\/  \\/|_|_| |_(_)");
  }
}
