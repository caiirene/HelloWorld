public class Board implements ChessBoard {

  private BoardUnit[][] wholeBroad; // = new BoardUnit[8][8];
  private int count = 0;


  /*
  create an empty new Board Object,
  which will have 64 new Unit Objects
  and in each Unit Object, the chess is null, the hasPiece is false.
   */
  public Board() {
    this.wholeBroad = new BoardUnit[8][8];
    for (int i = 1; i <= 8; i++) {
      for (int j = 1; j <= 8; j++) {
        this.wholeBroad[i][j] = new BoardUnit();
      }
    }
  }

  public Board(int doNotMatter_JustPutAnyIntHere_ItWillGiveYouAInitializedBoard) {
    this.wholeBroad = new BoardUnit[8][8];
    for (int i = 1; i <= 8; i++) {
      for (int j = 1; j <= 8; j++) {
        this.wholeBroad[i][j] = new BoardUnit();
      }
    }
    initializeTheBoard();
  }


  @Override
  public void initializeTheBoard() {
    this.wholeBroad[0][0].setPiece(new Rook(0, 0, BW.WHITE));
    this.wholeBroad[1][0].setPiece(new Knight(1, 0, BW.WHITE));
    this.wholeBroad[2][0].setPiece(new Bishop(2, 0, BW.WHITE));
    this.wholeBroad[3][0].setPiece(new Queen(3, 0, BW.WHITE));
    this.wholeBroad[4][0].setPiece(new King(4, 0, BW.WHITE));
    this.wholeBroad[5][0].setPiece(new Bishop(5, 0, BW.WHITE));
    this.wholeBroad[6][0].setPiece(new Knight(6, 0, BW.WHITE));
    this.wholeBroad[7][0].setPiece(new Rook(7, 0, BW.WHITE));

    for (int i = 0; i < 8; i++) {
      this.wholeBroad[i][1].setPiece(new Pawn(i, 1, BW.WHITE));
      this.wholeBroad[i][6].setPiece(new Pawn(i, 6, BW.BLACK));
    }

    this.wholeBroad[0][7].setPiece(new Rook(0, 7, BW.BLACK));
    this.wholeBroad[1][7].setPiece(new Knight(1, 7, BW.BLACK));
    this.wholeBroad[2][7].setPiece(new Bishop(2, 7, BW.BLACK));
    this.wholeBroad[3][7].setPiece(new Queen(3, 7, BW.BLACK));
    this.wholeBroad[4][7].setPiece(new King(4, 7, BW.BLACK));
    this.wholeBroad[5][7].setPiece(new Bishop(5, 7, BW.BLACK));
    this.wholeBroad[6][7].setPiece(new Knight(6, 7, BW.BLACK));
    this.wholeBroad[7][7].setPiece(new Rook(7, 7, BW.BLACK));
  }

  @Override
  public void setPieceOntoBoard(ChessPiece a) {
    this.wholeBroad[a.getRow()][a.getColoum()].setPiece(a);
  }

  @Override
  public ChessPiece getPieceOnPosition(int x, int y) {
    return this.wholeBroad[x][y].whatPieceItHas();
  }

  @Override
  public boolean canMove2(ChessPiece a, int x, int y) {
    switch (a.getChessType()) {
      case PAWN:
        return a.canMove(x, y) || a.canKill(this.wholeBroad[x][y].whatPieceItHas());

      case KNIGHT:
        if (!a.canMove(x, y)) {
          return false;
        }
        if (!this.wholeBroad[x][y].isThereAPiece()) {
          return true;
        }
        return a.canKill(this.wholeBroad[x][y].whatPieceItHas());

      default:

        if (!a.canMove(x, y)) {
          return false;
        }

        boolean canMove2ReturnVal = true;

        int horizonDiffer = Math.abs(x - a.getRow());
        int verticalDiffer = Math.abs(y - a.getColoum());

        int standard = Math.max(horizonDiffer, verticalDiffer);

        for (int i = 1; i < standard; i++) {
          int checkX = (x - a.getRow()) / standard * i + a.getRow();
          int checkY = (y - a.getColoum()) / standard * i + a.getColoum();
          if (this.wholeBroad[checkX][checkY].isThereAPiece()) {
            return false;
          }
        }
        if (this.wholeBroad[x][y].isThereAPiece()) {
          return a.canKill(this.wholeBroad[x][y].whatPieceItHas());
        }

        return canMove2ReturnVal;
    }
  }


}
