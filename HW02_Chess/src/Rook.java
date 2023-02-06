import static java.lang.Math.abs;
public class Rook extends AbstractChessPiece {


  public Rook(int x, int y, BW blackOrWhite) {
    super(x,y,blackOrWhite);
  }


  @Override
  public boolean canMove(int x, int y) {
    if ((x>=8) || y>=8 || 0>x || 0>y) {throw new IllegalArgumentException();}
    boolean RookCanMove = true;
    if (x != this.rowPos && y != this.coloumPos) {RookCanMove = false;}
    if (x == this.rowPos && y == this.coloumPos) {RookCanMove = false;}
    return RookCanMove;
  }

  @Override
  public boolean canKill(ChessPiece another) {
    boolean bishopCanKill;
    return (this.canMove(another.getRow(), another.getColoum()) && this.color != another.getBW());
  }
}
