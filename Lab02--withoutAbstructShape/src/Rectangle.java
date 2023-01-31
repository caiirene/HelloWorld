/**
 * This class represents a rectangle.  It defines all the operations mandated by
 * the Shape interface
 */
public class Rectangle implements Shape {
  private double width, height;
  private double x, y;

  /**
   * Constructs a rectangle object with the given location of its lower-left
   * corner and dimensions
   *
   * @param x      x coordinate of the lower-left corner of this rectangle
   * @param y      y coordinate of the lower-left corner of this rectangle
   * @param width  width of this rectangle
   * @param height height of this rectangle
   */
  public Rectangle(double x, double y, double width, double height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  /*
   * Return the distance between LL coner and Origin
   * @return the distance
   */
  @Override
  public double distanceFromOrigin() {
    return Math.sqrt(this.x * this.x + this.y * this.y);
  }//Repetitive

  /*
   * Return the area of rectangle by it own radius
   * @return the area of this rectangle
   */
  @Override
  public double area() {
    return this.width * this.height;
  }

  /*
   * Return the perimeter of rectangle by it own h/w
   * @return the perimeter of this rectangle
   */
  @Override
  public double perimeter() {
    return 2 * (this.width + this.height);
  }

  /*
   * take 几倍 as factor, which means a bigger circle should be created
   * Return a new Rectangle object
   * @return Rectangle object
   */
  @Override
  public Shape resize(double factor) {
    double sqrtFactor = Math.sqrt(factor);
    return new Rectangle(
        this.x,
        this.y,
        sqrtFactor * this.width,
        sqrtFactor * this.height);
  }

  /*
   * we need two objects for this methods
   * Return -1 if this Rectangle's area is smaller than the compare one
   * Return 1 if this Rectangle's area is bigger than the compare one
   * Return 0 if this Rectangle's area is equal than the compare one
   */
  @Override
  public int compareTo(Shape s) {
    double areaThis = this.area();
    double areaOther = s.area();

    if (areaThis < areaOther) {
      return -1;
    } else if (areaOther < areaThis) {
      return 1;
    } else {
      return 0;
    }//Repetitive
  }

  public String toString() {
    return String.format("Rectangle: LL corner (%.3f,%.3f) width %.3f height " +
            "%.3f",
        this.x, this.y, this.width, this.height);
  }
}