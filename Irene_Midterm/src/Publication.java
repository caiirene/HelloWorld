/**
 * Interface Specification for Publications, such as Books and Magazines
 */
public interface Publication {

  /**
   * Getter for the title of the publication
   *<p>
   * @return String, the title of the publication
   */
  String getTitle();

  /** Getter for the year of the publication
   *<p>
   * @return int, the year of publication
   */
  int getYear();

  /**
   * Getter for the author of the publication, a Person
   * <p>
   * @return Person, the author of the publication
   */
  Person getAuthor();

  /**
   * Getter for the retail price of the publication
   *<p>
   * @return double, the retail price of the publication
   */
  double getPrice();

  /**
   * Method to determine if two publications have the same author
   * <p>
   * @param other, the other Publication whose author might be same as this
   * @return boolean, true if the authors are the same Person, else false
   */
  boolean sameAuthor(Publication other);
  //FLAW: suggest to implement in AbstractPublication, so we can just implement once
  //FIXED: add to AbstractPublication and remove from book and magazine

  /**
   * Method to return the kind of Publication as a String
   * <p>
   * @return String, the kind of publication (eg "Book" or "Magazine")
   */
  String getKind();
  //FLAW: suggest to use getKind() because that is a verb
  //FIXED: String getKind();
}
