import java.util.Comparator;

public class PerimComparator implements Comparator<Shape> {

  @Override
  public int compare(Shape o1, Shape o2) {
    if (o1.area()<o2.area()) {
      return -1;
    }
    else if (o1.area()>o2.area()) {
      return 1;
    }
    else {
      return 0;
    }
  }
}
