import static java.lang.Math.abs;

public class Knight extends AbstractChessPiece{

  /**
   * constructor
   * need 横纵坐标, BW
   * it provides type as knight to AbstractChessPiece automaticlly
   * @param x
   * @param y
   * @param BW
   */
  public Knight(int x, int y, BW blackOrWhite) {
    super(x,y,blackOrWhite,Type.KNIGHT);
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
    boolean knightCanMove = false;
    if (abs(x-this.getRow()) + abs(y-this.getColoum()) == 3) { knightCanMove = true;}
    if (x-this.getRow()==0 || y-this.getColoum()==0) {knightCanMove = false;}
    return knightCanMove;
  }

  /**
   * it takes another ChessPiece object as param, to check this object can kill or not
   * @param another
   * @return t/f
   */
  @Override
  public boolean canKill(ChessPiece another) {
    return canMove(another.getRow(), another.getColoum()) && this.getBW() != another.getBW();
  }
}
