import static java.lang.Math.abs;

public class Bishop extends AbstractChessPiece {


  public Bishop (int x, int y, BW color) {
    super(x,y,color);
  }


  @Override
  public boolean canMove(int x, int y) {
    if ((x>=8) || y>=8 || 0>x || 0>y) {throw new IllegalArgumentException();}
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
