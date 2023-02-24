/**
 * this class can provide object of shape
 * it has three points stored in
 */
public class Triangle extends AbstractShape {
  private Point2D reference2;
  private Point2D reference3;


  /**
   * constructor
   * it take 6 doubles, and make them as three point2d object,
   * and our triangle will hold these three point2d objects
   * @param x x-axis for point1
   * @param y y-axis for point1
   * @param x2 x-axis for point2
   * @param y2 y-axis for point2
   * @param x3 x-axis for point3
   * @param y3 y-axis for point3
   * @throws IllegalArgumentException
   */
  public Triangle(double x, double y, double x2, double y2, double x3, double y3) throws IllegalArgumentException{
    super(new Point2D(x,y));
    this.reference2 = new Point2D(x2,y2);
    this.reference3 = new Point2D(x3,y3);
    if (this.reference.sameTo(this.reference2) || this.reference.sameTo(this.reference3) || this.reference2.sameTo(this.reference3)) {
      throw new IllegalArgumentException();
    }
  }

  /**
   * toString method provide info about this triangle
   * @return
   */
  public String toString() {

    String str = String.format("triangle: (%.3f,%.3f)(%.3f,%.3f)(%.3f,%.3f)",
        this.reference.getX(), this.reference.getY(),
        this.reference2.getX(),this.reference2.getY(),
        this.reference3.getX(),this.reference3.getY());
    /*String str = "this triangle has three points at " +
        "("+this.reference.getX()+","+this.reference.getY()+")" +
        "("+this.reference2.getX()+","+this.reference2.getY()+")" +
        "("+this.reference3.getX()+","+this.reference3.getY()+")";

     */
    return str;
  }


  /**
   * this method calculate the area of this triangle object
   * if the triangle has three points on same line,
   * it will return 0
   * @return area
   */
  @Override
  public double area() {
    /*
    我解释一下，这里先判断这三个点的横坐标是否完全相同，或竖坐标完全相同
    这样是判断这三点是否在同一竖线或横线
    然后再判断三点斜率相同
    因为前面把竖坐标相同情况拦截下来了，所以不怕斜率为无穷
     */
    if (this.reference.getX() == this.reference2.getX()
        && this.reference2.getX()==this.reference3.getX()) {
      //System.out.println("在一条竖线上");
      return 0;

    }
    else if (this.reference.getY() == this.reference2.getY()
        && this.reference2.getY()==this.reference3.getY()) {
      //System.out.println("在一条横线上");
      return 0;
    }
    else if (Math.abs(this.reference.getVector(this.reference2) - this.reference.getVector(this.reference3)) < 0.000001 ) {
      return 0;
    }

    double p = this.perimeter() / 2.0;

    double a = this.reference.getDistanceFromAnother2DPoint(this.reference2);
    double b = this.reference2.getDistanceFromAnother2DPoint(this.reference3);
    double c = this.reference3.getDistanceFromAnother2DPoint(this.reference);

    double area = Math.pow(p*(p-a)*(p-b)*(p-c),0.5);

    return area;
  }

  /**
   * return the perimeter of this triangle
   * @return perimeter
   */
  @Override
  public double perimeter() {
    double side_1 = this.reference.getDistanceFromAnother2DPoint(this.reference2);
    double side_2 = this.reference2.getDistanceFromAnother2DPoint(this.reference3);
    double side_3 = this.reference3.getDistanceFromAnother2DPoint(this.reference);

    double perimeter = side_1+side_2+side_3;
    return perimeter;
  }

  /**
   * it takes a factor that 几倍于 the original area,
   * it will make this object change.
   * @param factor factor of resizing
   * @return
   */
  @Override
  public Shape resize(double factor) throws IllegalArgumentException {
    if (factor<=0) {
      throw new IllegalArgumentException();
    }
    double realFactor = Math.sqrt(factor);
    this.reference2.extendFromAnother(realFactor, this.reference);
    this.reference3.extendFromAnother(realFactor, this.reference);
    return this;
  }

}
