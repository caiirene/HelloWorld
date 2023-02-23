/**
 * concrete queen class.
 * AbstractChessPiece implement ChessPiece, this bishop class extend AbstractChessPiece
 * this class can create an ChessPiece object
 * it has 横纵坐标, BW, and provide type as queen to AbstractChessPiece
 */

import static java.lang.Math.abs;

public class Queen extends AbstractChessPiece {

  /**
   * this construct an object of queen chess
   * at x,y position
   * and color in your choice
   * @param x pos
   * @param y pos
   * @return object
   */
  public Queen (int x, int y, BorW color) {
    super(x,y,color, Type.QUEEN);
  }


  /**
   * it checks this object can move to a provided 横纵坐标
   * @param x
   * @param y
   * @return true or false
   */
  @Override
  public boolean canMove(int x, int y) {
    checkIndex(x,y);
    boolean bishopCanMove = false;
    if (abs(x-this.getRow()) == abs(y-this.getColoum())) { bishopCanMove = true;}
    if (x == this.getRow() || y == this.getColoum()) {bishopCanMove = true;}
    if (x == this.getRow() && y == this.getColoum()) {bishopCanMove = false;}
    return bishopCanMove;
  }

  /**
   * it takes another ChessPiece object as param, to check this object can kill or not
   * @param another
   * @return t/f
   */
  @Override
  public boolean canKill(ChessPiece another) {
    boolean bishopCanKill;
    return (this.canMove(another.getRow(), another.getColoum()) && this.getBW() != another.getBW());
  }


  /*
  @Override
  public boolean canPosition() {
    return false;
  }
   */
}

