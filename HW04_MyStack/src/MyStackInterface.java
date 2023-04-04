/**
 * this is an interface for MyStack
 */

import java.util.ArrayList;
import java.util.EmptyStackException;

public interface MyStackInterface<T> {

  /**
   * just a getter for size
   * @return int size of mystack
   */
  public int getStackSize();

  /**
   * just a getter for stack, which is an arraylist
   * @return arraylist object
   */
  public ArrayList<T> getStack();

  /**
   * adds element x to the stack, returning void
   * first element can be any type, other added elements should be same type as first one
   *
   */
  void push(T object);

  /**
   * removes the last element of the stack and returns it
   *
   * @return The last element in this stack object's array list.
   * @throws EmptyStackException If the stack is empty.
   */
  T pop();

  /**
   * method returns the last element of the stack, without removing it
   *
   * @return The last element in this stack object's array list.
   * @throws EmptyStackException If the stack is empty.
   */
  T top();

  /**
   * returns boolean, indicating whether the stack is empty or not
   *
   * @return true or false.
   */
  boolean empty();


}
