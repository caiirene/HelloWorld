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
    stack = new ArrayList<>();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void push(T data) {
    stack.add(data);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public T pop() {
    if (empty()) {
      throw new EmptyStackException();
    }
    return stack.remove(stack.size() - 1);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public T top() {
    if (empty()) {
      throw new EmptyStackException();
    }
    return stack.get(stack.size() - 1);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean empty() {
    return stack.isEmpty();
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
