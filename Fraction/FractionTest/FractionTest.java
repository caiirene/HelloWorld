import static org.junit.Assert.assertEquals;

import java.util.Random;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.awt.desktop.UserSessionEvent;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class FractionTest {

  private static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }

  /*测试所有分子，和正数分母*/
  @Test
  public void setUpGoodFraction() {
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
    }
  }

    @Test
    public void setUpBadFraction() {
      Fraction f;
      Random r = new Random();
      int n = 1000000; //这个是正数分母范围

      for (int i = 0; i < 10000; i++) {
        int a = r.nextInt();
        //System.out.println(a);
        int b = -(r.nextInt(n));
        f = new Fraction(a, b);

        int maxCommonDivider = gcd(a, b);
        int exceptA = a / maxCommonDivider;
        int exceptB = b / maxCommonDivider;
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