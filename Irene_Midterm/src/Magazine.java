import java.util.Objects;

/**
 * Represents a Magazine, which has title, author, year, month, price.
 * <p>
 * Also has Kind "Magazine" computed by method in AbstractPublication.
 */
public class Magazine extends AbstractPublication {
  // title, author, year, price are protected fields from parent
  // Only Magazines have a month field, though (an Enum type)
  private Month month;

  /**
   * Construct a Magazine with provided title, author, year, month, price
   * <p>
   * @param title  the title to be given to this book
   * @param author the author to be given to this book
   * @param year   the year of publication of the Magazine
   * @param month  the month of publication of the Magazine
   * @param price  the price to be assigned to this book
   * Unlike Books, Magazines also have a month of publication (an enum)
   */
  public Magazine(String title, Person author, int year, Month month, double price) {
    this.title = title;
    this.author = author;
    this.year = year;
    this.month = month;
    this.price = price;
  }

  /**
   * Method getMonth gets the month of this Magazine as constructed
   *
   * @return Month, an enum representing the month of publication
   * NB: This method is NOT part of the interface for Publications!
   */
  public Month getMonth() {
    return this.month;
  }

  /**
   * Checks if two Magazines have the same author
   * <p>
   * @param other, the other Publication
   * @return boolean, true iff the authors are equal
   */

  /*
  @Override
  public boolean sameAuthor(Publication other) {
    // Get the two authors and hand to equals
    Person author1 = this.getAuthor();
    Person author2 = other.getAuthor();
    return author1.equals(author2);
  }

   */

  /**
   * Method toString() returns a formatted String containing information about
   * this Magazine. The resulting String should be in the following format:
   * <p>
   *     Kind: the Kind of Publication ("Magazine")
   *     Title: title of the magazine
   *     Author: first-name last-name
   *     Year: four digit year
   *     Month: valueOf month (in title case)
   *     Price: in dollars, as decimal number, w 2 digits after decimal point
   * <p>
   * @return the String, formatted as shown
   */
  @Override
  public String toString() {
    String str;
    str = "Kind: " + this.getKind() +
          "\nTitle: " + this.title +
          "\nAuthor: " + this.author.toString() +
          "\nYear: " + this.year +
          "\nMonth: " + this.month.toString();
    str = str + String.format("\nPrice: %.2f", price);
    return str;
  }

  /**
   * Check if two magazines are equal based on fields
   * <p>
   * @param other, the other object to compare this to
   * @return true iff they are considered equal
   */
  @Override
  public boolean equals(Object other) {
    // Check if identical
    if (this == other)
      return true;
    // Check if null
    if (other == null)
      return false;
    // Check type compatibility
    if (!(other instanceof Magazine))
      return false;
    //FLAW: again, suggest not use
    //FIX: use try {
    //            some code
    //  }
    //  catch(something) {
    //    return false;
    //  }
    // Cast to Magazine type
    Magazine other_mag = (Magazine) other;
    // Compare fields
    return this.title.equals(other_mag.title)
        && this.author.equals(other_mag.author)
        && this.year == other_mag.year//FLAW: suggest to use getYear()
                                       //FIXED: && this.year == other_mag.getYear();
        && Math.abs(this.price - other_mag.price) < 0.001
        && this.month == other_mag.getMonth();
        //FLAW: how about month
        //FIXED: && this.month == other_mag.getMonth();
  }

  //FLAW: I think you need hashcode() method
  //FIXED:
  @Override
  public int hashCode() {
     return Objects.hash(title, author, year);
  }


}
