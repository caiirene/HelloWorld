/**
 * THIS is a chess game project
 */
public interface ChessPiece {

  /**
   * this return the row number
   * @return int
   */
  int getRow();

  /**
   * this return the coloum number
   * @return int
   */
  int getColoum();

  /**
   * this return the color
   * @return BW
   */
  BW getBW();

  /**
   * this return true or false for if this chess piece can move to certain position
   * @return true or false
   */
  boolean canMove(int x, int y);

  /**
   * this return true or false for if this chess piece can kill another chess in certain position
   * @return true or false
   */
  boolean canKill(ChessPiece another);

  boolean canMove2(int x, int y);

  Type getChessType();


}
