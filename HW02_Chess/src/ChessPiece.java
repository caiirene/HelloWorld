public interface ChessPiece {

  int getRow();

  int getColoum();

  BW getBW();

  boolean canMove(int x, int y);

  boolean canKill(ChessPiece another);

  /*
  boolean canPosition();

   */

}
