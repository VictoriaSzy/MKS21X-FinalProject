public class Minesweeper{
  //this just runs the simple Minesweeper
  public static void main(String[] args) {
    String mo, lev ;
    if (args[0].equals("NE")) {
      mo = "Normal" ;
      lev = "Easy" ;
    }
    if (args[0].equals("NH")) {
      mo = "Normal" ;
      lev = "Hard" ;
    }
    if (args[0].equals("CE")) {
      mo = "Crazy" ;
      lev = "Easy" ;
    }
    if (args[0].equals("CH")) {
      mo = "Crazy" ;
      lev = "Hard" ;
    }
    BoardMethods.start() ;
    BoardMethods.go(12) ;
  }
}
