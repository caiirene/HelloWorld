public class Fraction {

  private int numerator;
  private int denominator;

  public Fraction(int x, int y) throws IllegalArgumentException {
    if (y <= 0) {
      throw new IllegalArgumentException();
    }
    this.numerator = x;
    this.denominator = y;
  }

  public Fraction() {
    this.numerator = 1;
    this.denominator = 1;
  }

  public void setNumerator(int numerator) {
    this.numerator = numerator;
  }

  public void setDenominator(int denominator) throws IllegalArgumentException {
    if (denominator <= 0) {
      throw new IllegalArgumentException();
    }
    this.denominator = denominator;
  }

  public int getNumerator() {
    return this.numerator;
  }

  public int getDenominator() {
    return this.denominator;
  }

  private double getValue() {
    double a = this.numerator;
    double b = this.denominator;
    return a / b;
  }

  public double toDouble() {
    return this.getValue();
  }

  /*
  public double toDouble() {
    return (double)this.numerator/(double)this.denominator;
  }
   */

  private static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }

  public String toString() {
    String str;
    int greatestCommonDivisor;
    greatestCommonDivisor = gcd(this.numerator, this.denominator);
    int cleanedNumerator = this.numerator / greatestCommonDivisor;
    int cleanedDenominator = this.denominator / greatestCommonDivisor;

    str = String.format("your fraction is %d/%d.", cleanedNumerator, cleanedDenominator);

    return str;
  }

  public Fraction reciprocal() {
    //Fraction reciprocaledFraction;
    if (this.numerator == 0) {
      throw new IllegalArgumentException();
    }
    if (this.getValue() < 0) {
      return new Fraction(-this.denominator, -this.numerator);
    } else {
      return new Fraction(this.denominator, this.numerator);
    }
  }

  public Fraction add(Fraction anotherFraction) {
    int newDeno = this.denominator * anotherFraction.denominator;
    int newNumo =
        this.numerator * anotherFraction.denominator + anotherFraction.numerator * this.denominator;

    int maxCommonDivider = gcd(newNumo, newDeno);

    newNumo = newNumo / maxCommonDivider;
    newDeno = newDeno / maxCommonDivider;

    return new Fraction(newNumo, newDeno);
  }

  public int compareTo(Fraction anotherFraction) {
    if (this.getValue() > anotherFraction.getValue()) { return 1;}
    else if (this.getValue() < anotherFraction.getValue()) { return -1;}
    else { return 0;}
  }


}

