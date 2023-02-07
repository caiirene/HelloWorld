import static java.lang.Math.abs;

public class Queen extends AbstractChessPiece {

  /**
   * this construct an object of bishop chess
   * at x,y position
   * and color in your choice
   * @param x pos
   * @param y pos
   * @return object
   */
  public Queen (int x, int y, BW color) {
    super(x,y,color, Type.QUEEN);
  }


  @Override
  public boolean canMove(int x, int y) {
    checkIndex(x,y);
    boolean bishopCanMove = false;
    if (abs(x-this.getRow()) == abs(y-this.getColoum())) { bishopCanMove = true;}
    if (x == this.getRow() || y == this.getColoum()) {bishopCanMove = true;}
    if (x == this.getRow() && y == this.getColoum()) {bishopCanMove = false;}
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

