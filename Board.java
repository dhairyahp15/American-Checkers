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
    boardState = new String[BOARD_SIZE][BOARD_SIZE]; // Initialized the boardState array same size as BOARD_SIZE - 8 x 8.

    // setting all the values of the array to empty.
    clearBoard();
  }

  // The following method draws the checkerboerd with white and gray checks wiht the provided size.
  public void drawBoard()
  {
    for(int i = 0; i < BOARD_SIZE; i++)
    {
      for(int j = 0; j < BOARD_SIZE; j++)
      {
        // this conditional statement checks whether to set color as light gray or white, depending on the row & column.
        if((i + j) % 2 == 0)
          StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        else  
          StdDraw.setPenColor(StdDraw.WHITE);
        // updating center for every checks so that it draws a column of checks for every row.
        double xC = (2 * j + 1)/(2.0 * BOARD_SIZE);
        double yC = (2 * i + 1)/(2.0 * BOARD_SIZE);   
        //drawing filled rectangle with the corresponding color of the pen.
        StdDraw.filledRectangle(xC, yC, TILE_RADIUS, TILE_RADIUS);
      }    
    }
    // These statements draws border lines at the edges of the checkerboard.
    StdDraw.line(0, 0, 1, 0);
    StdDraw.line(0, 0, 0, 1);
    StdDraw.line(0, 1, 1, 1);
    StdDraw.line(1, 1, 1, 0);
  }

  // This method draws a Tile in the row & column passed as a parameter, with given color and same radius as TILE_RADIUS.
  public void drawTile(int row, int col, String color)
  {
    // This should work only if the given String color is red or black.
    if(color.equalsIgnoreCase("RED") || color.equalsIgnoreCase("BLACK"))
    {
      // Scaling center of the tile using the given row and column.
      double xC = (2 * col + 1)/(2.0 * BOARD_SIZE);
      double yC = (2 * row + 1)/(2.0 * BOARD_SIZE);

      // following conditional checks the given color and sets the pen color respectively.
      if(color.equalsIgnoreCase("BLACK"))
        StdDraw.setPenColor(StdDraw.BLACK);
      else
        StdDraw.setPenColor(StdDraw.RED);
      // Drawing filled ellipse with the respective pen color and center.
      StdDraw.filledEllipse(xC, yC, TILE_RADIUS, TILE_RADIUS);
    }
  }

  // This method verifies if the tile is valid or not.
  public boolean isValidTile(int row, int col)
  {
    boolean isValid  = false;
    if((row + col) % 2 == 0)
      isValid = true;
    return isValid;
  }

  // This method clears the tiles on the board and stores the starting positon of the board in the boardState.
  public void resetBoard()
  {
    clearBoard(); // Clears the board.
    for(int i = 0; i < 3; i++)
    {
      for(int j = 0; j < BOARD_SIZE; j++)
      {
        if(isValidTile(i, j))
        {
          boardState[i][j] = red;
        }
      }
    } // Sets the red tiles to the starting positions.

    for(int i = BOARD_SIZE - 1; i >= BOARD_SIZE - 3; i--)
    {
      for(int j = 0; j < BOARD_SIZE; j++)
      {
        if(isValidTile(i, j))
        {
          boardState[i][j] = black;
        }
      }
    } // Sets the black tiles to the starting position.
  }

  // The following method draws the current state of the board.
  public void drawTiles()
  {
    for(int i = 0; i < BOARD_SIZE; i++)
    {
      for(int j = 0; j < BOARD_SIZE; j++)
      {
        drawTile(i, j, boardState[i][j]);// Using drawTile, current state of board is printed on the screen.
      }
    }
  }

  // This method is used to set Tile color to the given value and corresponding row and column.
  public void setTile(int row, int col, String value)
  {
    boardState[row][col] = value;
  }

  // ClearBoard() method clears the state of board, i.e. set all the values of boardState to empty.
  public void clearBoard()
  {
    boardState = new String[BOARD_SIZE][BOARD_SIZE];
    for(int i = 0; i < BOARD_SIZE; i++)
    {
      for(int j = 0; j < BOARD_SIZE; j++)
      {
        boardState[i][j] = empty; // setting all the values to the empty state.
      }
    }
  } 

}//Chessboard
