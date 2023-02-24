/**

 The Point2DTest class contains JUnit tests for the Point2D class.
 It tests various methods of the Point2D class, such as distToOrigin, getX, getY, sameTo,
 getDistanceFromAnother2DPoint, increaseX, and increaseY.
 @author [author name]
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class Point2DTest {

  /**

   Test method for {@link Point2D#distToOrigin()}.
   */
  @Test
  public void distToOrigin() {
    Point2D test = new Point2D(1,0);
    assertEquals(1,test.distToOrigin(),0.0001);
    Point2D test2 = new Point2D(-1,0);
    assertEquals(1,test2.distToOrigin(),0.0001);
  }

  /**

   Test method for {@link Point2D#getY()}.
   */
  @Test
  public void getX() {
    Point2D test = new Point2D(1,0);
    assertEquals(1,test.getX(),0.0001);
    Point2D test2 = new Point2D(-1,0);
    assertEquals(-1,test2.getX(),0.0001);
  }

  /**

   Test method for {@link Point2D#getY()}.
   */
  @Test
  public void getY() {
    Point2D test = new Point2D(1,0);
    assertEquals(0,test.getY(),0.0001);
    Point2D test2 = new Point2D(-1,0);
    assertEquals(0,test2.getY(),0.0001);
  }

  /**
   Test method for {@link Point2D#sameTo(Point2D)}.
   */
  @Test
  public void sameTo() {
    Point2D test = new Point2D(1,0);
    Point2D test2 = new Point2D(1,0);
    assertEquals(true,test2.sameTo(test));
    Point2D test3 = new Point2D(3,0);
    Point2D test4 = new Point2D(1,0);
    assertEquals(true,test2.sameTo(test));
  }

  /**

   Test method for {@link Point2D#getDistanceFromAnother2DPoint(Point2D)}.
   */
  @Test
  public void getDistanceFromAnother2DPoint() {
    Point2D test = new Point2D(1,0);
    Point2D test2 = new Point2D(-1,0);
    assertEquals(2,test2.getDistanceFromAnother2DPoint(test),0.0001);
    assertEquals(0,test2.getDistanceFromAnother2DPoint(test2),0.0001);
  }

  /**

   Test method for {@link Point2D#increaseX(double)}.
   */
  @Test
  public void increaseX() {
    Point2D test = new Point2D(1,0);
    test.increaseX(2);
    Point2D test2 = new Point2D(-1,0);
    test2.increaseX(2);
    assertEquals(3,test.getX(),0.001);
    assertEquals(1,test2.getX(),0.001);
  }

  /**

   Test method for {@link Point2D#increaseX(double)}.
   */
  @Test
  public void increaseY() {
    Point2D test = new Point2D(1,0);
    test.increaseY(2);
    assertEquals(2,test.getY(),0.001);
    test.increaseY(2);
    assertEquals(4,test.getY(),0.001);
    assertEquals(1,test.getX(),0.001);
  }
}