package Model.Food;

public abstract class AbstractFood implements FoodInterface{

  private int value;

  @Override
  public int getFoodValue() {
    return this.value;
  }
}
