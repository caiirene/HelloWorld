package Model.Pet;

import Model.Food.FoodInterface;
import Model.Toy.ToyBox;
import Model.Toy.ToyBoxInterface;
import Model.Toy.ToyInterface;
import java.awt.Component;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.time.LocalDate;
import java.util.Map;
import java.util.Timer;

public class PetImpl implements PetInterface {
  protected String name = "涩涩";
  protected LocalDate birthDay;
  protected LocalDate birthDayReal;
  protected LocalDate deathDay;
  protected int age = 0; //count as days
  protected int hunger = 100;
  protected int hungryRate = 10;
  protected int happiness = 100;
  protected int lonelyRate = 10;
  protected int health = 100;
  protected boolean isSleeping = false;
  protected int activationRate;
  protected boolean liveOrDead = true;
  protected Map<String, Integer> toyFreshness;
  protected ToyBox toyBox;
  private Timer timer;
  private PropertyChangeSupport support = new PropertyChangeSupport(this);


  /**
   * 构造器：全部使用默认值，生成当前时间的生日
   */
  public PetImpl() {
    this.birthDay = LocalDate.now();
    this.birthDayReal = LocalDate.now();
  }

  public PetImpl(File record) {

  }


  /**
   * get the name of pet
   *
   * @return String name
   */
  @Override
  public String getName() {
    return null;
  }

  /**
   * rename the pet
   *
   * @param name
   */
  @Override
  public void setName(String name) {

  }

  /**
   * get the age
   *
   * @return int age
   */
  @Override
  public int getAge() {
    return 0;
  }

  /**
   * reset the age (day)
   *
   * @param age you want
   */
  @Override
  public void setAge(int age) {

  }

  /**
   * get the hunger number
   *
   * @return
   */
  @Override
  public int getHunger() {
    return 0;
  }

  /**
   * reset the hunger to a number you want
   *
   * @param hunger
   */
  @Override
  public void setHunger(int hunger) {

  }

  /**
   * eat a food object from food box or whatever you have, and bring up the hunger number
   *
   * @param food
   */
  @Override
  public void eat(FoodInterface food) {

  }

  /**
   * play with a toy object from toy box or whatever you have and bring up the happiness
   *
   * @param toy
   */
  @Override
  public void play(ToyInterface toy) {

  }

  /**
   * 因为宠物会随时间流逝而失去health，就是会get tired 所以需要通过睡觉来补充health，这里的主要补充途径就是做梦 bring up the health
   */
  @Override
  public void sleep() {

  }

  /**
   * 恢复sleep状态为false
   */
  @Override
  public void weakUp() {

  }

  /**
   * 这个方法直接接收一个字符串，然后添加到dreamList中
   *
   * @param dream
   */
  @Override
  public void askUserDream(String dream) {

  }

  /**
   * 返还一个布尔值，表示宠物死亡与否
   *
   * @return boolean pet dead or not
   */
  @Override
  public boolean getDeathStatus() {
    return false;
  }

  /**
   * get health number
   *
   * @return int health
   */
  @Override
  public boolean getHealth() {
    return false;
  }

  /**
   * return a toy box that the pet have a pet can only have at most one toy box
   *
   * @return ToyBox object
   */
  @Override
  public ToyBoxInterface getToyBox() {
    return null;
  }

  /**
   * give the pet a toy box if the pet already have a toy box, we just add all toys into the box
   *
   * @param toyBox
   */
  @Override
  public void setToyBox(ToyBoxInterface toyBox) {

  }

  /**
   * return some string randomly, 说话内容包括，说自己的生日，表达思念，劝人休息
   *
   * @return string
   */
  @Override
  public String speakRandomly() {
    return null;
  }

  /**
   * say thank you after be feed or played
   *
   * @return string
   */
  @Override
  public String sayThankYou() {
    return null;
  }

  /**
   * 汇报自己处在饥饿状态
   *
   * @return "我饿了“
   */
  @Override
  public String sayHungry() {
    return null;
  }

  /**
   * 汇报自己处在低happiness状态
   *
   * @return “能陪我玩玩吗？”
   */
  @Override
  public String sayLonely() {
    return null;
  }

  /**
   * 汇总自身所有状态，讲出自己几岁了，很高兴认识你 汇报自己获得了几个“梦”，说梦被记录在文件中了
   *
   * @return
   */
  @Override
  public String sayTheLastWord() {
    return null;
  }

  /**
   * 宠物如果不处在sleep状态 根据activationRate降低health
   */
  @Override
  public void loseHealth_GetTiredWhileTimePass() {

  }

  /**
   * lose hunger while time pass rate depends on pet hungerRate
   */
  @Override
  public void loseHungerWhileTimePass() {

  }

  /**
   * lose happiness while time pass rate depends on pet lonelyRate
   */
  @Override
  public void loseHappinessWhileTimePass() {

  }

  /**
   * check the health==0 or not if true, pet's liveOrDead turn to true and make the property
   * listener inform the controller (controller should do this check every 0.1 second)
   */
  @Override
  public void checkDeath() {
    boolean oldDead = this.liveOrDead;
    if (health == 0) {
      this.liveOrDead = true;
    }
    support.firePropertyChange("dead", oldDead, liveOrDead);
  }

  public void addPropertyChangeListener(PropertyChangeListener listener) {
    support.addPropertyChangeListener(listener);
  }
}
