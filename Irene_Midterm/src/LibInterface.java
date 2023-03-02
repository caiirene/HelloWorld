import java.util.Comparator;

public interface LibInterface {

  /**
   * Constructor for a new, empty library
   * <p>
   * A Library is implemented as an ArrayList of Publications
   * NB: Additional List-based methods could be added as needed
   * Also relies on ArrayList.sort() for sorting with a Comparator method
   */
  public void addToLibrary(Publication pub1);
  /**
   * Get a book from the Library, relying on built-in List, ArrayList methods
   * >
   * @param index a non-negative int within the range being used
   * @return a Publication from the Library, such as a Book or Magazine
   */
  public Publication getFromLibrary(int index) throws IndexOutOfBoundsException;
  /**
   * Determine whether library contains a given publication
   * <p>
   * @param pub a publication to check for
   * @return boolean, true iff pub is in the Library
   */
  public boolean libraryContains(Publication pub);
  /**
   * Given existing library, sort in order determined by provided Comparator
   * <p>
   * @param comp a Class that implements Comparator<Publication>
   * myLibrary will be sorted in place
   */
  public void sortLibrary(Comparator<Publication> comp);
  /**
   * Return a String representation of myLibrary, sorted by author
   * <p>
   * @return the String representation, with each Publication on a new line
   */
  public String toString();

}
