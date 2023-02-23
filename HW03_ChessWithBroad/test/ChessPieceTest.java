import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ChessPieceTest {

  ChessPiece bishop_b1, rook_b1, rook_b2, pawn_b1, pawn_b2, pawn_b3,pawn_b4, queen_b;
  ChessPiece  knight_w1, rook_w1, rook_w2, pawn_w1, pawn_w2, pawn_w3,pawn_w4, queen_w;

  @Test (expected = IllegalArgumentException.class)
  public void badSetUp() {
    bishop_b1 = new Bishop(10,101, BorW.WHITE);
  }

  /**
   * chess record from https://www.hellochess.cn/dupuzzles/fourstep
   * no king, so replaced by queen
   */
  @Before
  public void setUp() {
    bishop_b1 = new Bishop(3,5, BorW.BLACK);
    rook_b1 = new Rook(3,3, BorW.BLACK);
    rook_b2 = new Rook(2,6, BorW.BLACK);
    pawn_b1 = new Pawn(0,6, BorW.BLACK);
    pawn_b2 = new Pawn(5,6, BorW.BLACK);
    pawn_b3 = new Pawn(5,5, BorW.BLACK);
    pawn_b4 = new Pawn(6,5, BorW.BLACK);
    queen_b = new Queen(6,6, BorW.BLACK);

    knight_w1 = new Knight(4,2, BorW.WHITE);
    rook_w1 = new Rook(1,7, BorW.WHITE);
    rook_w2 = new Rook(4,7, BorW.WHITE);
    pawn_w1 = new Pawn(2,3, BorW.WHITE);
    pawn_w2 = new Pawn(0,1, BorW.WHITE);
    pawn_w3 = new Pawn(6,2, BorW.WHITE);
    pawn_w4 = new Pawn(5,1, BorW.WHITE);
    queen_w = new Queen(6,1, BorW.WHITE);
  }

  @org.junit.Test
  public void getRow() {
    assertEquals(3, bishop_b1.getRow());
    assertEquals(3, rook_b1.getRow());
    assertEquals(2, rook_b2.getRow());
    assertEquals(0, pawn_b1.getRow());
    assertEquals(4, knight_w1.getRow());
    assertEquals(1, rook_w1.getRow());
    assertEquals(2, pawn_w1.getRow());

  }

  @org.junit.Test
  public void getColoum() {
    assertEquals(6, pawn_b2.getColoum());
    assertEquals(5, pawn_b3.getColoum());
    assertEquals(5, pawn_b4.getColoum());
    assertEquals(6, queen_b.getColoum());
    assertEquals(1, queen_w.getColoum());
    assertEquals(1, pawn_w4.getColoum());
  }

  @org.junit.Test
  public void getBW() {
    assertEquals(BorW.WHITE, pawn_w4.getBW());
    assertEquals(BorW.WHITE, queen_w.getBW());
    assertEquals(BorW.BLACK, pawn_b2.getBW());
    assertEquals(pawn_b2.getBW(), bishop_b1.getBW());
  }

  @org.junit.Test
  public void canMove() {
    assertEquals(true, pawn_b3.canMove(5,4));
    assertEquals(true, pawn_b4.canMove(6,4));
    assertEquals(true, pawn_w3.canMove(6,3));
    assertEquals(true, rook_b1.canMove(7,3));
    assertEquals(false, rook_b1.canMove(2,4));
    assertEquals(true, rook_b1.canMove(3,5));
    assertEquals(false, rook_b1.canMove(6,6));
    assertEquals(false, pawn_w1.canMove(2,2));
    assertEquals(true, queen_w.canMove(0,7));
    assertEquals(false, queen_w.canMove(2,2));
    assertEquals(false, bishop_b1.canMove(3,4));
    assertEquals(true, bishop_b1.canMove(5,3));

    assertEquals(BorW.BLACK, pawn_b1.getBW());
    //System.out.println("start\n");
    assertEquals(false, pawn_b1.canMove(0,7));
  }



  @org.junit.Test
  public void canKill() {
    assertTrue(rook_b1.canKill(pawn_w1));
    assertTrue(bishop_b1.canKill(pawn_w3));
    assertTrue(queen_w.canKill(queen_b));
    assertTrue(queen_b.canKill(queen_w));
    assertFalse(rook_b2.canKill(pawn_b2));
    assertFalse(bishop_b1.canKill(queen_w));
    assertFalse(knight_w1.canKill(rook_b1));
    assertFalse(pawn_w1.canKill(rook_b1));


    ChessPiece test_pawn_b_1 = new Pawn(1,4, BorW.BLACK);
    ChessPiece test_pawn_b_2 = new Pawn(1,2, BorW.BLACK);
    ChessPiece test_pawnw_1 = new Pawn(3,4, BorW.WHITE);


    assertEquals(true, pawn_w1.canKill(test_pawn_b_1));
  }

  @Test
  public void testToString() {
    String expected = "this piece is a white pawn in position (2,3)\n";
    assertEquals(expected, pawn_w1.toString());
  }
}