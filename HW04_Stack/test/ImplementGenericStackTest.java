import static org.junit.Assert.*;
import org.junit.Test;


/**
 * Test class for the ImplementGenericStack class.
 */
class ImplementGenericStackTest {

  /**
   * Test the push and pop methods for a stack of Integers.
   */
  @Test
  void testPushAndPopI(){
    ImplementGenericStack<Integer> stack1 = new ImplementGenericStack<>();
    stack1.push(1);
    stack1.push(2);
    stack1.push(3);

    assertEquals(3, stack1.pop(), 0.001);
    assertEquals(2, stack1.pop(), 0.001);
  }

  /**
   * Test the push and pop methods for a stack of Strings.
   */
  @Test
  void testPushAndPopS(){
    ImplementGenericStack<String> stack2 = new ImplementGenericStack<>();
    stack2.push("hello");
    stack2.push("hi");

    assertEquals("hi", stack2.pop());
    assertEquals("hello", stack2.pop());
  }

  /**
   * Test the top method.
   */
  @Test
  void testTop() {
    ImplementGenericStack<Integer> stack3 = new ImplementGenericStack<>();
    stack3.push(1);
    stack3.push(2);

    assertEquals(2, stack3.top(), 0.001);// Also check that top does not remove the element
  }

  /**
   * Test the empty method.
   */
  @Test
  void testEmpty() {
    ImplementGenericStack<Integer> stack4 = new ImplementGenericStack<>();
    assertTrue(stack4.empty());

    stack4.push(1);
    assertFalse(stack4.empty());

    stack4.pop();
    assertTrue(stack4.empty());
  }

  /**
   * Test the toString method.
   */
  @Test
  void testToString() {
    ImplementGenericStack<String> stack5 = new ImplementGenericStack<>();
    assertEquals("Stack: ", stack5.toString());

    stack5.push("Zijun");
    assertEquals("Stack: Zijun", stack5.toString());

    stack5.push("Chen");
    assertEquals("Stack: Zijun, Chen", stack5.toString());
  }
}
