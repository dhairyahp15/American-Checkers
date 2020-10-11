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
    drawBoard();
  }

  public void drawBoard()
  {
    for(int i = 0; i < BOARD_SIZE; i++)
    {
      for(int j = 0; j < BOARD_SIZE; j++)
      {
        if((i + j) % 2 == 0)
          StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        else  
          StdDraw.setPenColor(StdDraw.WHITE);
        double xC = (2 * i + 1)/(2.0 * BOARD_SIZE);
        double yC = (2 * j + 1)/(2.0 * BOARD_SIZE);

        StdDraw.filledRectangle(xC, yC, TILE_RADIUS, TILE_RADIUS);
      }    
    }
    StdDraw.line(0, 0, 1, 0);
    StdDraw.line(0, 0, 0, 1);
    StdDraw.line(0, 1, 1, 1);
    StdDraw.line(1, 1, 1, 0);
  }

  public void drawTile(int row, int col, String color)
  {
    if(color.equalsIgnoreCase("RED") || color.equalsIgnoreCase("BLACK"))
    {
      double xC = (2 * row + 1)/(2.0 * BOARD_SIZE);
      double yC = (2 * col + 1)/(2.0 * BOARD_SIZE);
      if(color.equalsIgnoreCase("BLACK"))
        StdDraw.setPenColor(StdDraw.BLACK);
      else
        StdDraw.setPenColor(StdDraw.RED);
      StdDraw.filledEllipse(xC, yC, TILE_RADIUS, TILE_RADIUS);
    }
  }

  

}//Chessboard
