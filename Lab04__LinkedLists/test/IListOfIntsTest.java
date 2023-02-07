//By Irene Cai and Zijun Chen
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IListOfIntsTest {

  //private IListOfIntsTest myList_1;

  IListOfInts myList_1, myList_2, myList_3, myEmpty_4;

  @Before
  public void setup() {
    //IListOfInts myList_1, myList_2, myList_3, myEmpty_4;

    myEmpty_4 = new EmptyNode();

    myList_1 = new NommalNode(111, new NommalNode(222, new NommalNode(333, new NommalNode(444, myEmpty_4))));
    myList_2 = new NommalNode(11, new NommalNode(22, new NommalNode(33, new NommalNode(44,myList_1))));
    myList_3 = new NommalNode(1, new NommalNode(2, new NommalNode(3, new NommalNode(4,myList_2))));
  }

  @org.junit.Test
  public void addAtIndex() {
    //IListOfInts expectedList;
    String expected_1 = "(111)(222)(9999)(333)(444)";
    //expectedList = new NommalNode(111, new NommalNode(222, new NommalNode(9999, new NommalNode(333, (new NommalNode(444,myEmpty_4))))));
    assertEquals(expected_1, myList_1.addAtIndex(9999,2).toString());
    //System.out.println(myList_1.toString());

    String expected_2 = "(11)(22)(33)(9999)(44)(111)(222)(9999)(333)(444)";
    //expectedList = new NommalNode(11, new NommalNode(22, new NommalNode(33, new NommalNode(9999, (new NommalNode(44,myList_1))))));
    assertEquals(expected_2, myList_2.addAtIndex(9999,3).toString());

    String expected_3 = "(1)(9999)(2)(3)(4)(11)(22)(33)(9999)(44)(111)(222)(9999)(333)(444)";
    //expectedList = new NommalNode(1, new NommalNode(9999, new NommalNode(2, new NommalNode(3, (new NommalNode(4,myList_2))))));
    assertEquals(expected_3, myList_3.addAtIndex(9999,1).toString());
  }

  @Test
  public void addFront() {
    String expected_1 = "(9999)(111)(222)(333)(444)";
    assertEquals(expected_1, myList_1.addFront(9999).toString());

    String expected_2 = "(9999)(11)(22)(33)(44)(9999)(111)(222)(333)(444)";
    assertEquals(expected_2, myList_2.addFront(9999).toString());

    String expected_3 = "(9999)(1)(2)(3)(4)(9999)(11)(22)(33)(44)(9999)(111)(222)(333)(444)";
    assertEquals(expected_3, myList_3.addFront(9999).toString());
  }

  @org.junit.Test
  public void addBack() {
    String expected_1 = "(111)(222)(333)(444)(9999)";
    assertEquals(expected_1, myList_1.addBack(9999).toString());
    String expected_2 = "(11)(22)(33)(44)(111)(222)(333)(444)(9999)(9999)";
    assertEquals(expected_2, myList_2.addBack(9999).toString());
    String expected_3 = "(1)(2)(3)(4)(11)(22)(33)(44)(111)(222)(333)(444)(9999)(9999)(9999)";
    assertEquals(expected_3, myList_3.addBack(9999).toString());
  }

  @org.junit.Test
  public void getDataAtIndex() {
    assertEquals(333, myList_1.getDataAtIndex(2));
    assertEquals(22, myList_2.getDataAtIndex(1));
    assertEquals(4, myList_3.getDataAtIndex(3));
  }

  @org.junit.Test
  public void count() {
    int a = myList_1.count();
    assertEquals(4, a);
    assertEquals(8, myList_2.count());
    assertEquals(12, myList_3.count());
  }

  @org.junit.Test
  public void sum() {
    assertEquals(1110, myList_1.sum());
    assertEquals(1220, myList_2.sum());
    assertEquals(1230, myList_3.sum());
  }

  @org.junit.Test (expected = IllegalArgumentException.class)
  public void testNoSuchIndex() {
    myList_1.getDataAtIndex(10);
  }

  @org.junit.Test (expected = IllegalArgumentException.class)
  public void testAddAtWrongIndex() {
    myList_1.addAtIndex(10, 10);
  }

}