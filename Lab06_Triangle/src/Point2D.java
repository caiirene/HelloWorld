/**
 * This class represents a 2D point. This point is denoted in Cartesian
 * coordinates as (x,y).
 */
public class Point2D {
  private double x;
  private double y;

  /**
   * Construct a 2d point with the given coordinates
   *
   * @param x the x-coordinate of this point
   * @param y the y-coordinate of this point
   */
  public Point2D(double x, double y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Compute and return the Euclidean distance of this point to the origin
   *
   * @return the euclidean distance
   */

  public double distToOrigin() {
    return Math.sqrt(x * x + y * y);
  }

  /**
   * Return the x-coordinate of this point
   *
   * @return x-coordinate of this point
   */
  public double getX() {
    return x;
  }

  /**
   * Return the y-coordinate of this point
   *
   * @return y-coordinate of this point
   */
  public double getY() {
    return y;
  }


  public boolean sameTo(Point2D another) {
    boolean returnVal = false;
    if (this.x == another.getX() && this.y == another.getY()) {
      returnVal = true;}
    return returnVal;
  }

  public double getDistanceFromAnother2DPoint (Point2D another) {
      return Math.pow(
          (Math.pow((this.x-another.getX()),2)
          + Math.pow((this.y-another.getY()),2))
          ,0.5);
  }

  public void increaseX(double increment) {
    this.x = this.x + increment;
  }

  public void increaseY(double increment) {
    this.y = this.y + increment;
  }

  /**
   * this method will take another Point2D and assume that point is origin
   * and then change the xy in this object
   * @param another
   */
  private void markAsFromOrigin(Point2D another) {
    this.x = this.x-another.getX();
    this.y = this.y-another.getY();
  }

  /**
   * this method will take a factor
   * and change the xy by time the factor
   * @param factor
   */
  private void extendFromOrigin(double factor) {
    this.x = this.x * factor;
    this.y = this.y * factor;
  }

  /**
   * this is a combo of markAsOrigin and extendFromOrigin
   * it extend the xy from a given point
   * @param factor
   * @param another
   */
  protected void extendFromAnother(double factor, Point2D another) {
    markAsFromOrigin(another);

    extendFromOrigin(factor);

    increaseX(another.getX());
    increaseY(another.getY());
  }

  /**
   * this calculate the 斜率 between two points
   * 如果在同一竖线，斜率为无穷（因为分母为0）
   * @param another
   * @return
   */
  public double getVector(Point2D another) {
    if (this.x - another.getX() != 0) {
    double vactor = (another.getY() - this.y)/(another.getX() - this.x);
    vactor = Math.abs(vactor);
    return vactor;}
    else {
      //System.out.println("这两个点在一条竖线上，斜率为无穷");
      return 999999999;
    }
  }

  public double gettV(Point2D a, Point2D b) {
    GetVector<Point2D> myG = (c, d) -> c.getX() - d.getX();

    return  myG.getVectorr(a,b);
  }

}