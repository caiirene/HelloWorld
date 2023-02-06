import static java.lang.Math.abs;

public class Queen extends AbstractChessPiece {


  public Queen (int x, int y, BW color) {
    super(x,y,color);
  }


  @Override
  public boolean canMove(int x, int y) {
    if ((x>=8) || y>=8 || 0>x || 0>y) {throw new IllegalArgumentException();}
    boolean bishopCanMove = false;
    if (abs(x-this.getRow()) == abs(y-this.getColoum())) { bishopCanMove = true;}
    if (x == this.getRow() || y == this.getColoum()) {bishopCanMove = true;}
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

