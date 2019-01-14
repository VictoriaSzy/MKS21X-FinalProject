public class Minesweeper{
  //this just runs the simple Minesweeper
  public static void main(String[] args) {
    String mo, lev ;
    int randomNumberOfBombs, len ;
    Random ran = new Random() ;
    if (args[0].equals("NE")) {
      mo = "Normal" ;
      lev = "Easy" ;
      randomNumberOfBombs = Math.abs(ran.nextInt() % 3) + 3 ;
      len = 5 ;
    }
    if (args[0].equals("NH")) {
      mo = "Normal" ;
      lev = "Hard" ;
      randomNumberOfBombs = Math.abs(ran.nextInt() % 7) + 6 ;
      len = 8 ;
    }
    if (args[0].equals("CE")) {
      mo = "Crazy" ;
      lev = "Easy" ;
      randomNumberOfBombs = Math.abs(ran.nextInt() % 11) + 10 ;
      len = 8 ;
    }
    if (args[0].equals("CH")) {
      mo = "Crazy" ;
      lev = "Hard" ;
      randomNumberOfBombs = Math.abs(ran.nextInt() % 6) + 5 ;
      len = 10 ;
    }
    BoardMethods.start() ;
    BoardMethods.go(randomNumberOfBombs, len) ;
  }
}
