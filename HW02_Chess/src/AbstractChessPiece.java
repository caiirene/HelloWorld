public abstract class AbstractChessPiece implements ChessPiece {

  protected BW color;
  protected int rowPos;
  protected int coloumPos;


  public AbstractChessPiece(int x, int y, BW blackOrWhite) {
    this.rowPos = x;
    this.coloumPos = y;
    this.color = blackOrWhite;
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

}
