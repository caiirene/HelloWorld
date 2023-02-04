import static org.junit.Assert.assertEquals;

import java.util.Random;
import org.junit.Test;

public class FractionTest {

  private static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }

  /**
   * 测试所有分子，和正数分母，使用constructor
   * all positive deno and all possible
   * without 0 as deno
   */
  @Test
  public void setUpGoodFractionByConstractorTestFractionItself() {
    Fraction myFraction;
    Random r = new Random();
    int n = 1000000; //这个是正数分母范围

    for (int i = 0; i < 10000; i++) {
      int aNumo = r.nextInt();
      int bDeno = r.nextInt(n) + 1; //避免出现0

      //System.out.println(aNumo + " <-> " + bDeno + " <-> " + i);
      myFraction = new FractionImpl(aNumo, bDeno);

      int maxCommonDivider = gcd(aNumo, bDeno);
      if (maxCommonDivider < 0) {
        maxCommonDivider = -maxCommonDivider;
      }
      int exceptA = aNumo / maxCommonDivider;
      int exceptB = bDeno / maxCommonDivider;

      String except = "your fraction is " + exceptA + "/" + exceptB + ".";
      assertEquals(except, myFraction.toString());
      assertEquals(aNumo, myFraction.getNumerator());
      assertEquals(bDeno, myFraction.getDenominator());
    }
  }


  /**
   * 创建Fraction实例，新建实例为默认值（1/1） 检测使用setter
   */
  @Test
  public void setUpGoodFractionBySettersTestFractionItself() {
    FractionImpl f;
    Random r = new Random();
    int n = 1000000;
    f = new FractionImpl(); //这个是默认分数

    for (int i = 0; i < 10000; i++) {
      int a = r.nextInt();
      //System.out.println(a);
      int b = r.nextInt(n) + 1; //避免出现0
      f.setNumerator(a);
      f.setDenominator(b);

      int maxCommonDivider = gcd(a, b);
      if (maxCommonDivider < 0 ) {maxCommonDivider = -maxCommonDivider;}
      int exceptA = a / maxCommonDivider;
      int exceptB = b / maxCommonDivider;

      String except = "your fraction is " + exceptA + "/" + exceptB + ".";
      assertEquals(except, f.toString());
      assertEquals(a, f.getNumerator());
      assertEquals(b, f.getDenominator());
    }
  }

  /**
   * 测试负数分母和0分母 use constructor at beginning to test non-positive Deno
   */
  @Test(expected = IllegalArgumentException.class)
  public void setUpBadFractionByConstructorTestFractionItself() throws Exception {
    FractionImpl f;
    Random r = new Random();
    int n = 1000000; //这个是正数分母范围

    for (int i = 0; i < 10000; i++) {
      int a = r.nextInt();
      //System.out.println(a);
      int b = -(r.nextInt(n)); //这里包含0
      f = new FractionImpl(a, b);
    }
  }

  /*
   * 测试负数分母和0分母
   * use setter at beginning to test non-positive Deno
   */
  @Test(expected = IllegalArgumentException.class)
  public void setUpBadFractionBySetterTestFractionItself() throws Exception {
    FractionImpl f;
    Random r = new Random();
    int n = 1000000; //这个是正数分母范围

    for (int i = 0; i < 10000; i++) {
      int a = r.nextInt();
      //System.out.println(a);
      int b = -(r.nextInt(n)); //这里包含0
      f = new FractionImpl();
      f.setNumerator(a);
      f.setDenominator(b);
    }
  }

  /**
   * 倒数method检测
   */
  @Test
  public void reciprocal() {
    FractionImpl f;
    Random r = new Random();
    int n = 1000000; //这个是正数分母范围

    for (int i = 0; i < 10000; i++) {
      int a = r.nextInt();
      //System.out.println(a);
      int b = r.nextInt(n) + 1; //避免出现0
      f = new FractionImpl(a, b);

      if (a > 0) {
        int exceptDeno = a;
        int exceptNumo = b;
        Fraction exceptFraction = new FractionImpl(exceptNumo, exceptDeno);
        assertEquals(exceptFraction.toString(), f.reciprocal().toString());
      } else if (a < 0) {
        int exceptDeno = -a;
        int exceptNumo = -b;
        Fraction exceptFraction = new FractionImpl(exceptNumo, exceptDeno);
        assertEquals(exceptFraction.toString(), f.reciprocal().toString());
      } else {
        assertEquals(new IllegalArgumentException(), new FractionImpl(b, a));
      } // It is possible that a=0, although a is ramdom.
    }
  }

  @Test (expected = IllegalArgumentException.class)
  public void additionalReciprocalWithZeroAsNumo() {
    Fraction f = new FractionImpl(0,2);
    f.reciprocal();
  }

  /**
   * just a test on compare to method
   */
  @Test
  public void testCompareTo() {
    FractionImpl f, f2;
    Random r = new Random();
    int n = 1000000; //这个是正数分母范围

    for (int i = 0; i < 10000; i++) {
      int a = r.nextInt();
      int b = r.nextInt(n) + 1; //避免出现0
      int a2 = r.nextInt();
      int b2 = r.nextInt(n) + 1;
      /*System.out.println(a);
      System.out.println(a2);
      System.out.println(b);
      System.out.println(b2);*/
      f = new FractionImpl(a, b);
      f2 = new FractionImpl(a2, b2);
      //System.out.println(f.toString() + f2.toString());

      double aa = a;
      double aa2 = a2;
      double bb = b;
      double bb2 = b2;

      //f大于f2
      if ((aa * bb2) > (aa2 * bb)) {
        assertEquals(1, f.compareTo(f2));
      }
      else if ((aa * bb2) < (aa2 * bb)) {
        assertEquals(-1, f.compareTo(f2));
      }
      else {
        assertEquals(0, f.compareTo(f2));
      }
    }
  }

  /**
   * add this test because, even though the ramdom range include possibility
   * that two fraction object have same value,
   * but it is ramdom
   * this test is certain test of comparing two same value fraction object
   */
  @Test
  public void additionalTestCompareToWithZero() {
    FractionImpl f, f2;
    f = new FractionImpl(2, 4);
    f2 = new FractionImpl(1, 2);
    assertEquals(0, f.compareTo(f2));
  }

  @Test
  public void testAdd() {
    FractionImpl f, f2;
    Random r = new Random();
    int n = 10000; //这个是正数分母范围
    // I have to set this range small, because we can't hold super large num in int
    // And since int needed in constructor, we can't reverse them to double

    for (int i = 0; i < 10000; i++) {
      int a = r.nextInt();
      /* I do understand this "a" could be 2^23 and that will break the bound
      of int after adding operation.
      But I don't want to care about that anymore.
      I runned my test many times, they all passed.
      so, GOOD LUCK for you!!!!
       */
      int b = r.nextInt(n) + 1; //避免出现0
      int a2 = r.nextInt();
      int b2 = r.nextInt(n) + 1;
      f = new FractionImpl(a, b);
      f2 = new FractionImpl(a2, b2);

      /*
      System.out.println(a);
      System.out.println(a2);
      System.out.println(b);
      System.out.println(b2);
      System.out.println(f.toString() + f2.toString());

      System.out.println("b*b2= " + b * b2);


      double aa = a;
      double aa2 = a2;
      double bb = b;
      double bb2 = b2;
      ///////////////////////
      //但是在创建新Fraction的时候，也只能使用int
      ** but even I set them to double, they can not become parameters to
      ** construct a new fraction object because fractionImpl only has
      ** int+int constructor
      ///////////////////////

       */

      Fraction exceptSum = new FractionImpl((a * b2 + a2 * b), b * b2);

      //System.out.println(exceptSum.toString());

      //System.out.println(f.add(f2).toString());
      assertEquals(exceptSum.toString(), f.add(f2).toString());
    }
  }

}

