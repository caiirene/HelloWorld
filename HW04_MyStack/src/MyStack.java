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
  private int stackSize;

  /**
   * Constructs an empty MyStack instance.
   */
  public MyStack() {
    this.stack = new ArrayList<>();
    this.stackSize = 0;
  }

  /**
   * just a getter for size
   * @return int size of mystack
   */
  public int getStackSize(){
    return this.stackSize;
  }

  /**
   * just a getter for stack, which is an arraylist
   * @return arraylist object
   */
  public ArrayList<T> getStack(){
    return this.stack;
  }

  /**
   * adds element x to the stack, returning void
   * first element can be any type, other added elements should be same type as first one
   *
   */
  @Override
  public void push(T object) {

    this.stack.add(object);
    this.stackSize++;
  }

  /**
   * removes the last element of the stack and returns it
   *
   * @return The last element in this stack object's array list.
   * @throws EmptyStackException If the stack is empty.
   */
  @Override
  public T pop() {
    if (this.stackSize == 0) {
      throw new EmptyStackException();
    }
    T remember = this.stack.get(stackSize - 1);
    this.stack.remove(stackSize - 1);
    this.stackSize--;
    return remember;
  }

  /**
   * method returns the last element of the stack, without removing it
   *
   * @return The last element in this stack object's array list.
   * @throws EmptyStackException If the stack is empty.
   */
  @Override
  public T top() {
    if (this.stackSize == 0) {
      throw new EmptyStackException();
    }
    int lastIndex = this.stackSize - 1;
    return this.stack.get(lastIndex);
  }

  /**
   * returns boolean, indicating whether the stack is empty or not
   *
   * @return true or false.
   */
  @Override
  public boolean empty() {
    return (this.stackSize == 0);
  }

  /**
   * Returns a string representation of the stack.
   *
   * @return A string containing "Stack: " followed by each element, separated by a single space.
   */
  @Override
  public String toString() {
    String returnStr = "Stack: ";

    for (int i = 0; i < stackSize; i++) {
      returnStr += stack.get(i).toString();
      returnStr += " ";
    }
    return returnStr;
  }

}