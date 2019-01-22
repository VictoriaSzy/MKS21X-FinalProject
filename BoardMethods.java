import java.util.Scanner;
public class BoardMethods{

  //Displays rules at beginning of game.
    public static void start() {
      // this just prints out the directions so the user understands how to play
      System.out.println("Why are you here? To play the most awesomest game ever: Minesweeer!") ;
      System.out.println("In this mode, you have to try to find where the bombs or mines are, and AVOID THEM. Be careful to not accidentally choose one of them!") ;
      System.out.println("Use the tiles around to determine whether there is a bomb or mine near.") ;
      System.out.println("To choose a tile, enter the coordinates of the tile you want to select.") ;
      System.out.println("Good luck!") ;
    }

      public static void go() {
        EasyBoard game = new EasyBoard() ;
        game.generateBombs(10) ;
        game.refresh() ;
        Scanner scan = new Scanner(System.in);
        int x, y ;
        System.out.print("\nEnter the x coordinate of the tile you want to select: ") ;
        x = scan.nextInt() ;
        System.out.print("\nEnter the y coordinate of the tile you want to select: ") ;
        y = scan.nextInt() ;

        game.clear(x,y) ;
        game.numberOfBombsAround() ;
        game.refresh() ;
        boolean running = true ;
        while (running) {
          if (game.isFinished() && game.isWin()) {
            // PLAYER WON!
            System.out.println("CONGRATULATIONS!! You win!") ;
            game.showLayout() ;
            running = false ;
          }
                else if (game.isFinished()) {
                  game.showLayout() ;
                  running = false ;
                }
                else if (!game.isFinished()) {
                  // this is when the game is still going
                  x = -1 ;
                  y = -1 ;
                  System.out.print("\nEnter the x coordinate of the tile you want to select: ") ;
                  x = scan.nextInt() ;
                  System.out.print("\nEnter the y coordinate of the tile you want to select: ") ;
                  y = scan.nextInt() ;
                  game.move(x,y) ;
                  game.clear(x,y) ;
                  game.isVictory() ;
                  game.numberOfBombsAround() ;
                  game.refresh() ;
                }
              }
            }

          }
