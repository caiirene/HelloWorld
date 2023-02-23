import java.util.ArrayList;

public class ChessBoard {
  private ArrayList<ArrayList<ChessPiece>> board;

  public ChessBoard(int rows, int cols) {
    board = new ArrayList<ArrayList<ChessPiece>>();
    for (int i = 0; i < rows; i++) {
      ArrayList<ChessPiece> row = new ArrayList<ChessPiece>();
      for (int j = 0; j < cols; j++) {
        row.add(null); // initialize all cells to null
      }
      board.add(row);
    }
  }

  public ChessPiece getPiece(int row, int col) {
    return board.get(row).get(col);
  }

  public void setPiece(int row, int col, ChessPiece piece) {
    board.get(row).set(col, piece);
  }
}
