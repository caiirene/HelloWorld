/**
 * test but not able to run
 */

import static org.junit.Assert.*;

public class TTTModelTest {

  private TTTModel myModel;

  /**
   * test move method
   */
  @org.junit.Test
  public void move() {
    myModel.move(1,1);
    assertEquals(Player.X, myModel.getMarkAt(1,1));
    myModel.move(2,1);
    assertEquals(Player.Y, myModel.getMarkAt(2,1));
  }

  /**
   * test use crazy index as parameter for move method
   */
  @org.junit.Test (expected = IndexOutOfBoundsException.class)
  public void moveOut() {
    myModel.move(5,1);
  }

  /**
   * after a game win, move method should not working
   */
  @org.junit.Test (expected = IllegalStateException.class)
  public void moveAfterWin() {
    if (myModel.isGameOver()) {
      myModel.move(2,1);
    }
  }

  /**
   * move method should know where has a piece already
   */
  @org.junit.Test (expected = IllegalStateException.class)
  public void moveRepeatPos() {
    myModel.move(1,1);
    myModel.move(1,1);
  }

  /**
   * test nextPlayer method
   */
  @org.junit.Test
  public void nextPlayer() {
    assertEquals(Player.X, myModel.nextPlayer());
    myModel.move(1,1);
    assertEquals(Player.Y, myModel.nextPlayer());
  }

  /**
   * there should not be a next player after win
   */
  @org.junit.Test(expected = IllegalStateException.class)
  public void nextPlayerAfterWin() {
    if (myModel.isGameOver()) {
      myModel.nextPlayer();
    }
  }

  /**
   * test getMarkAt method
   */
  @org.junit.Test
  public void getMarkAt() {
    myModel.move(1,1);
    assertEquals(Player.X, myModel.getMarkAt(1,1));
    myModel.move(2,1);
    assertEquals(Player.Y, myModel.getMarkAt(2,1));
  }

  /**
   * test getGrid method
   */
  @org.junit.Test
  public void getGrid() {
    assertEquals(null, myModel.getGrid()[1][1]);
    assertEquals(null, myModel.getGrid()[2][1]);
    assertEquals(null, myModel.getGrid()[0][1]);
    assertEquals(null, myModel.getGrid()[2][2]);
    myModel.move(1,1);
    assertEquals(Player.X,myModel.getGrid()[1][1]);
    myModel.move(2,2);
    assertEquals(Player.Y,myModel.getGrid()[1][1]);

  }

  @org.junit.Test
  public void isGameOver() {
    assertEquals(false, myModel.isGameOver());
    myModel.move(0,1);
    myModel.move(1,1);
    myModel.move(0,0);
    myModel.move(2,2);
    myModel.move(0,2);
    assertEquals(true,myModel.isGameOver());
  }

  @org.junit.Test
  public void getWinner() {
    assertEquals(null, myModel.getWinner());
    myModel.move(0,0);
    myModel.move(1,1);
    myModel.move(2,2);
    myModel.move(0,1);
    myModel.move(2,1);
    myModel.move(1,2);
    assertEquals(Player.Y,myModel.getWinner());
  }
}