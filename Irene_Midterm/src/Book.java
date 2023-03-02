import java.util.Objects;

/**
 * This class represents a Book. A Book has a title, author, year, price, and category.
 * <p>
 * The "kind" ("Book") is calculated by a method inherited method from AbstractPublication.
 * The other fields must be provided to Book's constructor when a new Book is created.
 * A book can be equal to another book even if their prices are different.
 * Book is a subclass of AbstractPublication, which implements Publication
 */
public class Book extends AbstractPublication {
  // Note: Book inherits protected fields title, author, year, and price from parent
  // It also inherits some concrete methods, but implement others directly

  /**
   * Construct a new Book object that has the provided title, author, year, and price
   * <p>
   * @param title, String representing the title of this book
   * @param author, Person who is the author of this book
   * @param year, int representing the year of publication
   * @param price, double representing the current price of this book
   */
  public Book(String title, Person author, int year, double price) {
    this.title = title;
    this.author = author;
    this.year = year;
    this.price = price;
  }

  /**
   * Checks if two Books have the same author
   * <p>
   * @param other, the other Publication
   * @return boolean, true iff the authors are equal
   */

  /*
  @Override
  public boolean sameAuthor(Publication other) {
    // Get the two authors and hand to equals
    Person author1 = this.getAuthor();
    // FLAW? suggest to use author or this.author, but it's ok to use getAuthor()
    Person author2 = other.getAuthor();
    return author1.equals(author2);
  }

   */

  /**
   * Return a formatted string that contains key information about this.
   * <p>
   * The string should be in the following format:
   * Category: [Book]
   * Title: [title of the book]
   * Author: [first-name last-name]
   * Year: [year of publication]
   * Price: [Price as a decimal number with two numbers after decimal]
   * 
   * @return String, the formatted string as above
   */
  public String toString() {
    String str;
    str = "Kind: "+this.getKind()+"\nTitle: "+this.title+"\nAuthor: "+this.author+
          "\nYear: "+this.year+String.format("\nPrice: %.2f",this.price);
    return str;
  }
  //FLAW: suggest to change lines, but that's ok
  //FIXED: "Kind: "+this.getKind()+
  //       "\nTitle: "+this.title+
  //       "\nAuthor: "+this.author+
  //       "\nYear: "+this.year+
  //       String.format("\nPrice: %.2f",this.price);

  /**
   * Books to be considered equal if Title, Author, and publication Year are.
   * <p>
   * @param object, the other object to be compared with this book
   * @return true iff the books are equal
   * Different prices do not invalidate equality
   */
//  @Override
//  public boolean equals(Object object) {
//    return false;
//  }

  //FLAW: equal() method needed here
  @Override
  public boolean equals(Object other) {
    // Check if identical
    if (this == other)
      return true;
    // Check if null
    if (other == null)
      return false;
    //FLAW: again, suggest not use
    //FIX: use try {
    //            some code
    //  }
    //  catch(something) {
    //    return false;
    //  }
    // Check type compatibility
    if (!(other instanceof Book))
      return false;
    // Cast to Magazine type
    Book other_book = (Book) other;
    // Compare fields
    return this.title.equals(other_book.title)
        && this.author.equals(other_book.author)
        && this.year == other_book.getYear()
        && Math.abs(this.price - other_book.price) < 0.001;
  }


  /**
   * Override hashCode since overriding equals
   * <p>
   * @return an int, the hashCode for equal Books
   * Based on title, author, and year
   */
  @Override
  public int hashCode() {
     return Objects.hash(title, author, year);
  }
}