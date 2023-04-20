package Model.Food;

import java.util.List;

/**
 * FoodBox is a List<Food>
 * food stored here is just a pointer to real food object
 */
public interface FoodBoxInterface {

  /**
   * add a pointer to a food object into this box
   * add at back of the list
   */
  void addFood(FoodInterface food);

  /**
   * provide a type of food if it is in this box
   * scan from the front
   * remove the food after providing
   * @return FoodInterface food
   */
  FoodInterface provideFood(String foodName);

  /**
   * return a food by searching index
   * and then remove it, also free the food
   * @return
   */
  FoodInterface getFood(int index);

  /**
   * without providing an index, just get a food in index 0
   * and then remove it
   * @return
   */
  FoodInterface getFrontFood();

  /**
   * search all food, remove those food already have 0 freshness
   */
  void removeBadFood();

  /**
   * return the entire list
   * @return
   */
  List<FoodInterface> getFoodBox();

}
