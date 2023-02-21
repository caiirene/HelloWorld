import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BishopTest {

  @Before
  public void setup() {
    ChessPiece test_1 = new Bishop(2,0,BW.WHITE);
    ChessPiece test_2 = new Bishop(5,7,BW.BLACK);
  }

  @Test
  public void getRow() {
    ChessPiece test_1 = new Bishop(2,0,BW.WHITE);
    ChessPiece test_2 = new Bishop(5,7,BW.BLACK);
    assertEquals(2,test_1.getRow());
    assertEquals(5,test_2.getRow());
  }

  @Test
  public void getColoum() {
    ChessPiece test_1 = new Bishop(2,0,BW.WHITE);
    ChessPiece test_2 = new Bishop(5,7,BW.BLACK);
    assertEquals(0,test_1.getColoum());
    assertEquals(7,test_2.getColoum());
  }

  @Test
  public void getBW() {
    ChessPiece test_1 = new Bishop(2,0,BW.WHITE);
    ChessPiece test_2 = new Bishop(5,7,BW.BLACK);
    assertEquals(BW.WHITE,test_1.getBW());
    assertEquals(BW.BLACK,test_2.getBW());
  }

  @Test (expected = IllegalArgumentException.class)
  public void checkIndex() {
    ChessPiece test = new Bishop(11,1,BW.WHITE);
  }

  @Test
  public void testToString() {
    ChessPiece test_1 = new Bishop(2,0,BW.WHITE);
    ChessPiece test_2 = new Bishop(5,7,BW.BLACK);
    String except_1 = "this piece is a white bishop in position (2,0)\n";
    String except_2 = "this piece is a black bishop in position (5,7)\n";

    assertEquals(except_1, test_1.toString());
    assertEquals(except_2, test_2.toString());
  }

  @Test
  public void canMove() {
    ChessPiece test_1 = new Bishop(2,0,BW.WHITE);
    ChessPiece test_2 = new Bishop(5,7,BW.BLACK);
    assertEquals(true, test_1.canMove(1,1));
    assertEquals(false, test_2.canMove(1,1));
  }

  @Test
  public void canKill() {
    ChessPiece test_1 = new Bishop(2,0,BW.WHITE);
    ChessPiece test_2 = new Bishop(5,7,BW.BLACK);
    assertEquals(false, test_1.canKill(test_2));
    assertEquals(false, test_2.canKill(test_1));
    ChessPiece killed = new Rook(4,2,BW.BLACK);
    ChessPiece killed2 = new Rook(0,2,BW.BLACK);
    assertEquals(true, test_1.canKill(killed));
    assertEquals(false, test_2.canKill(killed2));
  }
}