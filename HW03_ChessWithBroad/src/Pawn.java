/**
 * concrete pawn class.
 * AbstractChessPiece implement ChessPiece, this bishop class extend AbstractChessPiece
 * this class can create an ChessPiece object
 * it has 横纵坐标, BW, and provide type as pawn to AbstractChessPiece
 */

import static java.lang.Math.abs;


public class Pawn extends AbstractChessPiece {


  /**
   * this construct an object of pawn chess
   * at x,y position
   * and color in your choice
   * @param x pos
   * @param y pos
   * @return object
   */
  public Pawn(int x, int y, BorW blackOrWhite) {
    super(x, y, blackOrWhite, Type.PAWN);
  }


  /**
   * check index in range 8 by public method
   * then black can only move down, white only up
   * this canMove do NOT include move by killing
   * @param x
   * @param y
   * @return
   */
  @Override
  public boolean canMove(int x, int y) {
    checkIndex(x,y);
    boolean pawnCanMove = false;
    switch (this.getBW()) {
      case BLACK:
        //System.out.println("this is black\n");
        if ((this.getRow() == x) && (this.getColoum() - y == 1)) {
          //System.out.println("this is black\n");
          pawnCanMove = true;
          break;
          //return true;
        }
        break;
      case WHITE:
        if ((this.getRow() == x) && (this.getColoum() - y == -1)) {
          pawnCanMove = true;
          break;
        }
        break;
    }
    return pawnCanMove;
  }


  /**
   * 首先判断颜色不同，然后再判断位置合适
   * 这个method和canMove是分开的，判断是重新做的
   * @param another
   * @return
   */
  @Override
  public boolean canKill(ChessPiece another) {
    if (another.getBW() == this.getBW()) {return false;}
    boolean pawnCanKill = false;
    switch (this.getBW()) {
      case BLACK:
        if ((this.getColoum()-another.getColoum()== 1) && (abs(this.getRow()-another.getRow())== 1)) {
          pawnCanKill = true;
          break;
        }
      case WHITE:
        if ((this.getColoum()-another.getColoum()== -1) && (abs(this.getRow()-another.getRow())== 1)) {
          pawnCanKill = true;
          break;
        }

    }
    return pawnCanKill;
  }
}
