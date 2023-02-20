public interface ChessBoard {


  void initializeTheBoard();

  void setPieceOntoBoard(ChessPiece a);

  ChessPiece getPieceOnPosition(int x, int y);

  boolean canMove2(ChessPiece a, int x, int y);//需要检查这个棋子是否在棋盘上

  BoardUnit[][] getWholeBoard();
}
