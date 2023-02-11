import static org.junit.Assert.*;

import java.awt.desktop.UserSessionEvent;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class PetRockTest {

  /**
   * set up some rules for this test
   * timeout=10
   */
  @Rule
  public Timeout globalTimeout = Timeout.seconds(10);


  /**
   * set up two object as class PetRock
   */
  private PetRock SeSe;
  private PetRock EE;


  /**
   * use constructor to setup real objects before every test
   * @throws Exception
   */
  @Before
  public void myTestSetup() throws Exception{
    SeSe = new PetRock("涩涩");
    EE = new PetRock("饿饿");
  }

  /**
   * test getName method
   * @throws Exception
   */
  @Test
  public void getName() throws Exception {
    PetRock EEOrSeSe = new PetRock("SeSe");
    assertEquals("SeSe",EEOrSeSe.getName());
    assertEquals("涩涩",SeSe.getName());
    assertEquals("饿饿",EE.getName());
  }

  /**
   * test the happy is defualt to unhappy
   */
  @Test
  public void testUnhappyAtStart() {
    assertFalse(SeSe.isHappy());
  }

  /**
   * test after useing play method, object will be happy
   */
  @Test
  public void testHappyAfterPlay(){
    SeSe.playWithEE();
    assertTrue(SeSe.isHappy());
  }

  /**
   * due to the unfinish of original code,
   * the exception is not test here
   * it just test the return string no matter it is happy or not
   * @throws Exception
   */
  @Ignore ("not yet finish the exceptions")
  @Test (expected = IllegalStateException.class)
  public void testPrintHappyMessage() throws Exception{
    SeSe.printHappyMessage();
  }

  /**
   * test the happy string is excepted
   * @throws not yet
   */
  @Test
  public void testGetHappyMessage() throws Exception{
    SeSe.playWithEE();
    assertEquals("I am happy!", SeSe.printHappyMessage());
  }

  /**
   * test the int
   * @throws Exception none
   */
  @Test
  public void testFavorateNuber() throws Exception{
    assertEquals(666,SeSe.getFavorateNumber());
  }

  /**
   * test IllegalArgumentException been thrown as it should be
   * @throws Exception
   */
  @Test (expected = IllegalArgumentException.class)
  public void testEmptyName() throws Exception{
    PetRock EE = new PetRock("");
  }

  /**
   * it is an infinity loop, but we have time out = 100
   * @throws Exception
   */
  @Test (timeout = 100)
  public void testTimeOut() throws Exception{
    SeSe.iJustWantTimeOutThankYou();
  }

  /**
   * 我实在不想解释了
   */
  @Test
  public void whenAssertingNull_thenTrue() {
    assertNull("should be null", SeSe.getNull());
  }

  @Test
  public void testNotSameObject() {
    assertNotSame(EE, SeSe);
  }

  /**
   * test toString return string as excepted
   */
  @Test
  public void testToString() {
    String except = "Your Pet is 涩涩.\n It is unhappy at beginning. You can make it happy if you use playWithEE() method.";
    assertEquals(except, SeSe.toString());
  }
}