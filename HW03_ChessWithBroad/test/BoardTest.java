import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {

  ChessBoard testBoard = new Board();

  @Test
  public void initializeTheBoardTEST() {
    ChessBoard myBoard = new Board(1);
    assertTrue(myBoard.getWholeBoard()[1][1].isThereAPiece());
    assertEquals(false,myBoard.getWholeBoard()[2][2].isThereAPiece());

    String excepted = "this piece is a white pawn in position (2,3)\n";
    ChessPiece testPiece = new Pawn(2,3,BW.WHITE);


  }

  @Test
  public void testSetOntoBoard() {
    ChessBoard testBoard = new Board();

    String excepted = "this piece is a white pawn in position (2,3)\n";
    ChessPiece testPiece = new Pawn(2,3,BW.WHITE);
    testBoard.setPieceOntoBoard(testPiece);
    String real = testBoard.getWholeBoard()[2][3].whatPieceItHas().toString();
    assertEquals(excepted,real);


  }

  @Test
  public void getPieceOnPositionTEST() {
  }

  @Test
  public void canMove2TEST() {
  }
}