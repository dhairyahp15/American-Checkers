/**
 * Checkers game base framework. 
 */
public class Board {
  
    // board size - square tiles
  // Size of the board (per size) in units
  public static final int BOARD_SIZE = 8;
  // the proportion of a tile (mostly used for mouse input)
  public static final double BOARD_PROPORTION = 1.0 / (double)BOARD_SIZE;
  // the radius of an individual tile. 
  private static final double TILE_RADIUS = 0.5/BOARD_SIZE;

  // Helper variables that can be used to set the color easily
  public static final String red = "RED";
  public static final String black = "BLACK";
  public static final String empty = "EMPTY";

  // The state of the board
  public String[][] boardState;

  // Initialize the board state 
  // Set all values of array to Empty
  // Phase 1
  public Board(){
    // Add your code here .... 
  }


}//Chessboard
