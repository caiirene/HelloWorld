

public class FractionImpl implements Fraction {

  private int numerator;
  private int denominator;

  /*
  private double bigNumerator;
  private double bigDenominator;
  */

  public FractionImpl(int x, int y) throws IllegalArgumentException {
    if (y <= 0) {
      throw new IllegalArgumentException();
    }
    this.numerator = x;
    this.denominator = y;
  }


  public FractionImpl() {
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

  @Override
  public int getNumerator() {
    return this.numerator;
  }

  @Override
  public int getDenominator() {
    return this.denominator;
  }


  private double getValue() {
    double a = this.numerator;
    double b = this.denominator;
    return a / b;
  }

  @Override
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

  @Override
  public String toString() {
    String str;
    int greatestCommonDivisor;
    greatestCommonDivisor = gcd(this.numerator, this.denominator);
    if (greatestCommonDivisor < 0) { greatestCommonDivisor = -greatestCommonDivisor;}


    int cleanedNumerator = this.numerator / greatestCommonDivisor;
    int cleanedDenominator = this.denominator / greatestCommonDivisor;
    str = String.format("your fraction is %d/%d.", cleanedNumerator, cleanedDenominator);

    return str;
  }

  @Override
  public Fraction reciprocal() {
    //Fraction reciprocaledFraction;
    if (this.numerator == 0) {
      throw new IllegalArgumentException();
    }
    if (this.getValue() < 0) {
      return new FractionImpl(-this.denominator, -this.numerator);
    } else {
      return new FractionImpl(this.denominator, this.numerator);
    }
  }

  @Override
  public Fraction add(Fraction anotherFraction) {
    int newDeno = this.denominator * anotherFraction.getDenominator();
    int newNumo =
        this.numerator * anotherFraction.getDenominator() + anotherFraction.getNumerator() * this.denominator;

    int maxCommonDivider = gcd(newNumo, newDeno);
    if (maxCommonDivider < 0) { maxCommonDivider = -maxCommonDivider;}

    newNumo = newNumo / maxCommonDivider;
    newDeno = newDeno / maxCommonDivider;

    return new FractionImpl(newNumo, newDeno);
  }

  @Override
  public int compareTo(Fraction anotherFraction) {
    if (this.toDouble() > anotherFraction.toDouble()) { return 1;}
    else if (this.toDouble() < anotherFraction.toDouble()) { return -1;}
    else { return 0;}
  }
}

