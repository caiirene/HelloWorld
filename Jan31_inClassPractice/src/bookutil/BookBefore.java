package bookutil;

import java.util.function.Predicate;

public class BookBefore implements Predicate<Book> {


  private int year;

  public BookBefore(int year) {
    this.year = year;
  }

  @Override
  public boolean test(Book b) {
    return b.getYear() < year;
  }

}
