/**
 * test on triangle class
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TriangleTest {

  /**
   * set up first
   */
  Shape circle1,circle2,circle3,rect1,rect2,tri1,tri2,tri3,tri4,tri5;

  /**
   * here we create a lot of shapes
   */
  @Before
  public void setup() {
    circle1 = new Circle(3,4,5);
    circle2 = new Circle(10.32,10.43,10);
    circle3 = new Circle(20);

    rect1 = new Rectangle(5,6,2.5,2);
    rect2 = new Rectangle(2,3,10,10);

    tri1 = new Triangle(1,1,2,2,3,3); //一条线
    tri2 = new Triangle(1,1,2,2,1,3); //大三角
    tri3 = new Triangle(1,1,2,2,1,2); //小上三角
    tri4 = new Triangle(1,1,2,2,2,1); //小下三角
    tri5 = new Triangle(0,3,2,2,2,1);
  }

  /**
   * test distanceFromOrigin()
   * it should return the correct double
   */
  @Test
  public void testDistanceFromOrigin() {
    assertEquals(1.41421356237, tri1.distanceFromOrigin(),0.001);
    assertEquals(1.41421356237, tri2.distanceFromOrigin(),0.001);
    assertEquals(1.41421356237, tri3.distanceFromOrigin(),0.001);
    assertEquals(3, tri5.distanceFromOrigin(),0.001);
  }

  /**
   * test on compareTo() method in abstract class
   */
  @Test
  public void compareTo() {

    assertEquals(0,tri3.compareTo(tri4));
    assertEquals(-1,tri1.compareTo(rect1));
    assertEquals(1,rect2.compareTo(tri2));
    assertEquals(-1,tri3.compareTo(tri5));
  }

  /**
   * test on toString() method in triangle class
   */
  @Test
  public void testToString() {
    String expect = "triangle: (1.000,1.000)(2.000,2.000)(3.000,3.000)";
    assertEquals(expect,tri1.toString());
    expect = "triangle: (1.000,1.000)(2.000,2.000)(1.000,3.000)";
    assertEquals(expect,tri2.toString());
    expect = "triangle: (0.000,3.000)(2.000,2.000)(2.000,1.000)";
    assertEquals(expect,tri5.toString());
  }


  /**
   * test on area() method in triangle class
   */
  @Test
  public void area() {
    assertEquals(0.5, tri3.area(),0.001);
    assertEquals(0.5, tri4.area(),0.001);
    assertEquals(0.0, tri1.area(),0.001);
  }

  /**
   * test on perimeter() method in triangle class
   */
  @Test
  public void perimeter() {

    assertEquals(3.41421356237, tri3.perimeter(),0.001);
    assertEquals(5.65685424949, tri1.perimeter(),0.001);
    assertEquals(4.82842712474, tri2.perimeter(),0.001);
  }

  /**
   * test on resize() method in triangle class
   */
  @Test
  public void resize() {
    tri3.resize(4);
    String except = "triangle: (1.000,1.000)(3.000,3.000)(1.000,3.000)";
    assertEquals(except, tri3.toString());
    tri4.resize(4);
    except = "triangle: (1.000,1.000)(3.000,3.000)(3.000,1.000)";
    assertEquals(except, tri4.toString());
    tri1.resize(4);
    except = "triangle: (1.000,1.000)(3.000,3.000)(5.000,5.000)";
    assertEquals(except, tri1.toString());
  }


  /**
   * test on resize() method that will raise error
   */
  @Test (expected = IllegalArgumentException.class)
  public void tryError() {
    tri1.resize(-1);
  }

  /**
   * test on constructor that will raise error
   */
  @Test (expected = IllegalArgumentException.class)
  public void tryError2() {
    Shape wrong = new Triangle(1,1,1,1,1,1);
  }
}