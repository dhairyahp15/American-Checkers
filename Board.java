/*
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
        double xC = (2 * j + 1)/(2.0 * BOARD_SIZE); // center x coordinate of corresponding tile.
        double yC = (2 * i + 1)/(2.0 * BOARD_SIZE); // center x coordinate of corresponding tile.
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
      // Scaling center of the tile using the given row and column.
    double xC = (2 * col + 1)/(2.0 * BOARD_SIZE); // center x coordinate of corresponding tile.
    double yC = (2 * row + 1)/(2.0 * BOARD_SIZE); // center x coordinate of corresponding tile.
    // This should work only if the given String color is red or black.
    if(color.equalsIgnoreCase(red) || color.equalsIgnoreCase(black))
    {
      // following conditional checks the given color and sets the pen color respectively.
      if(color.equalsIgnoreCase(black))
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
    boolean isValid  = false; // boolean variable that is to be returned for valid tile as true or false.
    if((row + col) % 2 == 0)
      isValid = true;
    return isValid;
  }

  // This method clears the tiles on the board and stores the starting positon of the board in the boardState.
  public void resetBoard()
  {
    clearBoard(); // Clears the board.
    for(int i = 0; i < 3; i++) // for loop for first 3 rows, to be filled with red tiles.
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
      for(int j = 0; j < BOARD_SIZE; j++) // for loop for last 3 rows, to be filled with black tiles.
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
    // creating new instance for boardState and setting all values to empty.
    boardState = new String[BOARD_SIZE][BOARD_SIZE];
    for(int i = 0; i < BOARD_SIZE; i++)
    {
      for(int j = 0; j < BOARD_SIZE; j++)
      {
        boardState[i][j] = empty; // setting all the values to the empty state.
      }
    }
  } 

  // This method returns the color of the corresponding row and column. 
  public String getTileColor(int row, int col)
  {
    return boardState[row][col];
  } 

  public void drawSelectedTile(int row, int col)
  {
    double xC = (2 * col + 1)/(2.0 * BOARD_SIZE); // center x coordinate of corresponding tile.
    double yC = (2 * row + 1)/(2.0 * BOARD_SIZE); // center y coordinate of corresponding tile.
    StdDraw.setPenColor(StdDraw.GREEN);
    StdDraw.ellipse(xC, yC, TILE_RADIUS, TILE_RADIUS);
  } // This method draws green circle around the selected tile, to let the user know which tile is selected

  /* This method is used to count the number of tiles of the given color left
  to decide the winner of the game. */
  public int countTiles(String color)
  {
    int count = 0; // count variable to be increased when corresponding color found.
    for(int i = 0; i < BOARD_SIZE; i++) // looping through whole boardState.
    {
      for(int j = 0; j < BOARD_SIZE; j++)
      {
        if(boardState[i][j].equalsIgnoreCase(color))
          count++;
      }
    }
    return count;
  }

  /* This method checks wheter the move is valid or not, i.e. it is 
  moving diagonally and only in the gray tiles as well as if there is 
  enemy in the diagonal, it should move 2 steps diagonally. */
  public boolean isValidMove(int startRow, int startCol, int endRow, int endCol, String color)
  {
    boolean isValidMove = false; // boolean variable that is supposed to be returned as valid move or not
    // if the ending tile is valid and empty.
    if(isValidTile(endRow, endCol)) 
    {
      if(boardState[endRow][endCol].equals(empty))
      {
        if(color.equals(red)) // logic for red color tiles
        {
          if(endRow - startRow == 1 && (endCol - startCol == 1 || startCol - endCol == 1))
            isValidMove = true;
          else if(endRow - startRow == 2 && (endCol - startCol == 2 || startCol - endCol == 2))
          {
             if(endCol > 0 && ((boardState[endRow - 1][endCol - 1].equals(black)) || (boardState[endRow - 1][endCol + 1].equals(black))))
              isValidMove = true;
            else if(boardState[endRow - 1][endCol + 1].equals(black))
              isValidMove = true;
          }
          else
            isValidMove = false;
      }

      if(color.equals(black)) // logic for black color tiles
      {
          if(startRow - endRow == 1 && (endCol - startCol == 1 || startCol - endCol == 1))
             isValidMove = true;
          else if(startRow - endRow == 2 && (endCol - startCol == 2 || startCol - endCol == 2))
          {
            if(endCol > 0 && ((boardState[endRow + 1][endCol - 1].equals(red)) || (boardState[endRow + 1][endCol + 1].equals(red))))
              isValidMove = true;
            else if(boardState[endRow + 1][endCol + 1].equals(red))
              isValidMove = true;

          }
          else
            isValidMove = false;
        }
      }
      else // if the end tile is not empty then it is not a valid move.
        isValidMove = false;
    }
    return isValidMove; // returns the boolean for valid move or not
  }

  /* This method is used to apply the move, i.e. move the tile to the given
  end row and end col which is to be used in GameController, it will also
  check for isValidMove, so we do not have to check for isValidMove here.*/ 
  public void applyMove(int startRow, int startCol, int endRow, int endCol)
  {
    if(isValidTile(endRow, endCol)) // if endRow and endCol is gray tile.
    {
      // condition for red color tile.
      if(boardState[startRow][startCol].equals(red))
      {
        // swapping and capturing logic of tile from startRow startCol to endRow endCol.
        if(endRow - startRow == 1 && (endCol - startCol == 1 || startCol - endCol == 1))
        {
          boardState[endRow][endCol] = boardState[startRow][startCol];
          boardState[startRow][startCol] = empty;
        }
        else
        {
          boardState[endRow][endCol] = boardState[startRow][startCol];
          boardState[startRow][startCol] = empty;
          if(endRow - startRow == 2 && endCol - startCol == -2)
              boardState[endRow - 1][endCol + 1] = empty;
          else if(endRow - startRow == 2 && endCol - startCol == 2)
              boardState[endRow - 1][endCol - 1] = empty;
        }
      }
      else // else part for black color tile.
      {
        // swapping and capturing logic of tile from startRow startCol to endRow endCol.
        if(startRow - endRow == 1 && (endCol - startCol == 1 || startCol - endCol == 1))
        {
          boardState[endRow][endCol] = boardState[startRow][startCol];
          boardState[startRow][startCol] = empty;
        }
        else
        {
          boardState[endRow][endCol] = boardState[startRow][startCol];
          boardState[startRow][startCol] = empty;
          if(startRow - endRow == 2 && endCol - startCol == -2)
              boardState[endRow + 1][endCol + 1] = empty;
          else if(startRow - endRow == 2 && endCol - startCol == 2)
              boardState[endRow + 1][endCol - 1] = empty;
        }
      }
    }
  }
} //Chessboard
