import static org.junit.Assert.*;

import org.junit.Test;

public class PetRockTest {

  @Test
  public void getName() throws Exception {
    PetRock EEOrSeSe = new PetRock("SeSe");
    assertEquals("SeSe",EEOrSeSe.getName());
  }

  @Test
  public void testHappy() {
    PetRock SeSe = new PetRock("涩涩")
    assertFalse(SeSe.isHappy());
  }
}