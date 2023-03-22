/**
 * MyStackInterface represents a generic stack interface
 * that allows operations such as push, pop, top, and checking if the stack is empty.
 *
 * @param <T> The type of elements stored in the stack.
 */
public interface MyStackInterface<T> {

  /**
   * Adds an element to the top of the stack.
   *
   * @param data The element to be added to the stack.
   */
  void push(T data);

  /**
   * Removes the top element of the stack and returns it.
   *
   * @return The top element of the stack.
   * @throws RuntimeException If the stack is empty.
   */
  T pop();

  /**
   * Returns the top element of the stack without removing it.
   *
   * @return The top element of the stack.
   * @throws RuntimeException If the stack is empty.
   */
  T top();

  /**
   * Checks whether the stack is empty or not.
   *
   * @return true if the stack is empty, false otherwise.
   */
  boolean empty();
}
