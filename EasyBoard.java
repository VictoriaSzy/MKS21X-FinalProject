public class EasyBoard {
public String[][] layout = new String[12][12] ;   // 12 rows, 12 columns
 public String[][] display = new String[12][12] ; // This is what the user sees
 public boolean finished = false ;
 public boolean victory = false ;

 private String hidden = " ? " ;
 private String bomb = " * " ;
 private String empty = "   " ;

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
  public void generateMines(int n){
    for(int m = 0; m < n; m++){
      boolean generatingAMine = true ;
      while(generatingAMine){
        int x, y = 0 ;
        x = (int) ( 10 * Math.random() ) ;
        y = (int) ( 10 * Math.random() ) ;
        //So that a mine is placed in a tile visible to the player
        if(x >= 1 && x <= 10){
          if(y >= 1 && y <= 10){
            // Checks if a mine is already there
            if(!layout[x][y].equals(bomb)){
              layout[x][y] = bomb;
              generatingAMine = false ;
            }
          }
        }
      }
    }
  }
  // accessor method
  public String getTile(int x, int y) {
    return layout[x][y] ;
  }

  //On first move, this clears the area around the selected tile.
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
