import java.util.ArrayList;

/**
 * this class impl ChessBoard interface
 * it has two constructors
 * one build empty board
 * another one build board with default chess on top
 * it has 5 methods
 */

public class Board implements ChessBoard {

  private BoardUnit[][] wholeBroad; // = new BoardUnit[8][8];
  //private int count = 0;
  private ArrayList<ArrayList<ChessPiece>> board;


  /*
  create an empty new Board Object,
  which will have 64 new Unit Objects
  and in each Unit Object, the chess is null, the hasPiece is false.
   */
  public Board() {
    this.wholeBroad = new BoardUnit[8][8];
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        this.wholeBroad[i][j] = new BoardUnit();
      }
    }
  }

  /**
   * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
   * this is just a Array<></>version of constructor
   * it only constructs an 8*8board
   * no other method related to these
   * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
   * @param tORf doesn't matter
   * @param an doesn't matter
   * @param other doesn't matter
   */
  public Board(boolean tORf, boolean an, boolean other) {

    this.board = new ArrayList<ArrayList<ChessPiece>>();
    for (int i = 0; i < 8; i++) {
      ArrayList<ChessPiece> row = new ArrayList<ChessPiece>();
      for (int j = 0; j < 8; j++) {
        row.add(null); // initialize all cells to null
      }
      board.add(row);
    }
  }



  /**
   * second constructor
   * take any int param to make a difference
   * it will use initializeTheBoard() to put all piece to default position
   * @param doNotMatter_JustPutAnyIntHere_ItWillGiveYouAInitializedBoard
   */
  public Board(int doNotMatter_JustPutAnyIntHere_ItWillGiveYouAInitializedBoard) {
    this.wholeBroad = new BoardUnit[8][8];
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        this.wholeBroad[i][j] = new BoardUnit();
      }
    }
    initializeTheBoard();
  }


  /**
   * put default pieces onto correct postion by unit class-setPiece method
   * then make the middle 4 lines empty as new empty units
   */
  @Override
  public void initializeTheBoard() {
    this.wholeBroad[0][0].setPiece(new Rook(0, 0, BorW.WHITE));
    this.wholeBroad[1][0].setPiece(new Knight(1, 0, BorW.WHITE));
    this.wholeBroad[2][0].setPiece(new Bishop(2, 0, BorW.WHITE));
    this.wholeBroad[3][0].setPiece(new Queen(3, 0, BorW.WHITE));
    this.wholeBroad[4][0].setPiece(new King(4, 0, BorW.WHITE));
    this.wholeBroad[5][0].setPiece(new Bishop(5, 0, BorW.WHITE));
    this.wholeBroad[6][0].setPiece(new Knight(6, 0, BorW.WHITE));
    this.wholeBroad[7][0].setPiece(new Rook(7, 0, BorW.WHITE));

    for (int i = 0; i < 8; i++) {
      this.wholeBroad[i][1].setPiece(new Pawn(i, 1, BorW.WHITE));
      this.wholeBroad[i][6].setPiece(new Pawn(i, 6, BorW.BLACK));
      this.wholeBroad[i][2] = new BoardUnit();
      this.wholeBroad[i][3] = new BoardUnit();
      this.wholeBroad[i][4] = new BoardUnit();
      this.wholeBroad[i][5] = new BoardUnit();
      //清空一下中间4行
      //这里看上去无用，看上去新棋盘总是空的，但是在棋盘上有棋子时，也可以使用这个method来重置
    }

    this.wholeBroad[0][7].setPiece(new Rook(0, 7, BorW.BLACK));
    this.wholeBroad[1][7].setPiece(new Knight(1, 7, BorW.BLACK));
    this.wholeBroad[2][7].setPiece(new Bishop(2, 7, BorW.BLACK));
    this.wholeBroad[3][7].setPiece(new Queen(3, 7, BorW.BLACK));
    this.wholeBroad[4][7].setPiece(new King(4, 7, BorW.BLACK));
    this.wholeBroad[5][7].setPiece(new Bishop(5, 7, BorW.BLACK));
    this.wholeBroad[6][7].setPiece(new Knight(6, 7, BorW.BLACK));
    this.wholeBroad[7][7].setPiece(new Rook(7, 7, BorW.BLACK));
  }


  /**
   * we can set an exist piece onto board, by setPiece method in Unit class
   * but we need to check is there a piece already?
   * 这个似乎以后要去掉，因为如果吃子，是可以直接使用这个method的，
   * 否则吃子时，又要单独再判断
   * 画蛇添足！！！但不改了，就这样吧
   * @param a ChessPiece object
   * @throws IllegalArgumentException
   */
  @Override
  public void setPieceOntoBoard(ChessPiece a) throws IllegalArgumentException {
    if (this.wholeBroad[a.getRow()][a.getColoum()].isThereAPiece()) {
      //System.out.println("aaa\n");
      throw new IllegalArgumentException();
    }
    this.wholeBroad[a.getRow()][a.getColoum()].setPiece(a);
  }

  /**
   * give back imformation about what is on board (in one unit)
   * @param x
   * @param y
   * @return
   */
  @Override
  public ChessPiece getPieceOnPosition(int x, int y) {
    return this.wholeBroad[x][y].whatPieceItHas();
  }


  /**
   * it checks can a piece move to a provided postion
   * for more information, translate the Chinese comments
   * @param a
   * @param x
   * @param y
   * @return
   * @throws IllegalArgumentException
   */
  @Override
  public boolean canMove2(ChessPiece a, int x, int y) throws IllegalArgumentException{
    //首先，我们来判断一下这颗棋子是否存在于棋盘
    if (this.wholeBroad[a.getRow()][a.getColoum()].whatPieceItHas() != a) {
      throw new IllegalArgumentException("这棋子根本不在棋盘上。\n");
    }
    switch (a.getChessType()) {
      //在兵的情况下，先判断是否在同一列，
      //如果同一列，则目标位置要为空，且canMove（这里判断走单步，以及黑白子方向正确）
      case PAWN:
        if (x == a.getRow()) {
          //System.out.println("棋子在同一列，开始判断canMove\n");
          return (!this.wholeBroad[x][y].isThereAPiece()) && (a.canMove(x,y));
        }
        //判断目标位置存在棋子，判断canKill（这里判断位置正确，颜色不同）
        else if (this.wholeBroad[x][y].isThereAPiece()) {
          //System.out.println("存在棋子，判断canKill\n");
          return a.canKill(this.wholeBroad[x][y].whatPieceItHas());
        }
        //System.out.println("既不在同一列，也不存在棋子，直接false\n");
        return false;

      case KNIGHT:
        //对于马，有三种情况，
        //先判断canMove，如果不行，直接false
        if (!a.canMove(x, y)) {
          return false;
        }
        //然后判断是否有棋子，无则直接true
        if (!this.wholeBroad[x][y].isThereAPiece()) {
          return true;
        }
        //有，则判断canKill
        return a.canKill(this.wholeBroad[x][y].whatPieceItHas());

      default:
        //第一点，当然是先使用之前的canMove进行初步判断
        if (!a.canMove(x, y)) {
          return false;
        }

        boolean canMove2ReturnVal = true;

        int horizonDiffer = Math.abs(x - a.getRow());
        int verticalDiffer = Math.abs(y - a.getColoum());

        int standard = Math.max(horizonDiffer, verticalDiffer);

        /**
         * 然后这个地方比较复杂，我稍微解释一下
         * 在刨除掉兵马的情况，又判断了canMove，我的棋子只可能“米字型”移动
         * 但是为了合并这两种情况，我对比了横向和竖向的移动长短，以长的那个为标准
         * 无论何种移动，其总长度是x - a.getRow()以及y - a.getColoum()
         * 需要移动几次呢？就是standard次。
         * 每次移动到哪呢？就是乘以i，再加上原坐标
         * 注意：如果是横竖移动，则其中一个坐标差为0，在这种情况下，x - a.getRow()和y - a.getColoum()是0
         *     0除以任何数都是0，再乘以i也是0，再加上原坐标，就是原坐标

         * 然后for循环，检查所有坐标为空
         * 注意：不检查终点坐标
         */
        for (int i = 1; i < standard; i++) {
          int checkX = (x - a.getRow()) / standard * i + a.getRow();
          int checkY = (y - a.getColoum()) / standard * i + a.getColoum();
          if (this.wholeBroad[checkX][checkY].isThereAPiece()) {
            return false;
          }
        }
        //在过程坐标检查完毕后，单独检查终点，如果有棋子则判断canKill
        if (this.wholeBroad[x][y].isThereAPiece()) {
          return a.canKill(this.wholeBroad[x][y].whatPieceItHas());
        }
        //否则无棋子，就true
        return canMove2ReturnVal;
    }
  }

  /**
   * 这个是为了test方便使用wholeBoard这个变量，所以写在这里
   * @return
   */
  public BoardUnit[][] getWholeBoard() {
    return this.wholeBroad;
  }

}
