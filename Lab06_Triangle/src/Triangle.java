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

  @Override
  public double area() {
    return 0;
  }

  @Override
  public double perimeter() {
    return 0;
  }

  @Override
  public Shape resize(double factor) {
    return null;
  }
}
