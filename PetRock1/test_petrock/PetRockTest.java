import static org.junit.Assert.*;

import java.awt.desktop.UserSessionEvent;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class PetRockTest {

  @Rule
  public Timeout globalTimeout = Timeout.seconds(10);


  private PetRock SeSe;
  private PetRock EE;

  @Before
  public void myTestSetup() throws Exception{
    SeSe = new PetRock("涩涩");
    EE = new PetRock("涩涩");
  }

  @Test
  public void getName() throws Exception {
    PetRock EEOrSeSe = new PetRock("SeSe");
    assertEquals("SeSe",EEOrSeSe.getName());
  }

  @Test
  public void testUnhappyAtStart() {
    assertFalse(SeSe.isHappy());
  }

  @Test
  public void testHappyAfterPlay(){
    SeSe.playWithEE();
    assertTrue(SeSe.isHappy());
  }

  @Ignore ("not yet finish the exceptions")
  @Test (expected = IllegalStateException.class)
  public void testPrintHappyMessage() throws Exception{
    SeSe.printHappyMessage();
  }

  @Test
  public void testGetHappyMessage() throws Exception{
    SeSe.playWithEE();
    assertEquals("I am happy!", SeSe.printHappyMessage());
  }

  @Test
  public void testFavorateNuber() throws Exception{
    assertEquals(666,SeSe.getFavorateNumber());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testEmptyName() throws Exception{
    PetRock EE = new PetRock("");
  }

  @Test (timeout = 100)
  public void testTimeOut() throws Exception{
    SeSe.iJustWantTimeOutThankYou();
  }

  @Test
  public void whenAssertingNull_thenTrue() {
    assertNull("should be null", SeSe.getNull());
  }

  @Test
  public void testNotSameObject() {
    assertNotSame(EE, SeSe);
  }

  @Test
  public void testToString() {
    String except = "Your Pet is 涩涩.\n It is unhappy at beginning. You can make it happy if you use playWithEE() method.";
    assertEquals(except, SeSe.toString());
  }
}