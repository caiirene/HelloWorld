public interface Fraction extends Comparable<Fraction> {

  int getNumerator();

  int getDenominator();

  double toDouble();

  Fraction reciprocal();

  Fraction add(Fraction anotherFraction);

  int compareTo(Fraction anotherFraction);

}
