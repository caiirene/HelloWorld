public class GetVector {

  public double getVector(Point2D a, Point2D b) {
    double vector = (a.getX()-b.getX())/(a.getY()-b.getY());
    return vector;
  }

}
