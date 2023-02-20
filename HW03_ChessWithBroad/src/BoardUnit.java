/*
我来解释一下这个UNIT啊
一个unit实例，就是棋盘上的一个格子
这个格子内部只包含三个信息：1.是否有棋子 2.棋子是什么 3.该格子的底色
 */

public class BoardUnit {

  private boolean hasPiece;
  private ChessPiece piece;
  private BW unitBoardColor; //这就是该个格子的底色

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
  public void setUnitColor(BW blackOrWhite) {
    this.unitBoardColor = blackOrWhite;
  }

  /*
  这里是第二种不同的初始化方式，可以直接放一颗棋子在本unit里
   */
  public BoardUnit(ChessPiece piece) {
    this.piece = piece;
    this.hasPiece = true;
  }


  public boolean isThereAPiece() {
    return this.hasPiece;
  }

  public ChessPiece whatPieceItHas() {
    return this.piece;
  }

  public void setPiece(ChessPiece newPiece) { //也可以是resetPiece
    this.piece = newPiece;
    this.hasPiece = (this.piece != null);
  }

  public void removePiece() {
    this.piece = null;
    this.hasPiece = false;
  }
}
