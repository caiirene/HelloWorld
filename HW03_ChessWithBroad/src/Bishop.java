import static java.lang.Math.abs;

/**
 * concrete bishop class.
 * AbstractChessPiece implement ChessPiece, this bishop class extend AbstractChessPiece
 * this class can create an ChessPiece object
 * it has 横纵坐标, BW, and provide type as bishop to AbstractChessPiece
 */
public class Bishop extends AbstractChessPiece {


  /**
   * constructor
   * need 横纵坐标, BW
   * it provides type as bishop to AbstractChessPiece automaticlly
   * @param x
   * @param y
   * @param color
   */
  public Bishop (int x, int y, BW color) {
    super(x,y,color,Type.BISHOP);
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
    boolean bishopCanMove;
    if (abs(x-this.getRow()) == abs(y-this.getColoum())) { bishopCanMove = true;}
    else {bishopCanMove = false;}
    if (x == this.getRow()) {bishopCanMove = false;}
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

}
