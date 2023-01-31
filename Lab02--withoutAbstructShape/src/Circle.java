/**
 * This class represents a circle.  It offers all the operations mandated by the
 * Shape interface.
 */
public class Circle implements Shape {
  private double radius;
  private double centerx, centery;


  /**
   * Construct a circle object using the given center and radius
   * @param x x coordinate of the center of this circle
   * @param y y coordinate of the center of this circle
   * @param radius the radius of this circle
   */
  public Circle(double x, double y, double radius) {
    this.centerx = x;
    this.centery = y;
    this.radius = radius;
  }

  /**
   * Construct a circle object with the given radius. It is centered at (0,0)
   * @param radius the radius of this circle
   */
  public Circle(double radius) {
    this.centerx = 0;
    this.centery = 0;
    this.radius = radius;
  }

  /*
   * Return the area of circle by it own radius
   * @return the area of this circle
   */
  @Override
  public double area() {
    return Math.PI * radius * radius;
  }

  /*
   * Return the perimeter of circle by it own radius
   * @return the perimeter of this circle
   */
  @Override
  public double perimeter() {
    return 2 * Math.PI * radius;
  }

  /*
   * take 几倍 as factor, which means a bigger circle should be created
   * Return a new Circle object
   * @return Circle object
   */
  @Override
  public Shape resize(double factor) {
    return new Circle(this.centerx, this.centery, Math.sqrt(factor) * radius);
  }

  /*
   * Return the distance between center and Origin
   * @return the distance
   */
  @Override
  public double distanceFromOrigin() {
    return Math.sqrt(this.centerx * this.centerx + this.centery * this.centery);
  }
  //Repetitive

  /*
   * we need two objects for this methods
   * Return -1 if this circle's area is smaller than the compare one
   * Return 1 if this circle's area is bigger than the compare one
   * Return 0 if this circle's area is equal than the compare one
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
    }
  }//Repetitive


  public String toString() {
    return String.format("Circle: center (%.3f,%.3f) radius %.3f",
        this.centerx,this.centery,this.radius);
  }
}