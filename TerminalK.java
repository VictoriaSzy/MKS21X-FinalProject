

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


public class TerminalK {

	public static void putString(int r, int c,Terminal t, String s){
		t.moveCursor(r,c);
		for(int i = 0; i < s.length();i++){
			t.putCharacter(s.charAt(i));
		}
	}
	public static void main(String[] args) {

		int x = 10 ;
		int y = 10 ;

		Terminal terminal = TerminalFacade.createTextTerminal();
		terminal.enterPrivateMode();
		TerminalSize size = terminal.getTerminalSize();
		terminal.setCursorVisible(false);
		boolean running = true;
		// Time vars:
		long tStart = System.currentTimeMillis();
		long lastSecond = 0 ;

		Board game = new Board("Normal","Easy") ; // just for testing purposes
		while(running){

			terminal.moveCursor(x,y) ;
      terminal.applyForegroundColor(Terminal.Color.RED) ;
      terminal.putCharacter('\u25A1') ; // this is a small white square character
			// this is the character of the cursor
      terminal.applyBackgroundColor(Terminal.Color.DEFAULT) ;
      terminal.applyForegroundColor(Terminal.Color.DEFAULT) ;
      terminal.applySGR(Terminal.SGR.RESET_ALL) ;

      Key key = terminal.readInput();

			/* This part will create the tiles
			terminal.moveCursor(size.getColumns()/2,size.getRows()/2) ;
			terminal.applyBackgroundColor(Terminal.Color.WHITE);
			terminal.applyForegroundColor(Terminal.Color.BLACK);
			// these are the colors used on the cursor
			//applySGR(a,b) for multiple modifiers (bold,blink) etc.
			terminal.applySGR(Terminal.SGR.ENTER_UNDERLINE);
			terminal.putCharacter('\u2691') ; // this is the character of the cursor that moves based on the keyboard keys
			//terminal.putCharacter(' ');
			terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
			terminal.applyForegroundColor(Terminal.Color.DEFAULT);
			terminal.applySGR(Terminal.SGR.RESET_ALL);
			// brings the terminal's colors back to normal when the cursor has left*/


			terminal.moveCursor(size.getColumns()-5,5) ;
			// This section colored the background of the terminal to red and placed the character on the upper right corner of the
			// red section
			/*terminal.applyBackgroundColor(Terminal.Color.RED);
			terminal.applyForegroundColor(Terminal.Color.YELLOW);
			terminal.applySGR(Terminal.SGR.ENTER_BOLD);
			terminal.putCharacter(' ');
			terminal.putCharacter(' ');
			terminal.putCharacter('\u262d');
			terminal.putCharacter(' ');
			terminal.moveCursor(size.getColumns()-5,6);
			terminal.putCharacter(' ');
			terminal.putCharacter(' ');
			terminal.putCharacter(' ');
			terminal.putCharacter(' ');
			terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
			terminal.applyForegroundColor(Terminal.Color.DEFAULT); */

			if (key != null) {
				if (key.getKind() == Key.Kind.Escape) {
					terminal.exitPrivateMode();
					running = false;
				}
				if (key.getKind() == Key.Kind.ArrowLeft) {
					terminal.moveCursor(x,y) ;
					terminal.putCharacter(' ') ;
					x-- ;
				}
				if (key.getKind() == Key.Kind.ArrowRight) {
					terminal.moveCursor(x,y) ;
					terminal.putCharacter(' ') ;
					x++ ;
				}
				if (key.getKind() == Key.Kind.ArrowUp) {
					terminal.moveCursor(x,y) ;
					terminal.putCharacter(' ') ;
					y-- ;
				}
				if (key.getKind() == Key.Kind.ArrowDown) {
					terminal.moveCursor(x,y) ;
					terminal.putCharacter(' ') ;
					y++ ;
				}
				//space moves it diagonally
				if (key.getCharacter() == ' ') {
					terminal.moveCursor(x,y) ;
					terminal.putCharacter(' ') ;
					y++ ;
					x++ ;
				}
				putString(1,4,terminal,"["+key.getCharacter() +"]");
				// in the brackets is the single character representing the key
				putString(1,1,terminal,key+"        ");
				//to clear leftover letters pad withspaces
			}
			// After we check whether the key is null or not
			//DO EVEN WHEN NO KEY PRESSED:
			long tEnd = System.currentTimeMillis() ;
			long millis = tEnd - tStart ;
			putString(1,2,terminal,"Milliseconds since start of program: "+millis) ;
			if(millis/1000 > lastSecond){
				lastSecond = millis / 1000 ;
				//one second has passed.
				putString(1,3,terminal,"Seconds since start of program: "+lastSecond) ;
			}

		}
	}
}
