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

    ChessBoard testBoard = new Board();

    ChessPiece bishop_b1, rook_b1, rook_b2, pawn_b1, pawn_b2, pawn_b3,pawn_b4, queen_b;
    ChessPiece  knight_w1, rook_w1, rook_w2, pawn_w1, pawn_w2, pawn_w3,pawn_w4, queen_w;

    bishop_b1 = new Bishop(3,5,BW.BLACK);
    rook_b1 = new Rook(3,3,BW.BLACK);
    rook_b2 = new Rook(2,6,BW.BLACK);
    pawn_b1 = new Pawn(0,6,BW.BLACK);
    pawn_b2 = new Pawn(5,6,BW.BLACK);
    pawn_b3 = new Pawn(5,5,BW.BLACK);
    pawn_b4 = new Pawn(6,5,BW.BLACK);
    queen_b = new Queen(6,6, BW.BLACK);

    knight_w1 = new Knight(4,2, BW.WHITE);
    rook_w1 = new Rook(1,7,BW.WHITE);
    rook_w2 = new Rook(4,7,BW.WHITE);
    pawn_w1 = new Pawn(2,3,BW.WHITE);
    pawn_w2 = new Pawn(0,1,BW.WHITE);
    pawn_w3 = new Pawn(6,2,BW.WHITE);
    pawn_w4 = new Pawn(5,1,BW.WHITE);
    queen_w = new Queen(6,1,BW.WHITE);

    testBoard.setPieceOntoBoard(bishop_b1);
    testBoard.setPieceOntoBoard(rook_b2);
    testBoard.setPieceOntoBoard(pawn_b1);
    testBoard.setPieceOntoBoard(rook_b1);
    testBoard.setPieceOntoBoard(pawn_b2);
    testBoard.setPieceOntoBoard(pawn_b4);
    testBoard.setPieceOntoBoard(pawn_b3);
    testBoard.setPieceOntoBoard(queen_b);

    testBoard.setPieceOntoBoard(knight_w1);
    testBoard.setPieceOntoBoard(rook_w1);
    testBoard.setPieceOntoBoard(rook_w2);
    testBoard.setPieceOntoBoard(pawn_w1);
    testBoard.setPieceOntoBoard(pawn_w2);
    testBoard.setPieceOntoBoard(pawn_w3);
    testBoard.setPieceOntoBoard(pawn_w4);
    testBoard.setPieceOntoBoard(queen_w);

    assertFalse(testBoard.canMove2(queen_w,5,5));

  }
}