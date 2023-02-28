public class Main {
  public static void main(String[] args) {
    Calculator addition = (num1, num2) -> num1 + num2;
    Calculator subtraction = (num1, num2) -> num1 - num2;
    Calculator multiplication = (num1, num2) -> num1 * num2;
    Calculator division = (num1, num2) -> num1 / num2;

    System.out.println(calculate(5, 3, addition)); // Output: 8.0
    System.out.println(calculate(5, 3, subtraction)); // Output: 2.0
    System.out.println(calculate(5, 3, multiplication)); // Output: 15.0
    System.out.println(calculate(5, 3, division)); // Output: 1.6666666666666667
  }

  public static double calculate(double num1, double num2, Calculator calculator) {
    return calculator.calculate(num1, num2);
  }
}