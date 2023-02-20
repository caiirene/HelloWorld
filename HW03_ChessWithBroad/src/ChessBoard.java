public interface ChessBoard {


  void initializeTheBoard();

  ChessPiece getPieceOnPosition(int x, int y);

  boolean canMove2(ChessPiece a, int x, int y);
}
