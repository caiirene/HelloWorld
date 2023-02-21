import static java.lang.Math.abs;

/**
 * this construct an object of bishop chess
 * at x,y position
 * and color in your choice
 * @param x pos
 * @param y pos
 * @return object
 */
public class Pawn extends AbstractChessPiece {

  /**
   * constructor
   * need 横纵坐标, BW
   * it provides type as pawn to AbstractChessPiece automaticlly
   * @param x
   * @param y
   * @param color
   */
  public Pawn(int x, int y, BW blackOrWhite) {
    super(x, y, blackOrWhite, Type.PAWN);
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
    boolean pawnCanMove = false;
    switch (this.getBW()) {
      case BLACK:
        if ((this.getRow() == x) && (this.getColoum() - y == 1)) {
          pawnCanMove = true;
          break;
        }
      case WHITE:
        if ((this.getRow() == x) && (this.getColoum() - y == -1)) {
          pawnCanMove = true;
          break;
        }
    }
    return pawnCanMove;
  }

  /**
   * it takes another ChessPiece object as param, to check this object can kill or not
   * @param another
   * @return t/f
   */
  @Override
  public boolean canKill(ChessPiece another) {
    if (another.getBW() == this.getBW()) {return false;}
    boolean pawnCanKill = false;
    switch (this.getBW()) {
      case BLACK:
        if ((this.getColoum()-another.getColoum()== 1) && (abs(this.getRow()-another.getRow())== 1)) {
          pawnCanKill = true;
          break;
        }
      case WHITE:
        if ((this.getColoum()-another.getColoum()== -1) && (abs(this.getRow()-another.getRow())== 1)) {
          pawnCanKill = true;
          break;
        }

    }
    return pawnCanKill;
  }
}
