public class Tile {
  // Variables are here:
  private boolean hasBomb, visible, flagged ;
  private String identifier ;

  /** Constructor
    *@param isABomb is a boolean that will determine whether the tile being created is going to become a bomb, which requires hasBomb to be true
    */
  public Tile(boolean isABomb) {
    if (isABomb) {
      hasBomb = true ;
      identifier = "*" ;
    }
    else {
      hasBomb = false ;
      identifier = "0" ;
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
  public String getIdentifier() {
    return identifier ;
  }
  // Mutator Methods
  public void setIdentifier(String n){
    identifier = n;
  }
  public void setVisible(boolean parameter) {
    visible = parameter ;
  }
  public void setFlagged(boolean parameter) {
    flagged = parameter ;
  }

  //action methods
  public int numberOfBombsAround(Tile n){
    int result = 0;
    for(int r=0; r < layout.length; r++){
      for(int c=0; c < layout.length; c++){
        if(r == 0 && c == 0){
          if(layout[1][0].getIdentifier().equals("*")){
            result = result + 1;
          }
          if(layout[1][1].getIdentifier().equals("*")){
            result = result + 1;
          }
          if(layout[0][1].getIdentifier().equals("*")){
            result = result + 1;
          }
        }
      }
    }
  }
  public void flag() {

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
