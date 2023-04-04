import java.util.EmptyStackException;

/**
 A generic interface that represents a stack based on the LIFO concept.
 @param <T> the type of elements in this stack, a kind of data types
 */
public interface StackInterface<T> {

  /**
   Adds the specified element to the top of the stack.
   @param x the element to add
   */
  void push(T x);

  /**
   Removes and returns the element at the top of the stack.
   @return the last element of the stack
   @throws EmptyStackException if the stack is empty
   */
  T pop() throws EmptyStackException;

  /**
   Returns the element at the top of the stack without removing it.
   @return the last element of the stack
   @throws EmptyStackException if the stack is empty
   */
  T top() throws EmptyStackException;

  /**
   @return true if this stack contains no elements, false otherwise
   */
  boolean empty();

  /**
   @return a string representation of this stack
   */
  @Override
  String toString();
}
