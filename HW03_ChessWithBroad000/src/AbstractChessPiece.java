public abstract class AbstractChessPiece implements ChessPiece {

  protected BW color;
  protected int rowPos;
  protected int coloumPos;

  public Type chessType;


  public AbstractChessPiece(int x, int y, BW blackOrWhite, Type chessType) {
    checkIndex(x, y);
    this.rowPos = x;
    this.coloumPos = y;
    this.color = blackOrWhite;
    this.chessType = chessType;
  }

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

  protected void checkIndex(int x, int y) {
    if ((x >= 8) || y >= 8 || 0 > x || 0 > y) {
      throw new IllegalArgumentException();
    }
    return;
  }

  public boolean canMove2(int x, int y){
    boolean canMove2_ReturnVal = false;
    if (!canMove(x,y)) {return false;}

    return canMove2_ReturnVal;
  }

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

  @Override
  public Type getChessType() {
    return this.chessType;
  }

}
