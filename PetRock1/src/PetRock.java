import java.util.EmptyStackException;

public class PetRock {
  private String name;
  private Integer x;
  private boolean happy = false;

  public PetRock(String name) {
    if (name.isEmpty()){
      throw new IllegalArgumentException();}

    this.name = name;

  }
  public String getName() {
    return name;
  }

  public boolean isHappy() {
    return happy;
  }

  public void playWithEE() {
    happy = true;
  }

  public String printHappyMessage(){
    //if (!happy){
     // throw new IllegalStateException();
    //}
    return "I am happy!";
  }

  public int getFavorateNumber(){
    return 666;
  }

  public void iJustWantTimeOutThankYou(){
    while (!happy){
      //do nothing, so it never finish while loop
    }
  }

  public Integer getNull(){
    x = null;
    return x;
  }

  public String toString(){
    return "Your Pet is " + this.name + ".\n It is unhappy at beginning. You can make it happy if you use playWithEE() method.";
  }
}
