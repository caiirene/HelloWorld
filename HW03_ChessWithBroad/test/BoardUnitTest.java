import static org.junit.Assert.*;

import org.junit.Test;

public class BoardUnitTest {

  @Test
  public void isThereAPiece() {
    BoardUnit test = new BoardUnit();
    assertEquals(false, test.isThereAPiece());
    BoardUnit test2 = new BoardUnit(new Rook(1,2, BorW.BLACK));
    assertEquals(true, test2.isThereAPiece());
  }

  @Test
  public void whatPieceItHas() {
    BoardUnit test = new BoardUnit();
    assertEquals(null, test.whatPieceItHas());
    ChessPiece mytest = new Rook(1,2, BorW.BLACK);
    BoardUnit test2 = new BoardUnit(mytest);
    assertEquals(mytest, test2.whatPieceItHas());
  }

  @Test
  public void setPiece() {
    BoardUnit test = new BoardUnit();
    assertEquals(null, test.whatPieceItHas());
    test.setPiece(new Rook(1,2, BorW.BLACK));
    assertEquals(true, test.isThereAPiece());
  }

  @Test
  public void removePiece() {
    BoardUnit test = new BoardUnit();
    assertEquals(null, test.whatPieceItHas());
    test.setPiece(new Rook(1,2, BorW.BLACK));
    assertEquals(true, test.isThereAPiece());
    test.removePiece();
    assertEquals(false, test.isThereAPiece());
  }
}