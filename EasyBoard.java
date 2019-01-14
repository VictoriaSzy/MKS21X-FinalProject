public class EasyBoard {
public String[][] layout = new String[12][12];   //12 rows, 12 columns.
 public String[][] display = new String[12][12]; //This is the field that is visible to the player.
 public Boolean complete = false;
 public Boolean victory = false;

 private String unknown = " ? ";
 private String mine = " * ";
 private String empty = "   ";

 public EasyBoard(){
    int row = 0;
    int column = 0;

    for(int x = 0; x < layout.length; x++){
      for(int y = 0; y < layout[0].length; y++){
        //Places blank spaces in buffer zones.
        if((x == 0 || x == layout.length - 1)||(y == 0 || y == layout[0].length - 1)){
          layout[x][y] = empty;
          display[x][y] = empty;
        }
        //Places ? in game field.
        else{
          layout[x][y] = unknown;
          display[x][y] = unknown;
        }
      }
    }
  }

  //Displays the layout.
  public static void printGame(String[][] str){
    for(int x = 1; x < str.length - 1; x++){
      for(int y = 0; y < str[0].length ; y++){
        //Formats row.
        if(y > 0 && y < str[0].length)
          System.out.print("|");
        else
          System.out.println("");

        System.out.print(str[x][y]);  //Prints out content of each tile.
      }
    }
  }

  //Places n mines at random on the field.
public void generateMines(int n){
  for(int m = 0; m < n; m++){
    //Loops until a mine is placed.
    while(true){
      int x, y = 0;   //Clears vars.
      x = (int)(10*Math.random());
      y = (int)(10*Math.random());

      //So that a mine is placed in a tile visible to the player.
      if(x >= 1 && x <= 10){
        if(y >= 1 && y <= 10){
          //Checks if a mine is present in a spot.
          if(!field[x][y].equals(mine)){
            field[x][y] = mine;
            break;
          }
        }
      }
    }
  }
}

//On first move, this clears the area around the selected tile.
public void clear(int x, int y){
  for(int i = (x - 1); i <= (x + 1); i++){
    for(int j = (y - 1); j <= (y + 1); j++){
      if(field[i][j].equals(unknown) == true){
        display[i][j] = empty;
        layout[i][j] = empty;
      }
    }
  }
}



}
