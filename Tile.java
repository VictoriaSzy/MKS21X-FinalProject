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
    visible, flagged = false ;
  }

  // Accessors Methods
  public boolean isBomb() {
    return hasBomb ;
  }
  public boolean isVisble() {
    return visible ;
  }
  public boolean isFlagged() {
    return flagged ;
  }
  public String getIdentifier() {
    return identifier ;
  }
  public int numberOfBombsAround(){
    //not implemented yet
  }

  // Mutator Methods
  public void setIdentifier(String n){
}
//action methods
  public void flag(){
  }

  public void unflag(){
  }

  public void reveal(){
  }

  public void blowUpNormal(){
  }

  public void blowUpCrazy(){
  }
