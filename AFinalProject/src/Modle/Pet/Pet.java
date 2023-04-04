package Modle.Pet;

import Modle.Toy.Toy;
import Modle.Toy.ToyInterface;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public abstract class Pet implements PetInterface {

  protected String name;
  protected LocalDate birthDay;
  protected LocalDate deathDay;
  protected int age; //count as days
  protected int hunger;
  protected int happiness;
  protected int health;
  protected boolean liveOrDead;
  protected PetChoice petType;

  protected Map<String, Integer> toyFreshness;




  public Pet() {
    // ... other field initializations

    this.toyFreshness = new HashMap<>();
  }






  public void playWithToy(ToyInterface toy) {
    String toyType = toy.getType();
    int freshness = toyFreshness.getOrDefault(toyType, 100); // 默认新鲜程度为100

    // 计算 happiness 提升
    int happinessBoost = (int) (toy.getHappinessBoost() * (freshness / 100.0));

    // 更新 happiness 和新鲜程度
    this.happiness += happinessBoost;
    this.toyFreshness.put(toyType, Math.max(freshness - 10, 0)); // 每次玩耍降低新鲜程度，最低为0
  }

  public void recoverFreshness() {
    for (String toyType : toyFreshness.keySet()) {
      int freshness = toyFreshness.get(toyType);
      toyFreshness.put(toyType, Math.min(freshness + 10, 100)); // 恢复新鲜程度，最高为100
    }
  }

}
