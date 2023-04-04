import static org.junit.Assert.assertEquals;

import java.util.EmptyStackException;

import org.junit.Before;
import org.junit.Test;


/**
 * Tests for the MyStack class.
 */
public class MyStackTest {

  private MyStack<Integer> stack;
  private MyStack<Double> doubleStack;
  private MyStack<String> stringStack;

  @Before
  public void setUp() {
    stack = new MyStack<>();
    doubleStack = new MyStack<>();
    stringStack = new MyStack<>();
  }

  /**
   * Tests the push() method.
   */
  @Test
  public void testPush() {

    //int
    assertEquals(true, stack.empty());
    stack.push(1);
    assertEquals(false,stack.empty());
    assertEquals(1, (int) stack.top());

    stack.push(2);
    assertEquals(false, stack.empty());
    assertEquals(2, (int) stack.top());

    //double
    assertEquals(true,doubleStack.empty());
    doubleStack.push(1.0);
    assertEquals(false,doubleStack.empty());
    assertEquals(1.0, doubleStack.top(), 0.001);

    doubleStack.push(2.0);
    assertEquals(false,doubleStack.empty());
    assertEquals(2.0,  doubleStack.top(), 0.001);

    //string
    assertEquals(true,stringStack.empty());
    stringStack.push("a");
    assertEquals(false,stringStack.empty());
    assertEquals("a", stringStack.top());

    stringStack.push("aa");
    assertEquals(false,stringStack.empty());
    assertEquals("aa", stringStack.top());

  }

  /**
   * Tests the pop() method.
   */
  @Test
  public void testPop() {
    //int
    stack.push(1);
    stack.push(2);

    assertEquals(2, (int)stack.pop());
    assertEquals(1, (int)stack.top());

    assertEquals(1, (int)stack.pop());
    assertEquals(true,stack.empty());

    //double
    doubleStack.push(1.1);
    doubleStack.push(2.2);

    assertEquals(2.2, doubleStack.pop(),0.001);
    assertEquals(1.1, doubleStack.top(),0.001);

    assertEquals(1.1, doubleStack.pop(),0.001);
    assertEquals(true,doubleStack.empty());

    //str
    stringStack.push("aa");
    stringStack.push("bb");

    assertEquals("bb", stringStack.pop());
    assertEquals("aa", stringStack.top());

    assertEquals("aa", stringStack.pop());
    assertEquals(true,stringStack.empty());

  }

  /**
   * Tests the top() method.
   */
  @Test
  public void testTop() {
    stack.push(1);
    assertEquals(1, (int)stack.top());

    stack.push(2);
    assertEquals(2, (int)stack.top());

    stack.pop();
    assertEquals(1, (int)stack.top());

    //double
    doubleStack.push(1.11);
    assertEquals(1.11, doubleStack.top(),0.0001);

    doubleStack.push(2.22);
    assertEquals(2.22, doubleStack.top(),0.0001);

    doubleStack.pop();
    assertEquals(1.11, doubleStack.top(),0.001);

    //str
    stringStack.push("1");
    assertEquals("1", stringStack.top());

    stringStack.push("2");
    assertEquals("2", stringStack.top());

    stringStack.pop();
    assertEquals("1", stringStack.top());


  }

  @Test (expected = EmptyStackException.class)
      public void testOnEmptyStackExceptionByTop() {
    stack.top();
  }
  @Test (expected = EmptyStackException.class)
  public void testOnEmptyStackExceptionByPop() {
    stack.pop();
  }

  /**
   * Tests the empty() method.
   */
  @Test
  public void testEmpty() {
    //int
    assertEquals(true,stack.empty());

    stack.push(1);
    assertEquals(false,stack.empty());

    stack.pop();
    assertEquals(true,stack.empty());

    //double
    assertEquals(true,doubleStack.empty());

    doubleStack.push(1.1);
    assertEquals(false,doubleStack.empty());

    doubleStack.pop();
    assertEquals(true,doubleStack.empty());

    //str
    assertEquals(true,stringStack.empty());

    stringStack.push("1");
    assertEquals(false,stringStack.empty());

    stringStack.pop();
    assertEquals(true,stringStack.empty());
  }

  /**
   * Tests the toString() method.
   */
  @Test
  public void testToString() {
    //int
    assertEquals("Stack: ", stack.toString());

    stack.push(1);
    assertEquals("Stack: 1 ", stack.toString());

    stack.push(2);
    assertEquals("Stack: 1 2 ", stack.toString());

    //double
    assertEquals("Stack: ", doubleStack.toString());

    doubleStack.push(1.22);
    assertEquals("Stack: 1.22 ", doubleStack.toString());

    doubleStack.push(2.2);
    assertEquals("Stack: 1.22 2.2 ", doubleStack.toString());

    //str
    assertEquals("Stack: ", stringStack.toString());

    stringStack.push("1");
    assertEquals("Stack: 1 ", stringStack.toString());

    stringStack.push("2");
    assertEquals("Stack: 1 2 ", stringStack.toString());
  }
}
