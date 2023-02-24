/**
 * this class only provide a method to compare two shapes
 */

import java.util.Comparator;

public class PerimComparator implements Comparator<Shape> {

  /**
   * there is no constructor here
   * we only have this method to compare the perimeter of two shapes
   * @param o1 the first object to be compared.
   * @param o2 the second object to be compared.
   * @return -1,0,1
   */
  @Override
  public int compare(Shape o1, Shape o2) {
    if (o1.perimeter()-o2.perimeter() >= 0.0001) {
      return 1;
    }
    else if (o2.perimeter()-o1.perimeter() >= 0.0001) {
      return -1;
    }
    else {
      return 0;
    }
  }
}
