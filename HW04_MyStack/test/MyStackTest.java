/**
 * Tests for the MyStack class.
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.EmptyStackException;
import org.junit.Before;
import org.junit.Test;

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
    assertEquals(true,stack.empty());
    stack.push(1);
    assertFalse(stack.empty());
    assertEquals(1, (int)stack.top());

    stack.push(2);
    assertFalse(stack.empty());
    assertEquals(2, (int)stack.top());

    //double
    assertEquals(true,doubleStack.empty());
    doubleStack.push(1.0);
    assertFalse(doubleStack.empty());
    assertEquals(1.0, doubleStack.top(),0.001);

    doubleStack.push(2.0);
    assertFalse(doubleStack.empty());
    assertEquals(2, doubleStack.top(),0.001);

    //string
    assertEquals(true,stringStack.empty());
    stringStack.push("a");
    assertFalse(stringStack.empty());
    assertEquals("a", stringStack.top());

    stringStack.push("aa");
    assertFalse(stringStack.empty());
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

    //In this case, we are calling the pop() method by lambda expression on the stack object with no parameter.

    //double
    doubleStack.push(1.1);
    doubleStack.push(2.2);

    assertEquals(2.2, doubleStack.pop(),0.001);
    assertEquals(1.1, doubleStack.top(),0.001);

    assertEquals(1.1, doubleStack.pop(),0.001);
    assertTrue(doubleStack.empty());

    //str
    stringStack.push("aa");
    stringStack.push("bb");

    assertEquals("bb", stringStack.pop());
    assertEquals("aa", stringStack.top());

    assertEquals("aa", stringStack.pop());
    assertTrue(stringStack.empty());

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
  public void testOnEmptyStackException() {
    stack.top();
  }

  @Test (expected = EmptyStackException.class)
  public void testOnEmptyStackExceptionBYpop() {
    stack.pop();
  }


  /**
   * Tests the empty() method.
   */
  @Test
  public void testEmpty() {
    //int
    assertTrue(stack.empty());

    stack.push(1);
    assertFalse(stack.empty());

    stack.pop();
    assertTrue(stack.empty());

    //double
    assertTrue(doubleStack.empty());

    doubleStack.push(1.1);
    assertFalse(doubleStack.empty());

    doubleStack.pop();
    assertTrue(doubleStack.empty());

    //str
    assertTrue(stringStack.empty());

    stringStack.push("1");
    assertFalse(stringStack.empty());

    stringStack.pop();
    assertTrue(stringStack.empty());
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
