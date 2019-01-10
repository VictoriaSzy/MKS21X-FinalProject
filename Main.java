// in the terminal type javac -cp lanterna.jar:. Main.java

//API : http://mabe02.github.io/lanterna/apidocs/2.1/
import com.googlecode.lanterna.terminal.Terminal.SGR;
import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.input.Key.Kind;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.Terminal.Color;
import com.googlecode.lanterna.terminal.TerminalSize;
import com.googlecode.lanterna.LanternaException;
import com.googlecode.lanterna.input.CharacterPattern;
import com.googlecode.lanterna.input.InputDecoder;
import com.googlecode.lanterna.input.InputProvider;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.input.KeyMappingProfile;


public class Main {
	// So this part places a string onto the terminal screen
	public static void putString(int r, int c,Terminal t, String s){
		t.moveCursor(r,c);
		for(int i = 0; i < s.length();i++){
			t.putCharacter(s.charAt(i)) ;
		}
	}
	public static void main(String[] args) {
		int x = 10 ;
		int y = 10 ;

		Terminal terminal = TerminalFacade.createTextTerminal() ;
		terminal.enterPrivateMode() ; // this prevents scrolling
		terminal.moveCursor(5,5) ;
		// text printing always starts at the cursor's position so we need to make sure it goes where we want it to go

		TerminalSize size = terminal.getTerminalSize(); // gets the size of the terminal
		/* We can also use size.getRows() and size.getColumns() to put things or labels into corners or sides
		I think that we can display the timer and number of chances left on the bottom of the screen by using
		size.getColumns()/2 and size.getRows() - 1 */

		terminal.setCursorVisible(false);

		boolean running = true ;
		///////// TIME //////////////////////////////////////////////
		long tStart = System.currentTimeMillis() ;
		long lastSecond = 0 ;
		int mode = 0;

		while(running){
			Board test = new Board("Normal","Easy");
			terminal.moveCursor(x,y); // we can also do terminal.setCursorPosition(x,y) ;
			// moveCursor(..) places the cursor somewhere else after writing something until the end of the row
			terminal.applyBackgroundColor(Terminal.Color.WHITE);
			terminal.applyForegroundColor(Terminal.Color.BLACK);
			// Examples of other colors: BLACK, RED,GREEN,YELLOW,BLUE,MAGENTA,CYAN,WHITE,DEFAULT (depends on user)
			//applySGR(a,b) for multiple modifiers (bold,blink) etc.
			terminal.applySGR(Terminal.SGR.ENTER_UNDERLINE);
			terminal.putCharacter('\u2B1B'); // this is a black square that will go over the tiles
			// I got this Unicode character from https://www.fileformat.info/info/unicode/char/2b1b/index.htm along with the flag
			terminal.putCharacter(' ');
			terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
			terminal.applyForegroundColor(Terminal.Color.DEFAULT);
			terminal.applySGR(Terminal.SGR.RESET_ALL);


			terminal.moveCursor(size.getColumns() - 5, 5);
			terminal.applyBackgroundColor(Terminal.Color.RED);
			terminal.applyForegroundColor(Terminal.Color.YELLOW);
			terminal.applySGR(Terminal.SGR.ENTER_BOLD);
			terminal.putCharacter(' ');
			terminal.putCharacter(' ');
			terminal.putCharacter('\u2691'); // this is the little image on the right hand side & testing the flag character
			terminal.putCharacter(' ');
			terminal.moveCursor(size.getColumns()-5,6);
			terminal.putCharacter(' ');
			terminal.putCharacter(' ');
			terminal.putCharacter(' ');
			terminal.putCharacter(' ');
			terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
			terminal.applyForegroundColor(Terminal.Color.DEFAULT);


			// Normal easy mode!
			if(test.getMode().equals("Normal")){
				if(test.getLevel().equals("Easy")){
					terminal.moveCursor((size.getColumns()/2) - 2,size.getRows()/2);
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.moveCursor((size.getColumns()/2) - 2,(size.getRows()/2) + 1);
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.moveCursor((size.getColumns()/2) - 2,(size.getRows()/2) + 2);
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.moveCursor((size.getColumns()/2) - 2,(size.getRows()/2) + 3);
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.moveCursor((size.getColumns()/2) - 2,(size.getRows()/2) + 4);
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
				}
				if(test.getLevel().equals("Hard")){
					//Normal Hard Mode
					terminal.moveCursor((size.getColumns()/2) - 4,size.getRows()/2);
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.moveCursor((size.getColumns()/2) - 4,(size.getRows()/2) + 1);
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.moveCursor((size.getColumns()/2) - 4,(size.getRows()/2) + 2);
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.moveCursor((size.getColumns()/2) - 4,(size.getRows()/2) + 3);
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.moveCursor((size.getColumns()/2) - 4,(size.getRows()/2) + 4);
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.moveCursor((size.getColumns()/2) - 4,(size.getRows()/2) + 5);
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.moveCursor((size.getColumns()/2) - 4,(size.getRows()/2) + 6);
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.moveCursor((size.getColumns()/2) - 4,(size.getRows()/2) + 7);
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
					terminal.putCharacter('\u2B1B');
				}
				terminal.moveCursor(10,10);
		}

			// //Crazy easy mode
			// terminal.moveCursor((size.getColumns()/2) - 4,size.getRows()/2);
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.moveCursor((size.getColumns()/2) - 4,(size.getRows()/2) + 1);
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.moveCursor((size.getColumns()/2) - 4,(size.getRows()/2) + 2);
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.moveCursor((size.getColumns()/2) - 4,(size.getRows()/2) + 3);
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.moveCursor((size.getColumns()/2) - 4,(size.getRows()/2) + 4);
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.moveCursor((size.getColumns()/2) - 4,(size.getRows()/2) + 5);
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.moveCursor((size.getColumns()/2) - 4,(size.getRows()/2) + 6);
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.moveCursor((size.getColumns()/2) - 4,(size.getRows()/2) + 7);
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			//
			// //Crazy Hard mode
			// terminal.moveCursor((size.getColumns()/2) - 5,size.getRows()/2);
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.moveCursor((size.getColumns()/2) - 5,(size.getRows()/2) + 1);
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.moveCursor((size.getColumns()/2) - 5,(size.getRows()/2) + 2);
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.moveCursor((size.getColumns()/2) - 5,(size.getRows()/2) + 3);
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.moveCursor((size.getColumns()/2) - 5,(size.getRows()/2) + 4);
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.moveCursor((size.getColumns()/2) - 5,(size.getRows()/2) + 5);
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.moveCursor((size.getColumns()/2) - 5,(size.getRows()/2) + 6);
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.moveCursor((size.getColumns()/2) - 5,(size.getRows()/2) + 7);
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.moveCursor((size.getColumns()/2) - 5,(size.getRows()/2) + 8);
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.moveCursor((size.getColumns()/2) - 5,(size.getRows()/2) + 9);
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');
			// terminal.putCharacter('\u2B1B');


			Key key = terminal.readInput(); // determines what and whether the user typed a key in

			if (key != null) {
				if (key.getKind() == Key.Kind.Escape) {
					// we need to exit the program --> THIS CAN STAY
					terminal.exitPrivateMode() ;
					running = false ;
				}

				if (key.getKind() == Key.Kind.ArrowLeft) {
					terminal.moveCursor(x,y);
					//terminal.putCharacter('\u2B1B');
					terminal.putCharacter(' ');
					x--;
				}

				if (key.getKind() == Key.Kind.ArrowRight) {
					terminal.moveCursor(x,y);
					//terminal.putCharacter('\u2B1B');
					terminal.putCharacter(' ');
					x++;
				}

				if (key.getKind() == Key.Kind.ArrowUp) {
					terminal.moveCursor(x,y);
					//terminal.putCharacter('\u2B1B');
					terminal.putCharacter(' ');
					y--;
				}

				if (key.getKind() == Key.Kind.ArrowDown) {
					terminal.moveCursor(x,y);
					//terminal.putCharacter('\u2B1B');
					terminal.putCharacter(' ');
					y++;
				}
				if (key.getKind() == Key.Kind.Enter) {
					/* the user has hit down so we should check the tile here to see if it's revealed or not
					*/
				}
				//space moves it diagonally
				if (key.getCharacter() == ' ') {
					terminal.moveCursor(x,y);
					terminal.putCharacter(' ');
					y++;
					x++;
				}
				//flag button
				if (key.getCharacter() == 'f') {
					terminal.putCharacter('\u2691') ;
				}
				//pause button
				if (key.getCharacter() == 'P') {
				 mode++;
				 mode%=2;//2 modes
				 terminal.clearScreen();
				 lastSecond = System.currentTimeMillis();
				 long currentTime = System.currentTimeMillis();
			 }
			  putString(1,4,terminal,"["+key.getCharacter() +"]");
				putString(1,1,terminal,key+"        ");//to clear leftover letters pad withspaces
		 }

			//DO EVEN WHEN NO KEY PRESSED:
			long tEnd = System.currentTimeMillis();
			long millis = tEnd - tStart;
			putString(1,2,terminal,"This is Minesweeper!\n"+" _    _      _                          _ \n| |  | |    | |                        | |\n| |  | | ___| | ___ ___  _ __ ___   ___| |\n| |/\\| |/ _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\ |\n\\  /\\  /  __/ | (_| (_) | | | | | |  __/_|\n \\/  \\/ \\___|_|\\___\\___/|_| |_| |_|\\___(_)" ) ;
			putString(2,10, terminal,"Please enter which mode and level you would like by doing NE (Normal Mode - Easy), NH (Normal Mode - Hard), CE (Crazy Mode - Easy), or CH (Crazy Mode - Hard)") ;
			if(millis/1000 > lastSecond){
				lastSecond = millis / 1000;
				//one second has passed.
				putString(size.getRows()-1, size.getColumns()/2, terminal,"Seconds since start of program: "+lastSecond);
				// this line will place the time left on the bottom middle

			}
		}
	}
}
