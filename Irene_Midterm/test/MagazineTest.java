import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit4 test Class for Magazine
 */
public class MagazineTest {
  private Person pat;
  private Person john;
  private Magazine mag1;
  private Magazine mag2;
  private Magazine mag3;

  /**
   * Set up examples of  Persons and Magazines to use in testing
   */
  @Before
  public void setUp() {
    pat = new Person("Pat", "Conroy", 1948);
    john = new Person("John", "Steinbeck", 1902);
    mag1 = new Magazine("Beaches Issue", pat, 2020,
        Month.MARCH, 5.0);
    mag2 = new Magazine("Sunsets Issue", pat, 2021,
        Month.SEPTEMBER, 2.50);
    mag3 = new Magazine("The Grapes of July", john, 1939,
        Month.JULY, 2.00);
  }

  @Test
  public void testToString() {
    String expected;
    expected = """
        Kind: Magazine
        Title: Beaches Issue
        Author: Pat Conroy
        Year: 2020
        Month: MARCH
        Price: 5.00""";
    assertEquals(expected, mag1.toString());
    assertNotEquals(expected, mag2.toString());
  }
}