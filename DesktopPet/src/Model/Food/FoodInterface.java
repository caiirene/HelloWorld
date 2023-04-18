package Model.Food;


/**
 * every food has a food value
 * food can rot after its object been created
 * 食物图像从一个JFrame中出现，然后点击那个JLabel，生成food
 */
public interface FoodInterface {

  /**
   *返还food原本的value
   * @return int the food value of original
   */
  int getFoodValue();

  /**
   * return the type of food
   * @return
   */
  FoodType getFoodType();

  /**
   * a food will have a boolean field indicate it still eatable or not
   * if a food object has false FoodBoolean when freshness get to 0
   * else boolean is true
   * @return
   */
  boolean getFoodBoolean();

  /**
   * food will lose freshness while time pass
   * witch depends on food's rotRate
   */
  void lossFreshnessWhileTimePass();

  /**
   * return the rot rate,
   * rot rate means a food will lose this amount of freshness every 60 seconds
   * @return int
   */
  int getRotRate();

  /**
   * although a food object will have an 初始 rot rate,
   * but you can set them if you want to 开挂
   */
  void setRotRate();

  /**
   * 返还计算过的food value
   * @return int food value after calculate the freshness
   */
  int getRealFoodValue();

  /**
   * return the current freshness of food, which is 0~100
   * @return double
   */
  int getFreshness();

  /**
   * reset the freshness of food to 1.00
   */
  void resetFreshness();

}
