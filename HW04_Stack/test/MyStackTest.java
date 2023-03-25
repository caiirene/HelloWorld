import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.EmptyStackException;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the MyStack class.
 */
public class MyStackTest {

  private MyStack<Integer> stack;

  @BeforeEach
  public void setUp() {
    stack = new MyStack<>();
  }

  /**
   * Tests the push() method.
   */
  @Test
  public void testPush() {
    assertTrue(stack.empty());
    stack.push(1);
    assertFalse(stack.empty());
    assertEquals(1, stack.top());

    stack.push(2);
    assertFalse(stack.empty());
    assertEquals(2, stack.top());
  }

  /**
   * Tests the pop() method.
   */
  @Test
  public void testPop() {
    stack.push(1);
    stack.push(2);

    assertEquals(2, stack.pop());
    assertEquals(1, stack.top());

    assertEquals(1, stack.pop());
    assertTrue(stack.empty());

    assertThrows(EmptyStackException.class, () -> stack.pop());
    //In this case, we are calling the pop() method by lambda expression on the stack object with no parameter.
  }

  /**
   * Tests the top() method.
   */
  @Test
  public void testTop() {
    stack.push(1);
    assertEquals(1, stack.top());

    stack.push(2);
    assertEquals(2, stack.top());

    stack.pop();
    assertEquals(1, stack.top());

    assertThrows(EmptyStackException.class, () -> {
      stack.pop();
      stack.top();
    });
    //这里lambda把空参数传入到一整段代码中
  }

  /**
   * Tests the empty() method.
   */
  @Test
  public void testEmpty() {
    assertTrue(stack.empty());

    stack.push(1);
    assertFalse(stack.empty());

    stack.pop();
    assertTrue(stack.empty());
  }

  /**
   * Tests the toString() method.
   */
  @Test
  public void testToString() {
    assertEquals("Stack:", stack.toString());

    stack.push(1);
    assertEquals("Stack: 1", stack.toString());

    stack.push(2);
    assertEquals("Stack: 1 2", stack.toString());
  }
}
