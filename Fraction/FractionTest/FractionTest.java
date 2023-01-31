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

  /*测试所有分子，和正数分母，使用constructor*/
  @Test
  public void setUpGoodFractionByConstractor() {
    Fraction f;
    Random r = new Random();
    int n = 1000000; //这个是正数分母范围

    for (int i = 0; i < 10000; i++) {
      int a = r.nextInt();
      //System.out.println(a);
      int b = r.nextInt(n) + 1; //避免出现0
      f = new Fraction(a, b);

      int maxCommonDivider = gcd(a, b);
      int exceptA = a / maxCommonDivider;
      int exceptB = b / maxCommonDivider;

      String except = "your fraction is " + exceptA + "/" + exceptB + ".";
      assertEquals(except, f.toString());
      assertEquals(a, f.getNumerator());
      assertEquals(b, f.getDenominator());
    }
  }


  /*
   *创建Fraction实例，新建实例为默认值（1/1）
   * 检测使用setter
   */
  @Test
  public void setUpGoodFractionBySetters() {
    Fraction f;
    Random r = new Random();
    int n = 1000000;
    f = new Fraction(); //这个是默认分数

    for (int i = 0; i < 10000; i++) {
      int a = r.nextInt();
      //System.out.println(a);
      int b = r.nextInt(n) + 1; //避免出现0
      f.setNumerator(a);
      f.setDenominator(b);

      int maxCommonDivider = gcd(a, b);
      int exceptA = a / maxCommonDivider;
      int exceptB = b / maxCommonDivider;

      String except = "your fraction is " + exceptA + "/" + exceptB + ".";
      assertEquals(except, f.toString());
      assertEquals(a, f.getNumerator());
      assertEquals(b, f.getDenominator());
    }
  }

  /*
   * 测试负数分母和0分母
   *
   */
    @Test (expected = IllegalArgumentException.class)
    public void setUpBadFraction() throws Exception {
      Fraction f;
      Random r = new Random();
      int n = 1000000; //这个是正数分母范围

      for (int i = 0; i < 10000; i++) {
        int a = r.nextInt();
        //System.out.println(a);
        int b = -(r.nextInt(n)); //这里包含0
        f = new Fraction(a, b);

        int maxCommonDivider = gcd(a, b);
        int exceptA = a / maxCommonDivider;
        int exceptB = b / maxCommonDivider;
      }
    }

  /*
   * 倒数method检测
   *
   */
  public void reciprocal() {
    Fraction f;
    Random r = new Random();
    int n = 1000000; //这个是正数分母范围

    for (int i = 0; i < 10000; i++) {
      int a = r.nextInt();
      //System.out.println(a);
      int b = r.nextInt(n) + 1; //避免出现0
      f = new Fraction(a, b);

      if (a)
    }

  }





    }



/*
  @Test
  public void setNumerator() {

  }

  @Test
  public void setDenominator() {
  }

  @Test
  public void toDouble() {
  }

  @Test
  public void testToString() {
  }

  @Test
  public void reciprocal() {
  }

  @Test
  public void add() {
  }

  @Test
  public void compareTo() {
  }
}

 */