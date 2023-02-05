import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;

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
    //IListOfInts expextedList;
    String expexted = "(111)(222)(9999)(333)(444)";
    //expextedList = new NommalNode(111, new NommalNode(222, new NommalNode(9999, new NommalNode(333, (new NommalNode(444,myEmpty_4))))));
    assertEquals(expexted, myList_1.addAtIndex(9999,2).toString());

  }

  @org.junit.Test
  public void addFront() {
    String expexted = "(9999)(111)(222)(333)(444)";
    assertEquals(expexted, myList_1.addFront(9999).toString());
  }

  @org.junit.Test
  public void addBack() {
    String expexted = "(111)(222)(333)(444)(9999)";
    assertEquals(expexted, myList_1.addBack(9999).toString());
  }

  @org.junit.Test
  public void getDataAtIndex() {
    assertEquals(333, myList_1.getDataAtIndex(2));
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
  }
}