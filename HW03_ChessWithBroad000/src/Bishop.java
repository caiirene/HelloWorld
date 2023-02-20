import static java.lang.Math.abs;

public class Bishop extends AbstractChessPiece {


  public Bishop (int x, int y, BW color) {
    super(x,y,color,Type.BISHOP);
  }


  /**
   * this construct an object of bishop chess
   * at x,y position
   * and color in your choice
   * @param x pos
   * @param y pos
   * @return object
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
