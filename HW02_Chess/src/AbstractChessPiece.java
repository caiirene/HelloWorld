/**
 * this abstract class provide 6 methods to implement ChessPiece interface
 */
public abstract class AbstractChessPiece implements ChessPiece {

  protected BW color;
  protected int rowPos;
  protected int coloumPos;

  protected Type chessType;


  /**
   * constructor
   * it will be used by all different pieces class
   * and in those class, they will provide chessType by default
   * @param x
   * @param y
   * @param blackOrWhite
   * @param chessType
   */
  public AbstractChessPiece(int x, int y, BW blackOrWhite, Type chessType) {
    checkIndex(x, y);
    this.rowPos = x;
    this.coloumPos = y;
    this.color = blackOrWhite;
    this.chessType = chessType;
  }

  /**
   * give info on piece's row
   * @return int
   */
  @Override
  public int getRow() {
    return this.rowPos;
  }


  /**
   * give info on piece's coloum
   * @return int
   */
  @Override
  public int getColoum() {
    return this.coloumPos;
  }


  /**
   * give info on piece's color
   * @return BW
   */
  @Override
  public BW getBW() {
    return this.color;
  }


  /**
   * just a helper method that only be used inside piece code
   * @return t/f
   */
  protected void checkIndex(int x, int y) {
    if ((x >= 8) || y >= 8 || 0 > x || 0 > y) {
      throw new IllegalArgumentException();
    }
    return;
  }

  /**
   * put toString here to void repeating in each different piece
   * @return str
   */
  public String toString() {
    String thisType;
    switch (this.chessType) {
      case PAWN:
        thisType = "pawn";
        break;
      case QUEEN:
        thisType = "queen";
        break;
      case ROOK:
        thisType = "rook";
        break;
      case BISHOP:
        thisType = "bishop";
        break;
      case KNIGHT:
        thisType = "knight";
        break;
      default:
        thisType = "unknow";
        break;
    }
    String bw;
    switch (color) {
      case BLACK:
        bw = "black";
        break;
      case WHITE:
        bw = "white";
        break;
      default:
        bw = "unknow";
        break;
    }
    String str = "this piece is a " + bw + " " + thisType + " in position (" + this.rowPos + ","
        + this.coloumPos + ")\n";
    System.out.println(str);
    return str;
  }

}
