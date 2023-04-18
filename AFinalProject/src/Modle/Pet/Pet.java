package Modle.Pet;

import Modle.Food.FoodInterface;
import Modle.Toy.Toy;
import Modle.Toy.ToyBox;
import Modle.Toy.ToyInterface;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public abstract class Pet implements PetInterface {

  protected String name = "sese";
  protected LocalDate birthDay;
  protected LocalDate birthDayReal;
  protected LocalDate deathDay;
  protected int age = 0; //count as days
  protected int hunger = 100;
  protected int hungryRate;
  protected int happiness = 100;
  protected int lonelyRate;
  protected int health = 100;
  protected boolean isSleeping = false;
  protected int activationRate;
  protected boolean liveOrDead = true;
  protected PetChoice petType;

  protected Map<String, Integer> toyFreshness;

  protected ToyBox toyBox;

  private Timer timer;
  private PetTimerManager timerManager;


  /**
   * 默认构造器，不命名，之后用setter直接命名
   * 用来构造新实例，是一个新生的pet
   */
  public Pet() {
    // ... other field initializations
    this.toyBox = new ToyBox();
    this.toyFreshness = new HashMap<>();
    this.birthDay = LocalDate.now();
    this.birthDayReal = LocalDate.now();
    timer = new Timer(); //这里是做什么用的

    timerManager = new PetTimerManager(this);
    timerManager.startHungerTimer();
    timerManager.startHealthTimer();
    timerManager.startHappinessTimer();
  }

  public Pet(String name, LocalDate birthDay, int age, int hunger,
      int happiness, int health,Map<String, Integer> toyFreshness,ToyBox toyBox) {
    //这里需要大量设置
  }


  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public int getAge() { //用天来计算
    LocalDate currentDate = LocalDate.now();
    return (int) ChronoUnit.DAYS.between(birthDay, currentDate);
  }

  public void setAge(int age) {
    this.age = age;
    LocalDate currentDate = LocalDate.now();
    this.birthDay = currentDate.minusDays(this.age);
  }

  public int getHunger() {
    return this.hunger;
  }
  public void setHunger(int hunger) {this.hunger = hunger;}

  public void eat(FoodInterface food) {
    this.hunger += food.getFullness();
    if (food.getFullness()>0) {
      sayThankYou();
      return;
    }
    speakRandomly();
  }

  public void play(ToyInterface toy){
    String toyType = toy.getType();
    int freshness = toyFreshness.getOrDefault(toyType, 100); // 默认新鲜程度为100

    // 计算 happiness 提升
    int happinessBoost = (int) (toy.getHappinessBoost() * (freshness / 100.0));

    // 更新 happiness 和新鲜程度
    this.happiness += happinessBoost;
    this.toyFreshness.put(toyType, Math.max(freshness - 10, 0)); // 每次玩耍降低新鲜程度，最低为0
  }

  public void sleep() {
    this.isSleeping = true;

    TimerTask recoverHealthTask = new TimerTask() {
      @Override
      public void run() {
        if (isSleeping) {
          health++; // Increment health value
          System.out.println("Health increased to: " + health);

          if (health >= 100) {
            health = 100; // Ensure health does not exceed 100
            wakeUp();
          }
        } else {
          // Cancel the task if the pet is not sleeping anymore
          this.cancel();
        }
      }
    };

    // Schedule the task to run every 5 seconds (5000 milliseconds)
    timer.scheduleAtFixedRate(recoverHealthTask, 0, 5000);
  }

  public void wakeUp() {
    this.isSleeping = false;
  }

  public void askUserDream();

  public boolean deadCheck();

  public boolean healthCheck();

  public ToyBox getToyBox();

  public void setToyBox(ToyBox toyBox);





  public void recoverFreshness() {
    for (String toyType : toyFreshness.keySet()) {
      int freshness = toyFreshness.get(toyType);
      toyFreshness.put(toyType, Math.min(freshness + 10, 100)); // 恢复新鲜程度，最高为100
    }
  }

}
