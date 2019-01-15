public class EasyBoard {
public String[][] layout = new String[12][12] ;   // 12 rows, 12 columns
 public String[][] display = new String[12][12] ; // This is what the user sees
 public boolean finished = false ;
 public boolean victory = false ;

 private String hidden = " ? " ;
 private String bomb = " * " ;
 private String empty = "   " ;

 // accessor methods
 public String getTile(int x, int y) {
   return layout[x][y] ;
 }
 public boolean isFinished() {
   return finished ;
 }
 public boolean isWin() {
   return victory ;
 }

 public void showBombs() {
   // happens at the end once the user hits a bomb!
   printGame(layout) ;
 }
public void showLayout() {
  printGame(layout) ;
}
 public EasyBoard(){
    int row = 0 ;
    int column = 0 ;
    for(int x = 0 ; x < layout.length ; x++){
      for(int y = 0 ; y < layout.length ; y++){
        if((x == 0 || x == layout.length - 1)||(y == 0 || y == layout.length - 1)){
          layout[x][y] = empty ;
          display[x][y] = empty ;
        }
        // Otherwise put a "?" because the player doesn't know what it is
        else{
          layout[x][y] = hidden ;
          display[x][y] = hidden ;
        }
      }
    }
  }
  // this reprints the board after the user chose the coordinates
  public void refresh() {
    printGame(display) ;
  }

  //Displays the layout, sort of like the toString
  public static void printGame(String[][] str){
    for(int x = 1 ; x < str.length - 1 ; x++){
      for(int y = 0 ; y < str[0].length ; y++){
        if (y > 0 && y < str[0].length) System.out.print("|") ;
        else {
          System.out.println("") ;
        }
        System.out.print(str[x][y]) ;  // Prints out the tile
      }
    }
  }
  // Randomly places the bombs
  public void generateBombs(int n){
    for(int m = 0; m < n; m++){
      boolean generatingABomb = true ;
      while(generatingABomb){
        int x, y = 0 ;
        x = (int) ( 10 * Math.random() ) ;
        y = (int) ( 10 * Math.random() ) ;
        //So that a bomb is placed in a tile visible to the player
        if(x >= 1 && x <= 10){
          if(y >= 1 && y <= 10){
            // Checks if a bomb is already there
            if(!layout[x][y].equals(bomb)){
              layout[x][y] = bomb;
              generatingABomb = false ;
            }
          }
        }
      }
    }
  }
  // called when the user chooses a tile
  public void move(int x, int y) {
    if (layout[x][y].equals(hidden) == true) {
      //If the spot hasn't been selected, it is cleared
      finished = false ;
      display[x][y] = empty ;
      layout[x][y] = empty ;
    }
    else if (layout[x][y].equals(bomb) == true) {
      finished = true ;
      victory = false ; // user lost
      System.out.println("Uh-oh! The game is OVER!!") ;
    }
    else if (display[x][y].equals(empty) == true && layout[x][y].equals(empty)) {
      finished = false ;
      System.out.println("The tile you chose was revealed!") ;
    }
  }
  // Checking if the user has won
  public void isVictory() {
    int numOfTilesLeft = 0 ;
    for (int a = 0 ; a < layout.length ; a++) {
      for(int b = 0; b < layout.length; b++) {
        if (layout[a][b].equals(hidden) == true) numOfTilesLeft++ ;
      }
    }

    if(numOfTilesLeft != 0) victory = false ;
    else {
      victory = true ;
      finished = true ;
    }
  }
  // Finds the number of bombs around a tile
  public void numberOfBombsAround() {
    for (int x = 1 ; x < display.length - 2 ; x++) {
      for (int y = 1 ; y < display.length - 2 ; y++) {
        if (layout[x][y].equals(empty) == true) {
          int numOfBombs = 0 ;
          for (int a = (x - 1) ; a <= (x + 1) ; a++) {
            for (int b = (y - 1) ; b <= (y + 1) ; b++) {
              if (layout[a][b].equals(bomb) == true) numOfBombs++ ;
            }
          }
          display[x][y] = " " + numOfBombs + " " ;
        }
      }
    }
  }

  // clears the tiles around the specified coordinates
  public void clear(int x, int y){
    for(int i = (x - 1); i <= (x + 1); i++){
      for(int j = (y - 1); j <= (y + 1); j++){
        if(layout[i][j].equals(hidden) == true){
          display[i][j] = empty;
          layout[i][j] = empty;
        }
      }
    }
  }

}
