public class Triangle extends AbstractShape {
  private Point2D reference2;
  private Point2D reference3;


  public Triangle(int x, int y, int x2, int y2, int x3, int y3) throws IllegalArgumentException{
    super(new Point2D(x,y));
    this.reference2 = new Point2D(x2,y2);
    this.reference3 = new Point2D(x3,y3);
    if (this.reference.sameTo(this.reference2) || this.reference.sameTo(this.reference3) || this.reference2.sameTo(this.reference3)) {
      throw new IllegalArgumentException();
    }
  }

  public String toString() {
    String str = "this triangle has three points at " +
        "("+this.reference.getX()+","+this.reference.getY()+")" +
        "("+this.reference2.getX()+","+this.reference2.getY()+")" +
        "("+this.reference3.getX()+","+this.reference3.getY()+")";
    return str;
  }

  @Override
  public double area() {
    if (this.reference.getX() == this.reference2.getX()
        && this.reference2.getX()==this.reference3.getX()) {
      return 0;
    }
    else if (this.reference.getY() == this.reference2.getY()
        && this.reference2.getY()==this.reference3.getY()) {
      return 0;
    }

    double p = this.perimeter() / 2.0;

    double a = this.reference.getDistanceFromAnother2DPoint(this.reference2);
    double b = this.reference2.getDistanceFromAnother2DPoint(this.reference3);
    double c = this.reference3.getDistanceFromAnother2DPoint(this.reference);

    double area = Math.pow(p*(p-a)*(p-b)*(p-c),0.5);

    return area;
  }

  @Override
  public double perimeter() {
    double side_1 = this.reference.getDistanceFromAnother2DPoint(this.reference2);
    double side_2 = this.reference2.getDistanceFromAnother2DPoint(this.reference3);
    double side_3 = this.reference3.getDistanceFromAnother2DPoint(this.reference);

    double perimeter = side_1+side_2+side_3;
    return perimeter;
  }

  @Override
  public Shape resize(double factor) {
    double realFactor = Math.sqrt(factor);
    this.reference2.extendFromAnother(realFactor, this.reference);
    this.reference3.extendFromAnother(realFactor, this.reference);
    return this;
  }
  /*question2*/
}
