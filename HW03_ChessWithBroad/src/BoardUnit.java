/*
我来解释一下这个UNIT啊
一个unit实例，就是棋盘上的一个格子
这个格子内部只包含三个信息：1.是否有棋子 2.棋子是什么 3.该格子的底色
 */

public class BoardUnit {

  private boolean hasPiece;
  private ChessPiece piece;
  private BorW unitBoardColor; //这就是该个格子的底色

  /*
  对于这个初始化，这么理解——我只想创建一个格子，至于格子里的内容，需要使用setter来设置
   */
  public BoardUnit() {
    this.hasPiece = false;
    this.piece = null;
  }

  /*
  这里设置该实例的底色，我先暂时不用，先试试看，
  因为似乎只有象，分“白象、黑象”
   */
  /*public void setUnitColor(BW blackOrWhite) {
    this.unitBoardColor = blackOrWhite;
  }
   */

  /*
  这里是第二种不同的初始化方式，可以直接放一颗棋子在本unit里
   */
  public BoardUnit(ChessPiece piece) {
    this.piece = piece;
    this.hasPiece = (piece != null);
  }


  /**
   * check is there a ChessPiece object in this unit
   * @return t/f
   */
  public boolean isThereAPiece() {
    return this.hasPiece;
  }

  /**
   * give information about the ChessPiece object in this unit
   * @return ChessPiece
   */
  public ChessPiece whatPieceItHas() {
    return this.piece;
  }

  /**
   * 重置安置的棋子信息
   * @param newPiece
   * @throws IllegalArgumentException
   */
  public void setPiece(ChessPiece newPiece) throws IllegalArgumentException{ //也可以是resetPiece
    if (this.hasPiece) {
      throw new IllegalArgumentException();
    }
    this.piece = newPiece;
    this.hasPiece = (this.piece != null);
  }

  /**
   * 删除一个棋子，让 this.piece = null;
   *     this.hasPiece = false;
   */
  public void removePiece() {
    this.piece = null;
    this.hasPiece = false;
  }
}
