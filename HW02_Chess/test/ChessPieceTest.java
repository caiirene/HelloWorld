import static org.junit.Assert.*;

import org.junit.Before;

public class ChessPieceTest {

  ChessPiece bishop_w, bishop_b, rook_w, rook_b;

  @Before
  public void setUp() {
    bishop_w = new Bishop(2,0,BW.WHITE);
    bishop_b = new Bishop(4,2,BW.BLACK);
    rook_w = new Rook(0,0,BW.WHITE);
    rook_b = new Rook(0,6,BW.BLACK);
  }

  @org.junit.Test
  public void getRow() {
    assertEquals(2, bishop_w.getRow());

  }

  @org.junit.Test
  public void getColoum() {
  }

  @org.junit.Test
  public void getBW() {
  }

  @org.junit.Test
  public void canMove() {
    //assertTrue(bishop_w.canMove(1,1));
    assertEquals(true, bishop_w.canMove(4,2));
  }



  @org.junit.Test
  public void canKill() {
    assertTrue(bishop_w.canKill(bishop_b));
  }
}