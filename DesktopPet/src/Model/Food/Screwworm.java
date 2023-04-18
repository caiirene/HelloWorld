package Model.Food;

public class Screwworm extends AbstractFood{

  public int value = 10;



  /**
   * return the type of food
   *
   * @return
   */
  @Override
  public FoodType getFoodType() {
    return null;
  }

  /**
   * a food will have a boolean field indicate it still eatable or not if a food object has false
   * FoodBoolean when freshness get to 0 else boolean is true
   *
   * @return
   */
  @Override
  public boolean getFoodBoolean() {
    return false;
  }

  /**
   * food will lose freshness while time pass witch depends on food's rotRate
   */
  @Override
  public void lossFreshnessWhileTimePass() {

  }

  /**
   * return the rot rate, rot rate means a food will lose this amount of freshness every 60 seconds
   *
   * @return int
   */
  @Override
  public int getRotRate() {
    return 0;
  }

  /**
   * although a food object will have an 初始 rot rate, but you can set them if you want to 开挂
   */
  @Override
  public void setRotRate() {

  }

  /**
   * 返还计算过的food value
   *
   * @return int food value after calculate the freshness
   */
  @Override
  public int getRealFoodValue() {
    return 0;
  }

  /**
   * return the current freshness of food, which is 0~100
   *
   * @return double
   */
  @Override
  public int getFreshness() {
    return 0;
  }

  /**
   * reset the freshness of food to 1.00
   */
  @Override
  public void resetFreshness() {

  }
}
