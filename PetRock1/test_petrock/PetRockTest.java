import static org.junit.Assert.*;

import org.junit.Test;

public class PetRockTest {

  private PetRock SeSe = new PetRock("涩涩");

  @Test
  public void getName() throws Exception {
    PetRock EEOrSeSe = new PetRock("SeSe");
    assertEquals("SeSe",EEOrSeSe.getName());
  }

  @Test
  public void testUnhappyAtStart() {
    assertFalse(SeSe.isHappy());
  }

  public void testHappyAfterPlay(){
    SeSe.playWithEE();
    assertTrue(SeSe.isHappy());
  }
}