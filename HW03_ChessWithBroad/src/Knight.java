import static java.lang.Math.abs;

public class Knight extends AbstractChessPiece{

  public Knight(int x, int y, BW blackOrWhite) {
    super(x,y,blackOrWhite,Type.KNIGHT);
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
    boolean knightCanMove = false;
    if (abs(x-this.getRow()) + abs(y-this.getColoum()) == 3) { knightCanMove = true;}
    if (x-this.getRow()==0 || y-this.getColoum()==0) {knightCanMove = false;}
    return knightCanMove;
  }

  @Override
  public boolean canKill(ChessPiece another) {
    return canMove(another.getRow(), another.getColoum()) && this.getBW() != another.getBW();
  }
}
