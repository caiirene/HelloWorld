public interface Fraction extends Comparable<Fraction> {


  /**
   * return the numo of this fraction object
   *
   * @return an int, the numo
   */
  int getNumerator();

  /**
   * return the deno of this fraction object
   *
   * @return an int, the deno
   */
  int getDenominator();

  /**
   * return the 1.2345 form of this fraction object
   *
   * @return a double, the value
   */
  double toDouble();

  /**
   * return the upside down form of this fraction object it means demo become numo, numo become
   * deno.
   *
   * @return a fraction object
   */
  Fraction reciprocal();

  /**
   * return the sum of this fraction with another fraction object
   *
   * @return a fraction object
   */
  Fraction add(Fraction anotherFraction);

  /**
   * return the result after compare this fraction's value to another fraction obeject's value
   * return 1, if this one is bigger return -1, if this one is smaller return 0, if two are same
   *
   * @return an int (1,-1,0)
   */
  int compareTo(Fraction anotherFraction);

}
