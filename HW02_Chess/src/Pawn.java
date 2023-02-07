import static java.lang.Math.abs;

public class Pawn extends AbstractChessPiece {

  public Pawn(int x, int y, BW blackOrWhite) {
    super(x, y, blackOrWhite, Type.PAWN);
  }

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
