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

  private void markAsFromOrigin(Point2D another) {
    this.x = this.x-another.getX();
    this.y = this.y-another.getY();
  }

  private void extendFromOrigin(double factor) {
    this.x = this.x * factor;
    this.y = this.y * factor;
  }
  protected void extendFromAnother(double factor, Point2D another) {
    markAsFromOrigin(another);

    extendFromOrigin(factor);

    increaseX(another.getX());
    increaseY(another.getY());
  }
}