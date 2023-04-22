package Model.Food;

/**
 * abstract food include nearly all methods needed
 * the most important is get real value method
 * with a constructor, but must be constructed in concrete class.
 * concrete class has all the default parameters
 */
public abstract class AbstractFood implements FoodInterface{

  protected int foodValue;
  protected int realFoodValue;
  protected int spoilRate;
  protected boolean notRotten;
  protected FoodType type;
  protected String foodName;

  public AbstractFood(int foodValue, int spoilRate,String foodName, FoodType type) {
    this.realFoodValue = foodValue;
    this.foodValue = foodValue;
    this.spoilRate = spoilRate;
    this.type = type;
    this.foodName = foodName;
  }

  /**
   * 返还food原本的value
   *
   * @return int the food value of original
   */
  @Override
  public int getFoodValue() {
    return foodValue;
  }

  /**
   * return the type of food
   *
   * @return
   */
  @Override
  public FoodType getFoodType() {
    return type;
  }

  /**
   * a food will have a boolean field indicate it still eatable or not if a food object has false
   * FoodBoolean when freshness get to 0 else boolean is true
   *
   * @return
   */
  @Override
  public boolean getFoodBoolean() {
    return notRotten;
  }

  /**
   * food will lose freshness while time pass 虽然这里管这个方法叫作随时间流逝而腐烂，但实际上只是腐烂，这里不涉及timer witch depends
   * on food's rotRate
   */
  @Override
  public void lossFoodValueWhileTimePass() {
    realFoodValue = Math.max(realFoodValue - spoilRate, 0);
    if (realFoodValue<=0) {notRotten=false;}
  }

  /**
   * return the rot rate, rot rate means a food will lose this amount of freshness every 60 seconds
   *
   * @return int
   */
  @Override
  public int getSpoilRate() {
    return spoilRate;
  }

  /**
   * although a food object will have an 初始 rot rate, but you can set them if you want to 开挂
   */
  @Override
  public void setSpoilRate(int rate) {
    this.spoilRate = rate;
  }

  /**
   * 返还计算过的food value
   *
   * @return int food value after calculate the freshness
   */
  @Override
  public int getRealFoodValue() {
    return realFoodValue;
  }

  /**
   * reset the freshness of food to 1.00
   */
  @Override
  public void resetToFresh() {
    this.realFoodValue = this.foodValue;
  }

  /**
   * return the food name such as apple, banana......
   *
   * @return
   */
  @Override
  public String getFoodName() {
    return foodName;
  }
}
