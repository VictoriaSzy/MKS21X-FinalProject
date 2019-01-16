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

import java.util.* ;
import java.io.* ;

public class Main {
	// So this part places a string onto the terminal screen
	public static void putString(int r, int c,Terminal t, String s){
		t.moveCursor(r,c);
		for(int i = 0; i < s.length();i++){
			t.putCharacter(s.charAt(i)) ;
		}
	}
	///////////////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		String directions = "To begin, make sure that you have downloaded all of the required files. \nFrom there, enter the directory containing the files." ;
		directions += "\nCompile all of the required .java files by doing javac FileName.java, except for Main.java which will be compiled using \"javac -cp lanterna.jar:. Main.java\"";
		directions += "\nTo run the program, you must type in valid and appropriate parameters after \"java -cp lanterna.jar:. Main\"\n" ;
		directions += "Here are your options:\n\"NE\" results in Normal Mode, but the level is easy with a board of size 5x5 and between 3 to 6 bombs." ;
		directions += "\n\"NH\" results in Normal Mode, but the level is hard with a board of size 8x8 and between 6 to 12 bombs." ;
		directions += "\n\"CE\" results in Crazy Mode, but the level is easy with a board of size 8x8 and between 10 to 20 bombs, which YOU MUST FIND IN ORDER TO WIN. You have 2 chances to click normal tiles, but after that, you lose!" ;
		directions += "\n\"CH\" results in Crazy Mode, but the level is hard with a board of size 10x10 and between 5 to 10 bombs, which YOU MUST FIND IN ORDER TO WIN. You can only click on a tile accidentally once! After that, you're done!" ;
		try {
			String modeS = "" ;
			String levelS = "" ;
			if (args[0].equals("NE")) {
				modeS = "Normal" ;
				levelS = "Easy" ;
			}
			if (args[0].equals("NH")) {
				modeS = "Normal" ;
				levelS = "Hard" ;
			}
			if (args[0].equals("CE")) {
				modeS = "Crazy" ;
				levelS = "Easy" ;
			}
			if (args[0].equals("CH")) {
				modeS = "Crazy" ;
				levelS = "Hard" ;
			}

			int x = 10 ;
			int y = 10 ;

			Terminal terminal = TerminalFacade.createTerminal() ;
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

			// Normal easy mode!

			while(running){
				terminal.moveCursor(x,y); // we can also do terminal.setCursorPosition(x,y) ;
				// moveCursor(..) places the cursor somewhere else after writing something until the end of the row
				terminal.applyBackgroundColor(Terminal.Color.BLUE);
				terminal.applyForegroundColor(Terminal.Color.WHITE);
				// Examples of other colors: BLACK, RED,GREEN,YELLOW,BLUE,MAGENTA,CYAN,WHITE,DEFAULT (depends on user)
				//applySGR(a,b) for multiple modifiers (bold,blink) etc.
				terminal.applySGR(Terminal.SGR.ENTER_UNDERLINE);
				terminal.putCharacter('\u25A1'); // this is a white square = cursor, helps you see where you are as you move with the keys
				// I got this Unicode character from https://www.fileformat.info/info/unicode/char/2b1b/index.htm along with the flag
				//terminal.putCharacter(' ');
				terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
				terminal.applyForegroundColor(Terminal.Color.DEFAULT);
				terminal.applySGR(Terminal.SGR.RESET_ALL);

				// This is the part that changed the background of the right side to red
				/*terminal.moveCursor(size.getColumns() - 5, 5);
				terminal.applyBackgroundColor(Terminal.Color.RED);
				terminal.applyForegroundColor(Terminal.Color.YELLOW);
				terminal.applySGR(Terminal.SGR.ENTER_BOLD);
				terminal.putCharacter(' ');
				terminal.putCharacter(' ');
				//terminal.putCharacter('\u2691'); // this is the little image on the right hand side & testing the flag character
				terminal.putCharacter(' ');
				*/
				terminal.moveCursor(size.getColumns()-5,6);
				for (int i = 0 ; i < 4; i++) {
					terminal.putCharacter(' ');
				}
				terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
				terminal.applyForegroundColor(Terminal.Color.DEFAULT);

				if (args[0].equals("NE")) {
					terminal.moveCursor((size.getColumns()/2) - 2,size.getRows()/2);
					for (int i = 0; i < 5; i++) {
						terminal.putCharacter('\u2B1B');
					}
					terminal.moveCursor((size.getColumns()/2) - 2,(size.getRows()/2) + 1);
					for (int i = 0; i < 5; i++) {
						terminal.putCharacter('\u2B1B');
					}
					terminal.moveCursor((size.getColumns()/2) - 2,(size.getRows()/2) + 2);
					for (int i = 0; i < 5; i++) {
						terminal.putCharacter('\u2B1B');
					}
					terminal.moveCursor((size.getColumns()/2) - 2,(size.getRows()/2) + 3);
					for (int i = 0; i < 5; i++) {
						terminal.putCharacter('\u2B1B');
					}
					terminal.moveCursor((size.getColumns()/2) - 2,(size.getRows()/2) + 4);
					for (int i = 0; i < 5; i++) {
						terminal.putCharacter('\u2B1B');
					}
				}
				//Normal Hard Mode
				if (args[0].equals("NH")) {
					terminal.moveCursor((size.getColumns()/2) - 4,size.getRows()/2);
					for (int i = 0; i < 8; i++) {
						terminal.putCharacter('\u2B1B');
					}
					terminal.moveCursor((size.getColumns()/2) - 4,(size.getRows()/2) + 1);
					for (int i = 0; i < 8; i++) {
						terminal.putCharacter('\u2B1B');
					}
					terminal.moveCursor((size.getColumns()/2) - 4,(size.getRows()/2) + 2);
					for (int i = 0; i < 8; i++) {
						terminal.putCharacter('\u2B1B');
					}
					terminal.moveCursor((size.getColumns()/2) - 4,(size.getRows()/2) + 3);
					for (int i = 0; i < 8; i++) {
						terminal.putCharacter('\u2B1B');
					}
					terminal.moveCursor((size.getColumns()/2) - 4,(size.getRows()/2) + 4);
					for (int i = 0; i < 8; i++) {
						terminal.putCharacter('\u2B1B');
					}
					terminal.moveCursor((size.getColumns()/2) - 4,(size.getRows()/2) + 5);
					for (int i = 0; i < 8; i++) {
						terminal.putCharacter('\u2B1B');
					}
					terminal.moveCursor((size.getColumns()/2) - 4,(size.getRows()/2) + 6);
					for (int i = 0; i < 8; i++) {
						terminal.putCharacter('\u2B1B');
					}
					terminal.moveCursor((size.getColumns()/2) - 4,(size.getRows()/2) + 7);
					for (int i = 0; i < 8; i++) {
						terminal.putCharacter('\u2B1B');
					}
				}

				//Crazy easy mode
				if (args[0].equals("CE")) {
					terminal.moveCursor((size.getColumns()/2) - 4,size.getRows()/2);
					for (int i = 0; i < 8; i++) {
						terminal.putCharacter('\u2B1B');
					}
					terminal.moveCursor((size.getColumns()/2) - 4,(size.getRows()/2) + 1);
					for (int i = 0; i < 8; i++) {
						terminal.putCharacter('\u2B1B');
					}
					terminal.moveCursor((size.getColumns()/2) - 4,(size.getRows()/2) + 2);
					for (int i = 0; i < 8; i++) {
						terminal.putCharacter('\u2B1B');
					}
					terminal.moveCursor((size.getColumns()/2) - 4,(size.getRows()/2) + 3);
					for (int i = 0; i < 8; i++) {
						terminal.putCharacter('\u2B1B');
					}
					terminal.moveCursor((size.getColumns()/2) - 4,(size.getRows()/2) + 4);
					for (int i = 0; i < 8; i++) {
						terminal.putCharacter('\u2B1B');
					}
					terminal.moveCursor((size.getColumns()/2) - 4,(size.getRows()/2) + 5);
					for (int i = 0; i < 8; i++) {
						terminal.putCharacter('\u2B1B');
					}
					terminal.moveCursor((size.getColumns()/2) - 4,(size.getRows()/2) + 6);
					for (int i = 0; i < 8; i++) {
						terminal.putCharacter('\u2B1B');
					}
					terminal.moveCursor((size.getColumns()/2) - 4,(size.getRows()/2) + 7);
					for (int i = 0; i < 8; i++) {
						terminal.putCharacter('\u2B1B');
					}
				}

				//Crazy Hard mode
				if (args[0].equals("CH")) {
					terminal.moveCursor((size.getColumns()/2) - 5,size.getRows()/2);
					for (int i = 0; i < 10; i++) {
						terminal.putCharacter('\u2B1B');
					}
					terminal.moveCursor((size.getColumns()/2) - 5,(size.getRows()/2) + 1);
					for (int i = 0; i < 10; i++) {
						terminal.putCharacter('\u2B1B');
					}
					terminal.moveCursor((size.getColumns()/2) - 5,(size.getRows()/2) + 2);
					for (int i = 0; i < 10; i++) {
						terminal.putCharacter('\u2B1B');
					}
					terminal.moveCursor((size.getColumns()/2) - 5,(size.getRows()/2) + 3);
					for (int i = 0; i < 10; i++) {
						terminal.putCharacter('\u2B1B');
					}
					terminal.moveCursor((size.getColumns()/2) - 5,(size.getRows()/2) + 4);
					for (int i = 0; i < 10; i++) {
						terminal.putCharacter('\u2B1B');
					}
					terminal.moveCursor((size.getColumns()/2) - 5,(size.getRows()/2) + 5);
					for (int i = 0; i < 10; i++) {
						terminal.putCharacter('\u2B1B');
					}
					terminal.moveCursor((size.getColumns()/2) - 5,(size.getRows()/2) + 6);
					for (int i = 0; i < 10; i++) {
						terminal.putCharacter('\u2B1B');
					}
					terminal.moveCursor((size.getColumns()/2) - 5,(size.getRows()/2) + 7);
					for (int i = 0; i < 10; i++) {
						terminal.putCharacter('\u2B1B');
					}
					terminal.moveCursor((size.getColumns()/2) - 5,(size.getRows()/2) + 8);
					for (int i = 0; i < 10; i++) {
						terminal.putCharacter('\u2B1B');
					}
					terminal.moveCursor((size.getColumns()/2) - 5,(size.getRows()/2) + 9);
					for (int i = 0; i < 10; i++) {
						terminal.putCharacter('\u2B1B');
					}
				}

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
						//the user has hit down so we should check the tile here to see if it's revealed or not
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
						terminal.moveCursor(x,y);
						terminal.putCharacter('\u2691') ;
						terminal.putCharacter(' ');
						x++;
					}
					//pause button
					if (key.getCharacter() == 'P') {
					 mode++;
					 mode%=2;//2 modes
					 terminal.clearScreen();
					 lastSecond = System.currentTimeMillis();
					 long currentTime = System.currentTimeMillis();
				 }
			 }

				//DO EVEN WHEN NO KEY PRESSED:
				long tEnd = System.currentTimeMillis();
				long millis = tEnd - tStart;
				putString(1,2,terminal, "_    _      _                          _ \n| |  | |    | |                        | |\n| |  | | ___| | ___ ___  _ __ ___   ___| |\n| |/\\| |/ _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\ |\n\\  /\\  /  __/ | (_| (_) | | | | | |  __/_|\n \\/  \\/ \\___|_|\\___\\___/|_| |_| |_|\\___(_)" ) ;
				//putString(2,10, terminal,"Please enter which mode and level you would like by doing NE (Normal Mode - Easy), NH (Normal Mode - Hard), CE (Crazy Mode - Easy), or CH (Crazy Mode - Hard)") ;
				if(millis/1000 > lastSecond){
					lastSecond = millis / 1000;
					//one second has passed.
					putString(size.getRows()-1, size.getColumns()/2, terminal,"Seconds since start of program: "+lastSecond);
					// this line will place the time left on the bottom middle
				}
			}
		} catch (Exception e) {
			System.out.println("Are you sure that you read the instructions to this program?\nThere seems to be an error with what you gave us. \nHere are the directions to help you play our awesome version of Minesweeper:") ;
			System.out.println(directions) ;
			System.exit(1) ;
		}
	}
}
