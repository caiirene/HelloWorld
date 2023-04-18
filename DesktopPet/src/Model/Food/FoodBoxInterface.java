package Model.Food;

/**
 * FoodBox is a List<Food>
 * food stored here is just a pointer to real food object
 */
public interface FoodBoxInterface {

  /**
   * add a pointer to a food object into this box
   * add at back of the list
   */
  void addFood();

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

}
