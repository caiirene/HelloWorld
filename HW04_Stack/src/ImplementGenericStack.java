import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * Generic class representing a stack based on the LIFO concept,
 * Use ArrayList as a concrete representation of stack data.
 * @param <Type> The type of elements in this stack, a kind of data type
 */
public class ImplementGenericStack<Type> {//Using "<>" meaning it is a data type.

  private ArrayList<Type> NewStack;

  /**
   Creates a new, empty object.
   */
  public ImplementGenericStack() {
    NewStack = new ArrayList<>();
  }

  /**
   Adds new element to the top of the stack.
   @param x the element to add
   */
  public void push(Type x) {
    NewStack.add(x);
  }

  /**
   Removes and returns the element at the top of the stack.
   @return the last element of this stack
   */
  public Type pop() {
    if (empty()) {
      throw new EmptyStackException();
    }
    int lastOne = NewStack.size() - 1;
    Type lastEle = NewStack.get(lastOne);
    NewStack.remove(lastOne);
    return lastEle;
  }

  /**
   Returns the element at the top of the stack without removing it.
   @return the last element of the stack
   */
  public Type top() {
    if (empty()) {
      throw new EmptyStackException();
    }
    int lastOne = NewStack.size() - 1;
    return NewStack.get(lastOne);
  }

  /**
   @return true if this stack contains no elements, false otherwise
   */
  public boolean empty() {
    return NewStack.size() == 0;
  }

  /**
   @return a string representation of this stack
   */
  @Override
  public String toString() {
    String res = "NewStack: ";
    for (int i = 0; i < NewStack.size(); i++) {
      res += NewStack.get(i);
      if (i < NewStack.size() - 1) {
        res += ", ";
      }
    }
    return res;
  }
}

/**
 * About the understanding that academic integrity cannot be violated:
 * Upholding academic integrity is important for several reasons.
 * It ensures that academic work is conducted with honesty, fairness, and responsibility,
 * and it helps to build trust and credibility in the academic community.
 * We should respect the work of others, and maintaining the highest ethical standards.
 * To ensure that ChatGPT promotes rather than undermines academic integrity,
 * it is important for us to use ChatGPT as a tool,
 * not a replacement for our own research and critical thinking;
 * and use ChatGPT ethically and responsibly: avoiding plagiarism!
 **/
