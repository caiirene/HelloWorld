package Model.Food;

import java.util.List;

public class FoodBox implements FoodBoxInterface{

  private List<FoodInterface> foodBox;

  /**
   * add a pointer to a food object into this box add at back of the list
   */
  @Override
  public void addFood(FoodInterface food) {
    this.foodBox.add(food);
  }

  /**
   * provide a type of food if it is in this box
   * scan from the front remove the food after providing
   * 优先提供还没腐败，但不是很新鲜了的食物
   * @param foodName
   * @return FoodInterface food
   */
  @Override
  public FoodInterface provideFood(String foodName) {
    for (FoodInterface food : foodBox) {
      if (food.getFoodName()==foodName && food.getFoodBoolean()) {
        FoodInterface returnFood = food;
        foodBox.remove(food);
        return returnFood;
      }
    }
    //如果上面没有return我们就再检查一边是否有腐败了的食物
    for (FoodInterface food : foodBox) {
      if (food.getFoodName()==foodName) {
        FoodInterface returnFood = food;
        foodBox.remove(food);
        return returnFood;
      }
    }
    System.out.println("没有该食物");
    return null;
  }

  /**
   * return a food by searching index and then remove it, also free the food
   * 通常来讲不会用这个方法
   * @param index
   * @return
   */
  @Override
  public FoodInterface getFood(int index) {
    if (foodBox.size()-1 < index) {
      System.out.println("超出index范围");
      return null;
    }
    return foodBox.get(index);
  }

  /**
   * without providing an index, just get a food in index 0 and then remove it
   * 其实对应的是“随便喂一口”
   * @return
   */
  @Override
  public FoodInterface getFrontFood() {
    if (foodBox.size()<=0) {
      System.out.println("空盒子");
      return null;
    }
    FoodInterface returnFood = foodBox.get(0);
    foodBox.remove(0);
    return returnFood;
  }

  /**
   * search all food, remove those food already have 0 freshness
   */
  @Override
  public void removeBadFood() {
    for (FoodInterface food : foodBox) {
      if (!food.getFoodBoolean()) {
        foodBox.remove(food);
      }
    }
  }

  /**
   * return the entire list
   *
   * @return
   */
  @Override
  public List<FoodInterface> getFoodBox() {
    return foodBox;
  }
}
