// This class is for testing A2 (Checkers Game) phases 1-3
public class TestClassA2{
	
	// Note: You should add additional testing for P1-3 and also add tests for phase 4 and 5

  public static void main(String[] args){
  	phase1();
  	StdDraw.show(1000);  // Draw all art and pause for 1 second
  //	phase2();
  	StdDraw.show(1000); // Draw all art and pause for 1 second
  //	phase3();
  }

  // Should be a board with one red and one black tile in the corners (see images. )
  public static void phase1(){
    Board b = new Board();
    // testing out all the instance methods created.
    b.drawBoard();
    //b.drawTile(0, 0, Board.red);
    //b.drawTile(7, 7, Board.black);
    b.resetBoard();
    b.drawTiles();
    //b.clearBoard();
    b.setTile(4, 6, Board.black);
    b.drawTiles();
  }
/*
  // Should be the board set up with tiles 
  // Note this is just drawing them, it is not setup. 
  public static void phase2(){
    Board b = new Board();

    b.resetBoard();

  }

  // This includes using a Board state that can be stored and updated. 
  public static void phase3(){
  	// default board
    Board b = new Board();
    b.resetBoard();
    b.drawBoard();
    b.drawTiles();
    StdDraw.show(1000);

    b = new Board();
    b.setTile(0,0,"RED");
    b.setTile(7,7,"BLACK");
    b.drawBoard();
    b.drawTiles();
    StdDraw.show(1000);
    // Make sure it is being done correctly. 
  }
  */
}