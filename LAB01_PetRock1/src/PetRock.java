import java.util.EmptyStackException;
import java.util.Objects;

/**
 * an object called PetRock it has name and happy or not
 */
public class PetRock {

  private String name;
  private Integer x; //just ignore these
  private boolean happy = false;

  /**
   * set up a PetRock object with the provided name from parameter
   *
   * @param name
   */
  public PetRock(String name) {
    if (name.isEmpty()) {
      throw new IllegalArgumentException();
    }

    this.name = name;

  }

  /**
   * this method will return the name of this PetRock object
   *
   * @return sting name
   */
  public String getName() {
    return name;
  }

  /**
   * this method return this object is happy or not
   *
   * @return
   */
  public boolean isHappy() {
    return happy;
  }

  /**
   * it is a method to change the happy status after use this method, this petrock object's happy
   * will become true
   */
  public void playWithEE() {
    happy = true;
  }

  /**
   * print i am happy no matter happy or not
   *
   * @return nothing
   */
  public String printHappyMessage() {
    //if (!happy){
    // throw new IllegalStateException();
    //}
    return "I am happy!";
  }

  /**
   * give a little more info for this object, which is the favorate num
   *
   * @return int 666
   */
  public int getFavorateNumber() {
    return 666;
  }

  /**
   * just a try on timeout in test
   */
  public void iJustWantTimeOutThankYou() {
    while (!happy) {
      //do nothing, so it never finish while loop
    }
  }


  /**
   * just another try on return null
   *
   * @return
   */
  public int getNull() {
    x = null;
    return x;
  }


  /**
   * to string: include name, favorate num, and introdue to use play method
   *
   * @return string intro for this petrock object
   */
  public String toString() {
    return "Your Pet is " + this.name
        + ".\n It is unhappy at beginning." +
        "You can make it happy if you use playWithEE() method.";
  }

  // Getter and setter methods for name and isHappy...

  //@Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof PetRock)) {
      return false;
    }

    PetRock other = (PetRock) o;
    return this.name.equals(other.getName())
        && this.happy == other.isHappy();

  }

  @Override
  public int hashCode() {
    return Objects.hash(name, happy);
  }
}

