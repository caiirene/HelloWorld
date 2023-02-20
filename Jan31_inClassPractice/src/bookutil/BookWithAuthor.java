package bookutil;

import java.util.function.Predicate;

public class BookWithAuthor implements Predicate<Book> {

  private String author;

  public BookWithAuthor(String author) {
    this.author = author;
  }

  @Override
  public boolean test(Book book) {
    return book.getAuthor().contains(this.author);
  }

}
