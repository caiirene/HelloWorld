import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Pet {
  private String name;
  private int hunger = 100;

  private PropertyChangeSupport support = new PropertyChangeSupport(this);

  public int getHunger(){
    return hunger;
  }

  public void addPropertyChangeListener(PropertyChangeListener listener) {
    support.addPropertyChangeListener(listener);
  }

  public void removePropertyChangeListener(PropertyChangeListener listener) {
    support.removePropertyChangeListener(listener);
  }

  public void getHungryWhileTimePass() {
    int oldHunger = this.hunger;
    // 在这里编写逻辑以根据时间流逝增加宠物的饥饿感
    // 例如：hunger = Math.max(hunger - 1, 0);
    System.out.println("hunger-25 in pet");
    hunger = Math.max(hunger - 25, 0);
    System.out.println("hunger, " + this.hunger);
    support.firePropertyChange("hunger", oldHunger, this.hunger);
  }

  public Pet(String name) {
    this.name = name;
  }


  public void eat() {
    int oldHunger = this.hunger;
    this.hunger = Math.min(this.hunger + 5, 100);
    System.out.println(name + " is eating.");
    System.out.println("after eat, " + this.hunger);
    support.firePropertyChange("hunger", oldHunger, this.hunger);
  }


}
