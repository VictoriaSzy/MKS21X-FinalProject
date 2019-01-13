public class Tile {
  // Variables are here:
  private boolean hasBomb, visible, flagged ;
  private char identifier ;
  private int number ;

  /** Constructor
    *@param isABomb is a boolean that will determine whether the tile being created is going to become a bomb, which requires hasBomb to be true
    */
  public Tile(boolean isABomb) {
    if (isABomb) {
      hasBomb = true ;
      identifier = '*' ;
    }
    else {
      hasBomb = false ;
      identifier = '0' ;
    }
    visible = false ;
    flagged = false ;
  }

  // Accessors Methods
  public boolean isBomb() {
    return hasBomb ;
  }
  public boolean isVisible() {
    return visible ;
  }
  public boolean isFlagged() {
    return flagged ;
  }
  public char getIdentifier() {
    return identifier ;
  }
  public int getNumber() {
    return number ;
  }

  // Mutator Methods
  public void setIdentifier(char n){
    identifier = n;
  }
  public void setVisible(boolean parameter) {
    visible = parameter ;
  }
  public void setFlagged(boolean parameter) {
    flagged = parameter ;
  }
  public void setNumber(int i) {
    number = i ;
  }

  // Action methods
  public void flag() {
    identifier = '\u2691' ;
  }
  public void unflag() {

  }
  public void reveal() {

  }
  public void blowUpNormal() {

  }
  public void blowUpCrazy() {

  }

}
