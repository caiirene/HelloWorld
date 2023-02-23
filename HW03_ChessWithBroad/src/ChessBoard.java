/**
 * ChessBoard interface impl by Board
 * 5 method included
 */
public interface ChessBoard {

  /**
   * it should put all piece to default position and make the middle empty
   */
  void initializeTheBoard();

  /**
   * put one piece to board,
   * the position info are taken from piece itself
   * @param a ChessPiece object
   */
  void setPieceOntoBoard(ChessPiece a);


  /**
   * provide some info about ChessPiece object that on certain position
   * @param x pos on x-axis
   * @param y pos on y-axis
   * @return ChessPiece
   */
  ChessPiece getPieceOnPosition(int x, int y);


  /**
   * check a piece can move to certain postion
   * it checks is there any other piece blocking in the way
   * @param a chessPiece object
   * @param x pos on x-axis
   * @param y pos on y-axis
   * @return t/f
   */
  boolean canMove2(ChessPiece a, int x, int y);

  /**
   * just a helper method for my own test
   * @return info about board object itself
   */
  BoardUnit[][] getWholeBoard();
}
