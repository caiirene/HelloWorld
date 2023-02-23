public class King extends AbstractChessPiece{

  public King(int x, int y, BorW blackOrWhite) {
    super(x,y,blackOrWhite,Type.KING);
  }

  @Override
  public boolean canMove(int x, int y) {
    return false;
  }

  @Override
  public boolean canKill(ChessPiece another) {
    return false;
  }
}
