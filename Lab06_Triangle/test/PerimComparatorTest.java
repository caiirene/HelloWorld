import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * this is a test on PerimComparator class
 * only one method inside PerimComparator class
 */
public class PerimComparatorTest {


  /**
   * test the compare methoed
   * they should return correct -1,0,1
   */
  @Test
  public void perCom() {
    Shape test_1 = new Triangle(1, 1, 2, 2, 1, 2);
    Shape test_2 = new Triangle(1, 1, 2, 2, 1, 3);
    Shape test_3 = new Triangle(1, 1, 2, 2, 1, 2);
    Shape test_4 = new Triangle(1, 1, 2, 2, -1, 2);

    double a, b, c, d;
    a = test_1.perimeter();
    b = test_2.perimeter();
    c = test_3.perimeter();
    d = test_4.perimeter();

    int real_1 = new PerimComparator().compare(test_1,test_2);
    assertEquals(-1,real_1);
    assertEquals(1, new PerimComparator().compare(test_2,test_3));
    assertEquals(1, new PerimComparator().compare(test_4,test_3));
    assertEquals(1, new PerimComparator().compare(test_4,test_2));
    assertEquals(0, new PerimComparator().compare(test_1,test_3));

  }


}