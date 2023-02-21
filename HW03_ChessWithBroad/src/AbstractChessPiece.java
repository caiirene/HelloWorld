/**
 * this abstract class provide 6 methods to implement ChessPiece interface
 */

public abstract class AbstractChessPiece implements ChessPiece {

  protected BW color;
  protected int rowPos;
  protected int coloumPos;

  public Type chessType;


  /**
   * constructor
   * it will be used by all different pieces class
   * and in those class, they will provide chessType by default
   * @param x the number on row (注意：这里是指从横坐标上读取到的数，而不是行数)
   * @param y the number read from y-axis
   * @param blackOrWhite
   * @param chessType e.g.BISHOP/ QUEEN......
   */
  public AbstractChessPiece(int x, int y, BW blackOrWhite, Type chessType) {
    checkIndex(x, y);
    this.rowPos = x;
    this.coloumPos = y;
    this.color = blackOrWhite;
    this.chessType = chessType;
  }


  /**
   * getRow() and getColoum() and getBW() are used by all pieces class,
   * so just make it abstract
   * they return the 横竖坐标读数 and the color info about a piece
   * @return int or BW
   */
  @Override
  public int getRow() {
    return this.rowPos;
  }

  @Override
  public int getColoum() {
    return this.coloumPos;
  }

  @Override
  public BW getBW() {
    return this.color;
  }

  /**
   * this method are used in all pieces class, but just inside them
   * so protected
   * @param x the x-axis you want to check
   * @param y ...y-axis...
   */
  protected void checkIndex(int x, int y) {
    if ((x >= 8) || y >= 8 || 0 > x || 0 > y) {
      throw new IllegalArgumentException();
    }
    return;
  }

  /*public boolean canMove2(int x, int y){
    boolean canMove2_ReturnVal = false;
    if (!canMove(x,y)) {return false;}

    return canMove2_ReturnVal;
  }
   */


  /**
   * since all pieces need toString, but each toString are different,
   * so use switch
   * @return string
   */
  @Override
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
      case KING:
        thisType = "king";
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

  /**
   * 这个写出来就是为了test使用，没啥重要的
   * @return type
   */
  @Override
  public Type getChessType() {
    return this.chessType;
  }

}
