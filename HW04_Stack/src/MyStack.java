import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * MyStack is a generic stack implementation using an ArrayList
 * as the underlying data structure.
 *
 * @param <T> The type of elements stored in the stack.
 */
public class MyStack<T> implements MyStackInterface<T> {
  private ArrayList<T> stack;

  /**
   * Constructs an empty MyStack instance.
   */
  public MyStack() {
    this.stack = new ArrayList<>();
  }

  /**
   * Adds an element to the top of the stack.
   *
   * @param data The element to be added to the stack.
   */
  @Override
  public void push(T data) {
    this.stack.add(data);
  }

  /**
   * Removes the top element of the stack and returns it.
   *
   * @return The top element of the stack.
   * @throws RuntimeException If the stack is empty.
   */
  @Override
  public T pop() {
    if (empty()) {
      throw new EmptyStackException();
    }
    return this.stack.remove(stack.size() - 1);
  }

  /**
   * Returns the top element of the stack without removing it.
   *
   * @return The top element of the stack.
   * @throws RuntimeException If the stack is empty.
   */
  @Override
  public T top() {
    if (empty()) {
      throw new EmptyStackException();
    }
    return this.stack.get(stack.size() - 1);
  }

  /**
   * Checks whether the stack is empty or not.
   *
   * @return true if the stack is empty, false otherwise.
   */
  @Override
  public boolean empty() {
    return this.stack.isEmpty();
  }

  /**
   * Returns a string representation of the stack.
   *
   * @return A string containing "Stack: " followed by each element, separated by a single space.
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Stack: ");
    for (T element : stack) {
      sb.append(element).append(" ");
    }
    return sb.toString().trim();
  }
}
