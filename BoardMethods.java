import java.util.*;

public class BoardMethods{

  public static void start() {
    // this just prints out the directions so the user understands how to play
    System.out.println("Why are you here? To play the most awesomest game ever: Minesweeer!") ;
    System.out.println("In Normal Mode, you have to try to find where the bombs or mines are, and AVOID THEM. Be careful to not accidentally choose one of them!") ;
    System.out.println("In Crazy Mode, you have to try to find where the bombs or mines are, and AVOID THE REGULAR TILES!") ;
    System.out.println("Use the tiles around to determine whether there is a bomb or mine near.") ;
    System.out.println("To choose a tile, enter the coordinates of the tile you want to select.") ;
    System.out.println("The size of the Normal Easy Mode Board is 5x5, while the hard mode has a size of 8x8.") ;
    System.out.println("The size of the Crazy Easy Mode Board is 8x8, while the hard mode has a size of 10x10.") ;
    System.out.println("Good luck!") ;
  }

  public static void go(int numberOfBombs) {
    EasyBoard game = new EasyBoard() ;
    game.generateBombs(numberOfBombs) ;
    game.refresh() ;
    Scanner scan = new Scanner(System.in);
    int x, y ;
    System.out.print("Enter the x coordinate of the tile you want to select: ") ;
    x = scan.nextInt() ;
    System.out.print("Enter the y coordinate of the tile you want to select: ") ;
    y = scan.nextInt() ;

    game.clear(x,y) ;
    game.numberOfBombsAround() ;
    game.refresh() ;
    boolean running = true ;
    while (running) {
      if (game.isFinished() == true && game.isWin() == true) {
        // PLAYER WON!
        System.out.println("CONGRATULATIONS!! You win!") ;
        game.showLayout() ;
        running = false ;
      }
      else if (game.isFinished() == true) {
        game.showLayout() ;
        running = false ;
      }
      else if (game.isFinished() == false) {
        // this is when the game is still going
        x = -1 ;
        y = -1 ;
        System.out.print("\nEnter the x coordinate of the tile you want to select: ") ;
        x = scan.nextInt() ;
        System.out.print("\nEnter the y coordinate of the tile you want to select: ") ;
        y = scan.nextInt() ;
        game.move(x,y) ;
        game.isVictory() ;
        game.numberOfBombsAround() ;
        game.refresh() ;
      }
    }
  }

}
