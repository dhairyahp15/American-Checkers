// This class is for testing A2 (Checkers Game) phases 1-3
public class TestClassA2{
	
	// Note: You should add additional testing for P1-3 and also add tests for phase 4 and 5

  public static void main(String[] args){
    System.out.println("-------| PHASE 1 TESTS |------");
  	phase1();
    StdDraw.show(1000);  // Draw all art and pause for 1 second
    System.out.println("\n-------| PHASE 2 TESTS |------");
  	phase2();
    StdDraw.show(1000); // Draw all art and pause for 1 second
    System.out.println("\n-------| PHASE 3 TESTS |------");
    phase3();
    StdDraw.show(1000); // Draw all art and pause for 1 second
    System.out.println("\n-------| PHASE 4 TESTS |------");
    phase4();
    StdDraw.show(1000); // Draw all art and pause for 1 second
    System.out.println("\n-------| PHASE 5 TESTS |------");
    phase5();
    StdDraw.show(1000); // Draw all art and pause for 1 second
    
  }

  // Should be a board with one red and one black tile in the corners (see images. )
  // Phase 1 tests.
  public static void phase1(){
    Board b = new Board();
    // testing out all the instance methods created.
    System.out.println("Drawing Board, and tile at [0][0] & [7][7].");
    b.drawBoard(); // draws empty board.
    b.drawTile(0, 0, Board.red); // drwaing tile at 0,0.
    b.drawTile(7, 7, Board.black);// drawing tile at 7,7.
  }
 
  public static void phase2(){
    Board b = new Board(); // new Board instance.

    b.resetBoard(); // resetBoard() method sets every tile to its initial position.
    // Drawing board and tiles to see the current state of the board.
    b.drawBoard();
    b.drawTiles();
    // Testing isValidTile().
    System.out.println("Tile at row -> 1, and column -> 3 is Valid: " + b.isValidTile(1, 3));
  }

  // Phase 3 tests.
  public static void phase3(){
  	// default board
    Board b = new Board(); // new Board instance
    System.out.println("Resetting board and drawing Tiles to the default position.");
    b.resetBoard(); // resets every tiles to default position.
    b.drawBoard();
    b.drawTiles(); // drawing current position of tiles on the board.
    StdDraw.show(1000); // Draw all art and pause for 1 second

    b = new Board(); // again initializing Board instance.
    // Testing all other mthods fir phase 3.
    System.out.println("Initializing board again and using setTile to set tiles and drawTiles to draw on the board.");
    b.setTile(0,2,"RED"); // setting red tile to 0,2. If valid.
    b.setTile(7,5,"BLACK"); // setting black tile to 7,5. If valid.
    // drawing blank board and then drawing current position of tiles to see the changes.
    b.drawBoard(); 
    b.drawTiles();
    StdDraw.show(1000); // Draw all art and pause for 1 second
    System.out.println("Cleared Board using clearBoard():");
    // Testing clearBoard() method.
    b.clearBoard();
    b.drawBoard();
    b.drawTiles();
    StdDraw.show(1000); // Draw all art and pause for 1 second
    // Make sure it is being done correctly. 
  }

  // Phase 4 tests.
  public static void phase4()
  {
    Board b = new Board(); // new Board instance.
    //b.clearBoard();
    b.drawBoard();
    b.resetBoard();
    b.drawTiles();
    // testing out all phase 4 methods using print statements. 
    System.out.println("Tile at row -> 0, and column -> 0 is: "+b.getTileColor(0, 0));
    System.out.println("Tile at row -> 4, and column -> 4 is: "+b.getTileColor(4, 4));
    System.out.println("Drawing selected tile [7][7] using draw selected method:" );
    b.drawSelectedTile(7, 7); // this will draw green circle around the selected tile.
    System.out.println("Total number of Black tiles: "+b.countTiles("BLACK"));
  }
  
  // phase 5 tests.
  public static void phase5()
  {
    Board b = new Board(); // new Board instance
    b.drawBoard();
    b.resetBoard();
    b.drawTiles();
    // Testing out all the methods for phase 5. 
    System.out.print("Moving red Tile to one of the White check on the board, ");
    System.out.println("isValidMove - " + b.isValidMove(2, 0, 3, 0, "RED"));
    b.applyMove(2, 0, 3, 0); // This will apply move if it is valid.
    // Drawing board and tiles again to see the changes.
    b.drawBoard();
    b.drawTiles();
    StdDraw.show(1000); // Draw all art and pause for 1 second
    System.out.print("Moving black Tile to one of the White check on the board, ");
    System.out.println("isValidMove - " + b.isValidMove(5, 1, 4, 0, "BLACK"));
    b.applyMove(5, 1, 4, 0); // This will apply move if it is valid.
    // Drawing board and tiles again to see the changes.
    b.drawBoard();
    b.drawTiles();
    StdDraw.show(1000); // Draw all art and pause for 1 second
  }
  
}