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
  public static void phase1(){
    Board b = new Board();
    // testing out all the instance methods created.
    System.out.println("Drawing Board, and tile at [0][0] & [7][7].");
    b.drawBoard();
    b.drawTile(0, 0, Board.red);
    b.drawTile(7, 7, Board.black);
  }

  // Should be the board set up with tiles 
  // Note this is just drawing them, it is not setup. 
  public static void phase2(){
    Board b = new Board();

    b.resetBoard();
    System.out.println("Tile at row -> 1, and column -> 3 is Valid: " + b.isValidTile(1, 3));

  }

  // This includes using a Board state that can be stored and updated. 
  public static void phase3(){
  	// default board
    Board b = new Board();
    System.out.println("Resetting board and drawing Tiles to the default position.");
    b.resetBoard();
    b.drawBoard();
    b.drawTiles();
    StdDraw.show(1000); // Draw all art and pause for 1 second

    b = new Board();
    System.out.println("Initializing board again and using setTile to set tiles and drawTiles to draw on the board.");
    b.setTile(0,2,"RED");
    b.setTile(7,5,"BLACK");
    b.drawBoard();
    b.drawTiles();
    StdDraw.show(1000); // Draw all art and pause for 1 second
    System.out.println("Cleared Board using clearBoard():");
    b.clearBoard();
    b.drawBoard();
    b.drawTiles();
    StdDraw.show(1000); // Draw all art and pause for 1 second
    // Make sure it is being done correctly. 
  }

  public static void phase4()
  {
    Board b = new Board();
    //b.clearBoard();
    b.drawBoard();
    b.resetBoard();
    b.drawTiles();
    System.out.println("Tile at row -> 0, and column -> 0 is: "+b.getTileColor(0, 0));
    System.out.println("Tile at row -> 4, and column -> 4 is: "+b.getTileColor(4, 4));
    System.out.println("Drawing selected tile [7][7] using draw selected method:" );
    b.drawSelectedTile(7, 7);
    System.out.println("Total number of Black tiles: "+b.countTiles("BLACK"));
  }
  
  public static void phase5()
  {
    Board b = new Board();
    b.drawBoard();
    b.resetBoard();
    b.drawTiles();
    System.out.print("Moving red Tile to one of the White check on the board, ");
    System.out.println("isValidMove - " + b.isValidMove(2, 0, 3, 0, "RED"));
    b.applyMove(2, 0, 3, 0);
    b.drawBoard();
    b.drawTiles();
    StdDraw.show(1000); // Draw all art and pause for 1 second
    System.out.print("Moving black Tile to one of the White check on the board, ");
    System.out.println("isValidMove - " + b.isValidMove(5, 1, 4, 0, "BLACK"));
    b.applyMove(5, 1, 4, 0);
    b.drawBoard();
    b.drawTiles();
    StdDraw.show(1000); // Draw all art and pause for 1 second
  }
  
}