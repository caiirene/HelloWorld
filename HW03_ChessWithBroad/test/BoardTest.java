import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {


  //ChessBoard testBoard = new Board();

  /**
   *use default constructor to build a board with all pieces on default position
   * then check is there correct piece by boolean isThereAPiece and toString
   */
  @Test
  public void initializeTheBoardTEST() {
    ChessBoard myBoard = new Board(1);
    assertTrue(myBoard.getWholeBoard()[1][1].isThereAPiece());
    assertEquals(false, myBoard.getWholeBoard()[2][2].isThereAPiece());
    String excepted = "this piece is a white pawn in position (2,1)\n";
    ChessPiece shouldBeWhitePawm = myBoard.getPieceOnPosition(2,1);
    assertEquals(excepted, shouldBeWhitePawm.toString());
  }

  /**
   * build an empty board, then use setPieceOntoBoard method to put piece on
   * then test by toString
   */
  @Test
  public void testSetOntoBoard() {
    ChessBoard testBoard = new Board();

    String excepted = "this piece is a white pawn in position (2,3)\n";
    ChessPiece testPiece = new Pawn(2, 3, BW.WHITE);
    testBoard.setPieceOntoBoard(testPiece);
    String real = testBoard.getWholeBoard()[2][3].whatPieceItHas().toString();
    assertEquals(excepted, real);
  }

  /**
   * create a new object of board, and a object of piece, put the piece onto that board test
   * getPiece can give back the object
   */
  @Test
  public void getPieceOnPositionTEST() {
    ChessPiece testPiece = new Rook(1, 1, BW.WHITE);
    ChessBoard testBoard = new Board();
    testBoard.setPieceOntoBoard(testPiece);
    assertEquals(testPiece, testBoard.getPieceOnPosition(1, 1));
    //they are the same object

    //for default board, there is null on 3,3
    ChessBoard testBoard2 = new Board(1);
    assertEquals(null, testBoard2.getPieceOnPosition(3, 3));
  }


  /**
   * copy all pieces from last test, put all of them on board test piece can move (include move by
   * killing)
   */
  @Test
  public void canMove2TEST() {

    ChessBoard testBoard = new Board();

    ChessPiece bishop_b1, rook_b1, rook_b2, pawn_b1, pawn_b2, pawn_b3, pawn_b4, queen_b;
    ChessPiece knight_w1, rook_w1, rook_w2, pawn_w1, pawn_w2, pawn_w3, pawn_w4, queen_w;

    bishop_b1 = new Bishop(3, 5, BW.BLACK);
    rook_b1 = new Rook(3, 3, BW.BLACK);
    rook_b2 = new Rook(2, 6, BW.BLACK);
    pawn_b1 = new Pawn(0, 6, BW.BLACK);
    pawn_b2 = new Pawn(5, 6, BW.BLACK);
    pawn_b3 = new Pawn(5, 5, BW.BLACK);
    pawn_b4 = new Pawn(6, 5, BW.BLACK);
    queen_b = new Queen(6, 6, BW.BLACK);

    knight_w1 = new Knight(4, 2, BW.WHITE);
    rook_w1 = new Rook(1, 7, BW.WHITE);
    rook_w2 = new Rook(4, 7, BW.WHITE);
    pawn_w1 = new Pawn(2, 3, BW.WHITE);
    pawn_w2 = new Pawn(0, 1, BW.WHITE);
    pawn_w3 = new Pawn(6, 2, BW.WHITE);
    pawn_w4 = new Pawn(5, 1, BW.WHITE);
    queen_w = new Queen(6, 1, BW.WHITE);

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

    assertFalse(testBoard.canMove2(queen_w, 5, 5));
    assertFalse(testBoard.canMove2(queen_b, 4, 4));
    assertTrue(testBoard.canMove2(knight_w1, 3, 4));
    assertFalse(testBoard.canMove2(knight_w1, 2, 3));
    assertTrue(testBoard.canMove2(bishop_b1, 6, 2));
    assertFalse(testBoard.canMove2(bishop_b1, 2, 6));
    assertFalse(testBoard.canMove2(bishop_b1, 4, 7));
    assertEquals(false, testBoard.canMove2(rook_b2, 1, 7));
    assertEquals(true, testBoard.canMove2(pawn_w1, 2, 4));
    assertEquals(false, testBoard.canMove2(pawn_w1, 3, 4));

    //这里再插入一个白棋和一个黑棋在白兵1的左右前方，以及一个黑棋在左后方
    ChessPiece test_pawn_b_1 = new Pawn(1, 4, BW.BLACK);
    ChessPiece test_pawn_b_2 = new Pawn(1, 2, BW.BLACK);
    ChessPiece test_pawnw_1 = new Pawn(3, 4, BW.WHITE);
    testBoard.setPieceOntoBoard(test_pawn_b_1);
    testBoard.setPieceOntoBoard(test_pawn_b_2);
    testBoard.setPieceOntoBoard(test_pawnw_1);

    assertEquals(false, testBoard.canMove2(pawn_w1, 3, 4));
    assertEquals(false, testBoard.canMove2(pawn_w1, 1, 3));
    //System.out.println("开始\n");
    assertEquals(true, testBoard.canMove2(pawn_w1, 1, 4));

    assertFalse(testBoard.canMove2(queen_w, 3,4));
    assertEquals(true, testBoard.canMove2(rook_w1, 1, 4));
    assertEquals(true, testBoard.canMove2(test_pawn_b_1, 2, 3));
    assertEquals(false, testBoard.canMove2(pawn_b1, 0, 7));
    assertEquals(false, testBoard.canMove2(pawn_b1, 4, 7));
    assertEquals(true, testBoard.canMove2(pawn_b1, 0, 5));
    assertEquals(false, testBoard.canMove2(knight_w1, 4, 7));
    assertEquals(true, testBoard.canMove2(rook_b1, 3, 0));
  }

  /**
   * additional test on canMove2
   * if there is no such piece on board, it throw exception
   */
  @Test(expected = IllegalArgumentException.class)
  public void testPieceNOTonBoard() {
    ChessPiece testPiece = new Pawn(1, 6, BW.BLACK);
    ChessBoard testBoard = new Board();
    testBoard.canMove2(testPiece, 1, 5);
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void putPieceOnOcuppiedUnit_Board() {
    ChessPiece testPiece = new Pawn(1,1,BW.BLACK);
    ChessBoard allTestBoard_2 = new Board(1);
    allTestBoard_2.setPieceOntoBoard(testPiece);
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void putPieceOnOcuppiedUnit_Unit() {
    ChessPiece testPiece = new Pawn(1,1,BW.BLACK);
    BoardUnit oneUnit = new BoardUnit(new Rook(1,1,BW.BLACK));
    assertEquals(true, oneUnit.isThereAPiece());
    oneUnit.setPiece(testPiece);
  }

  @org.junit.Test
  public void removePiece() {
    BoardUnit oneUnit = new BoardUnit(new Rook(1,1,BW.BLACK));
    oneUnit.removePiece();
    assertEquals(null, oneUnit.whatPieceItHas());
    assertEquals(false, oneUnit.isThereAPiece());
  }

  @org.junit.Test
  public void toStringTest() {
    ChessBoard defaultBoard = new Board(1);
    String excepted = "this piece is a white queen in position (3,0)\n";
    String real = defaultBoard.getWholeBoard()[3][0].whatPieceItHas().toString();
    assertEquals(excepted, real);

    excepted = "this piece is a white rook in position (0,0)\n";
    real = defaultBoard.getWholeBoard()[0][0].whatPieceItHas().toString();
    assertEquals(excepted, real);

    excepted = "this piece is a white bishop in position (2,0)\n";
    real = defaultBoard.getWholeBoard()[2][0].whatPieceItHas().toString();
    assertEquals(excepted, real);

    excepted = "this piece is a white knight in position (1,0)\n";
    real = defaultBoard.getWholeBoard()[1][0].whatPieceItHas().toString();
    assertEquals(excepted, real);

    excepted = "this piece is a black rook in position (0,7)\n";
    real = defaultBoard.getWholeBoard()[0][7].whatPieceItHas().toString();
    assertEquals(excepted, real);
  }


}