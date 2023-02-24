/**
 * Created by ashesh on 1/26/2017.
 */
public abstract class AbstractShape implements Shape {
  protected Point2D reference;

  /**
   * constructor
   * a shape has at least one point
   * @param reference
   */
  public AbstractShape(Point2D reference) {
    this.reference = reference;
  }

  /**
   * return the distance reference point to (0,0)
   * @return double distance
   */
  @Override
  public double distanceFromOrigin() {
    return reference.distToOrigin();
  }


  /**
   * it compare the area of a shap
   * @param s the object to be compared.
   * @return -1,0,1
   */
  @Override
  public int compareTo(Shape s) {
    double areaThis = this.area();
    double areaOther = s.area();

    if (areaOther - areaThis > 0.0001) {
      return -1;
    } else if (areaThis - areaOther > 0.0001) {
      return 1;
    } else {
      return 0;
    }
  }
  /*question3: change here will be "if (perimeterThis<perimeterOther)".
  Of course, redefine those two variables as well.
  If we don't have this abstract class, we just add this compareTo into three concrete classes.
   By the way, since we are comparing doubles, we want to detect the difference bigger than 0.0001
   otherwise, they will never be same.
   */
}